package club.luke.cloud.shop.app;

import club.luke.cloud.shop.app.ribbon.filter.RibbonFilter;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.annotation.WebFilter;

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
