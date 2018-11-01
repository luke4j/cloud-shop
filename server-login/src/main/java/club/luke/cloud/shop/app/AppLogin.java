package club.luke.cloud.shop.app;

import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

/**
 * Created by luke on 2018/11/1.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class AppLogin  {
    private static final Logger log = LoggerFactory.getLogger(AppLogin.class) ;
    public static void main(String[] args) {
        SpringApplication.run(AppLogin.class,args) ;
        log.info("====================login-server-started============================");
    }


    @Bean
    public SessionFactory sessionFactory(HibernateJpaSessionFactoryBean factory){
        return factory.getObject() ;
    }

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }

}
