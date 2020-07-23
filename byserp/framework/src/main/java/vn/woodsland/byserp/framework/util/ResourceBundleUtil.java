package vn.woodsland.byserp.framework.util;


import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * General resource file manipulation utilities.
 */
public class ResourceBundleUtil {

	private static Map bundleCache = new HashMap();

	/**
	 * Instantiates a new resource bundle util.
	 */
	private ResourceBundleUtil() {
	}

	/**
	 * Gets the resource bundle.
	 *
	 * @param resourceName the resource name
	 * @return the resource bundle
	 */
	public static ResourceBundle getResourceBundle(String resourceName) {
		return getResourceBundle(new Locale("", ""), resourceName); //use default locale
	}

	/**
	 * Gets the resource bundle.
	 *
	 * @param locale       the locale
	 * @param resourceName the resource name
	 * @return the resource bundle
	 */
	public static ResourceBundle getResourceBundle(Locale locale, String resourceName) {
		ResourceBundle bundle = null;
		final String bundleKey = (resourceName + locale.toString()).intern();

		synchronized (bundleCache) {
			bundle = (ResourceBundle) bundleCache.get(bundleKey);
			if (bundle == null) {
				bundle = ResourceBundle.getBundle(resourceName, locale);
				bundleCache.put(bundleKey, bundle);
			}
		}
		return bundle;
	}

	/**
	 * Gets the message.
	 *
	 * @param bundle the bundle
	 * @param key    the key
	 * @param args   the args
	 * @return the message
	 * @throws MissingResourceException the missing resource exception
	 */
	public static String getMessage(ResourceBundle bundle, String key, String[] args)
			throws MissingResourceException {
		String message = bundle.getString(key);
		return MessageFormat.format(message, args);
	}

	/**
	 * Gets the message.
	 *
	 * @param bundle the bundle
	 * @param key    the key
	 * @return the message
	 * @throws MissingResourceException the missing resource exception
	 */
	public static String getMessage(ResourceBundle bundle, String key)
			throws MissingResourceException {
		String message = bundle.getString(key);
		return MessageFormat.format(message, null);
	}
}

