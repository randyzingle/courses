package com.bms.adventure;

import java.util.ArrayList;

import com.bms.adventure.characters.Fighter;
import com.bms.adventure.characters.PlayerCharacter;
import com.bms.adventure.characters.race.Dwarf;
import com.bms.adventure.characters.race.Elf;
import com.bms.adventure.characters.race.Human;
import com.bms.adventure.combat.CombatEngine;

public class Adventure {
	
	public static void main(String[] args) {
		System.out.println("Adventure");
//		ArrayList<PlayerCharacter> pcs = makePlayerCharacter();
//		fight();
		makeAndSave();
	}
	
	private static void makeAndSave() {
		String name = "Baldur";
		PlayerCharacter first = PlayerCharacter.makeNewPlayerCharacter(name, 2, new Fighter(), new Dwarf());
		System.out.println(first);
	}

	private static void fight() {
		// make two PCs and get them to fight nbattles
		int nbattles = 5;
		CombatEngine ce = new CombatEngine();
		for (int i=0; i<nbattles; i++) {
			PlayerCharacter first = PlayerCharacter.makeNewPlayerCharacter("Baldur", 2, new Fighter(), new Dwarf());
			System.out.println(first);
			PlayerCharacter last = PlayerCharacter.makeNewPlayerCharacter("Aldir", 2, new Fighter(), new Elf());
			System.out.println(last);
			ce.simpleCombat(first, last);
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
		
		// human fighter
		name = "Gabriel";
		level = 3;
		pc = PlayerCharacter.makeNewPlayerCharacter(name, level, new Fighter(), new Human());
		pcs.add(pc);
		System.out.println(pc);
		
		return pcs;
	}

}
