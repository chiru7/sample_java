package test.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class XMLResourceManager {

	private static ResourceBundle XML_RES;

	static{
		ResourceBundle tmpRsource = null;
		try {
			tmpRsource = ResourceBundle.getBundle("resource", new XMLResourceBundleControl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		XML_RES = tmpRsource;
	}

	/**
	 * コンストラクタ。<br>
	 */
	private XMLResourceManager() {}

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
	 * システム設定値を取得します。<br>
	 *
	 * @param id キーID
	 * @return システム設定値
	 */
	public static String getString(String id) {
		try {
			return XML_RES.getString(id).trim();
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
}
