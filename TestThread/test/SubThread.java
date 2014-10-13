package test;

public class SubThread implements Runnable{

	private int outerCount;
	private int innerCount;

	public SubThread(int outerCount, int innerCount) {
		this.outerCount = outerCount;
		this.innerCount = innerCount;
	}

	public void run(){

		int number = outerCount * 10 + innerCount;
		try {
			Manager.getInstance().getSet().add(number);
			System.out.println("add list number：" + number);

			while (true) {
				if (!Manager.getInstance().isLock()) {
					break;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {}
				System.out.println("----- NOW LOCKING -----");
			}

			System.out.println("outerCount：" + outerCount + " innerCount：" + innerCount);

			/* 少し待機する */
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){
			}

		}
		finally {
			Manager.getInstance().getSet().remove(number);
			if (Manager.getInstance().getSet().size() == 0) {
				Manager.getInstance().setCheck(false);
				System.out.println("List size is 0. so Check is false");
				System.out.println("-------------------");
			}
			else {
				System.out.println("not yet compleet.");
			}
		}
	}
}