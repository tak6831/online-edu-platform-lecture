package com.example.onlineeduplatformlecture.config;

import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;
import io.r2dbc.h2.H2ConnectionOption;
import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@Slf4j
@Configuration
@EnableR2dbcRepositories
public class R2dbcConfig extends AbstractR2dbcConfiguration {

    @Override
    public ConnectionFactory connectionFactory() {
//        return new H2ConnectionFactory(H2ConnectionConfiguration.builder()
//                .inMemory("mem")
//                .property(H2ConnectionOption.DB_CLOSE_DELAY, "-1")
//                .username("sa")
//                .build());

        return null;
    }

//    @Bean
//    public ConnectionFactoryInitializer r2dbInitializer() {
//        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
//        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
//        resourceDatabasePopulator.addScript(new ClassPathResource("rating.sql"));
//
//        initializer.setConnectionFactory(connectionFactory());
//        initializer.setDatabasePopulator(resourceDatabasePopulator);
//        return initializer;
//    }

    @Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(new ClassPathResource("rating.sql"));
        initializer.setDatabasePopulator(populator);
        return initializer;
    }

}
