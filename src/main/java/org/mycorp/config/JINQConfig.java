package org.mycorp.config;

import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
@ComponentScan("org.mycorp")
public class JINQConfig {
    @Bean
    @Autowired
    public JinqJPAStreamProvider jinqJPAStreamProvider(EntityManagerFactory entityManagerFactory) {
        return new JinqJPAStreamProvider(entityManagerFactory);
    }
}
