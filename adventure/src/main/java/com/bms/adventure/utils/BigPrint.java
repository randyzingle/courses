package com.bms.adventure.utils;

public class BigPrint {
	public static void print(String s) {
		String x = "**************************************";
		System.out.printf("%s%n* %s%n%s%n", x,s,x);
	}
}
