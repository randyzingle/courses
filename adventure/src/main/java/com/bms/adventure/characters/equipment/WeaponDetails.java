package com.bms.adventure.characters.equipment;

import java.util.TreeSet;

public class WeaponDetails {
	
	public static final String RAPIER = "rapier";
	public static final String WARHAMMER = "warhammer";
	public static final String LONGSWORD = "longsword";
	public static final String MACE = "mace";
	
	private String name;
	private int cost;
	private double weight;
	private int damageNumberDice;
	private int damageNumberSides;
	private TreeSet<Integer> critHits; // 3 element array for crit on 18,19,20 (1 if yes, 0 if no)
	private int critMultiplier;
	private int magicBonus;
	
	public WeaponDetails(){}
	
	public WeaponDetails(String name, int cost, double weight, int damageNumberDice, int damageNumberSides, 
			TreeSet<Integer> critHits, int critMultiplier) {
		this(name, cost, weight, damageNumberDice, damageNumberSides, critHits, critMultiplier, 0);
	}
	
	public WeaponDetails(String name, int cost, double weight, int damageNumberDice, int damageNumberSides, 
			TreeSet<Integer> critHits, int critMultiplier, int magicBonus) {
		this.name = name;
		this.cost = cost;
		this.weight = weight;
		this.damageNumberDice = damageNumberDice;
		this.damageNumberSides = damageNumberSides;
		this.critHits = critHits;
		this.critMultiplier = critMultiplier;
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
	public int getDamageNumberDice() {
		return damageNumberDice;
	}
	public void setDamageNumberDice(int damageNumberDice) {
		this.damageNumberDice = damageNumberDice;
	}
	public int getDamageNumberSides() {
		return damageNumberSides;
	}
	public void setDamageNumberSides(int damageNumberSides) {
		this.damageNumberSides = damageNumberSides;
	}
	public TreeSet<Integer> getCritHits() {
		return critHits;
	}
	public void setCritHits(TreeSet<Integer> critHits) {
		this.critHits = critHits;
	}
	public int getCritMultiplier() {
		return critMultiplier;
	}
	public void setCritMultiplier(int critMultiplier) {
		this.critMultiplier = critMultiplier;
	}
	public int getMagicBonus() {
		return magicBonus;
	}

	public void setMagicBonus(int magicBonus) {
		this.magicBonus = magicBonus;
	}

	@Override
	public String toString() {
		String critString = "";
		if (critHits.isEmpty()) {
			critString = "no ";
		} else if (critHits.size() == 1) {
			critString = critHits.first().toString();
		} else if (critHits.size() > 1) {
			critString = critHits.first().toString() + "-" + critHits.last().toString();
		}
		String s = "%-12s: %4d GP, %dd%d%s damage, %5sx%d crit, %4.1f lbs";
		String magicString = "";
		if (magicBonus > 0) {
			magicString = "[+"+magicBonus+"]";
		}
		return String.format(s, name, cost, damageNumberDice, damageNumberSides, magicString, critString, critMultiplier, weight);
	}
	
}
