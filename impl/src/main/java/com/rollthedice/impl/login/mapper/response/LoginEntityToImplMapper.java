package com.rollthedice.impl.login.mapper.response;

import com.rollthedice.impl.login.model.request.LoginImplRequest;
import com.rollthedice.impl.login.repository.entity.LoginEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface LoginEntityToImplMapper {
    static LoginEntity mapFrom(LoginImplRequest loginImplRequest) {
        return getMapper(LoginEntityToImplMapper.class)
            .mapper(loginImplRequest);
    }
    
    @Mapping(target = "id", ignore = true)
    LoginEntity mapper(LoginImplRequest loginImplRequest);
}