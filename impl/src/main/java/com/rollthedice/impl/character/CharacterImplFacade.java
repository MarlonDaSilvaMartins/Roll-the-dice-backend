package com.rollthedice.impl.character;

import com.rollthedice.impl.character.model.request.CharacterImplRequest;
import com.rollthedice.impl.character.model.response.CharacterImplResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CharacterImplFacade {
    
    private final CharacterImplService characterImplService;
    
    public Mono<CharacterImplResponse> createCharacter(CharacterImplRequest characterImplRequest){
        return characterImplService.createCharacter(characterImplRequest);
    }
}