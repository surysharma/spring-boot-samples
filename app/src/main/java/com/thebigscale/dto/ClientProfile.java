package com.thebigscale.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data public class ClientProfile {

    private final long id;

    @NotNull(message = "Name cannot be null")
    private final String name;

    @Size(message = "Age should be between 15 to 70 years", min = 15, max = 70)
    private final String age;

    @NotNull(message = "Name cannot be null")
    private final String profileSummary;

    @Email(message = "Invalid email provided")
    @NotNull
    private final String email;
}
