package com.tok;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tok")
public class ApplicationConfiguration {

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
