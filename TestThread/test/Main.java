package test;

public class Main {

	public static void main(String args[]){
		Main m = new Main();
		m.test();
	}

	private void test() {
		for(int i = 0; i < 10; i++) {

			/* 少し待機する */
			try{
				Thread.sleep(50);
			}catch(InterruptedException e){
			}


			System.out.println("-------------------");
			System.out.println("outerCount：" + i * 10);

			if (Manager.getInstance().isCheck()) {
				System.out.println("----- check is true. so continue. -----");
				continue;
			}

			for (int j = 0; j < 5; j++) {
				if (j == 0) {
					System.out.println("----- LOCK -----");
				}
				System.out.println("innerCount：" + j);
				SubThread sub = new SubThread(i, j);
				Thread thread = new Thread(sub);
				Manager.getInstance().setLock(true);
				Manager.getInstance().setCheck(true);
				thread.start();
			}
			System.out.println("----- LOCK解除 -----");
			Manager.getInstance().setLock(false);
		}
	}

}
