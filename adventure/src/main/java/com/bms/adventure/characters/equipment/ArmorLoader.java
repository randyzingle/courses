package com.bms.adventure.characters.equipment;

import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import com.bms.adventure.utils.PropertyLoader;

public class ArmorLoader {
	
	public static final String CHAIN_SHIRT = "chain shirt";
	public static final String ELVIN_CHAIN = "elvin chainmail";
	public static final String LEATHER = "leather armor";
	public static final String SCALE_MAIL = "scale mail";
	
	private static final String STATIC_ARMOR_SOURCE = "static";
	private static final String FILE_ARMOR_SOURCE = "file";
	private static final String DATABASE_ARMOR_SOURCE = "database";
	
	public static void main(String[] args) {
		// load all of the weapons and print them out
		loadArmor();
		Set<String> keySet = armorMap.keySet();
		for (String key: keySet) {
			System.out.println(armorMap.get(key));
		}
	}
	
	private ArmorLoader() {}
	
	private static HashMap<String, ArmorDetails> armorMap;
	
	public static ArmorDetails getArmorDetails(String armorName) {
		if (armorMap == null || armorMap.isEmpty()) {
			loadArmor();
		}
		return armorMap.get(armorName);
	}

	private static HashMap<String, ArmorDetails> loadArmor() {
		if (armorMap == null || armorMap.isEmpty()) {
			Properties props = PropertyLoader.getStartupProps();
			String armor_source = props.getProperty("armor_source");
			if (armor_source.equals(FILE_ARMOR_SOURCE)) {
				loadHardCodedArmor();	
			} else {
				// this is all we have right now
				loadHardCodedArmor();
			}
		}
		return armorMap;
	}
	
	private static void loadHardCodedArmor() {
		armorMap = new HashMap<>();
		// armor
		armorMap.put(ArmorLoader.LEATHER, new ArmorDetails(ArmorLoader.LEATHER, 10, 15, 2, 6));
		armorMap.put(ArmorLoader.CHAIN_SHIRT, new ArmorDetails(ArmorLoader.CHAIN_SHIRT, 100, 25, 4, 4));
		armorMap.put(ArmorLoader.ELVIN_CHAIN, new ArmorDetails(ArmorLoader.ELVIN_CHAIN, 800, 10, 4, 6));
		armorMap.put(ArmorLoader.SCALE_MAIL, new ArmorDetails(ArmorLoader.SCALE_MAIL, 50, 30, 4, 3));
	}
}
