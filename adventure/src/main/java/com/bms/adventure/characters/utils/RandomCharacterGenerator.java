package com.bms.adventure.characters.utils;

import java.util.ArrayList;

import com.bms.adventure.characters.CharacterClass;
import com.bms.adventure.characters.CharacterClassEnum;
import com.bms.adventure.characters.Combatant;
import com.bms.adventure.characters.Fighter;
import com.bms.adventure.characters.PlayerCharacter;
import com.bms.adventure.characters.race.Dwarf;
import com.bms.adventure.characters.race.Elf;
import com.bms.adventure.characters.race.Human;
import com.bms.adventure.characters.race.Race;
import com.bms.adventure.characters.race.RaceEnum;
import com.bms.adventure.utils.Dice;

public class RandomCharacterGenerator {
	
	private RandomCharacterGenerator() {}
	
	public static ArrayList<Combatant> generateCombatants(String baseName, int numberCombatants, int level) {
		ArrayList<Combatant> clist = new ArrayList<>(numberCombatants);
		RaceEnum[] re = RaceEnum.values();
		RaceEnum race = null;
		CharacterClassEnum[] cce = CharacterClassEnum.values();
		CharacterClassEnum cc = null;
		String name = null;
		for (int i=0; i<numberCombatants; i++) {
			int rindex = Dice.rollDice(1, re.length);
			race = re[rindex-1];
			int ccindex = Dice.rollDice(1, cce.length);
			cc = cce[ccindex-1];
			name = baseName+cc.name()+i;
			PlayerCharacter p1 = generatePlayerCharacter(name, level, cc, race);
			clist.add(p1);
		}

		
		return clist;
	}
	
	private static PlayerCharacter generatePlayerCharacter(String name, int level, CharacterClassEnum cce, RaceEnum re) {
		Race race = null;
		CharacterClass cc = null;
		if (level < 1 || level > 20) level = 1;
		if (cce == CharacterClassEnum.fighter) {
			cc = new Fighter();
		}
		if (re == RaceEnum.dwarf) {
			race = new Dwarf();
		} else if (re == RaceEnum.elf) { 
			race = new Elf();
		} else if (re == RaceEnum.human) {
			race = new Human();
		}
		
		PlayerCharacter p1 = PlayerCharacter.makeNewPlayerCharacter(name, level, cc, race);
		return p1;
	}
}
