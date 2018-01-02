package com.bms.adventure.characters.equipment;

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
			} else if (weapon_source.equals(FILE_WEAPON_SOURCE)) {
				loadWeaponsFromFile();
			} else {
				// default to hard-coded
				loadHardCodedWeapons();
			}
		}
		return weaponsMap;
	}
	
	private static void loadWeaponsFromFile() {
		weaponsMap = new HashMap<>();
		int nfound = 0;
		int ngood = 0;
		// weapons
		try {
			BufferedReader br = new BufferedReader(new FileReader(WEAPONS_FILE));
			String s = null;
			while ((s = br.readLine()) != null) {
				if (s.startsWith("#")) {
					// comment line
					System.out.println(s);
				} else {
					nfound += 1;
					WeaponDetails wd = parseWeaponDetailsFromFile(s);
					if (wd != null) {
						ngood += 1;
						weaponsMap.put(wd.getName(), wd);
					}
				}
			}
			br.close();
			System.out.printf("Found %d weapons, loaded %d weapons%n", nfound, ngood);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static WeaponDetails parseWeaponDetailsFromFile(String s) {
		WeaponDetails wd = null;
		String[] ss = s.split(",");
		if (ss.length == 7) {
			try {
				String name = ss[0].trim();
				int cost = Integer.parseInt(ss[1].trim());
				double weight = Double.parseDouble(ss[2].trim());
				int ndice = Integer.parseInt(ss[3].trim());
				int nsides = Integer.parseInt(ss[4].trim());
				int critThreshold = Integer.parseInt(ss[5].trim());
				int critMult = Integer.parseInt(ss[6].trim());
				wd = new WeaponDetails(name, cost, weight, ndice, nsides, critThreshold, critMult);
			} catch (Exception ex) {
				System.out.println("Couldn't parse weapon");
			}
		} else {
			System.out.println("Couldn't parse weapon");
		}
		return wd;
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
