package com.rollthedice.impl.login;
import com.rollthedice.impl.login.model.request.AuthorizationImplRequest;
import com.rollthedice.impl.login.model.request.LoginImplRequest;
import com.rollthedice.impl.login.model.response.LoginImplResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class LoginImplFacade {
    
    private final LoginImplService loginImplService;
    
    public Mono<LoginImplResponse> getLogin(String id){
        return loginImplService.getLogin(id);
    }
    
    public Mono<LoginImplResponse> getAuthorization(AuthorizationImplRequest authorizationImplRequest){
        return loginImplService.getAuthorization(authorizationImplRequest);
    }
}