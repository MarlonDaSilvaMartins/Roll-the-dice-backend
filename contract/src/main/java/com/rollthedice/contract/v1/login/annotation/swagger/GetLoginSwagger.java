package com.rollthedice.contract.v1.login.annotation.swagger;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.rollthedice.contract.v1.login.model.response.LoginContractResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiOperation(value = "Get Login",
    response = LoginContractResponse.class,
    responseContainer = "Mono", produces = "application/json")
@ApiResponses({
    @ApiResponse(code = 200, message = ""),
    @ApiResponse(code = 400, message = "Bad request"),
    @ApiResponse(code = 500, message = "Internal error")
})
public @interface GetLoginSwagger {
}