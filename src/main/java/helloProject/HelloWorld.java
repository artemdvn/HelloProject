package helloProject;

import org.apache.log4j.Logger;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloWorld {

	private static Logger logger = Logger.getLogger(HelloWorld.class);

	public static String getMessage() {
		return getMessage(getCurrentHour(new Date()));
	}

	public static String getMessage(int currentHour) {
		Locale currentLocale = Locale.getDefault();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("Message", currentLocale);
		return convertToUTF(resourceBundle.getString(getPartOfDay(currentHour)));
	}

	private static int getCurrentHour(Date currentDate) {
		return Integer.parseInt(new SimpleDateFormat("HH").format(currentDate));
	}

	private static String convertToUTF(String str) {
		String newStr = null;
		try {
			newStr = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		}
		return newStr;
	}

	private static String getPartOfDay(int currentHour) {
		if (currentHour >= 6 && currentHour < 9)
			return "morning";
		if (currentHour >= 9 && currentHour < 19)
			return "day";
		if (currentHour >= 19 && currentHour < 23)
			return "evening";
		return "night";
	}

}
