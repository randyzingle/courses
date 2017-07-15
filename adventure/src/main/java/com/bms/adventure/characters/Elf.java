package com.bms.adventure.characters;

import java.util.HashMap;

import com.bms.adventure.characters.equipment.Armor;
import com.bms.adventure.characters.equipment.ArmorDetails;
import com.bms.adventure.characters.equipment.Weapon;
import com.bms.adventure.characters.equipment.WeaponDetails;
import com.bms.adventure.storage.ArmorLoader;
import com.bms.adventure.storage.WeaponsLoader;

public class Elf extends Race {

	// starting armor, weapons for elf
	ArmorDetails armorDetails = ArmorLoader.getArmor().get(ArmorDetails.LEATHER);
	WeaponDetails weaponDetails = WeaponsLoader.getWeapons().get(WeaponDetails.LONGSWORD);
	
	public Elf() {
		abilityModifiers = new HashMap<>();
		abilityModifiers.put(AbilitiesEnum.dexterity, 2);
		abilityModifiers.put(AbilitiesEnum.constitution, -2);
		racialType = RaceEnum.elf;
		armor = new Armor(armorDetails);
		weapon = new Weapon(weaponDetails);
		gold = 50;
	}

	@Override
	public String toString() {
		return "Elf [racialType=" + racialType + ", armor=" + armor + ", weapon=" + weapon + ", gold=" + gold + "]";
	}
	
}
