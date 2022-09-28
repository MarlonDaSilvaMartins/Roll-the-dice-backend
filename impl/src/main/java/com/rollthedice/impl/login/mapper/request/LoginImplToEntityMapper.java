package com.rollthedice.impl.login.mapper.request;

import com.rollthedice.impl.login.model.response.LoginImplResponse;
import com.rollthedice.impl.login.repository.entity.LoginEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface LoginImplToEntityMapper {
    static LoginImplResponse mapFrom(LoginEntity loginEntity) {
        return getMapper(LoginImplToEntityMapper.class)
            .mapper(loginEntity);
    }
    
    LoginImplResponse mapper(LoginEntity loginEntity);
}