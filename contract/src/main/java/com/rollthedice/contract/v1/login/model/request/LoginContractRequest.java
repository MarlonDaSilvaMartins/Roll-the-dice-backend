package com.rollthedice.contract.v1.login.model.request;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginContractRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}