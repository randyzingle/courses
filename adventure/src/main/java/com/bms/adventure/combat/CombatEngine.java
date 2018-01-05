package com.bms.adventure.combat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;

import com.bms.adventure.characters.Combatant;
import com.bms.adventure.characters.Combatant.Status;
import com.bms.adventure.characters.Team;
import com.bms.adventure.utils.BigPrint;
import com.bms.adventure.utils.Dice;

public class CombatEngine {
	
	private BufferedWriter writer;
	private String fileName = "src/main/resources/output/combat.txt";
	private static final int ROUND_LIMIT = 10;
	
	public CombatEngine() {
		try {
			writer = new BufferedWriter(new FileWriter(fileName, true));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
 	
	public void teamCombat(HashMap<String, Team> combatTeams) {
		
	}
	
	public void simpleCombat(Combatant c1, Combatant c2) {	
		System.out.println("begin combat...");
		int round = 0;
		// add combatants in order of initiative roll
		c1.rollInitiative();
		c2.rollInitiative();
		Combatant attacker = null;
		Combatant defender = null;
		if (c1.getInitiative() < c2.getInitiative()) {
			attacker = c2;
			defender = c1;
		} else if (c1.getInitiative() > c2.getInitiative()) {
			attacker = c1;
			defender = c2;
			
		} else {
			// tied - randomly decide who goes first
			double d = Math.random();
			if (d < 0.5) {
				attacker = c1;
				defender = c2;			
			} else {
				attacker = c2;
				defender = c1;
			}
		}
		boolean fighting = true;
		while(fighting) {
			round += 1;
			fighting = combatRound(attacker, defender);
			if (!fighting) break;
			fighting = combatRound(defender, attacker);
			if (!fighting) break;
			// we'll fight for a maximum of ROUND_LIMIT rounds
			if (round > ROUND_LIMIT) break;
		}
		String s = String.format("%s, %s, %d, %d : %s, %s, %d, %d%n", 
			attacker.getRace(), attacker.getStatus(), attacker.getArmorClass(), attacker.getBaseHitPoints(),
			defender.getRace(), defender.getStatus(), defender.getArmorClass(), defender.getBaseHitPoints()
		);
		System.out.print(s);
		try {
			writer.write(s);
			writer.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private boolean combatRound(Combatant attacker, Combatant defender) {
		boolean fighting = true;
		String s = "The %s, %s swings his %s at %s%n";
		System.out.printf(s, attacker.getRace(), attacker.getName(), attacker.getWeapon().getName(), defender.getName());
		// raw hit roll, 1 always misses, 20 always hits
		int hitRoll = Dice.rollDice(1, 20);
		boolean hit = false;
		if (hitRoll == 20) {
			hit = true;
		} else if (hitRoll == 1) {
			hit = false;
		} else {
			hit = hit(hitRoll, attacker, defender);
		}
		if (hit) {
			boolean crit = false;
			if(!defender.criticalHitImune()) crit = checkCrit(hitRoll, attacker, defender);
			int damage = 0;
			if (crit) {
				damage = attacker.getCritDamage();
			} else {
				damage = attacker.getBaseDamage();
			}
			defender.modifyCurrentHitPoints(-1 * damage);
			int hp = defender.getCurrentHitPoints();
			System.out.printf("%s did %d hps of damage, %s has %d hitpoints%n",attacker.getName(), damage, defender.getName(), hp);
			if (defender.getStatus() != Status.able) {
				// fight is over
				System.out.printf("Fight is over, %s is %s%n", defender.getName(), defender.getStatus().toString());
				fighting = false;
			}
		}
		return fighting;
	}
	
	private boolean hit(int hitRoll, Combatant attacker, Combatant defender) {
		boolean hit = false;
		int attackRoll = hitRoll + attacker.getAttackBonus(1);
		if (attackRoll >= defender.getArmorClass()) {
			String s = "HIT: %s rolled an attack roll of %d, %s has an AC of %d and was hit%n";
			System.out.printf(s, attacker.getName(), attackRoll, defender.getName(), defender.getArmorClass());
			hit = true;
		}	
		return hit;
	}
	
	private boolean checkCrit(int hitRoll, Combatant attacker, Combatant defender) {
		boolean crit = false;
		// for it to be a crit we need to be in the weapon's crit range (Player's handbook pg 123)
		int critThreshold = attacker.getWeapon().getWeaponDetails().getCritThreshold();
		if (hitRoll < critThreshold) return false;
		// at this point we have a possible crit
		System.out.printf("We have a possible critical hit: roll=%d, base crit for weapon=%d%n", hitRoll, critThreshold);
		// roll again 
		int critRoll = Dice.rollDice(1, 20);
		boolean hit =  hit(critRoll, attacker, defender);
		if (hit) {
			String s = "Critical hit on a roll of " + critRoll;
			BigPrint.print(s);
			crit = true;
		}
		return crit;
	}

}
