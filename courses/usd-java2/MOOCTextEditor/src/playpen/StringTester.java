package playpen;

public class StringTester {

	public static void main(String[] args) {
		String s1 = new String("String 1");
		String s2 = "String 1";
		if (s1 == s2) {
			System.out.println("equal");
		}
		
		String text = "My ";
		text.concat("String");
		System.out.println(text);
		
		String s = "%one%%two%%%three%%%%";
		String[] ss = s.split("one|two|three");
		for (String a: ss) {
			System.out.print(a + " ");
		}

	}

}
