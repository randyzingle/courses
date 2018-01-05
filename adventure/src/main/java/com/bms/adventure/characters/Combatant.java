package com.bms.adventure.characters;

import java.util.ArrayList;

import com.bms.adventure.equipment.Armor;
import com.bms.adventure.equipment.Weapon;

public interface Combatant extends Comparable<Combatant> {
	
	public static enum Status {able, disabled, dying, dead}
	
	public int getInitiative();
	public int rollInitiative(); // just roll once at the beginning of combat
	public int getArmorClass();
	public int getCurrentHitPoints();
	public int getAttackBonus(int attackNumber);
	public int getBaseDamage();
	public int getCritDamage();
	public String getName();
	public String getRace();
	public void modifyCurrentHitPoints(int hps);
	public int getBaseHitPoints();
	public boolean criticalHitImune();
	
	// fully heal the combatant
	public void fullyHeal();
	
	// whats our current status (dead, dying, etc)
	public Status getStatus();
	public void setStatus(Status status);
	
	// who is our current target?
	// also set up a list eventually for multi-target spells etc
	public ArrayList<Combatant> getCurrentTarget();
	public void setCurrentTarget(ArrayList<Combatant> currentTarget);
	
	// who is currently attacking us?
	// again eventually set up multiple attackers
	public ArrayList<Combatant> getCurrentAttacker();
	public void setCurrentAttacker(ArrayList<Combatant> currentAttacker);
	
	// certain attacks and abilities can damage armor and weapons
	public Armor getArmor();
	public Weapon getWeapon();

}
