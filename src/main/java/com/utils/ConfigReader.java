package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;
	private static final String PROP_FILE_PATH = "src/main/resources/configuration.properties";

	// Static block to initialize and load the properties file
	static {
		try (FileInputStream fis = new FileInputStream(PROP_FILE_PATH)) {
			properties = new Properties();
			properties.load(fis);

			// Set System Property for Log4j2 to use this same file
			System.setProperty("log4j.configurationFile", PROP_FILE_PATH);

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not load configuration.properties file.");
		}
	}

	/**
	 * Reads a property value. Priority: 1. System/CLI Property (-Dkey=value) 2.
	 * configuration.properties file
	 */
	public static String getProperty(String key) {
		String value = System.getProperty(key); // Check CLI override
		if (value == null) {
			value = properties.getProperty(key);
		}
		return value;
	}

	public static int getIntProperty(String key) {
		return Integer.parseInt(getProperty(key));
	}
}