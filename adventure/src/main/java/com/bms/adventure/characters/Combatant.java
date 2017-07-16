package com.bms.adventure.characters;

import com.bms.adventure.characters.equipment.Armor;
import com.bms.adventure.characters.equipment.Weapon;

public interface Combatant {
	
	public static enum Status {able, disabled, dying, dead}
	
	public int getInitiative();
	public int getArmorClass();
	public int getCurrentHitPoints();
	public int getAttackRoll(int attackNumber);
	public int getDamageRoll();
	
	// certain attacks and abilities can damage armor and weapons
	public Armor getArmor();
	public Weapon getWeapon();

}
