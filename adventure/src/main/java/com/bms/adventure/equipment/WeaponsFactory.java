package com.bms.adventure.equipment;

public class WeaponsFactory {
	
	private WeaponsFactory() {}
	
	public static Weapon getWeapon(String weaponName) {
		return getWeapon(weaponName, "", 0);
	}
	public static Weapon getWeapon(String weaponName, String description, int magicBonus) {
		WeaponDetails weaponDetails = WeaponsLoader.getWeaponDetails(weaponName);
		Weapon weapon = new Weapon(weaponDetails, description, magicBonus);
		return weapon;
	}
}
