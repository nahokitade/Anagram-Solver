
	/*
	 * Class that defines DictionaryNode structure that encompasses the sorted and 
	 * unsorted word of a dictionary word.
	 * 
	 * @author Naho Kitade
	 */
public class DictionaryNode {

	/* 
	 * private variables for instance
	 */
	private String sorted;
	private String unsorted;

	/*
	 * The only constructor of the DictionaryNode.
	 * @param sort sorted dictionary word
	 * @param unsort unsorted dictionary word
	 */
	public DictionaryNode(String sort, String unsort){
		this.sorted = sort;				
		this.unsorted = unsort;		
	}

	/*
	 * Getter for sorted word variable.
	 */
	public String getSorted() {
		return sorted;
	}

	/*
	 * Getter for unsorted word variable.
	 */
	public String getUnsorted() {
		return unsorted;
	}

	/*
	 * toString method for easy debugging.
	 */
	public String toString(){
		return sorted + ":" + unsorted;
	}
}