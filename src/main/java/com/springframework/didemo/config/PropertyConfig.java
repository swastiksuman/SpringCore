package com.springframework.didemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.springframework.didemo.examplebeans.FakeDataSource;
import com.springframework.didemo.examplebeans.JMSBroker;

@Configuration
@PropertySources({
	@PropertySource("datasource.properties"),
	@PropertySource("jms.properties")
})
/*@PropertySource({"datasource.properties", "jms.properties"})*///Can be put in application.properties as well
public class PropertyConfig {

	@Autowired
	Environment environment;

	@Value("${swastik.username}")
	String user;

	@Value("${swastik.password}")
	String password;

	@Value("${swastik.url}")
	String url;

	@Value("${jms.username}")
	String jmsUser;

	@Value("${jms.password}")
	String jmsPassword;

	@Value("${jms.url}")
	String jmsUrl;

	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		fakeDataSource.setUser(user);
		fakeDataSource.setEnvname(environment
				.getProperty("CURRENT.ENVIRONMENT"));
		return fakeDataSource;
	}

	@Bean
	public JMSBroker fakeJmsBroker() {
		JMSBroker jmsBroker = new JMSBroker();
		jmsBroker.setPassword(jmsPassword);
		jmsBroker.setUrl(jmsUrl);
		jmsBroker.setUser(jmsUser);
		return jmsBroker;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}
}
