package dataStructures.linear.array;

import java.util.Arrays;

public class MainArray {

	public static void main(String[] args) {
		//default Array
		int numbers[] = new int[3];
		numbers[0] = 10;
		numbers[1] = 20;
		numbers[2] = 30;
		System.out.println(Arrays.toString(numbers));

		//or
		int []numbers2 = {40,50,60};
		System.out.println(Arrays.toString(numbers2));
		
		
		// create instance of Custom array
		Array number = new Array(3);
		number.insert(100); //0
		number.insert(200); //1
		number.insert(300); //2
		number.insert(400); //3
		number.insert(500); //4
		number.removeAt(2);
		number.print();
		System.out.println(number.indexOf(200)); // 1
		System.out.println(number.indexOf(9)); // -1
		System.out.println(number.max()); // 500

	}

}
