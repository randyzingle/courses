package com.bms.adventure.characters.race;

import java.util.HashMap;

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
		age = randomAge(21);
	}

	@Override
	public RaceEnum getRacialType() {
		return racialType;
	}

	@Override
	public Weapon getStartingWeapon() {
		return weapon;
	}

	@Override
	public Armor getStartingArmor() {
		return armor;
	}	
}
