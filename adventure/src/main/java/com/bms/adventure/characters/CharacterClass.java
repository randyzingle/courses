package com.bms.adventure.characters;

public abstract class CharacterClass {

	public abstract int[] getFortSaveBonus();

	public abstract int[] getRefSaveBonus();

	public abstract int[] getWillSaveBonus();

	public abstract int[][] getBaseAttackBonus();

	public abstract int[] getNumberAttacksPerRound();

	public abstract int getHpDiceSides();
	
	// array with level = index, so level 0,1,2,3,....
	public static final int[] LEVEL_EXPERIENCE_POINTS = {0, 0, 1000, 3000, 6000, 10000, 15000, 21000, 28000, 36000, 45000};
}
