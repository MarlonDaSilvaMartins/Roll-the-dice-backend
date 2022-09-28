package com.rollthedice.impl.character.mapper.response;

import com.rollthedice.impl.character.model.response.CharacterImplResponse;
import com.rollthedice.impl.character.repository.entity.CharacterEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface CharacterEntityToImplResponseMapper {
    static CharacterImplResponse mapFrom(CharacterEntity characterEntity) {
        return getMapper(CharacterEntityToImplResponseMapper.class)
            .mapper(characterEntity);
    }
    
    CharacterImplResponse mapper(CharacterEntity characterEntity);
}