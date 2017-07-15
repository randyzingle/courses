package com.bms.adventure.characters.equipment;

public class Armor implements Equipment {
	
	private ArmorDetails armorDetails;
	private static final String slot = "BODY";
	
	public Armor(ArmorDetails armorDetails) {
		this.armorDetails = armorDetails;
	}
	
	public int getArmorBonus() {
		return armorDetails.getArmorBonus();
	}
	
	public int getMaxDexBonus() {
		return armorDetails.getMaxDex();
	}
	
	public int getMagicBonus() {
		return armorDetails.getMagicBonus();
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
