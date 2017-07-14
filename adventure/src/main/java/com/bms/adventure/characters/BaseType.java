package com.bms.adventure.characters;

import java.util.HashMap;

public class BaseType {

	private HashMap<AbilitiesEnum, Integer> abilityModifier = new HashMap<>();
	private Race race;
	private CharacterClassEnum characterClass;
	private AbilitiesEnum primary;
	private AbilitiesEnum secondary;
	private AbilitiesEnum tertiary;
	
	public BaseType(Race race, CharacterClassEnum characterClass) {
		this.race = race;
		this.characterClass = characterClass;
		if (characterClass == CharacterClassEnum.fighter) {
			if (race.getRacialType() == RaceEnum.dwarf) {
				primary = AbilitiesEnum.strength;
				secondary = AbilitiesEnum.constitution;
				tertiary = AbilitiesEnum.wisdom;
			} else if (race.getRacialType() == RaceEnum.elf) {			
				primary = AbilitiesEnum.dexterity;
				secondary = AbilitiesEnum.strength;
				tertiary = AbilitiesEnum.wisdom;
			} else if (race.getRacialType() == RaceEnum.human) {
				primary = AbilitiesEnum.strength;
				secondary = AbilitiesEnum.constitution;
				tertiary = AbilitiesEnum.wisdom;
			}
		}
	}
	
	public Race getRace() {
		return race;
	}
	
	public RaceEnum getRacialType() {
		return race.getRacialType();
	}

	public CharacterClassEnum getCharacterClass() {
		return characterClass;
	}
	
	public AbilitiesEnum getPrimary() {
		return primary;
	}

	public AbilitiesEnum getSecondary() {
		return secondary;
	}

	public AbilitiesEnum getTertiary() {
		return tertiary;
	}

	public HashMap<AbilitiesEnum, Integer> getAbilityModifier() {
		return abilityModifier;
	}

	public String getRaceName() {
		return race.getRacialType().toString();
	}

	@Override
	public String toString() {
		return "BaseType [racialType=" + race.getRacialType() + ", characterClass=" + characterClass + "]";
	}


	
}
