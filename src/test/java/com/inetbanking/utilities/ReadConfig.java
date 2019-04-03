package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	public ReadConfig() {
		File src = new File("./ConfigurationFiles/config.properties");

		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getApplicationURL() {
		String baseURL = properties.getProperty("baseURL");
		return baseURL;

	}

	public String getUserName() {
		String userName = properties.getProperty("userName");
		return userName;

	}

	public String getPassword() {
		String password = properties.getProperty("password");
		return password;

	}

	public String getChromePath() {
		String chromePath = properties.getProperty("chromePath");
		return chromePath;

	}

	public String getIEPath() {
		String iePath = properties.getProperty("iePath");
		return iePath;

	}

	public String getFirefoxPath() {
		String firefoxPath = properties.getProperty("firefoxPath");
		return firefoxPath;

	}

}
