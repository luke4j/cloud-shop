package club.luke.cloud.shop.app;

import club.luke.cloud.shop.app.database.HibernateConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by luke on 2018/11/1.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class AppLogin  extends HibernateConfig{
    private static final Logger log = LoggerFactory.getLogger(AppLogin.class) ;
    public static void main(String[] args) {
        SpringApplication.run(AppLogin.class,args) ;
        log.info("====================login-server-started============================");
    }



}
