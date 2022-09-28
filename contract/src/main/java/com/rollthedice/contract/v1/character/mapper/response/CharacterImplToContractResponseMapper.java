package com.rollthedice.contract.v1.character.mapper.response;

import com.rollthedice.contract.v1.character.model.response.CharacterContractResponse;
import com.rollthedice.impl.character.model.response.CharacterImplResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface CharacterImplToContractResponseMapper {
    static CharacterContractResponse mapFrom(CharacterImplResponse characterImplResponse) {
        return getMapper(CharacterImplToContractResponseMapper.class)
            .mapper(characterImplResponse);
    }
    
    CharacterContractResponse mapper(CharacterImplResponse characterImplResponse);
}