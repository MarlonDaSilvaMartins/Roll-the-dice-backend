package com.rollthedice.contract.v1.character;

import javax.validation.Valid;

import com.rollthedice.contract.v1.character.annotation.swagger.*;
import com.rollthedice.contract.v1.character.model.request.CharacterContractRequest;
import com.rollthedice.contract.v1.character.model.request.CharacterUpdateContractRequest;
import com.rollthedice.contract.v1.character.model.response.CharacterContractResponse;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@Api(tags = "character controller")
@RequestMapping(path = "/v1/character")
@CrossOrigin
public class CharacterRestController {
    
    private final CharacterContractFacade characterContractFacade;
    
    @GetMapping
    @GetCharactersSwagger
    public Flux<CharacterContractResponse> getCharacter() {
        return characterContractFacade.getCharacter();
    }
    
    @GetMapping("/{characterId}")
    @GetCharacterByIdSwagger
    public Mono<CharacterContractResponse> getCharacterById(
        @PathVariable
        String characterId) {
        return characterContractFacade.getCharacterById(characterId);
    }
    
    @PostMapping
    @CreateCharacterSwagger
    public Mono<CharacterContractResponse> createCharacter(
        @RequestBody
        @Valid
        CharacterContractRequest characterContractRequest) {
        return characterContractFacade.createCharacter(characterContractRequest);
    }
    
    @PutMapping
    @UpdateCharacterSwagger
    public Mono<CharacterContractResponse> updateCharacter(
        @RequestBody
        @Valid CharacterUpdateContractRequest characterUpdateRequest) {
        return characterContractFacade.updateCharacter(characterUpdateRequest);
    }
    
    @DeleteMapping("{characterId}")
    @DeleteCharacterSwagger
    public Mono<Void> deleteCharacter(
        @PathVariable
        String characterId) {
        return characterContractFacade.deleteCharacter(characterId);
    }
}