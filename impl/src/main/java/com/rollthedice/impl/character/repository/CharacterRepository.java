package com.rollthedice.impl.character.repository;

import com.rollthedice.impl.character.repository.entity.CharacterEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends ReactiveMongoRepository<CharacterEntity, Integer> {
}