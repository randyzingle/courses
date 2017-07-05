package com.bms.adventure.characters;

public class PlayerCharacter {
	
	private String name;	
	private Abilities abilities;
	private Race race;
	
	public PlayerCharacter(String name) {
		this.name = name;
	}
	
	public PlayerCharacter(String name, Race race) {
		this.name = name;
		this.race = race;
	}
	
}
