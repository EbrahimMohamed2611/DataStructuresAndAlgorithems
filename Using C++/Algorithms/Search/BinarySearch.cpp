#include<iostream>
using namespace std;

template<class T>
int binarySearch(T arr[], int size, T element) {
	int left = 0;
	int right = size - 1;
	while (left <= right) {
		int mid = left + ((right - left) >> 1);
		if (arr[mid] == element)
			return mid + 1;
		else if (element > arr[mid]) {
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}
	}
	return -1;
}

template<class T>
int binarySearchRecursiveltHelper(T arr[], int left, int right, T element) {
	//Base Condition
	if (left > right)
		return -1;
	int mid = left + ((right - left) >> 1);
	if (arr[mid] == element)
		return mid + 1;
	else if (arr[mid] > element) {
		return binarySearchRecursiveltHelper(arr, left, mid - 1, element);
	}
	else {
		return binarySearchRecursiveltHelper(arr, mid + 1, right, element);
	}
}

template<class T>
int binarySearchRecursivelt(T arr[], int size, T element) {
	int left = 0, right = size - 1;
	return binarySearchRecursiveltHelper<T>(arr, left, right, element);
}



int main() {
	cout << "Binary Search" << endl;
	int arr[5] = { 0,4,5,9,20 };
	cout << binarySearch<int>(arr, 5, 20) << endl;
	cout << binarySearchRecursivelt<int>(arr, 5, 20) << endl;
	cout << binarySearch<int>(arr, 5, 100) << endl;
	cout << binarySearchRecursivelt<int>(arr, 5, 100) << endl;

	char characters[5] = { 'a', 'b', 'h', 'y', 'z' };
	cout << binarySearch<char>(characters, 5, 'y') << endl;
	cout << binarySearchRecursivelt<char>(characters, 5, 'y') << endl;
	cout << binarySearch<char>(characters, 5, 'c') << endl;
	cout << binarySearchRecursivelt<char>(characters, 5, 'c') << endl;
	return 1;
}