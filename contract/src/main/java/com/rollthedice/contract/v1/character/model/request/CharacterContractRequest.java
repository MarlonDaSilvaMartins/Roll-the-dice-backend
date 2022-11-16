package com.rollthedice.contract.v1.character.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.rollthedice.commons.utils.enums.ClassTypeEnum;
import com.rollthedice.commons.utils.enums.RaceTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CharacterContractRequest {
    @NotBlank(message = "Nome não pode ser nulo")
    private String name;
    @NotEmpty(message = "Classe não pode ser nulo")
    private ClassTypeEnum characterClass;
    @NotEmpty(message = "Raça não pode ser nulo")
    private RaceTypeEnum race;
    @Positive
    @Builder.Default
    private Integer level = 1;
    @PositiveOrZero
    @Builder.Default
    private Integer lifePoints = 0;
    @PositiveOrZero
    @Builder.Default
    private Integer magicPoints = 0;
    @PositiveOrZero
    @Builder.Default
    private Integer attackPoints = 0;
    @PositiveOrZero
    @Builder.Default
    private Integer defensePoints = 0;
    @PositiveOrZero
    @Builder.Default
    private Integer expertisePoints = 0;
}