package club.luke.cloud.shop.app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by luke on 2018/11/6.
 */
@Configuration
@EnableAutoConfiguration
public class Config {

    @Bean(name = "login-service-restTemplate")
    @LoadBalanced// 这个 RestTemplate 是需要做负载的
    public RestTemplate restTemplate_login(){
        return new RestTemplate() ;
    }

    @Bean(name = "goods-service-restTemplate")
    @LoadBalanced// 这个 RestTemplate 是需要做负载的
    public RestTemplate restTemplate_goods(){
        return new RestTemplate() ;
    }

    @Resource
    private DataSource dataSource;
    @Resource
    private JpaProperties jpaProperties ;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("club.luke.cloud.shop.app.model");
        factory.setJpaPropertyMap(jpaProperties.getProperties());
        factory.setDataSource(dataSource);
        return factory;
    }


    @Bean("tx")
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
