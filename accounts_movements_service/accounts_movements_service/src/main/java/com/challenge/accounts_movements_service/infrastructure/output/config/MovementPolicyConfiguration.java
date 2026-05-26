package com.challenge.accounts_movements_service.infrastructure.output.config;

import com.challenge.accounts_movements_service.domain.policy.MovementPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovementPolicyConfiguration {
    @Bean
    public MovementPolicy movementPolicy() {
        return new MovementPolicy();
    }
}
