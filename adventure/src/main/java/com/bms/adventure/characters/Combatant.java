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
	
	// whats our current status (dead, dying, etc)
	public Status getStatus();
	public void setStatus(Status status);
	
	// who is our current target?
	// also set up a list eventually for multi-target spells etc
	public Combatant getCurrentTarget();
	public void setCurrentTarget(Combatant currentTarget);
	
	// who is currently attacking us?
	// again eventually set up multiple attackers
	public Combatant getCurrentAttacker();
	public void setCurrentAttacker(Combatant currentAttacker);
	
	// certain attacks and abilities can damage armor and weapons
	public Armor getArmor();
	public Weapon getWeapon();

}