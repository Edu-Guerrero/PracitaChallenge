package com.challenge.customer_service.application.output.port;

import reactor.core.publisher.Mono;

public interface PasswordHasherPort {
    Mono<String> hash(String rawPassword);
}
