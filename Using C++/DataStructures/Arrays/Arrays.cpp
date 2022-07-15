#include<iostream>
using namespace std;

class Array{
private:
	int size;
	int length;
	int* arrayItems;

public:
	Array(const int elementSize){
		size = elementSize;
		length = 0;
		arrayItems = new int[elementSize];
	}

	void fillArrayElements(){
		int numberOfItemes;
		cout << "Enter The Number of elements that you want to store it : ";
		cin >> numberOfItemes;
		if (numberOfItemes > size || numberOfItemes <= 0){
			cout << "Please Enter a Valid Size " << endl;
			return;
		}
		else{
			length = numberOfItemes;
			cout << endl;
			for (int i = 0; i < numberOfItemes; i++)
			{
				cin >> *(arrayItems + i);
			}
		}		
	}

	void displayArrayElements(){
		cout << "The Content of Array is => " << "[";
		cout << *arrayItems << ", ";
		int i = 1;
		for (i; i < length-1; i++)
		{
			cout << *(arrayItems + i)<<", ";
		}
		cout << *(arrayItems + i) << "]" << endl;;
	}

	int getArraySize(){
		return size;
	}

	int getArrayLength(){
		return length;
	}

	void append(const int newElement){
		if (isFull()){
			cout << "Array is Full you can not add new element" << endl;
		}
		else{
			*(arrayItems + length) = newElement;
			length++;
		}
	}

	int search(const int value){
		if (isEmpty()){
			cout << "There is no element in the Array :(" << endl;
			return -1;
		}
		else{
			for (int i = 0; i < length; i++)
			{
				if (*(arrayItems + i) == value){
					return ++i;
				}
			}
			return -1;
		}
	}

	void insert(const int index, const int newValue){
		if (isFull()){
			cout << "There is no spaces in the Array" <<endl;
		}
		else{
			for (int i = length; i > index; i--){
				*(arrayItems+i) = *(arrayItems+i - 1);
			}
			*(arrayItems + index) = newValue;
			length++;
		}
	}

	void deleteElementByIndex(const int index){
		if (isEmpty()){
			cout << "Your Array is Empty :(" << endl;
		}
		else{

			for (int i = index; i < length - 1; i++)
			{
				*(arrayItems + i) = *(arrayItems + i + 1);
			}
			length--;
		}
	}

	void enLarge(const int newSize){
		if (newSize <= size){
			cout << "you should add size with value bigger than the current value :(" << endl;
		}
		else{
			size = newSize;
			int *oldArraya = arrayItems;
			arrayItems = new int(newSize);
			for (int i = 0; i < length; i++)
			{
				*(arrayItems + i) = *(oldArraya + i);
			}
			delete[] oldArraya;
		}
	}

	void merge(Array& newArrayToBeMerged){
		int newArraySize = size + newArrayToBeMerged.getArraySize();
		int *oldArray = arrayItems;
		arrayItems = new int(newArraySize);
		size = newArraySize;
		int i = 0;
		for (i; i < length; i++)
		{
			*(arrayItems + i) = *(oldArray + i);
		}

		for (i; i < newArrayToBeMerged.getArrayLength()+length; i++)
		{
			*(arrayItems + i) = *(newArrayToBeMerged.arrayItems+ i);
		}
		length = i;
		delete[] oldArray;
	}


	int isFull(){
		return length == size;
	}

	int isEmpty(){
		return length == 0;
	}
};


int main(){
	cout << "*********************** Array as a ADT *********************** \n" << endl;
	cout << "Enter the size of Array : ";
	int sizeOfArray;
	cin >> sizeOfArray;
	Array arrayOfIntegers(sizeOfArray);

	arrayOfIntegers.fillArrayElements();

	//cout << "Enter the new element: ";
	//int newElement;
	//cin >> newElement;
	//arrayOfIntegers.append(newElement);

	arrayOfIntegers.displayArrayElements();

	/*int searchedValue;
	cout << "Enter the value you want to search on it: ";
	cin >> searchedValue;
	cout << "Result of search is:" << arrayOfIntegers.search(searchedValue) << endl;*/

	/*cout << "Enter the index and The Value that you want to store it on that index: ";
	int index, newValue;
	cin >> index >> newValue;
	arrayOfIntegers.insert(index, newValue);
	arrayOfIntegers.displayArrayElements();*/

	//cout << "Enter the index that you want to remove element from it:";
	//int index;
	//cin >> index;
	//arrayOfIntegers.deleteElementByIndex(index);
	//arrayOfIntegers.displayArrayElements();

	Array arrayToBeMerged(5);
	arrayToBeMerged.fillArrayElements();

	arrayOfIntegers.merge(arrayToBeMerged);

	cout<<"The Array Length is: "<<arrayOfIntegers.getArrayLength()<<endl;
	cout << "The Array size is: "<<arrayOfIntegers.getArraySize() << endl;

	//int newSize;
	//cout << "Enter the new size of array: ";
	//cin >> newSize;
	//arrayOfIntegers.enLarge(newSize);
	//cout << "The Array size is: " << arrayOfIntegers.getArraySize() << endl;

	system("pause");
	return 0;
}