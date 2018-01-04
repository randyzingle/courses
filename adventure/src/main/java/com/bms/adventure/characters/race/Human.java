package com.bms.adventure.characters.race;

import java.util.HashMap;

import com.bms.adventure.characters.Faction;
import com.bms.adventure.equipment.Armor;
import com.bms.adventure.equipment.ArmorFactory;
import com.bms.adventure.equipment.ArmorLoader;
import com.bms.adventure.equipment.Weapon;
import com.bms.adventure.equipment.WeaponsFactory;
import com.bms.adventure.equipment.WeaponsLoader;

public class Human extends Race {

	// starting armor, weapons for human
	Armor startingArmor = ArmorFactory.getArmor(ArmorLoader.CHAIN_SHIRT);
	Weapon startingWeapon = WeaponsFactory.getWeapon(WeaponsLoader.MACE);
	
	public Human() {
		racialAbilityModifiers = new HashMap<>();
		racialType = RaceEnum.human;
		armor = startingArmor;
		weapon = startingWeapon;
		gold = 50;
		faction = new Faction(RaceEnum.human.name());
		age = randomAge(19);
	}

	@Override
	public String toString() {
		return "Human [racialAbilityModifiers=" + racialAbilityModifiers + ", racialType=" + racialType + ", faction="
				+ faction + ", armor=" + armor + ", weapon=" + weapon + ", gold=" + gold + ", age=" + age + "]";
	}


}
