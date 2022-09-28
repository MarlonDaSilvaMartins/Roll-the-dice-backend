package com.rollthedice.contract.v1.character;

import com.rollthedice.contract.v1.character.mapper.request.CharacterContractToImplRequestMapper;
import com.rollthedice.contract.v1.character.mapper.response.CharacterImplToContractResponseMapper;
import com.rollthedice.contract.v1.character.model.request.CharacterContractRequest;
import com.rollthedice.contract.v1.character.model.response.CharacterContractResponse;
import com.rollthedice.impl.character.CharacterImplFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CharacterContractFacade {
    
    private final CharacterImplFacade characterImplFacade;
    
    public Mono<CharacterContractResponse> createCharacter(CharacterContractRequest characterContractRequest){
        return characterImplFacade.createCharacter(CharacterContractToImplRequestMapper
            .mapFrom(characterContractRequest)).map(CharacterImplToContractResponseMapper::mapFrom);
    }
}