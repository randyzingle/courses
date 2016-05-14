package textgen;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		if (sourceText == null) return;
		String[] s = sourceText.split("\\s+");
		if (s == null || s.length == 0) return;
		if (starter.equals("")) starter = s[0];
		
		// set up the first node in our list
		ListNode prev = new ListNode(s[0]);
		for (int i=1; i<s.length; i++) {
			String w1 = s[i];
			ListNode node = getNode(prev);
			if(node == null) { 
				wordList.add(prev);
				prev.addNextWord(w1);
			} else {
				node.addNextWord(w1);
			}
			prev = new ListNode(w1);
		}
		// add starter to end
		if(getNode(prev)==null) {
			wordList.add(prev);
		}
		prev.addNextWord(starter);

	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
		if (wordList.isEmpty() || numWords == 0 || starter.equals("")) return "";
	    String currWord = starter;
	    StringBuilder output = new StringBuilder();
	    output.append(currWord);
	    for (int i=1; i<numWords; i++) {
	    	ListNode node = getNode(currWord);
	    	String w = node.getRandomNextWord(rnGenerator);
	    	output.append(" ");
	    	output.append(w);
	    	currWord = w;
	    }
	    
		return output.toString();
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		train(sourceText);
	}
	
	// check to see if a word is already a ListNode word
	private ListNode getNode(ListNode node) {
		String word = node.getWord();
		return getNode(word);
	}
	private ListNode getNode(String word) {
		for (ListNode n: wordList) {
			if (n.getWord().equals(word)) return n;
		}
		return null;
	}
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(System.currentTimeMillis()));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		
		textString = "hi there hi leo twas brillig and the slithy toves did gire and gimble";
		gen.train(textString);
		System.out.println(gen.generateText(30));
		System.out.println(gen);
	
		
		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		if (nextWords.size()==0) throw new IndexOutOfBoundsException();
		int index = generator.nextInt(nextWords.size());
		String s = nextWords.get(index);
	    return s;
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


