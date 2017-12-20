package com.bms.adventure.utils;

import com.bms.adventure.characters.AbilitiesEnum;
import com.bms.adventure.characters.CharacterClass;
import com.bms.adventure.characters.Fighter;
import com.bms.adventure.characters.equipment.Armor;
import com.bms.adventure.characters.equipment.Weapon;
import com.bms.adventure.characters.race.Race;
import com.bms.adventure.characters.race.RaceEnum;

/**
 * CharacterClassInitializer is a mixture of CharacterClass and Race. 
 * 
 * You need both to determine which abilities a PlayerCharacter will want to maximize,
 * and which starting weapons and armor they will have.
 * 
 * @author rzingle
 *
 */
public class CharacterClassInitializer {

	private Race race;
	private CharacterClass characterClass;
	private AbilitiesEnum primary;
	private AbilitiesEnum secondary;
	private AbilitiesEnum tertiary;

	public CharacterClassInitializer(Race race, CharacterClass characterClass) {
		this.race = race;
		this.characterClass = characterClass;
		// Race + Class specializations
		if (characterClass instanceof Fighter) {
			if (race.getRacialType() == RaceEnum.dwarf) {
				primary = AbilitiesEnum.strength;
				secondary = AbilitiesEnum.constitution;
				tertiary = AbilitiesEnum.wisdom;			
			} else if (race.getRacialType() == RaceEnum.elf) {			
				primary = AbilitiesEnum.dexterity;
				secondary = AbilitiesEnum.strength;
				tertiary = AbilitiesEnum.constitution;
			} else if (race.getRacialType() == RaceEnum.human) {
				primary = AbilitiesEnum.strength;
				secondary = AbilitiesEnum.constitution;
				tertiary = AbilitiesEnum.dexterity;
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

	public Race getRace() {
		return race;
	}




	
}
