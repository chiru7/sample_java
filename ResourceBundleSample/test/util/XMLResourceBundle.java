package test.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * XMLファイルから構築されるリソースバンドル
 */
public class XMLResourceBundle extends ResourceBundle {

	private Properties props = null;

	XMLResourceBundle(InputStream is) throws IOException {
		props = new Properties();
		props.loadFromXML(is);
	}

	@Override
	protected Object handleGetObject(String key) {
		return props.getProperty(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		Enumeration enm = props.keys();
		return enm;
	}
}
