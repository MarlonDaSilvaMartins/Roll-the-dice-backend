package com.rollthedice.contract.v1.login.mapper.request;

import com.rollthedice.contract.v1.login.model.request.LoginContractRequest;
import com.rollthedice.impl.login.model.request.LoginImplRequest;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface LoginContractToImplRequestMapper {
    static LoginImplRequest mapFrom(LoginContractRequest loginContractRequest) {
        return getMapper(LoginContractToImplRequestMapper.class)
            .mapper(loginContractRequest);
    }
    
    LoginImplRequest mapper(LoginContractRequest loginContractRequest);
}