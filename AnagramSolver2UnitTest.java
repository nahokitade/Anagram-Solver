import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;


public class AnagramSolver2UnitTest{
	public static void main(String[] args) throws IOException{
		ArrayList<DictionaryNode> dictArray = AnagramSolver2.readWordsToArray("dictionary/testDictionary.txt");
		System.out.println(dictArray);
		System.out.println();
		
		String sortedTestInput = QuickSort.sort("humorlessnessrjs");
		String sortedHumor = QuickSort.sort("humor");		
		System.out.println("Test run on humorlessnessrjs and humor mini dictionary is: " + AnagramSolver2.canMakeWord(sortedTestInput, sortedHumor)); 
		System.out.println("Should be: true\n");
		String sortedHumorless = QuickSort.sort("humorless");		
		System.out.println("Test run on humorlessnessrjs and humorless mini dictionary is: " + AnagramSolver2.canMakeWord(sortedTestInput, sortedHumorless)); 
		System.out.println("Should be: true\n");	
		String sortedHumorlessness = QuickSort.sort("humorlessness");		
		System.out.println("Test run on humorlessnessrjs and humorlessness mini dictionary is: " + AnagramSolver2.canMakeWord(sortedTestInput, sortedHumorlessness)); 
		System.out.println("Should be: true\n");	
		System.out.println("Test run on humorlessnessrjs and humorlessnessz mini dictionary is: " + AnagramSolver2.canMakeWord(sortedTestInput, sortedHumorlessness + 'z')); 
		System.out.println("Should be: false\n");	
		
		System.out.println("Test run on zzzzzzzzzzzzzzzz on mini dictionary is: " + AnagramSolver2.findLongestWord("zzzzzzzzzzzzzzzz",dictArray));
		System.out.println("Should be empty\n");
		System.out.println("Test run on humorlessnessrjs on mini dictionary is: " + AnagramSolver2.findLongestWord("humorlessnessrjs",dictArray));
		System.out.println("Should be: humorlessness\n");
		System.out.println("Test run on prankstersefnwjf on mini dictionary is: " + AnagramSolver2.findLongestWord("prankstersefnwjf",dictArray));
		System.out.println("Should be: pranksters\n");
		System.out.println("Test run on prankstereefnwjf on mini dictionary is: " + AnagramSolver2.findLongestWord("prankstereefnwjf",dictArray));
		System.out.println("Should be: prankster\n");
	}
	
	
	
	
}