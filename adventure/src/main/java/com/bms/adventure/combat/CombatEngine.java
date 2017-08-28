package com.bms.adventure.combat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.UUID;

import com.bms.adventure.characters.Combatant;
import com.bms.adventure.characters.Combatant.Status;
import com.bms.adventure.characters.Team;

public class CombatEngine {
	
	private int round;
	
	private Comparator<Combatant> comparator = new Comparator<Combatant>() {
		public int compare(Combatant c1, Combatant c2) {
			int init1 = c1.getInitiative();
			int init2 = c2.getInitiative();
			if (init1 < init2) return -1;
			if (init1 == init2) return 0;
			return -1;
		}
	};
 	
	public void teamCombat(ArrayList<Team> combatTeams) {
		
	}
	
	public void simpleCombat(Combatant c1, Combatant c2) {	
		System.out.println("begin combat...");
		// add combatants in order of initiative roll
		c1.setInitiative(c1.rollInitiative());
		c2.setInitiative(c2.rollInitiative());
		TreeSet<Combatant> combatants = new TreeSet<>(comparator);
		combatants.add(c1);
		combatants.add(c2);
		Combatant first = combatants.first();
		Combatant last = combatants.last();
		boolean fighting = true;
		while(true) {
			round += 1;
			fighting = combatRound(first, last);
			if (!fighting) break;
			fighting = combatRound(last, first);
			if (!fighting) break;
			// safe-guard
			if (round > 10) break;
		}
	}
	
	private boolean combatRound(Combatant first, Combatant last) {
		boolean fighting = true;
		String s = "The %s, %s swings his %s at %s%n";
		System.out.printf(s, first.getRace(), first.getName(), first.getWeapon().getName(), last.getName());
		boolean hit = hit(first, last);
		if (hit) {
			int damage = first.getDamageRoll(); // modify this to check for critical hits
			last.modifyCurrentHitPoints(-1 * damage);
			int hp = last.getCurrentHitPoints();
			System.out.printf("%s did %d hps of damage, %s has %d hitpoints%n",first.getName(), damage, last.getName(), hp);
			if (last.getStatus() != Status.able) {
				// fight is over
				System.out.printf("Fight is over, %s is %s%n", last.getName(), last.getStatus().toString());
				fighting = false;
			}
		}
		return fighting;
	}
	
	private boolean hit(Combatant first, Combatant last) {
		boolean hit = false;
		int attackRoll = first.getAttackRoll(1);
		if (attackRoll >= last.getArmorClass()) {
			String s = "HIT: %s rolled an attack roll of %d, %s has an AC of %d and was hit%n";
			System.out.printf(s, first.getName(), attackRoll, last.getName(), last.getArmorClass());
			hit = true;
		}
		
		return hit;
	}

}
