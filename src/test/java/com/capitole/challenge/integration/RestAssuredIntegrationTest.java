package com.capitole.challenge.integration;

import com.capitole.challenge.CapitoleChallengeApplication;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("test")
@SpringBootTest(classes = CapitoleChallengeApplication.class, webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestAssuredIntegrationTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void configureRestAssured() {
        RestAssured.port = port;
    }

    @AfterEach
    public void end() {
        RestAssured.reset();
    }

}
