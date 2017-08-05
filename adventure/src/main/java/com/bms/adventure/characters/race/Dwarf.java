package com.bms.adventure.characters.race;

import java.util.HashMap;

import com.bms.adventure.characters.AbilitiesEnum;
import com.bms.adventure.characters.RaceEnum;
import com.bms.adventure.characters.equipment.Armor;
import com.bms.adventure.characters.equipment.ArmorDetails;
import com.bms.adventure.characters.equipment.Weapon;
import com.bms.adventure.characters.equipment.WeaponDetails;
import com.bms.adventure.storage.ArmorLoader;
import com.bms.adventure.storage.WeaponsLoader;

public class Dwarf extends Race {

	// starting armor, weapons for dwarf
	ArmorDetails armorDetails = ArmorLoader.getArmor().get(ArmorDetails.SCALE_MAIL);
	WeaponDetails weaponDetails = WeaponsLoader.getWeapons().get(WeaponDetails.WARHAMMER);
	
	public Dwarf() {
		abilityModifiers = new HashMap<>();
		abilityModifiers.put(AbilitiesEnum.constitution, 2);
		abilityModifiers.put(AbilitiesEnum.charisma, -2);
		racialType = RaceEnum.dwarf;
		armor = new Armor(armorDetails);
		weapon = new Weapon(weaponDetails);
		gold = 50;
		faction = new Faction();
	}

	@Override
	public String toString() {
		return "Dwarf [racialType=" + racialType + ", armor=" + armor + ", weapon=" + weapon + ", gold=" + gold + "]";
	}

}
