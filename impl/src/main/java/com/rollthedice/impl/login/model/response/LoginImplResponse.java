package com.rollthedice.impl.login.model.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginImplResponse {
    private String id;
    private String name;
    private String login;
}