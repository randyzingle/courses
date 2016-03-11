package playpen;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			ArrayList<String> tokens = new ArrayList<>();
			System.out.format("%nEnter your regular expression (q to quit): ");
			String s = scanner.nextLine();
			if (s.equalsIgnoreCase("q")) break;
			Pattern pattern = Pattern.compile(s);
			System.out.format("Enter the input string to match: ");
			String m = scanner.nextLine();
			Matcher matcher = pattern.matcher(m);
			
			boolean found = false;
			while(matcher.find()) {
				tokens.add(matcher.group());
				found = true;
			}
			if(!found) {
				System.out.format("No match found%n");
			} else {
				System.out.println(tokens);
				System.out.println(tokens.size());
			}
		}
		System.out.println("bye...");
		scanner.close();

	}

}
