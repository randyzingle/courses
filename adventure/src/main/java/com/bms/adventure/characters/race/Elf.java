package com.bms.adventure.characters.race;

import java.util.HashMap;

import com.bms.adventure.characters.AbilitiesEnum;
import com.bms.adventure.characters.equipment.Armor;
import com.bms.adventure.characters.equipment.ArmorDetails;
import com.bms.adventure.characters.equipment.ArmorLoader;
import com.bms.adventure.characters.equipment.Weapon;
import com.bms.adventure.characters.equipment.WeaponDetails;
import com.bms.adventure.characters.equipment.WeaponsLoader;

public class Elf extends Race {

	// starting armor, weapons for elf
	ArmorDetails startingArmor = ArmorLoader.getArmor().get(ArmorDetails.LEATHER);
	WeaponDetails startingWeapon = WeaponsLoader.getWeapons().get(WeaponDetails.LONGSWORD);
	
	public Elf() {
		racialAbilityModifiers = new HashMap<>();
		racialAbilityModifiers.put(AbilitiesEnum.dexterity, 2);
		racialAbilityModifiers.put(AbilitiesEnum.constitution, -2);
		racialType = RaceEnum.elf;
		armor = new Armor(startingArmor);
		weapon = new Weapon(startingWeapon);
		gold = 50;
		age = randomAge(70);
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
	@Override
	public String toString() {
		return "Elf [racialType=" + racialType + ", armor=" + armor + ", weapon=" + weapon + ", gold=" + gold + "]";
	}

}
