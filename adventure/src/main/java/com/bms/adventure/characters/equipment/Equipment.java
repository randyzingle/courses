package com.bms.adventure.characters.equipment;

public interface Equipment {
	public static final String ARMOR = "armor";
	public static final String MELEE_WEAPON = "melee_weapon";
	public static final String GOLD = "gold";
	
	public static enum EquipmentSlot {backpack, body, hand};
	
	public int getCost();
	public double getWeight();
	public String getSlot();

}
