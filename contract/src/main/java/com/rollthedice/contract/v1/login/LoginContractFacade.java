package com.rollthedice.contract.v1.login;

import com.rollthedice.contract.v1.login.mapper.request.AuthContractToImplRequest;
import com.rollthedice.contract.v1.login.mapper.request.LoginContractToImplRequestMapper;
import com.rollthedice.contract.v1.login.mapper.response.LoginImplToContractResponse;
import com.rollthedice.contract.v1.login.model.request.AuthorizationContractResquest;
import com.rollthedice.contract.v1.login.model.request.LoginContractRequest;
import com.rollthedice.contract.v1.login.model.response.LoginContractResponse;
import com.rollthedice.impl.login.LoginImplFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class LoginContractFacade {
    
    private final LoginImplFacade loginImplFacade;
    
    public Mono<LoginContractResponse> getLogin(String id){
        return loginImplFacade.getLogin(id)
            .map(LoginImplToContractResponse::mapFrom);
    }
    
    public Mono<LoginContractResponse> getAuthorization(AuthorizationContractResquest authorizationContractResquest){
        return loginImplFacade.getAuthorization(AuthContractToImplRequest.mapFrom(authorizationContractResquest))
            .map(LoginImplToContractResponse::mapFrom);
    }
}