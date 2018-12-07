package club.luke.cloud.shop.app;

import club.luke.cloud.shop.app.web.config.WebMvcConfigurerBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by luke on 2018/11/5.
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@EnableTransactionManagement
/**
 * 配置文件，这里面不知道为什么要有两个sessionFactory方法
 */
public class Config extends WebMvcConfigurerBean {

    private static final Logger logger = LoggerFactory.getLogger(Config.class) ;

//    @Bean
//    public SessionFactory sessionFactory(HibernateJpaSessionFactoryBean factory){
//        return factory.getObject() ;
//    }
//    @Bean
//    public HibernateJpaSessionFactoryBean sessionFactory() {
//        return new HibernateJpaSessionFactoryBean();
//    }


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
