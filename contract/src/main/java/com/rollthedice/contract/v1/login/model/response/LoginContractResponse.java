package com.rollthedice.contract.v1.login.model.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginContractResponse {
    private String name;
    private String login;
}