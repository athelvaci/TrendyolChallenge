package com.trendyolConf.spring.service;

import java.util.List;

import com.trendyolConf.spring.model.Configuration;

public interface ConfigurationService {
	void addConfiguration(Configuration configuration);

	void updateConfiguration(Configuration configuration);

	List<Configuration> listConfigurations();

	Configuration getConfigurationById(int id);

	void removeConfiguration(int id);
	
	List<Configuration> listConfigurationsByName(String name);
}
