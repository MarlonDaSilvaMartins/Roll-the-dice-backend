package com.rollthedice.contract.v1.character;

import com.rollthedice.contract.v1.character.annotation.swagger.CreateCharacterSwagger;
import com.rollthedice.contract.v1.character.model.request.CharacterContractRequest;
import com.rollthedice.contract.v1.character.model.response.CharacterContractResponse;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@Api(tags = "character controller")
@RequestMapping(path = "/v1/character")
public class CharacterRestController {
    
    private final CharacterContractFacade characterContractFacade;
    
    @PostMapping
    @CreateCharacterSwagger
    public Mono<CharacterContractResponse> createCharacter(
        @RequestBody
            CharacterContractRequest characterContractRequest) {
        return characterContractFacade.createCharacter(characterContractRequest);
    }
}