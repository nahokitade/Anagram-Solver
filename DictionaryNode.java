public class DictionaryNode {
     
    private String sorted;
    private String unsorted;
     
    public DictionaryNode(String sort, String unsort){
        this.sorted = sort;
        this.unsorted = unsort;
    }
 
    public String getSorted() {
        return sorted;
    }
 
    public String getUnsorted() {
        return unsorted;
    }
     
    public String toString(){
    	return sorted + ":" + unsorted;
    }
}