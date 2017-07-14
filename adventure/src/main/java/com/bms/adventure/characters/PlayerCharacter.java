package com.bms.adventure.characters;

import com.bms.adventure.utils.AbilityGenerator;

public class PlayerCharacter {
	
	private String name;	
	private Abilities abilities;
	private BaseType baseType;
	
	public PlayerCharacter(String name) {
		this.name = name;
	}
	
	public PlayerCharacter(String name, BaseType baseType) {
		this.name = name;
		this.baseType = baseType;
		this.abilities = AbilityGenerator.generateAbilities(baseType);
	}

	public String getName() {
		return name;
	}

	public Abilities getAbilities() {
		return abilities;
	}

	public BaseType getBaseType() {
		return baseType;
	}

	@Override
	public String toString() {
		return "PlayerCharacter [name=" + name + ", abilities=" + abilities + ", baseType=" + baseType + "]";
	}
	
	


}
