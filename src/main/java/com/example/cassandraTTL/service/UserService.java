package com.example.cassandraTTL.service;

import com.example.cassandraTTL.model.User;
import com.example.cassandraTTL.model.UserTTL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.data.cassandra.core.cql.ReactiveCqlTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private ReactiveCassandraOperations reactiveCassandraOperations;
    @Autowired
    private ReactiveCqlTemplate cqlTemplate;

    public Mono<Boolean> insertUserWithTTL(UserTTL user) {
        String cql = "INSERT INTO user (id, name, email,phonenumber) VALUES (?, ?, ?,?) USING TTL ?";
        Object[] params = new Object[] { user.getId(), user.getName(), user.getEmail(),user.getPhoneNumber(), user.getTTL() };
        return cqlTemplate.execute(cql, params);
    }


}
