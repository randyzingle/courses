package playpen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

	public static void main(String[] args) {
	    String s = "It was the best of times, it was ardvaarke worst of times.";
	    String r = "[a-zA-Z]+";
	    List<String> wlist = countWords(r, s);
	    System.out.println(wlist);
	    
	    for (String w: wlist) {
	        r = "[aeiouy]+";
	        List<String> slist = countSyllables(r,w);
	        System.out.println(w + ": " + slist.toString() + " " + slist.size());
	    }
	}
	
	private static List<String> countSyllables(String regex, String text) {
	    List<String> sList = new ArrayList<String>();
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(text);
	    while(matcher.find()) {
	        sList.add(matcher.group());
	    }
	    int size = sList.size();
	    if (size > 1) {
	        // we have more than one syllable - do we have a lone trailing 'e'
	        if (text.endsWith("e") && sList.get(size-1).length()==1) {
	            System.out.println("Dropping trailing 'e' for " + text);
	            sList.remove(size-1);
	        }
	    }
	    return sList;
	}
	
	private static List<String> countWords(String regex, String text) {
	    List<String> wordList = new ArrayList<String>();
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(text);
	    while(matcher.find()) {
	        wordList.add(matcher.group());
	    }
	            	    
	    return wordList;
	}
	
	private static void scan() {
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
