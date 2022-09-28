package com.rollthedice.impl.login;

import com.rollthedice.commons.utils.exceptions.datanotfound.DataNotFoundException;
import com.rollthedice.impl.login.mapper.request.LoginImplToEntityMapper;
import com.rollthedice.impl.login.mapper.response.LoginEntityToImplMapper;
import com.rollthedice.impl.login.model.request.AuthorizationImplRequest;
import com.rollthedice.impl.login.model.request.LoginImplRequest;
import com.rollthedice.impl.login.model.response.LoginImplResponse;
import com.rollthedice.impl.login.repository.LoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class LoginImplService {
    
    private final LoginRepository loginRepository;
    
    public Mono<LoginImplResponse> getLogin(LoginImplRequest loginImplRequest) {
        return loginRepository.save(LoginEntityToImplMapper.mapFrom(loginImplRequest))
            .map(LoginImplToEntityMapper::mapFrom);
    }
    
    public Mono<LoginImplResponse> getAuthorization(AuthorizationImplRequest auth) {
        return loginRepository.findLoginEntityByLoginAndPassword(auth.getLogin(), auth.getPassword())
            .switchIfEmpty(Mono.defer(() ->
                Mono.error(new DataNotFoundException("Login ou senha inválidos"))))
            .map(LoginImplToEntityMapper::mapFrom);
    }
}