package test.entry;

import test.util.XMLResourceManager;

public class Main2 {

	/**
	 * エントリポイント。<br>
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(XMLResourceManager.getString("key.string"));

		String[] array = XMLResourceManager.getStringArray("key.string.array");
		for(String str : array) {
			System.out.println(str);
		}

		System.out.println(XMLResourceManager.getString("key.string.cdata"));

		System.out.println(XMLResourceManager.getInt("key.int"));
	}
}
