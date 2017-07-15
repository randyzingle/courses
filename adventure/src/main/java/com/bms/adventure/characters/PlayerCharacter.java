package com.bms.adventure.characters;

import com.bms.adventure.characters.equipment.Armor;
import com.bms.adventure.characters.equipment.Weapon;
import com.bms.adventure.utils.AbilityGenerator;

public class PlayerCharacter {
	
	private String name;	
	private Abilities abilities;
	private BaseType baseType;
	private int armorClass;
	
	public PlayerCharacter(String name, BaseType baseType) {
		this.name = name;
		this.baseType = baseType;
		this.abilities = AbilityGenerator.generateAbilities(baseType);
		armorClass = calculateArmorClass();
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
	
	public int getArmorClass() {
		// TODO - set up a Listener on the appropriate place to recalculate for change in armor, dex, etc.
		return -99;
	}
	
	private Armor getArmor() {
		return baseType.getArmor();
	}

	public String getName() {
		return name;
	}

	public Abilities getAbilities() {
		return abilities;
	}

	public BaseType getBaseType() {
		return baseType;
	}

	@Override
	public String toString() {
		return "PlayerCharacter [name=" + name + ", abilities=" + abilities + ", baseType=" + baseType + ", armorClass="
				+ armorClass + "]";
	}
	
	


}
