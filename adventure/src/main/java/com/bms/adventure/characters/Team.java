package com.bms.adventure.characters;

import java.util.ArrayList;
import java.util.TreeSet;

import com.bms.adventure.characters.utils.RandomCharacterGenerator;
import com.bms.adventure.utils.BigPrint;

public class Team {
	public String name;
	public ArrayList<Combatant> members;
	
	public static void main(String[] args) {
		ArrayList<Combatant> members = RandomCharacterGenerator.generateCombatants("Aldir", 4, 2);
		Team t1 = new Team("Mymir's Molesters", members);
		members = RandomCharacterGenerator.generateCombatants("Finnr", 22, 3);
		Team t2 = new Team("Butters' Barkers", members);
//		System.out.println(t1);
//		System.out.println(t2);
		// roll initiative and print in order
		printByInit(members);
	}
	
	private static void printByInit(ArrayList<Combatant> members) {
		BigPrint.print("Before sorting");
		for (Combatant c: members) {
			c.rollInitiative();
			System.out.println(c.getName() + ": " + c.getInitiative());
		}
		BigPrint.print("After sorting");
		TreeSet<Combatant> tsc = new TreeSet<>(members);
		for (Combatant c: tsc) {
			System.out.println(c.getName() + ": " + c.getInitiative());
		}
	}
	
	public Team() {};
	
	public Team(String name, ArrayList<Combatant> members) {
		this.name = name;
		this.members = members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Combatant> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Combatant> members) {
		this.members = members;
	}
	
	public void addMember(Combatant member) {
		if (this.members == null) {
			members = new ArrayList<Combatant>();
		}
		members.add(member);
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", members=" + members + "]";
	}
	
}
