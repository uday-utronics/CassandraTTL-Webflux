package com.example.cassandraTTL.model;

import lombok.*;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(value = "user")
public class User {

    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int id;
    @PrimaryKeyColumn(name = "name", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private String name;
    @PrimaryKeyColumn(name = "email", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private String email;
    @Column(value = "phonenumber")
    private String phoneNumber;

}
