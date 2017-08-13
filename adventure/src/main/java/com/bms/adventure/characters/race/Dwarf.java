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

public class Dwarf extends Race {

	// starting armor, weapons for dwarf
	ArmorDetails startingArmor = ArmorLoader.getArmor().get(ArmorDetails.SCALE_MAIL);
	WeaponDetails startingWeapon = WeaponsLoader.getWeapons().get(WeaponDetails.WARHAMMER);
	
	public Dwarf() {
		racialAbilityModifiers = new HashMap<>();
		racialAbilityModifiers.put(AbilitiesEnum.constitution, 2);
		racialAbilityModifiers.put(AbilitiesEnum.charisma, -2);
		racialType = RaceEnum.dwarf;
		armor = new Armor(startingArmor);
		weapon = new Weapon(startingWeapon);
		gold = 50;
		faction = new Faction("dwarf");
		age = randomAge(50);
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
		return "Dwarf [racialType=" + racialType + ", armor=" + armor + ", weapon=" + weapon + ", gold=" + gold + "]";
	}

}
