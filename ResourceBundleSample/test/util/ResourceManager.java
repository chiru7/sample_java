package test.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceManager {

	private static ResourceBundle RES;

	static{
		ResourceBundle tmpRsource = null;
		try {
			tmpRsource = ResourceBundle.getBundle("resource");
		} catch (Exception e) {
			e.printStackTrace();
		}
		RES = tmpRsource;
	}

	/**
	 * コンストラクタ。<br>
	 */
	private ResourceManager() {}

	/**
	 * システム設定値を数値で取得します。<br>
	 *
	 * @param id キーID
	 * @return システム設定値
	 */
	public static int getInt(String id) {
		return getInt(id, Integer.MIN_VALUE);
	}

	/**
	 * システム設定値を数値で取得します。<br>
	 *
	 * @param id キーID
	 * @param defaultValue 初期値
	 * @return システム設定値
	 */
	public static int getInt(String id, int defaultValue) {
		try {
			return Integer.parseInt(getString(id));
		} catch(Exception e) {
			//
		}
		return defaultValue;
	}

	/**
	 * システム設定値を数値で取得します。<br>
	 *
	 * @param id キーID
	 * @return システム設定値
	 */
	public static long getLong(String id) {
		return getLong(id, Long.MIN_VALUE);
	}

	/**
	 * システム設定値を数値で取得します。<br>
	 *
	 * @param id キーID
	 * @param defaultValue 初期値
	 * @return システム設定値
	 */
	public static long getLong(String id, long defaultValue) {
		try {
			return Long.parseLong(getString(id));
		} catch(Exception e) {
			//
		}
		return defaultValue;
	}

	/**
	 * システム設定値を取得します。<br>
	 *
	 * @param id キーID
	 * @return システム設定値
	 */
	public static String getString(String id) {
		try {
			return RES.getString(id).trim();
		} catch(MissingResourceException mre) {
			mre.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * システム設定値を取得します。<br>
	 *
	 * @param id キーID
	 * @param defaultValue 初期値
	 * @return システム設定値
	 */
	public static final String getString(String id, String defaultValue) {
		String result = getString(id);
		return (result == null) ? defaultValue : result;
	}

	/**
	 * システム設定値をリストで取得します。<br>
	 *
	 * @param id キーID
	 * @return システム設定値
	 */
	public static String[] getStringArray(String id) {
		return getStringArray(id, null);
	}

	/**
	 * システム設定値をリストで取得します。<br>
	 *
	 * @param id キーID
	 * @return システム設定値
	 */
	public static String[] getStringArray(String id, String[] defaultValue) {
		String[] result = defaultValue;
		try {
			String val = getString(id);
			result = (val != null && val.length() > 0) ? val.split(",") : defaultValue;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * システム設定値を論理値で取得します。<br>
	 *
	 * @param id キーID
	 * @return 論理値 false:未登録、又は"true"以外(大文字/小文字無視)
	 */
	public static final boolean getBoolean(String id) {
		return Boolean.parseBoolean(getString(id));
	}

}
