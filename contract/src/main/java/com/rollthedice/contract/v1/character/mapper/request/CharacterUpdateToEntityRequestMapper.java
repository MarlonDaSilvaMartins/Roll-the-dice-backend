package com.rollthedice.contract.v1.character.mapper.request;

import com.rollthedice.contract.v1.character.model.request.CharacterUpdateContractRequest;
import com.rollthedice.impl.character.model.request.CharacterUpdateImplRequest;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface CharacterUpdateToEntityRequestMapper {
    static CharacterUpdateImplRequest mapFrom(CharacterUpdateContractRequest characterUpdateContractRequest) {
        return getMapper(CharacterUpdateToEntityRequestMapper.class)
                .mapper(characterUpdateContractRequest);
    }

    CharacterUpdateImplRequest mapper(CharacterUpdateContractRequest characterUpdateContractRequest);
}
