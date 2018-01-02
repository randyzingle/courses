package com.bms.adventure.characters.equipment;

import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import com.bms.adventure.utils.PropertyLoader;

public class WeaponsLoader {
	
	private static final String STATIC_WEAPON_SOURCE = "static";
	private static final String FILE_WEAPON_SOURCE = "file";
	private static final String DATABASE_WEAPON_SOURCE = "database";
	
	public static final String RAPIER = "rapier";
	public static final String WARHAMMER = "warhammer";
	public static final String LONGSWORD = "longsword";
	public static final String MACE = "mace";
	
	public static void main(String[] args) {
		// load all of the weapons and print them out
		loadWeapons();
		Set<String> keySet = weaponsMap.keySet();
		for (String key: keySet) {
			System.out.println(weaponsMap.get(key));
		}
	}
	
	private WeaponsLoader() {};
	
	private static HashMap<String, WeaponDetails> weaponsMap;
	
	public static WeaponDetails getWeaponDetails(String weaponName) {
		if(weaponsMap == null || weaponsMap.isEmpty()) {
			loadWeapons();
		}
		return weaponsMap.get(weaponName);
	}

	private static HashMap<String, WeaponDetails> loadWeapons() {
		if (weaponsMap == null || weaponsMap.isEmpty()) {
			Properties props = PropertyLoader.getStartupProps();
			String weapon_source = props.getProperty("weapon_source");
			if (weapon_source.equals(STATIC_WEAPON_SOURCE)) {
				loadHardCodedWeapons();	
			} else {
				// this is all we have right now
				loadHardCodedWeapons();
			}
		}
		return weaponsMap;
	}
	
	private static void loadHardCodedWeapons() {
		weaponsMap = new HashMap<>();
		// weapons
		weaponsMap.put(WeaponsLoader.RAPIER, new WeaponDetails(WeaponsLoader.RAPIER, 20, 3, 1, 6, 18, 2));
		weaponsMap.put(WeaponsLoader.WARHAMMER, new WeaponDetails(WeaponsLoader.WARHAMMER, 12, 8, 1, 8, 20, 3));
		weaponsMap.put(WeaponsLoader.LONGSWORD, new WeaponDetails(WeaponsLoader.LONGSWORD, 15, 4, 1, 8, 19, 2));
		weaponsMap.put(WeaponsLoader.MACE, new WeaponDetails(WeaponsLoader.MACE, 12, 12, 1, 8, 20, 2));

	}
}
