package com.bms.adventure.characters.race;

import java.util.HashMap;

import com.bms.adventure.characters.AbilitiesEnum;
import com.bms.adventure.characters.Faction;
import com.bms.adventure.equipment.Armor;
import com.bms.adventure.equipment.ArmorFactory;
import com.bms.adventure.equipment.ArmorLoader;
import com.bms.adventure.equipment.Weapon;
import com.bms.adventure.equipment.WeaponsFactory;
import com.bms.adventure.equipment.WeaponsLoader;

public class Dwarf extends Race {

	// starting armor, weapons for dwarf
	Armor startingArmor = ArmorFactory.getArmor(ArmorLoader.SCALE_MAIL);
	Weapon startingWeapon = WeaponsFactory.getWeapon(WeaponsLoader.WARHAMMER);
	
	public Dwarf() {
		racialAbilityModifiers = new HashMap<>();
		racialAbilityModifiers.put(AbilitiesEnum.constitution, 2);
		racialAbilityModifiers.put(AbilitiesEnum.charisma, -2);
		racialType = RaceEnum.dwarf;
		armor = startingArmor; 
		weapon = startingWeapon;
		gold = 50;
		faction = new Faction(RaceEnum.dwarf.name());
		age = randomAge(50);
	}

	@Override
	public String toString() {
		return "Dwarf [racialAbilityModifiers=" + racialAbilityModifiers + ", racialType=" + racialType + ", faction="
				+ faction + ", armor=" + armor + ", weapon=" + weapon + ", gold=" + gold + ", age=" + age + "]";
	}
	


}
