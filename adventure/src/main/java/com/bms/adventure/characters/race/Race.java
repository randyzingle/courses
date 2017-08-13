package com.bms.adventure.characters.race;

import java.util.HashMap;
import java.util.Random;

import com.bms.adventure.characters.AbilitiesEnum;
import com.bms.adventure.characters.Faction;
import com.bms.adventure.characters.equipment.Armor;
import com.bms.adventure.characters.equipment.Weapon;

public abstract class Race {	
	
	HashMap<AbilitiesEnum, Integer> racialAbilityModifiers;
	RaceEnum racialType;
	Faction faction;
	// starting values for the following
	Armor armor;
	Weapon weapon;
	int gold;
	int age;
	
	
	
	public HashMap<AbilitiesEnum, Integer> getRacialAbilityModifiers() {
		return racialAbilityModifiers;
	}



	public RaceEnum getRacialType() {
		return racialType;
	}



	public Faction getFaction() {
		return faction;
	}



	public Armor getArmor() {
		return armor;
	}



	public Weapon getWeapon() {
		return weapon;
	}



	public int getGold() {
		return gold;
	}



	public int getAge() {
		return age;
	}



	public int randomAge(int baseAge) {
		Random random = new Random();
		return baseAge + random.nextInt(baseAge/3);
	}



	@Override
	public String toString() {
		return "Race [racialAbilityModifiers=" + racialAbilityModifiers + ", racialType=" + racialType + ", faction="
				+ faction.getFactionName() + ", armor=" + armor + ", weapon=" + weapon + ", gold=" + gold + ", age=" + age + "]";
	}
	
	
	
}
