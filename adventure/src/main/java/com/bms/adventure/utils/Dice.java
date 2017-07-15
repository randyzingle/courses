package com.bms.adventure.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Dice {
	
	public static boolean DEBUG = true;
	private static Random random = new Random();
	
	public static int rollDice(int ndice, int nsides) {
		return rollDice(ndice, nsides, 0);
	}
	
	public static int rollDice(int ndice, int nsides, int modifier) {
		int[] dice = new int[ndice];
		int sum = 0;
		for (int i=0; i<ndice; i++) {
			dice[i] = random.nextInt(nsides) + 1 + modifier;
			sum += dice[i];
		}
		if(DEBUG) {
			System.out.println(getIntArrayAsString(dice));
		}
		return sum;
	}
	
	public static String getIntArrayAsString(int[] a) {
		StringBuffer buff = new StringBuffer();
		int sum = 0;
		for (int i=0; i<a.length; i++) {
			sum += a[i];
			if (i==0) {
				buff.append("Dice rolls: [" + a[i] + " ");
			} else if (i==a.length-1) {
				buff.append(a[i]+"]");
			} else {
				buff.append(a[i] + " ");
			}
		}
		return buff.toString() + " " + sum;
	}

}
