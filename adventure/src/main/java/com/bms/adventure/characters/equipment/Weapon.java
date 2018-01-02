package com.bms.adventure.characters.equipment;

import com.bms.adventure.utils.Dice;

public class Weapon implements Equipment {
	
	private static boolean DEBUG = true;
	private WeaponDetails weaponDetails;
	private static final String slot = "HAND";
	private int magicBonus;
	private String description;

	public Weapon(WeaponDetails weaponDetails, String description, int magicBonus) {
		this.weaponDetails = weaponDetails;
		this.magicBonus = magicBonus;
		this.description = description;
	}
	
	public int getHitRoll() {
		return Dice.rollDice(1, 20);
	}
	
	/**
	 * Damage roll plus all bonuses. Will need to call this multiple times for a critical hit.
	 * 
	 * @param damageBonus
	 * @return total damage
	 */
	public int getBaseDamage(int damageBonus) {
		return Dice.rollDice(weaponDetails.getDamageNumberDice(), weaponDetails.getDamageNumberSides()) + damageBonus;
	}

	public int getMagicBonus() {
		return magicBonus;
	}

	public void setMagicBonus(int magicBonus) {
		this.magicBonus = magicBonus;
	}

	public WeaponDetails getWeaponDetails() {
		return weaponDetails;
	}

	@Override
	public int getCost() {
		return weaponDetails.getCost();
	}

	@Override
	public double getWeight() {
		return weaponDetails.getWeight();
	}

	@Override
	public String getSlot() {
		return slot;
	}
	
	public String getName() {
		return weaponDetails.getName();
	}

	@Override
	public String toString() {
		return "Weapon [weaponDetails=" + weaponDetails + "]";
	}

}
