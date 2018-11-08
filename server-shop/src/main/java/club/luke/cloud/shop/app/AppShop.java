package club.luke.cloud.shop.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by luke on 2018/11/1.
 */
@SpringBootApplication
//@EnableEurekaClient  //单机开发，不用注册到中心主服务
public class AppShop {
    private static final Logger log = LoggerFactory.getLogger(AppShop.class) ;
    public static void main(String[] args) {
        SpringApplication.run(AppShop.class,args) ;
        log.info("====================login-server-started============================");
    }
}
