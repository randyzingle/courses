package com.bms.adventure.characters;

import com.bms.adventure.characters.equipment.Armor;
import com.bms.adventure.characters.equipment.Weapon;
import com.bms.adventure.characters.race.Race;
import com.bms.adventure.characters.race.RaceEnum;

public class BaseType {

	private Race race;
	private CharacterClass characterClass;
	private AbilitiesEnum primary;
	private AbilitiesEnum secondary;
	private AbilitiesEnum tertiary;
	private Weapon weapon;
	private Armor armor;

	public BaseType(Race race, CharacterClass.CharacterClassEnum characterClassEnum) {
		this.race = race;
		this.characterClass = makeCharacterClass(characterClassEnum);
		weapon = race.getWeapon();
		armor = race.getArmor();
		// Race + Class specializations
		if (characterClassEnum == CharacterClass.CharacterClassEnum.fighter) {
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
	
	private CharacterClass makeCharacterClass(CharacterClass.CharacterClassEnum characterClassEnum) {
		CharacterClass cc = null;
		if (characterClassEnum == CharacterClass.CharacterClassEnum.fighter) {
			cc = new Fighter();
		} else {
			cc = new Fighter(); // have to be something ...
		}
		return cc;
	}
	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	
	public Race getRace() {
		return race;
	}

	public RaceEnum getRacialType() {
		return race.getRacialType();
	}

	public CharacterClass getCharacterClass() {
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

	public String getRaceName() {
		return race.getRacialType().toString();
	}




	
}
