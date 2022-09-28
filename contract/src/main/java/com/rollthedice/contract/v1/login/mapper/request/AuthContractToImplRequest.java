package com.rollthedice.contract.v1.login.mapper.request;

import com.rollthedice.contract.v1.login.model.request.AuthorizationContractResquest;
import com.rollthedice.impl.login.model.request.AuthorizationImplRequest;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface AuthContractToImplRequest {
    static AuthorizationImplRequest mapFrom(AuthorizationContractResquest authorizationContractResquest) {
        return getMapper(AuthContractToImplRequest.class)
            .mapper(authorizationContractResquest);
    }
    
    AuthorizationImplRequest mapper(AuthorizationContractResquest authorizationContractResquest);
}