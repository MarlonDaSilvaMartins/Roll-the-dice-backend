package com.rollthedice.impl.character;

import com.rollthedice.commons.utils.exceptions.datanotfound.DataNotFoundException;
import com.rollthedice.impl.character.mapper.request.CharacterImplToEntityRequestMapper;
import com.rollthedice.impl.character.mapper.response.CharacterEntityToImplResponseMapper;
import com.rollthedice.impl.character.model.request.CharacterImplRequest;
import com.rollthedice.impl.character.model.response.CharacterImplResponse;
import com.rollthedice.impl.character.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CharacterImplService {
    
    private final CharacterRepository characterRepository;
    
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
}