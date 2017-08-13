package com.bms.adventure.characters.equipment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class WeaponsLoader {
	
	public static void main(String[] args) {
		// load all of the weapons and print them out
		getWeapons();
		Set<String> keySet = weaponsMap.keySet();
		for (String key: keySet) {
			System.out.println(weaponsMap.get(key));
		}
	}
	
	private WeaponsLoader() {};
	
	private static HashMap<String, WeaponDetails> weaponsMap;

	public static HashMap<String, WeaponDetails> getWeapons() {
		if (weaponsMap == null) loadHardCodedWeapons();	
		return weaponsMap;
	}
	
	private static void loadHardCodedWeapons() {
		// crits
		weaponsMap = new HashMap<>();
		TreeSet<Integer> ct18 = new TreeSet<>(Arrays.asList(18,19,20));
		TreeSet<Integer> ct19 = new TreeSet<>(Arrays.asList(19,20));
		TreeSet<Integer> ct20 = new TreeSet<>(Arrays.asList(20));
		
		// weapons
		weaponsMap.put(WeaponDetails.RAPIER, new WeaponDetails(WeaponDetails.RAPIER, 20, 3, 1, 6, ct18, 2));
		weaponsMap.put(WeaponDetails.WARHAMMER, new WeaponDetails(WeaponDetails.WARHAMMER, 12, 8, 1, 8, ct20, 3));
		weaponsMap.put(WeaponDetails.LONGSWORD, new WeaponDetails(WeaponDetails.LONGSWORD, 15, 4, 1, 8, ct19, 2));
		weaponsMap.put(WeaponDetails.MACE, new WeaponDetails(WeaponDetails.MACE, 12, 12, 1, 8, ct20, 2));

	}
}
