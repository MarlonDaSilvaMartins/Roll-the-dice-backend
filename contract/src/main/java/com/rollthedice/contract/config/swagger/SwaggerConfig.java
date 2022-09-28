package com.rollthedice.contract.config.swagger;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.rollthedice.contract"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(info());
    }
    
    private ApiInfo info() {
        return new ApiInfoBuilder()
            .title("Roll The Dice API")
            .description("Service dedicated to manage RPG characters")
            .version("v1")
            .contact(this.contact())
            .license("Apache License Version 2.0")
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
            .build();
    }
    
    private Contact contact() {
        return new Contact(
            "Marlon Martins",
            "https://github.com/MarlonDaSilvaMartins/Roll-the-dice-backend",
            "marlon673@hotmail.com");
    }
}