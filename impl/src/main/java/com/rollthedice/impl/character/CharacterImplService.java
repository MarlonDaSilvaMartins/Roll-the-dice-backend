package com.rollthedice.impl.character;

import com.rollthedice.commons.utils.exceptions.datanotfound.DataNotFoundException;
import com.rollthedice.impl.character.mapper.request.CharacterImplToEntityRequestMapper;
import com.rollthedice.impl.character.mapper.request.CharacterUpdateToEntityRequestMapper;
import com.rollthedice.impl.character.mapper.response.CharacterEntityToImplResponseMapper;
import com.rollthedice.impl.character.model.request.CharacterImplRequest;
import com.rollthedice.impl.character.model.request.CharacterUpdateImplRequest;
import com.rollthedice.impl.character.model.response.CharacterImplResponse;
import com.rollthedice.impl.character.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CharacterImplService {
    
    private final CharacterRepository characterRepository;

    public Flux<CharacterImplResponse> getCharacter() {
        return characterRepository.findAll()
                .map(CharacterEntityToImplResponseMapper::mapFrom);
    }

    public Mono<CharacterImplResponse> getCharacterById(Integer characterId) {
        return characterRepository.findById(characterId)
                .map(CharacterEntityToImplResponseMapper::mapFrom);
    }

    public Mono<CharacterImplResponse> createCharacter(CharacterImplRequest characterImplRequest){
        return validateCharacterPoints(characterImplRequest)
            .then(characterRepository.save(CharacterImplToEntityRequestMapper.mapFrom(characterImplRequest))
            .map(CharacterEntityToImplResponseMapper::mapFrom));
    }
    
    private Mono<Void> validateCharacterPoints(CharacterImplRequest characterImplRequest){
        if(characterPointsSum(characterImplRequest) > 40)
            return Mono.error(() -> new DataNotFoundException("pontos de personagem não pode ser maior que 40"));
        return Mono.empty();
    }
    
    private Integer characterPointsSum(CharacterImplRequest characterImplRequest){
        return characterImplRequest.getLifePoints()+characterImplRequest.getMagicPoints()+
            characterImplRequest.getAttackPoints()+characterImplRequest.getDefensePoints()+
            characterImplRequest.getExpertisePoints();
    }

    public Mono<CharacterImplResponse> updateCharacter(CharacterUpdateImplRequest characterUpdateImplRequest) {
        return characterRepository.save(CharacterUpdateToEntityRequestMapper.mapFrom(characterUpdateImplRequest))
                .map(CharacterEntityToImplResponseMapper::mapFrom);
    }

    public Mono<Void> deleteCharacter(Integer characterId) {
        return characterRepository.deleteById(characterId);
    }
}