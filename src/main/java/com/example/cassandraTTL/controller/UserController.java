package com.example.cassandraTTL.controller;

import com.example.cassandraTTL.model.User;
import com.example.cassandraTTL.model.UserTTL;
import com.example.cassandraTTL.repository.UserRepository;
import com.example.cassandraTTL.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.InsertOptions;
import org.springframework.data.cassandra.core.cql.WriteOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private CassandraTemplate cassandraTemplate;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Mono<Boolean> create(@RequestBody UserTTL userTTL){
//        int ttl = userTTL.getTTL();
//        User user = new User(userTTL.getId(), userTTL.getName(), userTTL.getEmail(), userTTL.getPhoneNumber());
//        InsertOptions options = InsertOptions.builder().ttl(ttl).build();
//        return userRepository.insert(user);
        return userService.insertUserWithTTL(userTTL);
    }

    @PostMapping("/createQueryMethod")
    public Mono<Boolean> createQueryMethod(@RequestBody UserTTL userTTL){

        return userRepository.updateUser(userTTL.getId(), userTTL.getName(), userTTL.getEmail(),
                userTTL.getPhoneNumber(), userTTL.getTTL());
    }

    @GetMapping("/findAll")
    public Flux<User> getAll(){
        return userRepository.findAll();
    }
}
