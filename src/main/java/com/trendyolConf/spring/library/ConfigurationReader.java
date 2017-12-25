package com.trendyolConf.spring.library;

import java.util.HashMap;

public class ConfigurationReader {

	private Configuration configuration;

	public ConfigurationReader(String applicationName, String connectionString, int refreshTimerIntervalInMs) {
		configuration = new Configuration(applicationName, connectionString, refreshTimerIntervalInMs);
		
	}

	public <T> T getValue(String key) {
		Config conf = configuration.getConfig(key);
		switch (conf.getType()) {
		case "Double":
			return (T) new Double((conf.getValue()));
		case "Integer":
			return (T) new Integer((conf.getValue()));
		case "Int":
			return (T) new Integer((conf.getValue()));
		case "Boolean":
			return (T) new Boolean((conf.getValue()));
		case "Long":
			return (T) new Long((conf.getValue()));
		case "Float":
			return (T) new Float((conf.getValue()));
		case "Short":
			return (T) new Short((conf.getValue()));
		case "String":
			return (T) (conf.getValue());
			
		default:
			System.out.println("Type doesn't match");
			return null;
		}
	}
}
