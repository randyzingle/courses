package playpen;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester {
	
	/*
	 * Three primary classes in java.util.regex
	 * Pattern - compiled representation of a regular expression
	 * Matcher - interprets the pattern and performs matches against the input string
	 * PatterSyntaxException - unchecked exception - indicates a syntax error in the regex
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			
			System.out.format("%nEnter your regular expression (q to quit): ");
			String s = scanner.nextLine();
			if (s.equalsIgnoreCase("q")) break;
			Pattern pattern = Pattern.compile(s);
			System.out.format("Enter the input string to match: ");
			String m = scanner.nextLine();
			Matcher matcher = pattern.matcher(m);
			
			boolean found = false;
			while(matcher.find()) {
				System.out.format("found matching text \"%s\" starting at %d and ending at %d%n", 
						matcher.group(), matcher.start(), matcher.end());
				found = true;
			}
			if(!found) {
				System.out.format("No match found%n");
			}
		}
		System.out.println("bye...");
		scanner.close();

	}

}
