package com.rollthedice.contract.v1.login.mapper.response;

import com.rollthedice.contract.v1.login.model.response.LoginContractResponse;
import com.rollthedice.impl.login.model.response.LoginImplResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface LoginImplToContractResponse {
    static LoginContractResponse mapFrom(LoginImplResponse loginImplResponse) {
        return getMapper(LoginImplToContractResponse.class)
            .mapper(loginImplResponse);
    }
    
    LoginContractResponse mapper(LoginImplResponse loginImplResponse);
}