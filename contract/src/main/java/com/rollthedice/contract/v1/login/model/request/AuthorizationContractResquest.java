package com.rollthedice.contract.v1.login.model.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthorizationContractResquest {
    private String login;
    private String password;
}