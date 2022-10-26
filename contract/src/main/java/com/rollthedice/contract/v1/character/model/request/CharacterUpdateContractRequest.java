package com.rollthedice.contract.v1.character.model.request;

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
public class CharacterUpdateContractRequest {
    private String name;
    private ClassTypeEnum characterClass;
    private RaceTypeEnum race;
    private Integer level;
    private Integer lifePoints;
    private Integer magicPoints;
    private Integer attackPoints;
    private Integer defensePoints;
    private Integer expertisePoints;
}
