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
    
    public Mono<CharacterImplResponse> getCharacterById(String characterId) {
        return characterRepository.findById(characterId)
            .map(CharacterEntityToImplResponseMapper::mapFrom)
            .switchIfEmpty(Mono.defer(() -> Mono
                .error(new DataNotFoundException("Personagem não encontrado"))));
    }
    
    public Mono<CharacterImplResponse> createCharacter(CharacterImplRequest characterImplRequest) {
        return validateCharacterPoints(characterImplRequest)
            .then(characterRepository.save(CharacterImplToEntityRequestMapper.mapFrom(characterImplRequest))
                .map(CharacterEntityToImplResponseMapper::mapFrom));
    }
    
    private Mono<Void> validateCharacterPoints(CharacterImplRequest characterImplRequest) {
        var totalPontos = characterImplRequest.getLevel() * 40;
        if (characterPointsSum(characterImplRequest) > totalPontos)
            return Mono.error(() ->
                new DataNotFoundException("pontos de personagem não pode ser maior que " + totalPontos));
        return Mono.empty();
    }
    
    private Integer characterPointsSum(CharacterImplRequest characterImplRequest) {
        return characterImplRequest.getLifePoints() + characterImplRequest.getMagicPoints() +
            characterImplRequest.getAttackPoints() + characterImplRequest.getDefensePoints() +
            characterImplRequest.getExpertisePoints();
    }
    
    public Mono<CharacterImplResponse> updateCharacter(CharacterUpdateImplRequest characterUpdateImplRequest) {
        return characterRepository.findById(characterUpdateImplRequest.getId())
            .switchIfEmpty(Mono.defer(() -> Mono
                .error(new DataNotFoundException("Personagem não encontrado"))))
            .flatMap(characterEntity -> {
                var entity = CharacterUpdateToEntityRequestMapper.mapFrom(characterUpdateImplRequest);
                entity.setId(characterEntity.getId());
                return characterRepository.save(entity);
            }).map(CharacterEntityToImplResponseMapper::mapFrom);
    }
    
    public Mono<Void> deleteCharacter(String characterId) {
        return characterRepository.deleteById(characterId);
    }
}