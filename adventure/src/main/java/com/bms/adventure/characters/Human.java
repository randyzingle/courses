package com.bms.adventure.characters;

import java.util.HashMap;

import com.bms.adventure.characters.equipment.Armor;
import com.bms.adventure.characters.equipment.ArmorDetails;
import com.bms.adventure.characters.equipment.Weapon;
import com.bms.adventure.characters.equipment.WeaponDetails;
import com.bms.adventure.storage.ArmorLoader;
import com.bms.adventure.storage.WeaponsLoader;

public class Human extends Race {

	// starting armor, weapons for human
	ArmorDetails armorDetails = ArmorLoader.getArmor().get(ArmorDetails.CHAIN_SHIRT);
	WeaponDetails weaponDetails = WeaponsLoader.getWeapons().get(WeaponDetails.MACE);
	
	public Human() {
		abilityModifiers = new HashMap<>();
		racialType = RaceEnum.human;
		armor = new Armor(armorDetails);
		weapon = new Weapon(weaponDetails);
		gold = 50;
	}
	
	
}
