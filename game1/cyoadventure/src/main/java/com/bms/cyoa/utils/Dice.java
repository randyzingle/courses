package com.bms.cyoa.utils;

import java.util.Random;

public class Dice {
	
	public Random rand = new Random(System.currentTimeMillis());
	
	public int roll(int ndice, int nsides) {
		int total = 0;
		for (int i=0; i<ndice; i++) {
			int roll = rand.nextInt(nsides) + 1;
			total += roll;
		}
		return total;
	}

}
