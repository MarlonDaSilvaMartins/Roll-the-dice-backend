package com.rollthedice.impl.login.model.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginImplRequest {
    private String name;
    private String login;
    private String password;
}