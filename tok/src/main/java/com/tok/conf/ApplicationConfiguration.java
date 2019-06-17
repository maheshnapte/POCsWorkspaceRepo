package com.tok.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@PropertySource({ "classpath:database.properties" })
/*@ComponentScan(basePackages = "com.tok")
*/@ComponentScans(value = { 
	      @ComponentScan("com.tok.dao"),
	      @ComponentScan("com.tok.service"), @ComponentScan("com.tok.controller") 
	    })
public class ApplicationConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(restDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.tok.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	public DataSource restDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));

		return dataSource;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties hibernateProperties() {
		
		return new Properties() {
			{
				setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
				setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
				setProperty("hibernate.globally_quoted_identifiers", "true");
			}
		};
	}
	/*
	 * @Value("${id}") private String id;
	 * 
	 * @Value("Mahesh Hardcoded") private String name;
	 * 
	 * @Autowired Environment environment;
	 * 
	 * private final String URL = "url"; private final String USER = "dbuser";
	 * private final String DRIVER = "driver"; private final String PASSWORD =
	 * "dbpassword";
	 * 
	 * @Bean DataSource dataSource() { DriverManagerDataSource
	 * driverManagerDataSource = new DriverManagerDataSource();
	 * driverManagerDataSource.setUrl(environment.getProperty(URL));
	 * driverManagerDataSource.setUsername(environment.getProperty(USER));
	 * driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
	 * driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
	 * return driverManagerDataSource; }
	 * 
	 * // Following is perfect example to we need to create bean as follows
	 * using @Bean // to autowire it in project. Here, see PaymentDAOImpl.java
	 * 
	 * @Bean TemplateParserContext templateParserContext() {
	 * System.out.println("Bean creation started."); return new
	 * TemplateParserContext(id, "Bye" + name); }
	 */

}
