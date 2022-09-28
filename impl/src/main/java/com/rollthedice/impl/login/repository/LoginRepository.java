package com.rollthedice.impl.login.repository;

import com.rollthedice.impl.login.repository.entity.LoginEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface LoginRepository extends ReactiveMongoRepository<LoginEntity, String> {
    @Query(value = "{ 'login' : ?0, 'password' : ?1 }")
    Mono<LoginEntity> findLoginEntityByLoginAndPassword(String login, String password);
}