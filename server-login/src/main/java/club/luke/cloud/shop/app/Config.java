package club.luke.cloud.shop.app;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

/**
 * Created by luke on 2018/11/5.
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
/**
 * 配置文件，这里面不知道为什么要有两个sessionFactory方法
 */
public class Config {

    private static final Logger logger = LoggerFactory.getLogger(Config.class) ;

    @Bean
    public SessionFactory sessionFactory(HibernateJpaSessionFactoryBean factory){
        return factory.getObject() ;
    }

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }



}
