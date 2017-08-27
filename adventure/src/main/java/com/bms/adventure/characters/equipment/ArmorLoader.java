package com.bms.adventure.characters.equipment;

import java.util.HashMap;
import java.util.Set;

public class ArmorLoader {
	public static void main(String[] args) {
		// load all of the weapons and print them out
		getArmor();
		Set<String> keySet = armorMap.keySet();
		for (String key: keySet) {
			System.out.println(armorMap.get(key));
		}
	}
	
	private static HashMap<String, ArmorDetails> armorMap;

	public static HashMap<String, ArmorDetails> getArmor() {
		if (armorMap == null) loadHardCodedArmor();	
		return armorMap;
	}
	
	private static void loadHardCodedArmor() {
		armorMap = new HashMap<>();
		// armor
		armorMap.put(ArmorDetails.LEATHER, new ArmorDetails(ArmorDetails.LEATHER, 10, 15, 2, 6));
		armorMap.put(ArmorDetails.CHAIN_SHIRT, new ArmorDetails(ArmorDetails.CHAIN_SHIRT, 100, 25, 4, 4));
		armorMap.put(ArmorDetails.ELVIN_CHAIN, new ArmorDetails(ArmorDetails.ELVIN_CHAIN, 800, 10, 4, 6));
		armorMap.put(ArmorDetails.SCALE_MAIL, new ArmorDetails(ArmorDetails.SCALE_MAIL, 50, 30, 4, 3));
	}
}
