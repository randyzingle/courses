package com.bms.adventure.characters;

//max level 10 for now
public class Fighter {
	
	public static final int[][] baseAttackBonus = {
		{1,2,3,4,5,6,7,8,9,10}, 
		{0,0,0,0,0,1,2,3,4,5}
	};
	public static final int[] fortSaveBonus = {2,3,3,4,4,5,5,6,6,7};
	public static final int[] refSaveBonus = {0,0,1,1,1,2,2,2,3,3};
	public static final int[] willSaveBonus = {0,0,1,1,1,2,2,2,3,3};
	public static final int[] numberAttacksPerRound = {1,1,1,1,1,2,2,2,2,2};
	
	public static void main(String[] args) {
		String s1 = "Level %d, # attacks: %d, +%dth, Fort Save: +%d, Ref Save: +%d, Will Save: +%d%n";
		String s2 = "Level %d, # attacks: %d, +%d/+%dth, Fort Save: +%d, Ref Save: +%d, Will Save: +%d%n";
		for (int i=0; i<10; i++) {
			if (numberAttacksPerRound[i] == 1) {
				System.out.printf(s1, i+1, 1, baseAttackBonus[0][i], fortSaveBonus[i], refSaveBonus[i], willSaveBonus[i]);
			} else if (numberAttacksPerRound[i] == 2) {
				System.out.printf(s2, i+1, 2, baseAttackBonus[0][i], baseAttackBonus[1][i], fortSaveBonus[i], refSaveBonus[i], willSaveBonus[i]);
			}
		}
	}
}
