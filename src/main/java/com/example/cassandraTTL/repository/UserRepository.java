package com.example.cassandraTTL.repository;

import com.example.cassandraTTL.model.User;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCassandraRepository<User,Integer> {

    @Query("INSERT INTO user (id, name, email,phonenumber) VALUES (?0, ?1, ?2,?3) USING TTL ?4")
    Mono<Boolean> updateUser(int empId,
                                 String name,
                                 String email,
                                 String  phonenumber,
                                 int TTL);
}
