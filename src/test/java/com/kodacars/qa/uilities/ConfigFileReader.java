package com.kodacars.qa.uilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private static Properties properties;
	private static ConfigFileReader configReader;

	private static final String propertyFilePath = "src//test//resources//config//Configuration.properties";

	private ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}

	}

	public static ConfigFileReader getInstance() {
		if (configReader != null) {
			return configReader;
		} else {
			configReader = new ConfigFileReader();
			return configReader;
		}
	}

	public static String getLoginUrl() {
		String loginUrl = properties.getProperty("loginUrl");
		if (loginUrl != null)
			return loginUrl;
		else
			throw new RuntimeException(" Index url not specified in the Configuration.properties file.");
	}

	public static String getUsername() {
		String username = properties.getProperty("username");
		if (username != null)
			return username;
		else
			throw new RuntimeException("username  not specified in the Configuration.properties file.");
	}

	public static String getPassword() {
		String password = properties.getProperty("password");
		if (password != null)
			return password;
		else
			throw new RuntimeException("password not specified in the Configuration.properties file.");
	}
	public static String getExcelPath() {
		String excelPath = properties.getProperty("excelPath");
		if (excelPath != null)
			return excelPath;
		else
			throw new RuntimeException(" Excel Path is not specified in the Configuration.properties file.");
	}
}
