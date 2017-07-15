package com.bms.adventure.storage;

import java.util.HashMap;
import java.util.Set;

import com.bms.adventure.characters.equipment.ArmorDetails;

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
		armorMap.put(ArmorDetails.SCALE_MAIL, new ArmorDetails(ArmorDetails.SCALE_MAIL, 50, 30, 4, 3));
	}
}
