package com.rollthedice.impl.character.mapper.request;

import com.rollthedice.impl.character.model.request.CharacterImplRequest;
import com.rollthedice.impl.character.repository.entity.CharacterEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface CharacterImplToEntityRequestMapper {
    static CharacterEntity mapFrom(CharacterImplRequest characterImplRequest) {
        return getMapper(CharacterImplToEntityRequestMapper.class)
            .mapper(characterImplRequest);
    }
    
    CharacterEntity mapper(CharacterImplRequest characterImplRequest);
}