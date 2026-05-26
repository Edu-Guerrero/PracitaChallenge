package com.challenge.accounts_movements_service.infrastructure.output.config;

import com.challenge.accounts_movements_service.infrastructure.output.adapter.rest.customer_service.CustomersApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Slf4j
@Configuration
public class ApiClientConfiguration {

    @Bean
    public CustomersApi customerServiceApiClient(
            @Value("${optimus.http-client.customer-service.base-path}") String basePath
    ) {
        final var api = new CustomersApi();
        log.info(basePath);
        api.getApiClient().setBasePath(basePath);
        return api;
    }
}