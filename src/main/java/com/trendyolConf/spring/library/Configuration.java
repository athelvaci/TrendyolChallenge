package com.trendyolConf.spring.library;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

	private Map<String, Config> configMap;
	private int refreshInterval;
	private String connectionString;
	private String applicationName;
	private DBConnection db;

	public Configuration(String applicationName, String connectionString, int refreshTimerIntervalInMs) {
		this.connectionString = connectionString;
		this.refreshInterval = refreshTimerIntervalInMs;
		this.applicationName = applicationName;
		configMap = new HashMap<String, Config>();
		DBImplementor();
		new UpdateThread().start();
	}

	public Config getConfig(String configName) {
		
		return configMap.get(configName);
	}

	public void DBImplementor() {
		db = new DBConnection(connectionString,applicationName);
		configMap = db.getValueConf();
	}

	public class UpdateThread extends Thread {

		public void run() {
			updateFromDB();
		}

		private void updateFromDB() {
			try {
				while (true) {
					DBConnection db = new DBConnection(connectionString,applicationName);
					configMap = db.getValueConf();
					System.out.println("Configrations refreshed");
					Thread.sleep(refreshInterval);
				}
			} catch (InterruptedException e) {
				// TODO continue with the old list
				System.out.println("hata aldin");
				e.printStackTrace();
			}
		}
	}
}
