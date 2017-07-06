package com.bms.adventure.characters;

import java.util.HashMap;

public class Abilities {
	
	// raw or base abilities
	private int strength;
	private int intelligence;
	private int wisdom;
	private int dexterity;
	private int constitution;
	private int charisma;
	
	public static final int[] abilityModifiers = getAbilityModifiers();
	
	// raw abilities +/- effects of magic, poison, etc.
	public HashMap<AbilitiesEnum, Integer> abilities = new HashMap<>();
	
	public Abilities(HashMap<AbilitiesEnum, Integer> abilities) {
		this.strength = abilities.get(AbilitiesEnum.strength);
		this.intelligence = abilities.get(AbilitiesEnum.intelligence);
		this.wisdom = abilities.get(AbilitiesEnum.wisdom);
		this.dexterity = abilities.get(AbilitiesEnum.dexterity);
		this.constitution = abilities.get(AbilitiesEnum.constitution);
		this.charisma = abilities.get(AbilitiesEnum.charisma);
		this.abilities = abilities;
	}
	
	public Abilities(int strength, int intelligence, int wisdom, 
			int dexterity, int constitution, int charisma) {
		this.strength = strength;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.charisma = charisma;
		abilities.put(AbilitiesEnum.strength, strength);
		abilities.put(AbilitiesEnum.intelligence, intelligence);
		abilities.put(AbilitiesEnum.wisdom, wisdom);
		abilities.put(AbilitiesEnum.dexterity, dexterity);
		abilities.put(AbilitiesEnum.constitution, constitution);
		abilities.put(AbilitiesEnum.charisma, charisma);
	}
	
	private static int[] getAbilityModifiers() {
		int[] mods = new int[46];
		int mod = -5;
		for (int i=0; i<45; i=i+2) {
			mods[i] = mod;
			mods[i+1] = mod;
			mod++;
		}
		return mods;
	}
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public HashMap<AbilitiesEnum, Integer> getAbilities() {
		return abilities;
	}

	public void setAbilities(HashMap<AbilitiesEnum, Integer> abilities) {
		this.abilities = abilities;
	}

	@Override
	public String toString() {
		return "Abilities [strength=" + strength + ", intelligence=" + intelligence + ", wisdom=" + wisdom
				+ ", dexterity=" + dexterity + ", constitution=" + constitution + ", charisma=" + charisma
				+ ", abilities=" + abilities + "]";
	}
}
