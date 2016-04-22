package helloProject;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Locale;

import static helloProject.HelloWorld.*;
import static org.junit.Assert.assertEquals;

public class TestHelloProject {
	private static Locale defaultLocale;

	@BeforeClass
	public static void changeDefaultLocale() {
		defaultLocale = Locale.getDefault();
	}

	@AfterClass
	public static void setLocale() {
		Locale.setDefault(defaultLocale);
	}

	@Test
	public void testEnglishLocale() {
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("Good morning, World!", getMessage(7));
		assertEquals("Good day, World!", getMessage(18));
		assertEquals("Good evening, World!", getMessage(22));
		assertEquals("Good night, World!", getMessage(1));
	}

	@Test
	public void testRuLocale() {
		Locale.setDefault(new Locale("RU"));
		assertEquals("Доброе утро, Мир!", getMessage(8));
		assertEquals("Добрый день, Мир!", getMessage(13));
		assertEquals("Добрый вечер, Мир!", getMessage(20));
		assertEquals("Доброй ночи, Мир!", getMessage(0));
	}	

}
