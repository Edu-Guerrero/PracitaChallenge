package com.challenge.customer_service.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenderTest {

    @Test
    void valuesShouldContainAllExpectedConstants() {
        Gender[] values = Gender.values();

        assertArrayEquals(
                new Gender[]{Gender.MALE, Gender.FEMALE, Gender.OTHER},
                values
        );
    }

    @Test
    void valueOfShouldParseExistingConstant() {
        assertEquals(Gender.MALE, Gender.valueOf("MALE"));
        assertEquals(Gender.FEMALE, Gender.valueOf("FEMALE"));
        assertEquals(Gender.OTHER, Gender.valueOf("OTHER"));
    }

    @Test
    void valueOfShouldThrowExceptionForInvalidConstant() {
        assertThrows(IllegalArgumentException.class, () -> Gender.valueOf("INVALID"));
    }
}
