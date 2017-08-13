package com.bms.adventure.characters.race;

import java.util.HashMap;

import com.bms.adventure.characters.AbilitiesEnum;
import com.bms.adventure.characters.Faction;
import com.bms.adventure.characters.equipment.Armor;
import com.bms.adventure.characters.equipment.ArmorDetails;
import com.bms.adventure.characters.equipment.ArmorLoader;
import com.bms.adventure.characters.equipment.Weapon;
import com.bms.adventure.characters.equipment.WeaponDetails;
import com.bms.adventure.characters.equipment.WeaponsLoader;

public class Human extends Race {

	// starting armor, weapons for human
	ArmorDetails startingArmor = ArmorLoader.getArmor().get(ArmorDetails.CHAIN_SHIRT);
	WeaponDetails startingWeapon = WeaponsLoader.getWeapons().get(WeaponDetails.MACE);
	
	public Human() {
		racialAbilityModifiers = new HashMap<>();
		racialType = RaceEnum.human;
		armor = new Armor(startingArmor);
		weapon = new Weapon(startingWeapon);
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
