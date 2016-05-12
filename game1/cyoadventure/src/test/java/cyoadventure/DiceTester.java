package cyoadventure;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bms.cyoa.utils.Dice;

public class DiceTester {
	final static Logger logger = LogManager.getLogger(DiceTester.class);

	public static Dice dice;

	@BeforeClass
	public static void setup() {
		dice = new Dice();
	}

	@Test
	public void testRoll3d6() {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 30; i++) {
			int roll = dice.roll(3, 6);
			if (roll < min) min = roll;
			if (roll > max) max = roll;
			assertTrue(roll >= 3 && roll <= 18);
		}
//		System.out.println("max " + max + ", min" + min);
		logger.error("maximus " + max + ", minimus" + min);
	}
	
	@Test 
	public void testRoll18with3d6() {
		double ave = 0;
		int ntests = 500;
		double numtimes = 0;
		for (int i=0; i<ntests; i++){
			int roll = dice.roll(3, 6);
			if (roll == 18) numtimes += 1;
		}
		ave = numtimes * 1.0 / ntests;
		assertTrue(ave < 0.5);
		System.out.println("percent 18s: " + ave);
		System.out.println("expected percent: " + (1.0 / Math.pow(6.0, 3)));
	}
	
	@Test
	public void testRoll2d4() {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 30; i++) {
			int roll = dice.roll(2, 4);
			if (roll < min) min = roll;
			if (roll > max) max = roll;
			assertTrue(roll >=2 && roll <=8);
		}
		System.out.println("2d4 max: " + max + ", min: " + min);
	}

}
