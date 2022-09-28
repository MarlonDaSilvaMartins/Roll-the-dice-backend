package com.rollthedice.commons.utils.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClassTypeEnum {
    @JsonProperty("Guerreiro")
    WARRIOR("Guerreiro"),
    @JsonProperty("Mago")
    MAGE("Mago"),
    @JsonProperty("Caçador")
    HUNTER("Caçador");
    private final String classType;
}