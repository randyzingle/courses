package com.bms.adventure.characters.equipment;

public class ArmorDetails {
	
	public static final String CHAIN_SHIRT = "chain shirt";
	public static final String ELVIN_CHAIN = "elvin chainmail";
	public static final String LEATHER = "leather armor";
	public static final String SCALE_MAIL = "scale mail";
	
	private String name;
	private int cost;
	private double weight;
	private int armorBonus;
	private int maxDex;
	private int magicBonus;
	
	public ArmorDetails(String name, int cost, double weight, int armorBonus, int maxDex) {
		this(name, cost, weight, armorBonus, maxDex, 0);
	}
	
	public ArmorDetails(String name, int cost, double weight, int armorBonus, int maxDex, int magicBonus) {
		super();
		this.name = name;
		this.cost = cost;
		this.weight = weight;
		this.armorBonus = armorBonus;
		this.maxDex = maxDex;
		this.magicBonus = magicBonus;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getArmorBonus() {
		return armorBonus;
	}

	public void setArmorBonus(int armorBonus) {
		this.armorBonus = armorBonus;
	}

	public int getMaxDex() {
		return maxDex;
	}

	public void setMaxDex(int maxDex) {
		this.maxDex = maxDex;
	}

	public int getMagicBonus() {
		return magicBonus;
	}

	public void setMagicBonus(int magicBonus) {
		this.magicBonus = magicBonus;
	}

	@Override
	public String toString() {
		String s = "%-14s: %4d GP, +%d%s Armor Bonus, +%d Max Dex, %4.1f lbs";
		String magicString = "";
		if (magicBonus > 0) {
			magicString = "[+"+magicBonus+"]";
		}
		return String.format(s, name, cost, armorBonus, magicString, maxDex, weight);
	}

}
