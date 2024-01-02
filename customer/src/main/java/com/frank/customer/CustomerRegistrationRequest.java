package com.frank.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
