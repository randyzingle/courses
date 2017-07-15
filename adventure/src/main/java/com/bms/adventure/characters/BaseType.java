package com.bms.adventure.characters;

import java.util.HashMap;
import java.util.Random;

import com.bms.adventure.characters.equipment.Armor;
import com.bms.adventure.characters.equipment.ArmorDetails;
import com.bms.adventure.characters.equipment.Weapon;
import com.bms.adventure.characters.equipment.WeaponDetails;
import com.bms.adventure.storage.ArmorLoader;
import com.bms.adventure.storage.WeaponsLoader;

public class BaseType {

	private Race race;
	private CharacterClassEnum characterClass;
	private AbilitiesEnum primary;
	private AbilitiesEnum secondary;
	private AbilitiesEnum tertiary;
	private HashMap<AbilitiesEnum, Integer> racialAbilityModifiers = new HashMap<>(3);
	private int age;
	private Weapon weapon;
	private Armor armor;

	public BaseType(Race race, CharacterClassEnum characterClass) {
		this.race = race;
		this.characterClass = characterClass;
		weapon = race.getWeapon();
		armor = race.getArmor();
		// Race + Class specializations
		if (characterClass == CharacterClassEnum.fighter) {
			if (race.getRacialType() == RaceEnum.dwarf) {
				primary = AbilitiesEnum.strength;
				secondary = AbilitiesEnum.constitution;
				tertiary = AbilitiesEnum.wisdom;
				age = randomAge(50);			
			} else if (race.getRacialType() == RaceEnum.elf) {			
				primary = AbilitiesEnum.dexterity;
				secondary = AbilitiesEnum.strength;
				tertiary = AbilitiesEnum.wisdom;
				age = randomAge(70);
			} else if (race.getRacialType() == RaceEnum.human) {
				primary = AbilitiesEnum.strength;
				secondary = AbilitiesEnum.constitution;
				tertiary = AbilitiesEnum.wisdom;
				age = randomAge(21);
			}
		}
		// Pure Racial Adjustments
		if (race.getRacialType() == RaceEnum.dwarf) {
			racialAbilityModifiers.put(AbilitiesEnum.constitution, 2);
			racialAbilityModifiers.put(AbilitiesEnum.charisma, -2);
		} else if (race.getRacialType() == RaceEnum.elf) {			
			racialAbilityModifiers.put(AbilitiesEnum.dexterity, 2);
			racialAbilityModifiers.put(AbilitiesEnum.constitution, -2);
		} else if (race.getRacialType() == RaceEnum.human) {
			primary = AbilitiesEnum.strength;
			secondary = AbilitiesEnum.constitution;
			tertiary = AbilitiesEnum.wisdom;
		}
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
	private int randomAge(int baseAge) {
		Random random = new Random();
		return baseAge + random.nextInt(baseAge/3);
	}
	
	public HashMap<AbilitiesEnum, Integer> getRacialAbilityModifiers() {
		return racialAbilityModifiers;
	}

	public void setRacialAbilityModifiers(HashMap<AbilitiesEnum, Integer> racialAbilityModifiers) {
		this.racialAbilityModifiers = racialAbilityModifiers;
	}
	
	public Race getRace() {
		return race;
	}
	
	public int getAge() {
		return age;
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

	public String getRaceName() {
		return race.getRacialType().toString();
	}

	@Override
	public String toString() {
		return "BaseType [race=" + race + ", characterClass=" + characterClass + ", primary=" + primary + ", secondary="
				+ secondary + ", tertiary=" + tertiary + ", racialAbilityModifiers=" + racialAbilityModifiers + ", age="
				+ age + ", weapon=" + weapon + ", armor=" + armor + "]";
	}


	
}
