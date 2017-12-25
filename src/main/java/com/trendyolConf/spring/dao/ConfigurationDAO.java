package com.trendyolConf.spring.dao;

import java.util.List;

import com.trendyolConf.spring.model.Configuration;

public interface ConfigurationDAO {

	void addConfiguration(Configuration configuration);

	void updateConfiguration(Configuration configuration);

	List<Configuration> listConfigurations();

	Configuration getConfigurationById(int id);

	void removeConfiguration(int id);
	
	List<Configuration> listConfigurationsByName(String name);
}
