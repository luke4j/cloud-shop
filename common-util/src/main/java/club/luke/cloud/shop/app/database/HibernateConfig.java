package club.luke.cloud.shop.app.database;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

/**
 * Created by luke on 2018/11/2.
 */
@Configurable
public class HibernateConfig {


    @Bean
    public SessionFactory sessionFactory(HibernateJpaSessionFactoryBean factory){
        return factory.getObject() ;
    }

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }



}
