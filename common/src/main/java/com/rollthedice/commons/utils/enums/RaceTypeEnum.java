package com.rollthedice.commons.utils.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RaceTypeEnum {
    @JsonProperty("Humano")
    HUMAN("Humano"),
    @JsonProperty("Elfo")
    ELF("Elfo"),
    @JsonProperty("Anão")
    DWARF("Anão"),
    @JsonProperty("Orc")
    ORC("Orc");
    private final String raceType;
}