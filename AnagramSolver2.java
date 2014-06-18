import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnagramSolver2{

	private static final Integer CHAR_LENGTH = 16;		// Length of input 

	public static ArrayList<DictionaryNode> readWordsToArray(String fileName) {
		try {
			FileReader reader = new FileReader("dictionary/dictionary.txt");
			Scanner in = new Scanner(reader);
			ArrayList<DictionaryNode> dictWords = new ArrayList<DictionaryNode>();

			// read every line 
			while(in.hasNextLine()) {

				String word = (in.nextLine()).toLowerCase();
				
				if(word.length() > 16) continue;
				
				String sortedWord = QuickSort.sort(word);
				DictionaryNode newDictNode = new DictionaryNode(sortedWord, word);
				dictWords.add(newDictNode);

			}			
			QuickSort2.sort(dictWords);
			return dictWords;														// return the existing final hashtable
		}
		// error reading the file
		catch (IOException exception) {
			System.out.println("File processing error: " + exception);
		}
		return null;  // In case of an exception still need to return.
	}

	public static String findLongestWord(String input, ArrayList<DictionaryNode> dictArray){
		String toReturn = "";
		String sortedInput = QuickSort.sort(input);
		for(int i = dictArray.size() - 1; i >= 0; i--){
			if(canMakeWord(sortedInput, dictArray.get(i).getSorted())){
				toReturn = dictArray.get(i).getUnsorted();
				break;
			}
		}
		return toReturn;
	}

	public static Boolean canMakeWord(String sortedInput, String sortedWord){
		int j = 0;
		for(int i = 0; i < sortedWord.length(); i++){
			if(!(j < sortedInput.length())) return false;
			while(j < sortedInput.length() && sortedInput.charAt(j) != sortedWord.charAt(i)){
				j++;
			}
			if(!(j < sortedInput.length())) return false;
			j++;
			
		}
		return true;
	}

	public static String takeInput(){
		String inputString = "";
		int length = 0;								// keeps track if input is of correct length
		Scanner input = new Scanner(System.in);
		while (length != CHAR_LENGTH) {						// input must be CHAR_LENGTH length
			System.out.print("Enter " + CHAR_LENGTH + " characters: ");
			inputString = input.next();							// get input and its length
			length = inputString.length();
		}
		return inputString;						// return the final input
	}

	public static void main(String[] args){
		ArrayList<DictionaryNode> dictArray = readWordsToArray("dictionary/dictionary.txt");
		String input1 = takeInput();				// get character input from user

		System.out.println(findLongestWord(input1, dictArray));
	}
}
