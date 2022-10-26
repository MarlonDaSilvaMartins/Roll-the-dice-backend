package com.rollthedice.impl.character.mapper.request;

import com.rollthedice.impl.character.model.request.CharacterUpdateImplRequest;
import com.rollthedice.impl.character.repository.entity.CharacterEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface CharacterUpdateToEntityRequestMapper {
    static CharacterEntity mapFrom(CharacterUpdateImplRequest characterUpdateImplRequest) {
        return getMapper(CharacterUpdateToEntityRequestMapper.class)
                .mapper(characterUpdateImplRequest);
    }

    CharacterEntity mapper(CharacterUpdateImplRequest characterUpdateImplRequest);
}
