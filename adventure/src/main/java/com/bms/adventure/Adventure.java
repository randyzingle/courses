package com.bms.adventure;

import com.bms.adventure.characters.BaseType;
import com.bms.adventure.characters.CharacterClass;
import com.bms.adventure.characters.PlayerCharacter;
import com.bms.adventure.characters.race.Dwarf;

public class Adventure {
	
	public static void main(String[] args) {
		System.out.println("Adventure");
		makePlayerCharacter();

	}
	
	private static void makePlayerCharacter() {
		String name = "Baldur";
		BaseType baseType = new BaseType(new Dwarf(), CharacterClass.CharacterClassEnum.fighter);
		int level = 10;
		PlayerCharacter pc = PlayerCharacter.makeNewPlayerCharacter(name, baseType, level);
		System.out.println(pc);
	}

}
