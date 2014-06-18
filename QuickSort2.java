import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Class that implements the Quick Sort algorithm.
 * Worst time: O(n^2) 
 * Average time: O(nlogn)
 * 
 * @author Naho Kitade
 */
public class QuickSort2{
	
	/*
	 * The final sorting function that ties every other
	 * functions in this class together.
	 * 
	 * @toSort the string to sort
	 * @return The sorted string is returned.
	 */
	public static void sort(ArrayList<DictionaryNode> toSort){
		// Call quick sort with the appropriate starting values
		quickSort(toSort, 0, toSort.size() - 1);
	}
	
	/*
	 * The recursive portion of quick sort. 
	 * 
	 * @toSort the character array to sort
	 * @low the smallest index value of the char array
	 * @high the largest index value of the char array
	 * @return the toSort will be completely sorted alphabetically once function
	 * is done.
	 */
	private static void quickSort(ArrayList<DictionaryNode> toSort, int low, int high){
		if(low < high){															// base case
			int pivot = partition(toSort, low, high);
			quickSort(toSort, low, pivot-1);					// recursive call twice on sub problem
			quickSort(toSort, pivot, high);
		}
	}
	
	/*
	 * The partition function portion of quick sort.
	 * 
	 * @toSort the character array to sort
	 * @low the smallest index value of the char array
	 * @high the largest index value of the char array
	 * @return the toSort will be completely partitioned 
	 * alphabetically once function is done.
	 */
	private static int partition(ArrayList<DictionaryNode> toSort, int low, int high){
		// get the middle element as pivot
		int pivot = toSort.get(((high - low) / 2) + low).getSorted().length();
		// keep low and high elements to use as index
		int leftInd = low;
		int rightInd = high;
		
		// until everything is partitioned
		while(leftInd <= rightInd){
			// skip until elements should be swapped
			while(toSort.get(leftInd).getSorted().length() < pivot) leftInd++;
			while(toSort.get(rightInd).getSorted().length() > pivot) rightInd--;
			// if indeed the leftInd is greater or equal to the
			// rightInd, swap the elements and move the index value
			// accordingly
			if(leftInd <= rightInd){
				swap(toSort, leftInd, rightInd);
				leftInd++;
				rightInd--;
			}
		}
		return leftInd;
	}
	
	/*
	 * Function that swaps two elements in two indexes in a char array.
	 * 
	 * @ind1 index of first swapping element
	 * @ind2 index of second swapping element
	 * @toSort character array to swap elements
	 * @return the toSort will store the swapped elements character array.
	 */
	private static void swap(ArrayList<DictionaryNode> toSort, int ind1, int ind2){
		DictionaryNode tempChar = toSort.get(ind1);
		toSort.set(ind1, toSort.get(ind2));
		toSort.set(ind2,tempChar);
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		FileReader reader = new FileReader("dictionary/dictionary.txt");
		Scanner in = new Scanner(reader);
		ArrayList<DictionaryNode> dictWords = new ArrayList<DictionaryNode>();
		int count = 0;
		// read every line 
		while(in.hasNextLine()) {

			String word = (in.nextLine()).toLowerCase();
			
			if(word.length() > 16) continue;
			
			String sortedWord = QuickSort.sort(word);
			DictionaryNode newDictNode = new DictionaryNode(word, sortedWord);
			dictWords.add(newDictNode);
		
			count++;
			
		}
		System.out.println(dictWords);
		
		sort(dictWords);
		
		System.out.println(dictWords);
	
	}
}
