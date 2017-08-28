package com.bms.adventure;

import java.util.ArrayList;

import com.bms.adventure.characters.Fighter;
import com.bms.adventure.characters.PlayerCharacter;
import com.bms.adventure.characters.race.Dwarf;
import com.bms.adventure.characters.race.Elf;
import com.bms.adventure.combat.CombatEngine;

public class Adventure {
	
	public static void main(String[] args) {
		System.out.println("Adventure");
		ArrayList<PlayerCharacter> pcs = makePlayerCharacter();
		// get the first two players in the list to fight
		if (pcs.size() > 1) {
			CombatEngine ce = new CombatEngine();
			ce.simpleCombat(pcs.get(0), pcs.get(1));
		}
	}

	
	private static ArrayList<PlayerCharacter> makePlayerCharacter() {
		ArrayList<PlayerCharacter> pcs = new ArrayList<>();
		
		// dwarven fighter
		String name = "Baldur";
		int level = 3;
		PlayerCharacter pc = PlayerCharacter.makeNewPlayerCharacter(name, level, new Fighter(), new Dwarf());
		pcs.add(pc);
		System.out.println(pc);
		
		// elvin fighter
		name = "Aldir";
		level = 3;
		pc = PlayerCharacter.makeNewPlayerCharacter(name, level, new Fighter(), new Elf());
		pcs.add(pc);
		System.out.println(pc);
		
		return pcs;
	}

}
