package com.bms.adventure;

import java.util.ArrayList;
import java.util.Random;

import com.bms.adventure.characters.Fighter;
import com.bms.adventure.characters.PlayerCharacter;
import com.bms.adventure.characters.race.Dwarf;
import com.bms.adventure.characters.race.Elf;

public class Adventure {
	
	public static void main(String[] args) {
		System.out.println("Adventure");
		ArrayList<PlayerCharacter> pcs = makePlayerCharacter();
	}
	
	public static void shuffle(int[] a) { // move this to Dice
		Random random = new Random();
		int n = a.length;
		for (int i=0; i<n; i++) {
			int r = random.nextInt(n-i) + i;
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
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
