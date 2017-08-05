package com.bms.adventure.characters.race;

import java.util.HashMap;

import com.bms.adventure.characters.AbilitiesEnum;
import com.bms.adventure.characters.Faction;
import com.bms.adventure.characters.RaceEnum;
import com.bms.adventure.characters.equipment.Armor;
import com.bms.adventure.characters.equipment.Weapon;

public class Race {	
	
	HashMap<AbilitiesEnum, Integer> abilityModifiers;
	RaceEnum racialType;
	Armor armor;
	Weapon weapon;
	int gold;
	Faction faction;
	
	public Faction getFaction() {
		return faction;
	}
	public void setFaction(Faction faction) {
		this.faction = faction;
	}
	public Armor getArmor() {
		return armor;
	}
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public HashMap<AbilitiesEnum, Integer> getAbilityModifiers() {
		return abilityModifiers;
	}
	public RaceEnum getRacialType() {
		return racialType;
	}
	@Override
	public String toString() {
		return "Race [racialType=" + racialType + "]";
	}
	
}
