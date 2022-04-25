#include<iostream>
using namespace std;


// create Node class
template<class T>
class Node {

public:
	T data;
	Node* next;

	Node(T _data) {
		data = _data;
		next = NULL;
	}
	Node() {
		data = 0;
		next = NULL;
	}
};

/*
	Linked List Without Tail Pointer
*/
template<class T>
class SinglyLinkedList {
public:
	Node<T>* head;
	int size;

	SinglyLinkedList() {
		head = NULL;
		size = 0;
	}

	void inesrtFirst(T data);

	void display();

	void displayUsingPosition(Node<T>* position);

	void displayRecursively(Node<T>* head);

	void displayReversed(Node<T>* head);

	Node<T>* reverseFromStartToEndRecursively(Node<T>* head);

	Node<T>*  reverseFromStartToEndRecursivelyHelper(Node<T>* head, Node<T>* newHead);

	void insertAt(T data, int position);

	void deleteAt(int position);

	void deleteFirst();

	void deleteLast();

};

template<class T>
void SinglyLinkedList<T>::inesrtFirst(T data) {
	Node<T>* newNode = new Node<T>(); // Or new Node(data);
	newNode->data = data;
	newNode->next = head;
	head = newNode;
	size++;
}

template<class T>
void SinglyLinkedList<T>::display() {
	Node<T>* traversNode = head;
	while (traversNode != NULL) {
		cout << "-> [" << traversNode->data << ", " << traversNode->next << "]";
		traversNode = traversNode->next;
	}
	cout <<"-> NULL" <<endl;

}

template<class T>
void SinglyLinkedList<T>::displayUsingPosition(Node<T>* position) {
	Node<T>* traversNode = position;
	while (traversNode != NULL) {
		cout << "-> [" << traversNode->data << ", " << traversNode->next << "]";
		traversNode = traversNode->next;
	}
	cout << "-> NULL" << endl;
}

template<class T>
void SinglyLinkedList<T>::insertAt(T data, int position) {

	Node<T>* newNode = new Node<T>();
	newNode->data = data;
	newNode->next = NULL;
	// if position equals 1 that means add at first
	if (position == 1) {
		newNode->next = head;
		head = newNode;
		return;
	}
	else {
		Node<T>* travers = head;
		//while ((position - 2) != 0) {
		//	travers = travers->next;
		//	--position;
		//}

		for (int i = 1; i < position -1; i++)
		{
			travers = travers->next;
		}
		newNode->next = travers->next;
		travers->next = newNode;
	}
	size++;
}

template<class T>
void SinglyLinkedList<T>::deleteAt(int position) {
	Node<T>* traversNode = head;

	if (position == 1) {
		head = traversNode->next;
		delete(traversNode);
	}
	else {
		for (int i = 0; i < position-2; i++)
		{
			traversNode = traversNode->next;  // Previous Node
		}
		Node<T>* nodeToBeDeleted = traversNode->next; // Actual Node
		traversNode->next = nodeToBeDeleted->next;

		delete(nodeToBeDeleted);

	}
	size--;
}

template<class T>
void SinglyLinkedList<T>::deleteFirst() {
	if (head != NULL) {
		Node<T>* nodeToBeDeleted = head;
		head = head->next;
		delete(nodeToBeDeleted);
	}
	else {
		cout << "There is not nodes to delete it" << endl;
	}
	size--;
}

template<class T>
void SinglyLinkedList<T>::deleteLast() {
	if (head != NULL) {
		Node<T>* traversNode = head;
		for (int i = 0; i < size-2; i++)
			traversNode = traversNode->next; // Previous Node

		Node<T>* nodeToBeDeleted = traversNode->next;
		traversNode -> next = nodeToBeDeleted->next;
		delete(nodeToBeDeleted);
	}
	else {
		cout << "There is not nodes to delete it" << endl;
	}
	size--;

}

template<class T>
void SinglyLinkedList<T>::displayReversed(Node<T>* traverse) {

	// Note That the traverse Pointer is new local variable so change is will not change the head itself
	if (traverse == NULL)
		return;

	displayReversed(traverse->next);
	cout << "-> [" << traverse->data << ", " << traverse->next << "]";


}


template<class T>
void SinglyLinkedList<T>::displayRecursively(Node<T>* traverse) {

	// Note That the traverse Pointer is new local variable so change is will not change the head itself
	if (traverse == NULL) return;


	cout << "-> [" << traverse->data << ", " << traverse->next << "]";
	displayRecursively(traverse->next);



}

template<class T>
Node<T>* SinglyLinkedList<T>::reverseFromStartToEndRecursively(Node<T>* head) {
	return reverseFromStartToEndRecursivelyHelper(head, NULL);
}

template<class T>
Node<T>* SinglyLinkedList<T>::reverseFromStartToEndRecursivelyHelper(Node<T>* head, Node<T>* newHead) {
	if (head == NULL)
		return newHead;

	Node<T>* nextNode = head->next;
	head->next = newHead;
	newHead = head;
	head = nextNode;

	return reverseFromStartToEndRecursivelyHelper(head, newHead);
}

int main() {
	SinglyLinkedList<int> list;
	//list.insertAt(5,1);
	//list.insertAt(2,2);
	list.inesrtFirst(3);
	list.inesrtFirst(4);
	list.inesrtFirst(2);
	list.inesrtFirst(3);
	list.inesrtFirst(4);

	list.deleteLast();
	cout << "Size: " << list.size << endl;

	list.display();

	list.displayReversed(list.head);
	cout << endl;
	list.displayRecursively(list.head);
	cout << endl << endl << endl;
	list.display();
	cout << "Using ReversFunction " << endl;
	Node<int>* head = list.reverseFromStartToEndRecursively(list.head);
	cout << head << endl;
	list.displayUsingPosition(head);
	return 1;
}