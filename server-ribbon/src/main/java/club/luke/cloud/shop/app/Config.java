package club.luke.cloud.shop.app;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.web.client.RestTemplate;

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


    @Bean
    public SessionFactory sessionFactory(HibernateJpaSessionFactoryBean factory){
        return factory.getObject() ;
    }

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }

}
