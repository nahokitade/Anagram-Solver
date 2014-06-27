import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;


public class AnagramSolver3UnitTest{
	public static void main(String[] args) throws IOException{
		ArrayList<ArrayList<DictionaryNode>> dictAlphaArray = AnagramSolver3.readWordsToAlphaArray("dictionary/testDictionary.txt");
		System.out.println(dictAlphaArray);
		System.out.println();

		System.out.println("Test run on zzzzzzzzzzzzzzzz on mini dictionary is: " + AnagramSolver3.findLongestWord("zzzzzzzzzzzzzzzz",dictAlphaArray));
		System.out.println("Should be empty\n");
		System.out.println("Test run on humorlessnessrjs on mini dictionary is: " + AnagramSolver3.findLongestWord("humorlessnessrjs",dictAlphaArray));
		System.out.println("Should be: humorlessness\n");
		System.out.println("Test run on prankstersefnwjf on mini dictionary is: " + AnagramSolver3.findLongestWord("prankstersefnwjf",dictAlphaArray));
		System.out.println("Should be: pranksters\n");
		System.out.println("Test run on prankstereefnwjf on mini dictionary is: " + AnagramSolver3.findLongestWord("prankstereefnwjf",dictAlphaArray));
		System.out.println("Should be: prankster\n");
	}




}



