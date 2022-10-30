package com.rollthedice.impl.character.repository.entity;

import com.rollthedice.commons.utils.enums.ClassTypeEnum;
import com.rollthedice.commons.utils.enums.RaceTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Builder
@Data
@Document(collection = "character")
public class CharacterEntity{
    @Id
    private String id;
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