package com.example.cassandraTTL.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserTTL {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private int TTL;
}
