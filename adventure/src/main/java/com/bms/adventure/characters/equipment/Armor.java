package com.bms.adventure.characters.equipment;

public class Armor implements Equipment {
	
	private ArmorDetails armorDetails;
	private static final String slot = "BODY";
	private int magicBonus;
	
	public Armor(ArmorDetails armorDetails, String description, int magicBonus) {
		this.armorDetails = armorDetails;
		this.magicBonus = magicBonus;
	}
	
	public int getArmorBonus() {
		return armorDetails.getArmorBonus();
	}
	
	public int getMaxDexBonus() {
		return armorDetails.getMaxDex();
	}
	
	public int getMagicBonus() {
		return magicBonus;
	}

	@Override
	public int getCost() {
		return armorDetails.getCost();
	}

	@Override
	public double getWeight() {
		return armorDetails.getWeight();
	}

	@Override
	public String getSlot() {
		return slot;
	}

	@Override
	public String toString() {
		return "Armor [armorDetails=" + armorDetails + "]";
	}

}
