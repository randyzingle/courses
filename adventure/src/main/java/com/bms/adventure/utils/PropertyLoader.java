package com.bms.adventure.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
	
	// test for loader
	public static void main(String[] args) {
		Properties props = PropertyLoader.getStartupProps();
		System.out.println(props);
	}
	
	private static Properties props;
	
	public static Properties getStartupProps() {
		if (props == null || props.isEmpty()) {
			try {
				InputStream in = ClassLoader.getSystemResourceAsStream("adventure.props");
				props = new Properties();
				props.load(in);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return props;
	}
}
