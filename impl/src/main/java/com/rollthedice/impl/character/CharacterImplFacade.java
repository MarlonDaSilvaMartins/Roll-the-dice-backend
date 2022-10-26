package com.rollthedice.impl.character;

import com.rollthedice.impl.character.mapper.request.CharacterUpdateToEntityRequestMapper;
import com.rollthedice.impl.character.mapper.response.CharacterEntityToImplResponseMapper;
import com.rollthedice.impl.character.model.request.CharacterImplRequest;
import com.rollthedice.impl.character.model.request.CharacterUpdateImplRequest;
import com.rollthedice.impl.character.model.response.CharacterImplResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CharacterImplFacade {
    
    private final CharacterImplService characterImplService;

    public Flux<CharacterImplResponse> getCharacter() {
        return characterImplService.getCharacter();
    }

    public Mono<CharacterImplResponse> getCharacterById(String characterId) {
        return characterImplService.getCharacterById(characterId);
    }

    public Mono<CharacterImplResponse> createCharacter(CharacterImplRequest characterImplRequest){
        return characterImplService.createCharacter(characterImplRequest);
    }

    public Mono<CharacterImplResponse> updateCharacter(CharacterUpdateImplRequest characterUpdateImplRequest) {
        return characterImplService.updateCharacter(characterUpdateImplRequest);
    }

    public Mono<Void> deleteCharacter(String characterId) {
        return characterImplService.deleteCharacter(characterId);
    }
}