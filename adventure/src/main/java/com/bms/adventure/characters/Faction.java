package com.bms.adventure.characters;

import java.util.ArrayList;

public class Faction {
	
	public static final String ELF = "elf";
	public static final String DWARF = "dwarf";
	public static final String HUMAN = "human";
	
	String factionName;
	ArrayList<String> friendFactionList = new ArrayList<>();
	ArrayList<String> foeFactionList = new ArrayList<>();
	
	public Faction(String factionName) {
		this.factionName = factionName;
		setFactions(factionName);
	}
	
	private void setFactions(String fn) {
		if (factionName.equals(ELF)) {
			friendFactionList.add(ELF);
			foeFactionList.add(DWARF);
			foeFactionList.add(HUMAN);
		} else if (factionName.equals(DWARF)) {
			friendFactionList.add(DWARF);
			foeFactionList.add(ELF);
			foeFactionList.add(HUMAN);
		} else if (factionName.equals(HUMAN)) {
			
		}
	}

	public String getFactionName() {
		return factionName;
	}
	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}
	public ArrayList<String> getFriendFactionList() {
		return friendFactionList;
	}
	public void setFriendFactionList(ArrayList<String> friendFactionList) {
		this.friendFactionList = friendFactionList;
	}
	public ArrayList<String> getFoeFactionList() {
		return foeFactionList;
	}
	public void setFoeFactionList(ArrayList<String> foeFactionList) {
		this.foeFactionList = foeFactionList;
	}

}
