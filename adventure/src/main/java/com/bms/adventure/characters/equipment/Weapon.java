package com.bms.adventure.characters.equipment;

import java.util.TreeSet;

import com.bms.adventure.utils.Dice;

public class Weapon implements Equipment {
	
	private static boolean DEBUG = true;
	private WeaponDetails weaponDetails;
	private static final String slot = "HAND";
	private int magicBonus;
	private int diceNumber;
	private int diceSides;

	public Weapon(WeaponDetails weaponDetails) {
		this.weaponDetails = weaponDetails;
		this.diceNumber = weaponDetails.getDamageNumberDice();
		this.diceSides = weaponDetails.getDamageNumberSides();
	}
	
	public int getHitRoll() {
		return Dice.rollDice(1, 20);
	}
	
	public boolean isHit(int hitRoll, int attackBonus, int opponentAC) {
		boolean hit = false;
		if(DEBUG) System.out.println("you rolled [" + hitRoll + "] on your attack roll");
		if (hitRoll + attackBonus >= opponentAC) hit=true;
		if(DEBUG) {
			if(hit) {
				System.out.println("you hit your opponent");
			} else {
				System.out.println("you missed");
			}
		}
		return hit;
	}
	
	public int getBaseDamage() {
		return Dice.rollDice(diceNumber, diceSides);
	}
	
	// need to know opponent AC to determine crit
	public int getDamage(int hitRoll, int attackBonus, int damageBonus, int opponentAC) {
		// TODO
		int damage = 0;
		int ndice = weaponDetails.getDamageNumberDice();
		int nsides = weaponDetails.getDamageNumberSides();
		boolean crit = checkCrit(hitRoll, attackBonus, opponentAC);
		if (DEBUG && crit) System.out.println("Critical Hit!");
		if (crit) {
			int mult = weaponDetails.getCritMultiplier();
			for (int i=0; i<mult; i++) {
				damage += Dice.rollDice(ndice, nsides) + damageBonus;
			}
		} else {
			damage = Dice.rollDice(ndice, nsides) + damageBonus;
		}
		return damage;
	}
	
	private boolean checkCrit(int hitRoll, int attackBonus, int opponentAC) {
		boolean crit = false;
		// for it to be a crit we need to be in the weapon's crit range (Player's handbook pg 123)
		TreeSet<Integer> critRange = weaponDetails.getCritHits();
		if (critRange == null || critRange.isEmpty()) return false;
		int base = critRange.first();
		if (hitRoll < base) return false;
		// at this point we have a possible crit
		if (DEBUG) {
			System.out.printf("We have a possible critical hit: roll=%d, base crit for weapon=%d", hitRoll, base);
		}
		// roll again 
		int critRoll = Dice.rollDice(1, 20) + attackBonus;
		if (critRoll >= opponentAC) crit = true;
		return crit;
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

	@Override
	public String toString() {
		return "Weapon [weaponDetails=" + weaponDetails + "]";
	}

}
