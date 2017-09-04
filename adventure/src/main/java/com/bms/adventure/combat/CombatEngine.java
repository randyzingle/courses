package com.bms.adventure.combat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

import com.bms.adventure.characters.Combatant;
import com.bms.adventure.characters.Combatant.Status;
import com.bms.adventure.characters.Team;

public class CombatEngine {
	
	private BufferedWriter writer;
	private String fileName = "src/main/resources/combat.txt";
	
	public CombatEngine() {
		try {
			writer = new BufferedWriter(new FileWriter(fileName, true));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
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
		int round = 0;
		// add combatants in order of initiative roll
		c1.setInitiative(c1.rollInitiative());
		c2.setInitiative(c2.rollInitiative());
		Combatant first = null;
		Combatant last = null;
		if (c1.getInitiative() < c2.getInitiative()) {
			first = c2;
			last = c1;
		} else if (c1.getInitiative() > c2.getInitiative()) {
			first = c1;
			last = c2;
			
		} else {
			// tied - randomly decide who goes first
			double d = Math.random();
			if (d < 0.5) {
				first = c1;
				last = c2;			
			} else {
				first = c2;
				last = c1;
			}
		}
		boolean fighting = true;
		while(true) {
			round += 1;
			fighting = combatRound(first, last);
			if (!fighting) break;
			fighting = combatRound(last, first);
			if (!fighting) break;
			// safe-guard
			if (round > 15) break;
		}
		String s = String.format("%s, %s, %d, %d : %s, %s, %d, %d%n", 
			first.getRace(), first.getStatus(), first.getArmorClass(), first.getBaseHitPoints(),
			last.getRace(), last.getStatus(), last.getArmorClass(), last.getBaseHitPoints()
		);
		System.out.print(s);
		try {
			writer.write(s);
			writer.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
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
