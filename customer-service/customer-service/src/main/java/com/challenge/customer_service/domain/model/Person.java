package com.challenge.customer_service.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;
    private Gender gender;
    private String identification;
    private String address;
    private String phone;
}
