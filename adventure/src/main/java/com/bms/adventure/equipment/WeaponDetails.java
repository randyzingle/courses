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
	
	// TODO fill this in

	@Override
	public String toString() {
		String critString = critThreshold + "+";
		String damageString = String.format("%dd%d", damageNumberDice, damageNumberSides);
		String s = "%-12s: %4d GP, %-4s damage, %5sx%d crit, %4.1f lbs";
		return String.format(s, name, cost, damageString, critString, critMultiplier, weight);
	}
	
}
