package com.thebigscale;

import com.google.common.flogger.FluentLogger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static com.thebigscale.AppConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppIntegrationTest {

    @LocalServerPort private int port;

    @Autowired private TestRestTemplate testRestTemplate;

    FluentLogger logger = FluentLogger.forEnclosingClass();

    @Test
    @DisplayName("should startup the app")        
    void shouldStartupTheApp() {
        //When
        logger.atInfo().log("started the application on port %s...", port);

        //Then
        assertThat(this.testRestTemplate.getForObject(PROTOCOL.getName() + HOST.getName() + ":" + port + SEPERATOR.getName(), String.class))
        .isNotEmpty();
    }
    
}
