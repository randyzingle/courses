package com.bms.adventure.combat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.UUID;

import com.bms.adventure.characters.Combatant;
import com.bms.adventure.characters.Team;

public class CombatEngine {
	
	private int round;
	private boolean fighting = true;
	
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
		// Team name, list of friends, list of foes
		ArrayList<Combatant> a1 = new ArrayList<>(1);
		a1.add(c1);
		ArrayList<Combatant> a2 = new ArrayList<>(1);
		a2.add(c2);
		
		TreeSet<Combatant> combatants = new TreeSet<>(comparator);
		combatants.add(c1);
		combatants.add(c2);
		while(fighting) {
			round += 1;
			
		}
	}

}
