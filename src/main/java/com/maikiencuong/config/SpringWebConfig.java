package com.maikiencuong.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.maikiencuong" })
@PropertySource("classpath:app.properties")
@EnableJpaRepositories("com.maikiencuong.repository")
public class SpringWebConfig {

	private static final String PROP_DATABASE_URL = "db.url";
	private static final String PROP_DATABASE_DRIVER = "db.driver";
	private static final String PROP_DATABASE_PASSWORD = "db.password";
	private static final String PROP_DATABASE_USERNAME = "db.username";
	private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "db.entitymanager.packages.to.scan";
	private static final String PROP_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROP_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROP_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";

	@Autowired
	private Environment evn;

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	/* config jpa */

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(evn.getRequiredProperty(PROP_DATABASE_DRIVER));
		dataSource.setUrl(evn.getRequiredProperty(PROP_DATABASE_URL));
		dataSource.setUsername(evn.getRequiredProperty(PROP_DATABASE_USERNAME));
		dataSource.setPassword(evn.getRequiredProperty(PROP_DATABASE_PASSWORD));

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan(evn.getRequiredProperty(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN));
		entityManagerFactoryBean.setJpaProperties(hibernateProperties());

		return entityManagerFactoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}

	/* config hibernate */

	/*
	 * @Bean public DriverManagerDataSource dataSource() throws IOException {
	 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 * dataSource.setDriverClassName(evn.getProperty(PROP_DATABASE_DRIVER));
	 * dataSource.setUrl(evn.getProperty(PROP_DATABASE_URL));
	 * dataSource.setUsername(evn.getProperty(PROP_DATABASE_USERNAME));
	 * dataSource.setPassword(evn.getProperty(PROP_DATABASE_PASSWORD)); return
	 * dataSource; }
	 * 
	 * @Bean public LocalSessionFactoryBean sessionFactory() throws IOException {
	 * LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	 * sessionFactory.setDataSource(dataSource());
	 * sessionFactory.setPackagesToScan(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN);
	 * sessionFactory.setHibernateProperties(hibernateProperties()); return
	 * sessionFactory; }
	 * 
	 * @Bean
	 * 
	 * @Autowired public HibernateTransactionManager
	 * transactionManager(SessionFactory sessionFactory) {
	 * HibernateTransactionManager txManager = new HibernateTransactionManager();
	 * txManager.setSessionFactory(sessionFactory); return txManager; }
	 */

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty(PROP_HIBERNATE_DIALECT, evn.getProperty(PROP_HIBERNATE_DIALECT));
		properties.setProperty(PROP_HIBERNATE_FORMAT_SQL, evn.getProperty(PROP_HIBERNATE_FORMAT_SQL));
		properties.setProperty(PROP_HIBERNATE_SHOW_SQL, evn.getProperty(PROP_HIBERNATE_SHOW_SQL));
		properties.setProperty(PROP_HIBERNATE_HBM2DDL_AUTO, evn.getProperty(PROP_HIBERNATE_HBM2DDL_AUTO));

		return properties;
	}

}