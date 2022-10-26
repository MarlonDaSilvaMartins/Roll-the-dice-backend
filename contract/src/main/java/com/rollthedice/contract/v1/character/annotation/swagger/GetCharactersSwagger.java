package com.rollthedice.contract.v1.character.annotation.swagger;

import com.rollthedice.impl.character.model.response.CharacterImplResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value = "Get characters", response = CharacterImplResponse.class,
        responseContainer = "Flux", produces = "application/json")
@ApiResponses({
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 404, message = "Not Found")
})
public @interface GetCharactersSwagger {
}
