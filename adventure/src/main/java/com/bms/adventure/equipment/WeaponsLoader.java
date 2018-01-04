package com.bms.adventure.equipment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import com.bms.adventure.utils.PropertyLoader;

public class WeaponsLoader {
	
	private static final String STATIC_WEAPON_SOURCE = "static";
	private static final String FILE_WEAPON_SOURCE = "file";
	private static final String DATABASE_WEAPON_SOURCE = "database";
	
	private static final String WEAPONS_FILE = "src/main/resources/data/weapons.txt";
	
	private static HashMap<String, WeaponDetails> weaponsMap;
	
	public static void main(String[] args) {
		// load all of the weapons and print them out
		loadWeapons();
		Set<String> keySet = weaponsMap.keySet();
		for (String key: keySet) {
			System.out.println(weaponsMap.get(key));
		}
	}
	
	private WeaponsLoader() {}
	
	
	
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
//				loadHardCodedWeapons();	
			} else if (weapon_source.equals(FILE_WEAPON_SOURCE)) {
//				loadWeaponsFromFile();
			} else {
				// default to hard-coded
//				loadHardCodedWeapons();
			}
		}
		return weaponsMap;
	}

}
