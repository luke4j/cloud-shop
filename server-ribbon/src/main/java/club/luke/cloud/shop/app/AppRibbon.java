package club.luke.cloud.shop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by luke on 2018/11/6.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AppRibbon {

    public static void main(String[] args) {
        SpringApplication.run(AppRibbon.class,args) ;
    }

}
