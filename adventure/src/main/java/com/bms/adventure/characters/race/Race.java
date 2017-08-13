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
	
	public int randomAge(int baseAge) {
		Random random = new Random();
		return baseAge + random.nextInt(baseAge/3);
	}
	
	public abstract RaceEnum getRacialType();
	
	public abstract Weapon getStartingWeapon();
	
	public abstract Armor getStartingArmor();
	
	@Override
	public String toString() {
		return "Race [racialType=" + racialType + "]";
	}
	
}
