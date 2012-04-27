package com.game.grizzly.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.game.grizzly.app.bean.User;

@Configuration
@EnableTransactionManagement
public class DataConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/grizzly_game");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	@Bean(name = "sessionFactory")
	public SessionFactory sessionFactory() throws Exception {
		AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setHibernateProperties(buildHibernateProperties());
		sessionFactoryBean.setAnnotatedClasses(new Class[] { User.class });
		sessionFactoryBean.afterPropertiesSet();
		return sessionFactoryBean.getObject();
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager() throws Exception {
		return new HibernateTransactionManager(sessionFactory());
	}
	
	private Properties buildHibernateProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.connection.charSet", "UTF-8");
		props.put("hibernate.hbm2ddl.auto", "create");
		return props;
	}
}
