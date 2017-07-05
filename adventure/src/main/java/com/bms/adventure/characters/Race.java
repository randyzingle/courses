package com.bms.adventure.characters;

import java.util.HashMap;

public class Race {
	private HashMap<AbilitiesEnum, Integer> abilityModifier = new HashMap<>();
	private RaceEnum racialType;
	private CharacterClassEnum characterClass;
	private AbilitiesEnum primary;
	private AbilitiesEnum secondary;
	private AbilitiesEnum tertiary;
	
	public Race(RaceEnum racialType, CharacterClassEnum characterClass) {
		this.racialType = racialType;
		this.characterClass = characterClass;
		if (characterClass == CharacterClassEnum.fighter) {
			if (racialType == RaceEnum.dwarf) {
				abilityModifier.put(AbilitiesEnum.constitution, 2);
				abilityModifier.put(AbilitiesEnum.charisma, -2);
				primary = AbilitiesEnum.strength;
				secondary = AbilitiesEnum.constitution;
				tertiary = AbilitiesEnum.wisdom;
			} else if (racialType == RaceEnum.elf) {
				abilityModifier.put(AbilitiesEnum.dexterity, 2);
				abilityModifier.put(AbilitiesEnum.constitution, -2);
				primary = AbilitiesEnum.dexterity;
				secondary = AbilitiesEnum.strength;
				tertiary = AbilitiesEnum.wisdom;
			} else if (racialType == RaceEnum.human) {
				abilityModifier.put(AbilitiesEnum.dexterity, 0);
				abilityModifier.put(AbilitiesEnum.constitution, 0);
				primary = AbilitiesEnum.strength;
				secondary = AbilitiesEnum.constitution;
				tertiary = AbilitiesEnum.wisdom;
			}
		}
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
		return racialType.toString();
	}

	@Override
	public String toString() {
		return "[raceName=" + racialType.toString()  + "]";
	}
	
}
