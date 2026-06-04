package com.challenge.customer_service.karate;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

public class TestcontainersInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("challenge_test")
            .withUsername("test")
            .withPassword("test")
            .withInitScript("BaseDatos.sql");

    static {
        POSTGRES.start();
    }

    @Override
    public void initialize(ConfigurableApplicationContext context) {
        TestPropertyValues.of(
                "spring.datasource.url=" + POSTGRES.getJdbcUrl(),
                "spring.datasource.username=" + POSTGRES.getUsername(),
                "spring.datasource.password=" + POSTGRES.getPassword(),
                "spring.datasource.driver-class-name=org.postgresql.Driver",

                "spring.jpa.hibernate.ddl-auto=validate",
                "spring.jpa.open-in-view=false",
                "spring.jpa.properties.hibernate.default_schema=banking",

                "spring.webflux.base-path=/api/v1"
        ).applyTo(context.getEnvironment());
    }
}
