package com.zeervi.rader.spring.exetend;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class ExtendedPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	private Properties props;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		super.processProperties(beanFactory, props);
		this.props = props;
	}

	public String getProperty(String key) {
		return props.getProperty(key);
	}
}