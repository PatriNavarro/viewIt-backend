package com.patrinav.viewit.configuration;

import com.patrinav.viewit.entities.Movie;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//Required to work with persistencies
@EnableTransactionManagement
//The file where we will detail the properties for hibernate's instantiation (check file in resources)
@PropertySource(value="classpath:application.properties")
@ComponentScans(value={
        @ComponentScan("com.patrinav.viewit.dao"),
        @ComponentScan("com.patrinav.viewit.services")
})
public class HibernateConfig {
    @Autowired
    private Environment environment;

    private Properties getHibernateProperties(){
        Properties properties = new Properties();
        properties.put(AvailableSettings.DIALECT,environment.getRequiredProperty("hibernate.dialect"));
        properties.put(AvailableSettings.SHOW_SQL,environment.getRequiredProperty("hibernate.show_sql"));
        properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS,environment.getRequiredProperty("hibernate.current.session.context.class"));
        properties.put(AvailableSettings.USE_NEW_ID_GENERATOR_MAPPINGS,environment.getRequiredProperty("hibernate.id.new_generator_mappings"));

        return properties;
    }

    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("datasource.driver"));
        dataSource.setUrl(environment.getRequiredProperty("datasource.url"));
        dataSource.setUsername(environment.getRequiredProperty("datasource.username"));
        dataSource.setPassword(environment.getRequiredProperty("datasource.password"));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setAnnotatedClasses(Movie.class);
        sessionFactory.setPackagesToScan("com.patrinav.viewit.entities");
        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());

        return transactionManager;
    }
}
