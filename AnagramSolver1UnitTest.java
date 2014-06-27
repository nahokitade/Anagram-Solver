import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;


public class AnagramSolver1UnitTest{
	public static void main(String[] args) throws IOException{
		Hashtable<String, Set<String>> dictHash = AnagramSolver.readWordsToHash("dictionary/testDictionary.txt");
		System.out.println(dictHash);
		System.out.println();
		
		System.out.println(AnagramSolver.leftChars("humorlessnessrjs", "humor"));
		System.out.println("Should be: lessnessrjs\n");
		System.out.println(AnagramSolver.leftChars("humorlessnessrjs", "humorless"));
		System.out.println("Should be: nessrjs\n");	
		System.out.println(AnagramSolver.leftChars("humorlessnessrjs", "humorlessness"));
		System.out.println("Should be: rjs\n");	
		
		System.out.println("Test run on zzzzzzzzzzzzzzzz on mini dictionary is: " + AnagramSolver.findLongestWord("zzzzzzzzzzzzzzzz",dictHash));
		System.out.println("Should be empty\n");
		System.out.println("Test run on humorlessnessrjs on mini dictionary is: " + AnagramSolver.findLongestWord("humorlessnessrjs",dictHash));
		System.out.println("Should be: humorlessness\n");
		System.out.println("Test run on prankstersefnwjf on mini dictionary is: " + AnagramSolver.findLongestWord("prankstersefnwjf",dictHash));
		System.out.println("Should be: pranksters\n");
		System.out.println("Test run on prankstereefnwjf on mini dictionary is: " + AnagramSolver.findLongestWord("prankstereefnwjf",dictHash));
		System.out.println("Should be: prankster\n");
		System.out.println("Test run on prankstersefnwjf on mini dictionary is: " + AnagramSolver.findAllWords("prankstersefnwjf",dictHash));
		System.out.println("Should be: starer and prankster and pranksters\n");
		System.out.println("Test run on astronomerzzzzzz on mini dictionary is: " + AnagramSolver.findAllWords("astronomerzzzzzz",dictHash));
		System.out.println("Should be: moon and starer\n");
		System.out.println("Test run on astronomerzzzzzz on mini dictionary is: " + AnagramSolver.findCombinedWords("astronomerzzzzzz",dictHash));
		System.out.println("Should be: moon starer and starer moon\n");
	}
	
	
	
	
}