package com.bms.adventure.equipment;

/**
 * This is our Base Weapon description. We only need one of each as they are not individual weapons but
 * rather are descriptions of weapon types. Characters, Monsters, stores etc will have a copy of the 
 * weapons detailed here, in the Weapon.java class.
 *  
 * @author razing
 *
 */
public class WeaponDetails {
	
	private String name;
	private int cost;
	private double weight;
	private int damageNumberDice;
	private int damageNumberSides;
	private int critThreshold;
	private int critMultiplier;
	
	public WeaponDetails(String name, int cost, double weight, int damageNumberDice, int damageNumberSides, 
			int critThreshold, int critMultiplier) {
		this.name = name;
		this.cost = cost;
		this.weight = weight;
		this.damageNumberDice = damageNumberDice;
		this.damageNumberSides = damageNumberSides;
		this.critThreshold = critThreshold;
		this.critMultiplier = critMultiplier;
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
	public int getCritThreshold() {
		return critThreshold;
	}
	public void setCritThreshold(int critThreshold) {
		this.critThreshold = critThreshold;
	}
	public int getCritMultiplier() {
		return critMultiplier;
	}
	public void setCritMultiplier(int critMultiplier) {
		this.critMultiplier = critMultiplier;
	}

	@Override
	public String toString() {
		String critString = critThreshold + "+";
		String damageString = String.format("%dd%d", damageNumberDice, damageNumberSides);
		String s = "%-12s: %4d GP, %-4s damage, %5sx%d crit, %4.1f lbs";
		return String.format(s, name, cost, damageString, critString, critMultiplier, weight);
	}
	
}
