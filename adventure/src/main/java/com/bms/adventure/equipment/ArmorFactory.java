package com.bms.adventure.equipment;

public class ArmorFactory {
	
	public static Armor getArmor(String armorName) {
		return getArmor(armorName, "", 0);
	}

	public static Armor getArmor(String armorName, String description, int magicBonus) {
		ArmorDetails armorDetails = ArmorLoader.getArmorDetails(armorName);
		Armor armor = new Armor(armorDetails, description, magicBonus);
		return armor;
	}
}
