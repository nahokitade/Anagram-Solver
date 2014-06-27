import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Class that handles the solving of an anagram second implementation
 * Will output the longest 
 * 
 * Put the dictionary.txt in a new folder called dictionary to connect the 
 * .txt file without fiddling with the code. Else, change the filename
 * portion of the main function to make the code work for any other .txt file
 * with the same format as dictionary.txt.
 * 
 * Assignment 1 of STEP at Google Tokyo second implementation
 * 
 * @author Naho Kitade
 */
public class AnagramSolver2{
	
	// constants used
	private static final Integer CHAR_LENGTH = 16;		// Length of input 

	/*
	 * Function that reads words from a dictionary into an array of DictionaryNodes 
	 * from DictionaryNode.java. Words that are longer than CHAR_LENGTH are ignored.
	 * This array will be also sorted in increasing length of words, with the last
	 * word inside the DictionaryNode being the longest one.
	 * 
	 * @param filename the txt file containing dictionary words.
	 * @return the created arraylist described above. 
	 */
	public static ArrayList<DictionaryNode> readWordsToArray(String fileName) {
		try {
			FileReader reader = new FileReader(fileName);
			Scanner in = new Scanner(reader);
			ArrayList<DictionaryNode> dictWords = new ArrayList<DictionaryNode>();

			// read every line 
			while(in.hasNextLine()) {

				String word = (in.nextLine()).toLowerCase();
				
				if(word.length() > CHAR_LENGTH) continue;		// word too long so skip it
				
				String sortedWord = QuickSort.sort(word);		// sort the word for the sorted portion of DictionaryNode
				DictionaryNode newDictNode = new DictionaryNode(sortedWord, word);	// create new DictionaryNode
				dictWords.add(newDictNode);									// add created DictionaryNode in Array

			}			
			QuickSort2.sort(dictWords);									// sort the array so longer words end up later in array
			return dictWords;														// return the final DictionaryNode Array
		}
		// error reading the file
		catch (IOException exception) {
			System.out.println("File processing error: " + exception);
		}
		return null;  // In case of an exception still need to return.
	}

	/*
	 * Function that handles the longest word that can be made
	 * from a given input as an anagram.
	 * 
	 * @param input input from the user
	 * @param dictArray the Array returned in the readWordsToArray
	 * function.
	 * @return Strings of the longest words that can be made
	 * from the given input 
	 */
	public static String findLongestWord(String input, ArrayList<DictionaryNode> dictArray){
		String toReturn = "";
		String sortedInput = QuickSort.sort(input);											// sort the taken input
		// go through the whole array starting with longest word (from end of array)
		for(int i = dictArray.size() - 1; i >= 0; i--){							
			// see if you can make the current dictionary word from the input
			if(canMakeWord(sortedInput, dictArray.get(i).getSorted())){
				// if we can, we are done, and this is the longest word.
				toReturn = dictArray.get(i).getUnsorted();
				break;
			}
		}
		return toReturn;
	}

	/*
	 * Function that returns if the sortedWord can be made with the characters
	 * in sortedInput
	 * 
	 * @param sortedInput input from user that is sorted
	 * @param sortedWord sorted word to see if it can be made with the sortedInput
	 * @return true or false indicating if the sortedWord can be made with the characters 
	 */
	public static Boolean canMakeWord(String sortedInput, String sortedWord){
		int j = 0;
		// go though all the characters of the sortedWord
		for(int i = 0; i < sortedWord.length(); i++){
			// if we run out of the input, we cannot make sortedWord, so false
			if(!(j < sortedInput.length())) return false;
			// go through the sortedInput until we find the next word within the sortedWord.
			while(j < sortedInput.length() && sortedInput.charAt(j) != sortedWord.charAt(i)){
				j++;
			}
			// if we have no more characters left in the input, we cannot make sortedWord, so false
			if(!(j < sortedInput.length())) return false;
			j++;	// move onto next character in sortedInput
			
		}
		return true;	// if we get through to the end of sortedWord, we can make that word, so true
	}

	/*
	 * The main program that demonstrates all the functions created in
	 * this class. 
	 */
	public static void main(String[] args) throws IOException{
		ArrayList<DictionaryNode> dictArray = readWordsToArray("dictionary/dictionary.txt");
		String input1 = AnagramSolver.takeInput();				// get character input from user
		if(input1 != ""){
			System.out.println(findLongestWord(input1, dictArray));
		}
	}
}
