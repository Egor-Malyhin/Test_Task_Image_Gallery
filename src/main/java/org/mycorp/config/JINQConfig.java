package org.mycorp.config;

import javax.persistence.EntityManagerFactory;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("org.mycorp")
public class JINQConfig {
    @Bean
    @Autowired
    public JinqJPAStreamProvider jinqJPAStreamProvider(EntityManagerFactory entityManagerFactory) {
        return new JinqJPAStreamProvider(entityManagerFactory);
    }
}
