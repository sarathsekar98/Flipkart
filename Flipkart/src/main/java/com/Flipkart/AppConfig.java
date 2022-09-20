package com.Flipkart;

import java.beans.PropertyVetoException;
import java.net.Proxy;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = "com.Flipkart")
@PropertySource(value = "classpath:Application.properties",ignoreResourceNotFound = false)
public class AppConfig extends WebMvcConfigurerAdapter {


	  //  Autowired environment properties to get access the configuration values 
	
		@Autowired
		Environment env ;
		
	    // database configuration start here
		
		@Bean
		public DataSource dataSource()
		{
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			
	        // set url	
			
			dataSource.setJdbcUrl(env.getRequiredProperty("database.url"));
			
	        // set DriverClassName
			
			try {
				dataSource.setDriverClass(env.getRequiredProperty("database.driver"));
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
			
			// set username and password here
			
			dataSource.setUser(env.getRequiredProperty("database.username"));
			dataSource.setPassword(env.getRequiredProperty("database.password"));
			
			// set compo pooled size configuration added here
			
			dataSource.setInitialPoolSize(getvalue("combo.intialpoolsize"));
			dataSource.setMinPoolSize(getvalue("combo.minpoolsize"));
			dataSource.setMaxPoolSize(getvalue("combo.maxpoolsize"));
			dataSource.setMaxIdleTime(getvalue("combo.maxidletime"));
			
			//all the datasource configuration intalized and return to the datasource
			
			return dataSource;
		}
	    
		//	 environment all values are get in string formate so i convert the string formate to integer formate 
		//	 using integer wrapper class and parseint method
		
		public int getvalue(String propertyname)
		{
			return Integer.parseInt(env.getRequiredProperty(propertyname));
		}
		
		// localsessionfactory configuration are here
		
		@Bean
		public LocalSessionFactoryBean sessionFactory()
		{
			
			LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
			
			// datasource configure here
			
			localSessionFactoryBean.setDataSource(dataSource());
			
			//module package scan configuration here
			
			localSessionFactoryBean.setPackagesToScan(new String[] {"com.Flipkart.Module"});
			
			//hibernate properties configuration here
			
			localSessionFactoryBean.setHibernateProperties(hibernateProperties());
			
			// all the configuration object return to sessionfactory
			
			return localSessionFactoryBean;
		}
		
		// hibernate properties configure here
		
		@Bean
		public Properties hibernateProperties()
		{
			Properties properties = new Properties();
			
			properties.setProperty(AvailableSettings.DIALECT, env.getRequiredProperty("hibernate.dialect"));
			properties.setProperty(AvailableSettings.SHOW_SQL, env.getRequiredProperty("hibernate.showsql"));
			properties.setProperty(AvailableSettings.HBM2DDL_AUTO, env.getRequiredProperty("hibernate.hbmddl"));
			properties.setProperty(AvailableSettings.FORMAT_SQL, env.getRequiredProperty("hibernate.sqlformate"));
			
			return properties;
		}
		
		@Bean
		public HibernateTransactionManager txManager()
		{
			HibernateTransactionManager transactionManager = new HibernateTransactionManager();
			
			// sessionfactory intalized here
			
			transactionManager.setSessionFactory(sessionFactory().getObject());
			
			// all configuration object are return to platformtransaction manger
			
			return transactionManager;
		}
//	cors configuration to allow access from another origin server access
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(env.getProperty("cors.addmapping"))
                .allowedOrigins(env.getProperty("cors.origin"))
                .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
    }
	
	
}
