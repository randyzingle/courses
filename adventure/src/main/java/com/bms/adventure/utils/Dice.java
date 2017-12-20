package com.bms.adventure.utils;

import java.util.Random;

public class Dice {
	
	public static boolean DEBUG = true;
	private static Random random = new Random();
	
	public static int rollDice(int ndice, int nsides) {
		int[] dice = new int[ndice];
		int sum = 0;
		for (int i=0; i<ndice; i++) {
			dice[i] = random.nextInt(nsides) + 1;
			sum += dice[i];
		}
		if(DEBUG) {
			System.out.println(getIntArrayAsString(dice));
		}
		return sum;
	}
	
	public static int rollDiceDiscardOnes(int ndice, int nsides) {
		int[] dice = new int[ndice];
		int sum = 0;
		for (int i=0; i<ndice; i++) {
			int test = random.nextInt(nsides) + 1;
			if (test == 1) { // re-roll 1's 
				i = i-1;
				continue;
			}
			dice[i] = test;
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
				if (a.length==1) {
					buff.append("Dice rolls: [" + a[i] + "]");
				} else {
					buff.append("Dice rolls: [" + a[i] + " ");
				}
			} else if (i==a.length-1) {
				buff.append(a[i]+"]");
			} else {
				buff.append(a[i] + " ");
			}
		}
		return buff.toString() + " " + sum;
	}
	
	public static void shuffle(int[] a) { 
		Random random = new Random();
		int n = a.length;
		for (int i=0; i<n; i++) {
			int r = random.nextInt(n-i) + i;
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

}
