package com.bms.adventure.characters.race;

import java.util.HashMap;

import com.bms.adventure.characters.AbilitiesEnum;
import com.bms.adventure.characters.Faction;
import com.bms.adventure.characters.equipment.Armor;
import com.bms.adventure.characters.equipment.ArmorFactory;
import com.bms.adventure.characters.equipment.ArmorLoader;
import com.bms.adventure.characters.equipment.Weapon;
import com.bms.adventure.characters.equipment.WeaponsFactory;
import com.bms.adventure.characters.equipment.WeaponsLoader;

public class Elf extends Race {

	// starting armor, weapons for elf
	Armor startingArmor = ArmorFactory.getArmor(ArmorLoader.ELVIN_CHAIN);
	Weapon startingWeapon = WeaponsFactory.getWeapon(WeaponsLoader.LONGSWORD);
	
	public Elf() {
		racialAbilityModifiers = new HashMap<>();
		racialAbilityModifiers.put(AbilitiesEnum.dexterity, 2);
		racialAbilityModifiers.put(AbilitiesEnum.constitution, -2);
		racialType = RaceEnum.elf;
		armor = startingArmor;
		weapon = startingWeapon;
		gold = 50;
		faction = new Faction(RaceEnum.elf.name());
		age = randomAge(70);
	}

	@Override
	public String toString() {
		return "Elf [racialAbilityModifiers=" + racialAbilityModifiers + ", racialType=" + racialType + ", faction="
				+ faction + ", armor=" + armor + ", weapon=" + weapon + ", gold=" + gold + ", age=" + age + "]";
	}
	


}
