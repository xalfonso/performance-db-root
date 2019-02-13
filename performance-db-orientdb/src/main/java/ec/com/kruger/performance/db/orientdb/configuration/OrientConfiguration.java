package ec.com.kruger.performance.db.orientdb.configuration;

import ec.com.kruger.performance.db.model.Customer;
import ec.com.kruger.performance.db.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orient.OrientProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.orient.commons.core.OrientTransactionManager;
import org.springframework.data.orient.commons.repository.config.EnableOrientRepositories;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.data.orient.object.OrientObjectTemplate;
import org.springframework.data.orient.object.repository.support.OrientObjectRepositoryFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@Configuration
@EnableTransactionManagement
@EnableOrientRepositories(basePackages = "ec.com.kruger.performance.db.orientdb.repository", repositoryFactoryBeanClass = OrientObjectRepositoryFactoryBean.class)
@EnableAutoConfiguration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableConfigurationProperties(OrientProperties.class)
public class OrientConfiguration {

    @Autowired
    private OrientProperties properties;

    @Bean
    public OrientObjectDatabaseFactory factory() {
        OrientObjectDatabaseFactory factory = new OrientObjectDatabaseFactory();

        factory.setUrl(properties.getUrl());
        factory.setUsername(properties.getUsername());
        factory.setPassword(properties.getPassword());

        return factory;
    }

    @Bean
    public OrientTransactionManager transactionManager() {
        return new OrientTransactionManager(factory());
    }

    @Bean
    public OrientObjectTemplate objectTemplate() {
        return new OrientObjectTemplate(factory());
    }

    @PostConstruct
    public void registerEntities() {
       factory().db().getEntityManager().registerEntityClass(Person.class);
       factory().db().getEntityManager().registerEntityClass(Customer.class);
    }
}