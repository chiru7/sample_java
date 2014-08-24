package test.entry;

import java.util.ResourceBundle;

import test.util.XMLResourceBundleControl;

public class Main3 {

	/**
	 * エントリポイント。<br>
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		int maxCnt = 5;

		for (int i = 0; i < maxCnt; i++) {
			System.out.println("-------------------");
			ResourceBundle res = ResourceBundle.getBundle("resource", new XMLResourceBundleControl());
			dump(i, res);

			switch (i) {
			case 1:
				try {
					// スリープ時にxmlの設定値を更新する
					Thread.sleep(10 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				// キャッシュクリア
				ResourceBundle.clearCache();
				break;
			}
		}
	}

	/**
	 * 内容を表示します。<br>
	 *
	 * @param prefix
	 * @param res
	 */
	private static void dump(int cnt, ResourceBundle res) {
		System.out.println("res=@" + res.hashCode());
		for (String key : res.keySet()) {
			String value = res.getString(key);
			System.out.println((cnt + 1) + "回目：" + key + "=" + value);
		}
	}
}
