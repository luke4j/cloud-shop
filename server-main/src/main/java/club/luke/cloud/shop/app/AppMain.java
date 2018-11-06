package club.luke.cloud.shop.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by luke on 2018/11/6.
 */
@SpringBootApplication
@EnableEurekaServer
public class AppMain {

    private static final Logger log = LoggerFactory.getLogger(AppMain.class) ;

    public static void main(String[] args) {
        SpringApplication.run(AppMain.class,args) ;
        log.info("====================AppMain started=========================") ;

    }
}
