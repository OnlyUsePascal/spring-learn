package example;

import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mariadb.jdbc.Driver;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.*;

@Configuration
@EnableWebMvc
@PropertySource("classpath:jdbc.properties")
// @ComponentScan(basePackages = {"example.Controller",
//     "example.Util",
//     "example.Model"})
@ComponentScan("example")
@EnableTransactionManagement
public class MvcConfig {
  @Autowired
  private Environment environment;
  
  @Bean
  public InternalResourceViewResolver internalResourceViewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/public/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }
  
  @Bean
  public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.autoDetectFields(true);
    return builder;
  }
  
  @Bean
  public DriverManagerDataSource driverManagerDataSource() {
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
    driverManagerDataSource.setUrl(environment.getProperty("jdbc.url"));
    driverManagerDataSource.setUsername(environment.getProperty("jdbc.username"));
    driverManagerDataSource.setPassword(environment.getProperty("jdbc.password"));
    return driverManagerDataSource;
  }
  
  @Bean
  public LocalSessionFactoryBean localSessionFactoryBean(
      @Qualifier("driverManagerDataSource") DriverManagerDataSource driverManagerDataSource) {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setDataSource(driverManagerDataSource);
    sessionFactoryBean.setPackagesToScan("example.Model");
    
    Properties properties = new Properties();
    List<String> props = Arrays.asList("hibernate.dialect", "hibernate.show_sql",
                                       "hibernate.format_sql", "hibernate.hbm2ddl.auto");
    props.forEach(prop -> {
      properties.put(prop, environment.getProperty(prop));
    });
    sessionFactoryBean.setHibernateProperties(properties);
    
    return sessionFactoryBean;
  }
  
  @Bean
  public HibernateTransactionManager transactionManager(
      @Qualifier("localSessionFactoryBean") LocalSessionFactoryBean sessionFactoryBean){
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactoryBean.getObject());
    return transactionManager;
  }
}
