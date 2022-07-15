#include<iostream>
using namespace std;


template< class T>
class Node {
public:
	T data;
	Node<T>* prev;
	Node<T>* next;

	Node(T _data) {
		data = _data;
		prev = next = NULL;
	}
};

template< class T>
class DoublyLinkedList {
private:
	//Helper Methods
	Node<T>* createNode(const T data) {
		Node<T>* newNode = new Node<T>(data);
		return newNode;
	}
public:
	Node<T>* head;
	DoublyLinkedList() {
		head = NULL;
	}

	void insertAtHead(T data) {
		Node<T>* newNode = createNode(data);
		if (isEmpty())
			head = newNode;
		else {
			head->prev = newNode;
			newNode->next = head;
			head = newNode;
		}
	}

	void insertAtEnd(T data) {
		Node<T>* newNode = createNode(data);
		if (isEmpty())
			head = newNode;
		else {
			Node<T>* traversal = head;
			while (traversal->next != NULL)
			{
				traversal = traversal->next;
			}
			newNode->prev = traversal;
			traversal->next = newNode;
		}
	}

	void insertAtPosition(T data, int position) {
		if (head == NULL || position == 1) {
			insertAtHead(data);
		}
		else {
			Node<T>* traversal = head;
			for (int i = 0; i < position - 1; i++)
				traversal = traversal->next;

			Node<T>* newNode = createNode(data);
			newNode->prev = traversal;
			newNode->next = traversal->next;
			traversal->next->prev = newNode;
			traversal->next = newNode;
		}

	}

	void deleteFromPosition(int position) {
		if (isEmpty()) {
			cout << "List is Empty" << endl;
		}
		else if (position == 1) {
			deleteFromHead();
		}
		else {
			Node<T>* traversal = head;
			for (int i = 0; i < position - 1; i++)
				traversal = traversal->next;

			traversal->prev->next = traversal->next;
			traversal->next->prev = traversal->prev;
			delete(traversal);
		}

	}

	void deleteFromHead() {
		if (isEmpty()) {
			cout << "List is Empty" << endl;
		}
		else {
			Node<T>* traversal = head;
			head = head->next;
			head->prev = NULL;
			delete(traversal);

		}
	}

	void print() {
		Node<T>* traversal = head;
		while (traversal != NULL) {
			cout << "<- [ " << traversal->prev << " | " << traversal->data << " |" << traversal->next << " ] -> ";
			traversal = traversal->next;
		}
	}

	void printReversed() {

		if (head == NULL)
			return;
		Node<T>* traversal = head;
		while (traversal->next != NULL)
			traversal = traversal->next;

		while (traversal != NULL) {
			cout << "<- [ " << traversal->next << " | " << traversal->data << " |" << traversal->prev << " ] -> ";
			traversal = traversal->prev;
		}
	}

	bool isEmpty() {
		return head == NULL;
	}

	void printRecursevily() {
		printRecursevilyHelper(head);
	}

	void printRecursevilyHelper(const Node<T>* traversal) {
		if (traversal == NULL)
			return;
		cout << "<- [ " << traversal->prev << " | " << traversal->data << " |" << traversal->next << " ] -> ";
		printRecursevilyHelper(traversal->next);
	}


};

int main() {

	cout << "Doubly LinkedList" << endl;
	DoublyLinkedList<int> list;
	list.insertAtHead(10);
	list.insertAtEnd(20);
	list.insertAtEnd(30);
	list.insertAtHead(0);
	// [ 0, 10, 20, 30 ]
	//   1   2   3   4
	list.insertAtPosition(15, 2);
	// [ 0, 10, 15, 20, 30 ]
	//   1   2   3   4   5
	list.deleteFromPosition(4);
	// [ 0, 10, 15, 30 ]
	//   1   2   3   4

	list.deleteFromPosition(1);
	// [ 0, 10, 15, 30 ]
	//   1   2   3   4
	cout << "\nPrinting.... \n";
	list.print();
	cout << "\nRecursively ..." << endl;
	list.printRecursevily();
	cout << "\nReverse Printing.... \n";
	list.printReversed();
	return 1;
}