package test.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

/**
 * XMLファイルによるリソースバンドル操作を可能にする
 */
public class XMLResourceBundleControl extends Control {

	/** 対応するフォーマット形式。<br> */
	private static final String XML = "xml";

	public List<String> getFormats(String baseName) {
		return Arrays.asList(XML);
	}

	public long getTimeToLive(String baseName, Locale locale) {
        // キャッシュ期間(ミリ秒)
        return 2 * 1000;
    }

	public ResourceBundle newBundle(String baseName, Locale locale,
			String format, ClassLoader loader, boolean reload)
			throws IllegalAccessException, InstantiationException, IOException {
		if (baseName == null || locale == null || format == null
				|| loader == null) {
			throw new NullPointerException();
		}

		ResourceBundle bundle = null;

		// xml形式の場合
		if (format.equals(XML)) {
			// ロケールに対応するリソース名取得
			String bundleName = toBundleName(baseName, locale);

			// 対応するフォーマットのリソース名取得
			String rscName = toResourceName(bundleName, format);

			URL url = loader.getResource(rscName);
			URLConnection urlConn = url.openConnection();
			if (reload) {
				// リロードの場合はキャッシュクリア
				System.out.println("cash clear");
				urlConn.setUseCaches(false);
			}
			System.out.println("load resource: " + rscName + "=" + url);
			bundle = new XMLResourceBundle(new BufferedInputStream(urlConn.getInputStream()));
		}
		return bundle;
	}
}
