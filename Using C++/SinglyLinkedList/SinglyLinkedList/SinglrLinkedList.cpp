#include<iostream>
using namespace std;
class Node{
public:
	int value;
	Node* next;
};

class LinkedList{
public:
	Node* head;
	int size;
	LinkedList(){
		head = NULL;
		size = 0;
	}

	int isEmpty(){
		return (head == NULL);
	}

	void insertFirst(int item){
		Node *newNode = new Node();
		newNode->value = item;
		if (isEmpty()){
			newNode->next = NULL;
			head = newNode;
		}
		else{
			newNode->next = head;
			head = newNode;
		}
		size++;
	}

	void display(){
		Node* currentNode = head;
		cout << "Head ==> ";
		while (currentNode != NULL){
			cout <<  currentNode->value << " ==> ";
			currentNode = currentNode->next;
		}
		cout << "NULL" << endl;
	}

	int search(int value){
		int flag = 0;
		Node* currentNode = head;
		while (currentNode != NULL){
			if (currentNode->value == value){
				flag = 1;
				return flag;
			}
			else{
				currentNode = currentNode->next;
			}
		}
		return flag;
	}

	void append(int value){
		if (isEmpty()){
			insertFirst(value);
		}
		else{			
			Node* current = head;
			while (current->next != NULL){
				current = current->next;
			}
			Node* newNode = new Node();
			newNode->value = value;
			newNode->next = NULL;
			current->next = newNode;
		}
	}

	void deleteNode(int value){
		if (isEmpty()){
			cout << "LinkedList is Empty :( " << endl;
		}
		else if (!search(value)){
			cout << "This Value does not exist :( " << endl;
		}
		else if (head->value == value){
			Node* current = head;
			head = head->next;
			delete current;
		}
		else{
			Node* current = head;
			Node* previous = NULL;
			while (current->value != value){
				previous = current;
				current = current->next;
			}
			previous->next = current->next;
			current = NULL;
			delete current;
		}
	}
};
int main(){
	LinkedList linkedList;
	cout << "LinkedList is Empty ? : " << (linkedList.isEmpty()?"YES":"NO") << endl;

	//linkedList.append(0);
	linkedList.insertFirst(30);
	linkedList.insertFirst(20);
	linkedList.insertFirst(10);
	linkedList.append(40);
	linkedList.append(50);
	
	cout << linkedList.search(50) << endl;
	linkedList.deleteNode(10);
	linkedList.display();
	cout << "LinkedList is Empty ? : " << (linkedList.isEmpty() ? "YES" : "NO") << endl;

	system("pause");
	return 0;
}