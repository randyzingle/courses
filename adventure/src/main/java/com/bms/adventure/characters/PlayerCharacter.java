package com.bms.adventure.characters;

import java.util.Arrays;

import com.bms.adventure.characters.equipment.Armor;
import com.bms.adventure.characters.equipment.Weapon;
import com.bms.adventure.utils.AbilityGenerator;
import com.bms.adventure.utils.Constants;
import com.bms.adventure.utils.Dice;

public class PlayerCharacter implements Combatant {
	
	private static final int MAX_LEVEL = 10;
	
	private String name;	
	private Abilities abilities;
	private BaseType baseType;
	private int armorClass;
	private int baseHitPoints; // when rested and fully healthy
	private int currentHitPoints; // less than baseHitPoints when injured, more if healed and magic bonus
	private int hpBonus; // temporary magical bonus
	private int armorClassBonus; // temporary magical bonus
	private int level;
	private int xp;
	private int[] permanentHpRecord;
	private Combatant currentTarget;
	private Combatant currentAttacker;
	private Status status;

	
	private PlayerCharacter(){};
	
	public static PlayerCharacter makeNewPlayerCharacter(String name, BaseType baseType, int level) {
		PlayerCharacter pc = new PlayerCharacter();
		pc.permanentHpRecord = new int[MAX_LEVEL+1]; // 0 hp for level 0 for PC
		pc.level = level;
		pc.name = name;
		pc.baseType = baseType;
		pc.abilities = AbilityGenerator.generateAbilities(baseType);
		pc.armorClass = pc.calculateArmorClass();
		pc.baseHitPoints = pc.calculateInitialHP();
		pc.currentHitPoints = pc.baseHitPoints;
		return pc;
	}
	
	private int calculateInitialHP() {
		int temp = 0;
		int nsidesDice = baseType.getCharacterClass().getHpDiceSides();
		int con = abilities.getConstitution();
		int constitutionBonus = Abilities.abilityModifiers[con];
		for (int i=1; i<=level; i++) {
			if (i==1) {
				// max hp for die roll for level 1
				permanentHpRecord[i] = nsidesDice + constitutionBonus;
				temp += permanentHpRecord[i];
			} else {
				// roll for hp
				int roll = Dice.rollDice(1, nsidesDice) + constitutionBonus;
				if (roll < 1) roll = 1;
				permanentHpRecord[i] = roll;
				temp += permanentHpRecord[i];
			}
		}
		return temp; 
	}
	
	// TODO - only do this if something changes
	public int calculateArmorClass() {
		int ac = 0;
		Armor armor = baseType.getArmor();
		int dex = abilities.getDexterity();
		int dexBonus = Abilities.abilityModifiers[dex]; // need to change this to a method to make safe - check boundaries
		dexBonus = Math.min(dexBonus, armor.getMaxDexBonus());
		ac = 10 + dexBonus + armor.getArmorBonus() + armor.getMagicBonus();
		return ac;
	}

	@Override
	public Combatant getCurrentTarget() {
		return currentTarget;
	}

	@Override
	public void setCurrentTarget(Combatant currentTarget) {
		this.currentTarget = currentTarget;
	}

	@Override
	public Status getStatus() {
		return status;
	}

	@Override
	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public Combatant getCurrentAttacker() {
		return currentAttacker;
	}

	@Override
	public void setCurrentAttacker(Combatant currentAttacker) {
		this.currentAttacker = currentAttacker;
	}

	@Override
	public int getInitiative() {
		int dex = abilities.getDexterity();
		int initBonus = abilities.abilityModifiers[dex];
		return Dice.rollDice(1, 20, initBonus); 
	}

	@Override
	public int getArmorClass() {
		return armorClass;
	}

	@Override
	public int getCurrentHitPoints() {
		return currentHitPoints;
	}

	@Override
	public int getAttackRoll(int attackNumber) {
		int levelBonus = baseType.getCharacterClass().getBaseAttackBonus()[attackNumber][level];
		int strengthBonus = abilities.abilityModifiers[abilities.getStrength()];
		int weaponBonus = baseType.getWeapon().getMagicBonus();
		return Dice.rollDice(1, 20) + levelBonus + strengthBonus + weaponBonus;     
	}

	@Override
	public int getDamageRoll() {
		int strengthBonus = abilities.abilityModifiers[abilities.getStrength()];
		int weaponBonus = baseType.getWeapon().getMagicBonus();
		return 0;
	}

	@Override
	public Armor getArmor() {
		return baseType.getArmor();
	}

	@Override
	public Weapon getWeapon() {
		return baseType.getWeapon();
	}
	


	@Override
	public String toString() {
		String s = "Player Character:%n++++++++++%n%sname=%s, age=%d%n%srace=%s%n%s%s%n%sAC=%d, "
				+ "HP=%d%n%sWeapon=%s%n%sArmor=%s%n%sHP per level=%s"
				+ "%n++++++++++%n";
		s = String.format(s, 
				Constants.TAB4, name, baseType.getAge(),
				Constants.TAB4, baseType.getRace(),
				Constants.TAB4, abilities,
				Constants.TAB4, armorClass, baseHitPoints, 
				Constants.TAB4, baseType.getWeapon(), 
				Constants.TAB4, baseType.getArmor(),
				Constants.TAB4, Arrays.toString(permanentHpRecord)
			);			
		return s;
	}


}
