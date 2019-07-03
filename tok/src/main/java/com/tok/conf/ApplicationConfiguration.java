package com.tok.conf;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
import org.springframework.http.CacheControl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@PropertySource({ "classpath:database.properties" })
/*
 * @ComponentScan(basePackages = "com.tok")
 */@ComponentScans(value = { @ComponentScan("com.tok.dao"), @ComponentScan("com.tok.service"),
		@ComponentScan("com.tok.controller") })
public class ApplicationConfiguration implements WebMvcConfigurer {

	@Autowired
	private Environment env;

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	}
	
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".html");
		return bean;
	}



	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * 
	 * // Register resource handler for CSS and JS
	 * registry.addResourceHandler("/assets/**").addResourceLocations(
	 * "classpath:/assets/", "D:/statics/") .setCacheControl(CacheControl.maxAge(2,
	 * TimeUnit.HOURS).cachePublic());
	 * 
	 * // Register resource handler for images
	 * registry.addResourceHandler("/images/**").addResourceLocations(
	 * "/WEB-INF/images/") .setCacheControl(CacheControl.maxAge(2,
	 * TimeUnit.HOURS).cachePublic()); }
	 */

	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * // TODO Auto-generated method stub
	 * 
	 * WebMvcConfigurer.super.addResourceHandlers(registry);
	 * registry.addResourceHandler("/assets/**").addResourceLocations("/assets/").
	 * setCachePeriod(3600) .resourceChain(true).addResolver(new
	 * PathResourceResolver()); }
	 */

	/*
	 * @Override public void
	 * configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	 * // TODO Auto-generated method stub
	 * 
	 * WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
	 * 
	 * configurer.enable(); }
	 */

	/*
	 * @Override public void
	 * configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	 * configurer.enable(); }
	 */
	
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	
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
