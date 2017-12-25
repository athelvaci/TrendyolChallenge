package com.trendyolConf.spring.service;

import org.springframework.stereotype.Service;

import com.trendyolConf.spring.dao.ConfigurationDAO;
import com.trendyolConf.spring.model.Configuration;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {
	private ConfigurationDAO configurationDAO;

	public void setConfigurationDAO(ConfigurationDAO configurationDAO) {
		this.configurationDAO = configurationDAO;
	}

	@Transactional
	public void addConfiguration(Configuration configuration) {
		this.configurationDAO.addConfiguration(configuration);
	}

	@Transactional
	public void updateConfiguration(Configuration configuration) {
		this.configurationDAO.updateConfiguration(configuration);
	}

	@Transactional
	public List<Configuration> listConfigurations() {
		return this.configurationDAO.listConfigurations();
	}

	@Transactional
	public Configuration getConfigurationById(int id) {
		return this.configurationDAO.getConfigurationById(id);
	}

	@Transactional
	public void removeConfiguration(int id) {
		this.configurationDAO.removeConfiguration(id);
	}

	@Transactional
	public List<Configuration> listConfigurationsByName(String name) {
		return this.configurationDAO.listConfigurationsByName(name);
	}

}
