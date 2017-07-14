package com.bms.adventure;

import com.bms.adventure.characters.Abilities;
import com.bms.adventure.characters.AbilitiesEnum;
import com.bms.adventure.characters.BaseType;
import com.bms.adventure.characters.CharacterClassEnum;
import com.bms.adventure.characters.Dwarf;
import com.bms.adventure.characters.Elf;
import com.bms.adventure.characters.Human;
import com.bms.adventure.characters.PlayerCharacter;
import com.bms.adventure.utils.AbilityGenerator;
import com.bms.adventure.utils.Dice;

public class Adventure {
	public static void main(String[] args) {
		System.out.println("Adventure");
		makePlayerCharacter();

	}
	
	private static void makePlayerCharacter() {
		String name = "Baldur";
		BaseType baseType = new BaseType(new Dwarf(), CharacterClassEnum.fighter);
		PlayerCharacter pc = new PlayerCharacter(name, baseType);
		System.out.println(pc);
		baseType = new BaseType(new Elf(), CharacterClassEnum.fighter);
		pc = new PlayerCharacter("Finnr", baseType);
		System.out.println(pc);
	}

	public static void makeSomeFighters() {
		
		BaseType race = new BaseType(new Dwarf(), CharacterClassEnum.fighter);
		System.out.println("You are a " + race.toString());
		System.out.println("Your ability modifiers are: " + race.getAbilityModifier().toString());
		
		int strength = Dice.rollDice(3, 6);
		System.out.println("Your strength is: " + strength);
		
		Abilities abilities = AbilityGenerator.generateRawRandomAbilities();
		System.out.println("Raw abilities:");
		System.out.println(abilities);
		
		System.out.println("Smart abilities for fighter:");
		AbilitiesEnum primary = AbilitiesEnum.strength;
		AbilitiesEnum secondary = AbilitiesEnum.constitution;
		AbilitiesEnum tertiary = AbilitiesEnum.wisdom;
		Abilities better = AbilityGenerator.generateAbilities(primary, secondary, tertiary);
		System.out.println(better);
		
		Abilities elf = AbilityGenerator.generateAbilities(new Elf(), CharacterClassEnum.fighter);
		System.out.println("Elven Fighter: ");
		System.out.println(elf);
		
		Abilities human = AbilityGenerator.generateAbilities(new Human(), CharacterClassEnum.fighter);
		System.out.println("Human Fighter: ");
		System.out.println(human);
		
		System.out.println("Modifiers: "); 
		int[] mods = Abilities.abilityModifiers;
		String s = Dice.getIntArrayAsString(mods);
		System.out.println(s);
		System.out.printf("stat %d, modifier %d%n", 8, mods[8]);
		System.out.printf("stat %d, modifier %d%n", 13, mods[13]);
		System.out.printf("stat %d, modifier %d%n", 18, mods[18]);
	}
}
