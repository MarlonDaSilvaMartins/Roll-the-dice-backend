package com.rollthedice.impl.login.repository.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document("login")
public class LoginEntity {
    @Id
    private String id;
    private String name;
    private String login;
    private String password;
}