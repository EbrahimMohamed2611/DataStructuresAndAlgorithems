package dataStructures.linear;
public class Array {
//build Dynamic Array
	private int [] items;
	private int count;
/**
 * create Array Constructor take the length of array
 * @param lenght
 */
	public Array(int lenght) {
		this.items = new int[lenght];
	}
	/**
	 * insert new item to array
	 * @param item
	 */
	public void insert(int item) {
		//if array is full will resize it
		if(count == items.length) {
			// create new array with big size and clone the old array to it
			int [] newItems = new int[count*2];
			for (int i = 0; i < count; i++) {
				newItems[i] = items[i];
			}
			items = newItems;
		}
		
		//if array is not full will add in the end
			items[count++] = item;
	}
	
	/**
	 * remove item using index
	 * @param index
	 */
	public void removeAt(int index) {
		// check validate index
		if(index < 0 || index >= count)
			throw new IllegalArgumentException();
		for (int i = index; i < count; i++) {
			items[i] = items[i+1];
		}
		
		count--;
	}
	/**
	 * return indexOf item
	 * @param item
	 * @return
	 */
	public int indexOf(int item) {
		// if this item is not exist will return -1
		// else return the index
		for (int i = 0; i < count; i++) 
			if(item == items[i])
				return i;
		
		return -1;
		
	}
	
	
	/**
	 * print all elements in array
	 */
	public void print() {

		for (int i = 0; i < count; i++) 
			System.out.println(items[i]);
		}

	// return the max number of array
	/**
	 * return the biggest number of array
	 * @return
	 */
	public int max() {
		int maxNumber = 0;
		for (int i = 0; i < count; i++) {
			if(items[i] > maxNumber)
				maxNumber = items[i];
		}
		return maxNumber;
	}
	
}
