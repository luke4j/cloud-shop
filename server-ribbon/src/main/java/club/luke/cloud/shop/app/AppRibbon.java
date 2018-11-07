package club.luke.cloud.shop.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by luke on 2018/11/6.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@ServletComponentScan
public class AppRibbon {

    private static final Logger log = LoggerFactory.getLogger(AppRibbon.class) ;
    public static void main(String[] args) {
        SpringApplication.run(AppRibbon.class,args) ;
        log.info("====================AppRibbon started=========================");
    }

}
