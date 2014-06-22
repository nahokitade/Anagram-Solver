/*
 * Class that implements the Quick Sort algorithm for strings.
 * Worst time: O(n^2) 
 * Average time: O(nlogn)
 * 
 * @author Naho Kitade
 */
public class QuickSort{
	
	/*
	 * The final sorting function that ties every other
	 * functions in this class together.
	 * 
	 * @toSort the string to sort
	 * @return The sorted string is returned.
	 */
	public static String sort(String toSort){
		char[] sortArr = toSort.toCharArray();
		// Call quick sort with the appropriate starting values
		quickSort(sortArr, 0, toSort.length() - 1);
		String toReturn = String.valueOf(sortArr);	// converting array into string
		return toReturn;
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
	private static void quickSort(char[] toSort, int low, int high){
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
	private static int partition(char[] toSort, int low, int high){
		// get the middle element as pivot
		char pivot = toSort[((high - low) / 2) + low];
		// keep low and high elements to use as index
		int leftInd = low;
		int rightInd = high;
		
		// until everything is partitioned
		while(leftInd <= rightInd){
			// skip until elements should be swapped
			while(toSort[leftInd] < pivot) leftInd++;
			while(toSort[rightInd] > pivot) rightInd--;
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
	private static void swap(char[] toSort, int ind1, int ind2){
		char tempChar = toSort[ind1];
		toSort[ind1] = toSort[ind2];
		toSort[ind2] = tempChar;
	}
}