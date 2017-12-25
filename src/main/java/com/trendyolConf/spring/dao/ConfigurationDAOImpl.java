package com.trendyolConf.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trendyolConf.spring.model.Configuration;

import java.util.List;

@Repository
public class ConfigurationDAOImpl implements ConfigurationDAO {
	private static final Logger logger = LoggerFactory.getLogger(ConfigurationDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Configuration> listConfigurations() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Configuration> configurationsList = session.createQuery("from Configuration").list();
		for (Configuration configuration : configurationsList) {
			logger.info("Configuration List::" + configuration);
		}
		return configurationsList;
	}
	
	

	public void addConfiguration(Configuration configuration) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(configuration);
		logger.info("Configuration saved successfully, Configuration Details=" + configuration);
	}

	public void updateConfiguration(Configuration configuration) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(configuration);
		logger.info("Configuration updated successfully, Configuration Details=" + configuration);
	}

	public Configuration getConfigurationById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Configuration p = (Configuration) session.load(Configuration.class, new Integer(id));
		logger.info("Configuration loaded successfully, Configuration details=" + p);
		return p;
	}

	public void removeConfiguration(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Configuration configuration = (Configuration) session.load(Configuration.class, new Integer(id));
		if (configuration != null) {
			session.delete(configuration);
		}
		logger.info("Configuration deleted successfully, configuration details=" + configuration);
	}
	public List<Configuration> listConfigurationsByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Configuration> configurationsList = session.createQuery("from Configuration where name = :name").list();
		for (Configuration configuration : configurationsList) {
			logger.info("Configuration List::" + configuration);
		}
		return configurationsList;
	}
}
