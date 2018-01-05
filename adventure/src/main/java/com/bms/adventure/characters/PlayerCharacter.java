package com.bms.adventure.characters;

import java.util.ArrayList;
import java.util.Arrays;

import com.bms.adventure.characters.race.Race;
import com.bms.adventure.equipment.Armor;
import com.bms.adventure.equipment.Weapon;
import com.bms.adventure.utils.AbilityGenerator;
import com.bms.adventure.utils.CharacterClassInitializer;
import com.bms.adventure.utils.Constants;
import com.bms.adventure.utils.Dice;

public class PlayerCharacter implements Combatant {

	private static final int MAX_LEVEL = 10;

	private String name;
	private Abilities abilities;
	private CharacterClass characterClass;
	private Race race;
	private int armorClass;
	private Armor armor;
	private Weapon weapon;
	private int baseHitPoints; // when rested and fully healthy
	private int currentHitPoints; // less than baseHitPoints when injured, more if healed and magic bonus
	private int hpBonus; // temporary magical bonus
	private int armorClassBonus; // temporary magical bonus
	private int level;
	private int xp;
	private int age;
	private int[] permanentHpRecord; // need to drop back if level-drained by undead
	private ArrayList<Combatant> currentTarget;
	private ArrayList<Combatant> currentAttacker;
	private Status status;
	private int initiative;


	private PlayerCharacter(){};

	public static PlayerCharacter makeNewPlayerCharacter(String name, int level, CharacterClass cc, Race race) {
		PlayerCharacter pc = new PlayerCharacter();
		pc.permanentHpRecord = new int[MAX_LEVEL+1]; // 0 hp for level 0 for PCs - 1-4 for LV0 commoners
		pc.level = level;
		pc.name = name;
		pc.characterClass = cc;
		pc.race = race;
		pc.age = pc.race.getAge();
		pc.armor = race.getArmor();
		pc.weapon = race.getWeapon();
		CharacterClassInitializer cci = new CharacterClassInitializer(race, cc);
		pc.abilities = AbilityGenerator.generateAbilities(cci);
		pc.armorClass = pc.calculateArmorClass();
		pc.baseHitPoints = pc.calculateInitialHP();
		pc.currentHitPoints = pc.baseHitPoints;
		pc.status = Status.able;
		return pc;
	}
	
	// TODO move this into a Comparator in the Combat engine
	@Override
	public int compareTo(Combatant c) {
		// Sort combatants by initiative order for use in a TreeSet (note which returns -1, want highest initiative first for descending order)
		if (c.getInitiative() > this.getInitiative()) return 1;
		if (c.getInitiative() < this.getInitiative()) return -1;
		// we've tied, randomly select who wins initiative
		double n = Math.random();
		if(n < 0.5) return -1;
		return 1;
	}

	private int calculateInitialHP() {
		int temp = 0;
		int nsidesDice = characterClass.getHpDiceSides();
		int con = abilities.getConstitution();
		int constitutionBonus = Abilities.abilityModifiers[con];
		for (int i=1; i<=level; i++) {
			if (i==1) {
				// max hp for die roll for level 1
				permanentHpRecord[i] = nsidesDice + constitutionBonus;
				temp += permanentHpRecord[i];
			} else {
				// roll for hp
				int roll = Dice.rollDiceDiscardOnes(1, nsidesDice) + constitutionBonus;
				if (roll < 1) roll = 1; // can't let constitution penalty give 0 or less HPs for new level
				permanentHpRecord[i] = roll;
				temp += permanentHpRecord[i];
			}
		}
		return temp;
	}

	// TODO - only do this if something changes
	public int calculateArmorClass() {
		int ac = 0;

		int dex = abilities.getDexterity();
		int dexBonus = Abilities.abilityModifiers[dex]; // need to change this to a method to make safe - check boundaries
		dexBonus = Math.min(dexBonus, armor.getMaxDexBonus());
		ac = 10 + dexBonus + armor.getArmorBonus() + armor.getMagicBonus();
		return ac;
	}

	@Override
	public ArrayList<Combatant> getCurrentTarget() {
		return currentTarget;
	}

	@Override
	public void setCurrentTarget(ArrayList<Combatant> currentTarget) {
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
	public ArrayList<Combatant> getCurrentAttacker() {
		return currentAttacker;
	}

	@Override
	public void setCurrentAttacker(ArrayList<Combatant> currentAttacker) {
		this.currentAttacker = currentAttacker;
	}

	@Override
	public int rollInitiative() {
		int dex = abilities.getDexterity();
		int initBonus = abilities.abilityModifiers[dex];
		int init = Dice.rollDice(1, 20) + initBonus;
		System.out.println("Initiative for " + this.name + ": " + init);
		this.initiative = init;
		return init;
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
	public void modifyCurrentHitPoints(int hps) {
		this.currentHitPoints += hps;
		if (currentHitPoints == 0) {
			this.status = Status.disabled;
		} else if (currentHitPoints > 0) {
			this.status = Status.able;
		} else if (currentHitPoints < 0 && currentHitPoints > -10) {
			this.status = Status.dying;
		} else {
			this.status = Status.dead;
		}
	}

	@Override
	public int getAttackBonus(int attackNumber) {
		int baseAttackBonus = characterClass.getBaseAttackBonus()[attackNumber][level];
		int strengthBonus = abilities.abilityModifiers[abilities.getStrength()];
		int weaponBonus = weapon.getMagicBonus();
		return baseAttackBonus + strengthBonus + weaponBonus;
	}

	@Override
	public int getBaseDamage() {
		int strengthBonus = abilities.abilityModifiers[abilities.getStrength()];
		int magicBonus = weapon.getMagicBonus();
		int damageBonus = strengthBonus + magicBonus;
		return weapon.getBaseDamage(damageBonus);
	}
	
	@Override
	public int getCritDamage() {
		int multiplier = weapon.getWeaponDetails().getCritMultiplier();
		int damage = 0;
		for (int i=0; i<multiplier; i++) {
			damage += getBaseDamage();
		}
		return damage;
	}

	@Override
	public Armor getArmor() {
		return armor;
	}

	@Override
	public Weapon getWeapon() {
		return weapon;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getRace() {
		return race.getRacialType().toString();
	}

	@Override
	public int getInitiative() {
		return this.initiative;
	}
	
	@Override
	public int getBaseHitPoints() {
		return baseHitPoints;
		
	}
	
	@Override
	public void fullyHeal() {
		currentHitPoints = baseHitPoints;
		status = Status.able;
	}

	@Override
	public boolean criticalHitImune() {
		return false;
	}

	@Override
	public String toString() {
		String s = "Player Character:%n++++++++++%n%sname=%s, age=%d%n%srace=%s%n%s%s%n%sAC=%d, "
				+ "HP=%d%n%sWeapon=%s%n%sArmor=%s%n%sHP per level=%s"
				+ "%n++++++++++%n";
		s = String.format(s,
				Constants.TAB4, name, age,
				Constants.TAB4, race,
				Constants.TAB4, abilities,
				Constants.TAB4, armorClass, baseHitPoints,
				Constants.TAB4, weapon,
				Constants.TAB4, armor,
				Constants.TAB4, Arrays.toString(permanentHpRecord)
			);
		return s;
	}





}
