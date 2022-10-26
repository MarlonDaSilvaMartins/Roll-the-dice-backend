package com.rollthedice.contract.v1.character;

import com.rollthedice.contract.v1.character.mapper.request.CharacterContractToImplRequestMapper;
import com.rollthedice.contract.v1.character.mapper.request.CharacterUpdateToEntityRequestMapper;
import com.rollthedice.contract.v1.character.mapper.response.CharacterImplToContractResponseMapper;
import com.rollthedice.contract.v1.character.model.request.CharacterContractRequest;
import com.rollthedice.contract.v1.character.model.request.CharacterUpdateContractRequest;
import com.rollthedice.contract.v1.character.model.response.CharacterContractResponse;
import com.rollthedice.impl.character.CharacterImplFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CharacterContractFacade {

    private final CharacterImplFacade characterImplFacade;

    public Flux<CharacterContractResponse> getCharacter() {
        return characterImplFacade.getCharacter()
                .map(CharacterImplToContractResponseMapper::mapFrom);
    }

    public Mono<CharacterContractResponse> getCharacterById(Integer characterId) {
        return characterImplFacade.getCharacterById(characterId)
                .map(CharacterImplToContractResponseMapper::mapFrom);
    }

    public Mono<CharacterContractResponse> createCharacter(CharacterContractRequest characterContractRequest) {
        return characterImplFacade.createCharacter(CharacterContractToImplRequestMapper
                .mapFrom(characterContractRequest)).map(CharacterImplToContractResponseMapper::mapFrom);
    }

    public Mono<CharacterContractResponse> updateCharacter(CharacterUpdateContractRequest characterUpdateRequest) {
        return characterImplFacade.updateCharacter(CharacterUpdateToEntityRequestMapper.mapFrom(characterUpdateRequest))
                .map(CharacterImplToContractResponseMapper::mapFrom);
    }

    public Mono<Void> deleteCharacter(Integer characterId) {
        return characterImplFacade.deleteCharacter(characterId);
    }
}