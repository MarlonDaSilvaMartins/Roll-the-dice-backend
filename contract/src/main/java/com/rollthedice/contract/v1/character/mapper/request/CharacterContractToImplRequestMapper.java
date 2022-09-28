package com.rollthedice.contract.v1.character.mapper.request;

import com.rollthedice.contract.v1.character.model.request.CharacterContractRequest;
import com.rollthedice.impl.character.model.request.CharacterImplRequest;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface CharacterContractToImplRequestMapper {
    static CharacterImplRequest mapFrom(CharacterContractRequest characterContractRequest) {
        return getMapper(com.rollthedice.contract.v1.character.mapper.request.CharacterContractToImplRequestMapper.class)
            .mapper(characterContractRequest);
    }
    
    CharacterImplRequest mapper(CharacterContractRequest characterContractRequest);
}