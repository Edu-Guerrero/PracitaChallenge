package com.challenge.customer_service.infrastructure.output.adapter.security;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import reactor.test.StepVerifier;

class BCryptPasswordHasherAdapterTest {

    private final BCryptPasswordHasherAdapter adapter = new BCryptPasswordHasherAdapter();
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Test
    void hashShouldReturnEncodedPasswordDifferentFromRawAndMatchOriginal() {
        String raw = "P@ssw0rd-123";

        StepVerifier.create(adapter.hash(raw))
                .assertNext(hashed -> {
                    assertNotNull(hashed);
                    assertNotEquals(raw, hashed, "BCrypt hash should not equal raw password");
                    assertTrue(encoder.matches(raw, hashed), "Encoded password should match raw password");
                })
                .verifyComplete();
    }

    @Test
    void hashShouldGenerateDifferentHashesForSameRawPasswordBecauseOfSalt() {
        String raw = "same-password";

        String h1 = adapter.hash(raw).block();
        String h2 = adapter.hash(raw).block();

        assertNotNull(h1);
        assertNotNull(h2);
        assertNotEquals(h1, h2, "BCrypt should generate different hashes due to salt");

        assertTrue(encoder.matches(raw, h1));
        assertTrue(encoder.matches(raw, h2));
    }

    @Test
    void hashShouldErrorWhenRawPasswordIsNull() {
        StepVerifier.create(adapter.hash(null))
                .expectError(IllegalArgumentException.class)
                .verify();
    }
}
