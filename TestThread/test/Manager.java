package test;

import java.util.HashSet;
import java.util.Set;

public final class Manager {

	private static final Manager instance = new Manager();

	private boolean lock = false;

	private boolean check = false;

	private Set<Integer> set = new HashSet<Integer>();

	private Manager(){
	}

	public static Manager getInstance() {
		return instance;
	}

	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public Set<Integer> getSet() {
		return set;
	}

	public void setSet(Set<Integer> set) {
		this.set = set;
	}
}
