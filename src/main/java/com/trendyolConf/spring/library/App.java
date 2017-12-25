package com.trendyolConf.spring.library;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurationReader configurationReader = new ConfigurationReader("SERVICE-A", "jdbc:mysql://localhost/trendyolcase", 3000);

		// System.out.println(configurationReader.getValue("ahmet").toString());
		Integer intValue = configurationReader.getValue("ahmet");
		String strValue = configurationReader.getValue("counter");
		Boolean booleanValue = configurationReader.getValue("isCorrect");
		System.out.println("sonuc=" + strValue + "-" + intValue + "-" + booleanValue);

	}

}
