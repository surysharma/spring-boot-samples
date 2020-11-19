package com.thebigscale.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientProfileControllerTest {

    @Autowired
    private ClientProfileController clientProfileController;

    @Test
//    @DisplayName("should return valid response for valid request")
    public void shouldReturnValidResponseForValidRequest() {
        //Given

        //When
        Assertions.assertThat(clientProfileController)
                .isNotNull();

        //Then
    }


}