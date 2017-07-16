package com.bms.adventure.characters;

import java.util.ArrayList;

public class Team {
	public String name;
	public ArrayList<Combatant> friends;
	public ArrayList<Combatant> foes;
	
	public Team() {};
	
	public Team(String name, ArrayList<Combatant> friends, ArrayList<Combatant> foes) {
		this.name = name;
		this.friends = friends;
		this.foes = foes;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Combatant> getFriends() {
		return friends;
	}
	public void setFriends(ArrayList<Combatant> friends) {
		this.friends = friends;
	}
	public ArrayList<Combatant> getFoes() {
		return foes;
	}
	public void setFoes(ArrayList<Combatant> foes) {
		this.foes = foes;
	}
}
