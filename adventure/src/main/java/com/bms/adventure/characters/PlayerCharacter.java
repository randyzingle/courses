package com.bms.adventure.characters;

import com.bms.adventure.utils.AbilityGenerator;

public class PlayerCharacter {
	
	private String name;	
	private Abilities abilities;
	private BaseType baseType;
	private RaceEnum racialType;
	private CharacterClassEnum characterClassEnum;
	
	public PlayerCharacter(String name) {
		this.name = name;
	}
	
	public PlayerCharacter(String name, BaseType baseType) {
		this.name = name;
		this.baseType = baseType;
		this.racialType = baseType.getRacialType();
		this.characterClassEnum = baseType.getCharacterClass();
		this.abilities = AbilityGenerator.generateAbilities(baseType);
	}

	@Override
	public String toString() {
		String s = "PlayerCharacter [%n   name=%s%n   abilities=%s%n   baseType=racialType=%s, characterClassEnum=%s%n]";
		return String.format(s, name, abilities, baseType, racialType, characterClassEnum);
	}

}
