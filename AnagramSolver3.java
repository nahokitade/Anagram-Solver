import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Class that handles the solving of an anagram third implementation
 * Will output the longest 
 * 
 * Put the dictionary.txt in a new folder called dictionary to connect the 
 * .txt file without fiddling with the code. Else, change the filename
 * portion of the main function to make the code work for any other .txt file
 * with the same format as dictionary.txt.
 * 
 * Assignment 1 of STEP at Google Tokyo third implementation
 * 
 * @author Naho Kitade
 */
public class AnagramSolver3{

	private static final Integer CHAR_LENGTH = 16;		// Length of input 

	/*
	 * Function that reads words from a dictionary into an array of array of DictionaryNodes 
	 * from DictionaryNode.java. The first layer of array is like an array bucket of 26 length 
	 * that stores arrays of DictionaryNodes. Each bucket signifies an alphabet, and the first 
	 * alphabet of the sorted word within the DictionaryNodes will determine which bucket the 
	 * word will be added to. For example, cat sorted is act, so cat will be stored in the first
	 * 'a' bucket of the array.
	 * Diagram:
	 * |a|b|c|d|e|...|z|
	 *  ^|act:cat|<-DictionaryNode array with cat as only entry.
	 * Words that are longer than CHAR_LENGTH are ignored.
	 * The DictionaryNode array within the alphabet bucket array will be sorted in increasing 
	 * length of words, with the last word inside the DictionaryNode array being the longest one.
	 * 
	 * @filename the txt file containing dictionary words.
	 * @return the created arraylist described above. 
	 */
	public static ArrayList<ArrayList<DictionaryNode>> readWordsToAlphaArray(String fileName) {
		try {
			// get ready to read from dictionary file
			FileReader reader = new FileReader(fileName);
			Scanner in = new Scanner(reader);
			ArrayList<ArrayList<DictionaryNode>> dictWords = new ArrayList<ArrayList<DictionaryNode>>();
			// initialize the 26 alphabet bucket array
			for(int i = 0; i < 26; i++){
				ArrayList<DictionaryNode> toAddWords = new ArrayList<DictionaryNode>();
				dictWords.add(toAddWords);
			}
			// read every line of the dictionary file
			while(in.hasNextLine()) {

				String word = (in.nextLine()).toLowerCase();

				if(word.length() > CHAR_LENGTH) continue;			// ignore words that are too long

				String sortedWord = QuickSort.sort(word);
				DictionaryNode newDictNode = new DictionaryNode(sortedWord, word);
				
				// find the appropriate index of the alphabet bucket array to add to. We do this
				// by negating the ASCII decimal number for the lowercase a, so that a word starting
				// with 'a' will have index 0, and 'z' will have index 25. 
				ArrayList<DictionaryNode> dictWord = dictWords.get(sortedWord.charAt(0) - 'a');
				dictWord.add(newDictNode);
			}			
			// sort each DictionaryNode array in the alphabet bucket array from shortest word
			// to longest word.
			for(ArrayList<DictionaryNode> words : dictWords){
				QuickSort2.sort(words);
			}
			return dictWords;														
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
	 * Algorithm: 
	 * Start with the sorted 16 char. Go to the DictionaryNode array of the first character
	 * and find the longest word within that array that can be made with the full 16 characters.
	 * Next, get the substring of the original input, with the first character chopped off. 
	 * Go to the DictionaryNode array of the first character of that substring and find the longest 
	 * word within that array that can be made with the 15 character substring. If that word is longer
	 * than the previously found longest word, then this is the new longest word.
	 * Keep repeating the step for the shorter and shorter substrings until you find the longest word. 
	 * 
	 * @input input from the user
	 * @dictAlphaArray the Array returned in the readWordsToAlphaArray function.
	 * @return Strings of the longest words that can be made from the given input 
	 */
	public static String findLongestWord(String input, ArrayList<ArrayList<DictionaryNode>> dictAlphaArray){
		// sort the input
		String sortedInput = QuickSort.sort(input);
		String remainingSortedInput;
		String longestWord = "";
		int index;
		
		for(int n = 0; n < sortedInput.length(); n++){
			index = sortedInput.charAt(n) - 'a';
			remainingSortedInput = sortedInput.substring(n);
			
			// we have found the longest word already if the remaining substring of the input is 
			// shorter than the longest word that we have previously found.
			if(remainingSortedInput.length() <= longestWord.length()) continue;
			
			// go though the DictionaryNode array of the specific stating word character, looking at
			// longest words first, to see if you can make that word out of the current sortedInput substring.
			for(int i = dictAlphaArray.get(index).size() - 1; i >= 0; i--){
				
				// if the next word that you are looking at (within the DictionaryNode array) is shorter than the
				// longest word found, we can stop searching that array for a longer word.
				if(dictAlphaArray.get(index).get(i).getSorted().length() <= longestWord.length()) break;
				
				// if you find a word that you can make out of the sortedInput substring, that is longer than
				// the previously found longest word, then update that variable since we have found a new
				// longest word.
				if(AnagramSolver2.canMakeWord(remainingSortedInput, dictAlphaArray.get(index).get(i).getSorted())){
					if(dictAlphaArray.get(index).get(i).getSorted().length() > longestWord.length()){
						longestWord = dictAlphaArray.get(index).get(i).getUnsorted();
						break;
					}
				}
			}
		}
		return longestWord;
	}

	/*
	 * The main program that demonstrates all the functions created in
	 * this class. 
	 */
	public static void main(String[] args) throws IOException{
		ArrayList<ArrayList<DictionaryNode>> dictArray = readWordsToAlphaArray("dictionary/dictionary.txt");
		String input1 = AnagramSolver.takeInput();				// get character input from user
		if(input1 != ""){
			System.out.println(findLongestWord(input1, dictArray));
		}
	}
}
