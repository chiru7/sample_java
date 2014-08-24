package test.entry;

import test.util.ResourceManager;

public class Main {

	/**
	 * エントリポイント。<br>
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(ResourceManager.getString("key.string"));

		String[] array = ResourceManager.getStringArray("key.string.array");
		for(String str : array) {
			System.out.println(str);
		}

		System.out.println(ResourceManager.getString("key.string.cdata"));

		System.out.println(ResourceManager.getInt("key.int"));
	}

}
