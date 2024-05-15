package org.mycorp.config;

import jakarta.persistence.EntityManagerFactory;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JINQConfig {
    @Bean
    public JinqJPAStreamProvider jinqJPAStreamProvider(EntityManagerFactory entityManagerFactory) {
        return new JinqJPAStreamProvider(entityManagerFactory);
    }
}
