package com.rollthedice.contract.v1.login;

import com.rollthedice.contract.v1.login.annotation.swagger.GetAuthSwagger;
import com.rollthedice.contract.v1.login.annotation.swagger.GetLoginSwagger;
import com.rollthedice.contract.v1.login.model.request.AuthorizationContractResquest;
import com.rollthedice.contract.v1.login.model.request.LoginContractRequest;
import com.rollthedice.contract.v1.login.model.response.LoginContractResponse;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/v1/login")
@Api(tags = "Login Controller")
@CrossOrigin
public class LoginRestController {
    private final LoginContractFacade loginContractFacade;

    @GetMapping("/{id}")
    @GetLoginSwagger
    public Mono<LoginContractResponse> getLogin(@PathVariable String id) {
        return loginContractFacade.getLogin(id);
    }
    
    @GetMapping("/auth")
    @GetAuthSwagger
    public Mono<LoginContractResponse> getAuthorization(
        @RequestParam
            String login,
        @RequestParam
            String password) {
        
        return loginContractFacade.getAuthorization(AuthorizationContractResquest.builder()
            .login(login)
            .password(password)
            .build());
    }
}