package com.challenge.customer_service.karate;

import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = TestcontainersInitializer.class)
class KarateIT {

    @LocalServerPort
    int port;

    @BeforeAll
    static void beforeAll() {
        // nothing
    }

    @Karate.Test
    Karate run() {
        System.setProperty("baseUrl", "http://localhost:" + port);
        return Karate.run("customers").relativeTo(getClass());
    }
}
