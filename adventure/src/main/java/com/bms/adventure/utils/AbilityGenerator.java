package com.bms.adventure.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import com.bms.adventure.characters.Abilities;
import com.bms.adventure.characters.AbilitiesEnum;
import com.bms.adventure.characters.BaseType;
import com.bms.adventure.characters.CharacterClassEnum;
import com.bms.adventure.characters.Race;

public class AbilityGenerator {
	
	//TODO need to add re-roll rules:
	// reroll if total modifiers are 0 or less, or if highest score is 13 or lower

	public static Abilities generateRawRandomAbilities() {
		Abilities abilities = null;
		int[] stats = rollRawAbilities();
		abilities = new Abilities(stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]);
		return abilities;
	}
	
	public static Abilities generateAbilities(AbilitiesEnum primary, AbilitiesEnum secondary, AbilitiesEnum tertiary) {
		Abilities abilities = null;
		int[] stats = rollRawAbilities();
		Arrays.sort(stats); // sorts lowest to highest
		HashMap<AbilitiesEnum, Integer> map = new HashMap<>();
		map.put(primary, stats[5]);
		map.put(secondary, stats[4]);
		map.put(tertiary, stats[3]);
		AbilitiesEnum[] allAbilities = AbilitiesEnum.values(); // get all the values as an array
		ArrayList<AbilitiesEnum> emptyAbilities = new ArrayList<>(3);
		for (AbilitiesEnum ab: allAbilities) {
			if(ab != primary && ab != secondary && ab != tertiary) emptyAbilities.add(ab);
		}
		int[] remainingStats = Arrays.copyOfRange(stats, 0,3);
		shuffle(remainingStats);
		for (int i=0; i<remainingStats.length; i++) {
			map.put(emptyAbilities.get(i), remainingStats[i]);
		}
		abilities = new Abilities(map);
		return abilities;
	}
	
	public static Abilities generateAbilities(BaseType baseType) {
		return generateAbilities(baseType.getRace(), baseType.getCharacterClass());
	}
	
	public static Abilities generateAbilities(Race race, CharacterClassEnum characterClassEnum) {
		Abilities abilities = null;
		BaseType baseType = new BaseType(race, characterClassEnum);
		int[] stats = rollRawAbilities();
		Arrays.sort(stats); // sorts lowest to highest
		HashMap<AbilitiesEnum, Integer> map = new HashMap<>();
		// set top stats based on racial preferences
		map.put(baseType.getPrimary(), stats[5]);
		map.put(baseType.getSecondary(), stats[4]);
		map.put(baseType.getTertiary(), stats[3]);
		AbilitiesEnum[] allAbilities = AbilitiesEnum.values(); // get all the values as an array
		ArrayList<AbilitiesEnum> emptyAbilities = new ArrayList<>(3);
		for (AbilitiesEnum ab: allAbilities) {
			if(ab != baseType.getPrimary() && ab != baseType.getSecondary() && ab != baseType.getTertiary()) emptyAbilities.add(ab);
		}
		int[] remainingStats = Arrays.copyOfRange(stats, 0,3);
		shuffle(remainingStats);
		for (int i=0; i<remainingStats.length; i++) {
			map.put(emptyAbilities.get(i), remainingStats[i]);
		}
		// add racial modifiers
		HashMap<AbilitiesEnum, Integer> modifiers = baseType.getRacialAbilityModifiers();
		Set<AbilitiesEnum> modifierKeys = modifiers.keySet();
		for (AbilitiesEnum key: modifierKeys) {
//			int stat = map.get(key);
//			int modifier = modifiers.get(key);
			map.put(key, map.get(key) + modifiers.get(key));
		}
		
		abilities = new Abilities(map);
		return abilities;
	}
	
	public static void shuffle(int[] a) { // move this to Dice
		Random random = new Random();
		int n = a.length;
		for (int i=0; i<n; i++) {
			int r = random.nextInt(n-i) + i;
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	private static int[] rollRawAbilities() {
		int[] stat = new int[6];
		for (int i=0; i<stat.length; i++) {
			stat[i] = Dice.rollDice(3, 6);
		}
		return stat;
	}
	

}
