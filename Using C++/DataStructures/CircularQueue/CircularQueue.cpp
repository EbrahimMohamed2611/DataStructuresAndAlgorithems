#include <iostream>
using namespace std;

template <class T>
class CircularQueue
{
private:
    T *data;
    int front;
    int rear;
    int size;

public:
    CircularQueue()
    {
        front = rear = -1;
        size = 10;
        data = new T[size];
    }

    CircularQueue(int _size)
    {
        front = rear = -1;
        size = _size;
        data = new T[size];
    }

    void enqueue(T element)
    {
        if (isFull())
        {
            cout << "Queue is Full -_-" << endl;
            return;
        }
        else if (isEmpty())
        {
            rear = front = 0;
        }
        else
        {
            rear = (rear + 1) % size;
        }
        data[rear] = element;
    }

    T dequeue()
    {
        if (isEmpty())
        {
            cout << "Queue is Empty -_-" << endl;
            throw "No Such Elements";
        }
        else if (rear == front) // Important special case
        {
            T element = data[front];
            front = rear = -1;
            return element;
        }
        else
        {
            T element = data[front];
            front = (front + 1) % size;
            return element;
        }
    }

    bool isFull()
    {
        return ((rear + 1) % size) == front;
    }

    bool isEmpty()
    {
        return (front == -1 && rear == -1);
    }

    void display()
    {
        if (isEmpty())
        {
            throw "No Such Elements";
        }
        int i;
        for (i = front; i != rear; i = (i + 1) % size) // (i = (i + 1) % size) -> for next Position
        {
            cout << data[i] << "\t";
        }
        cout << data[i] << endl; // becouse we stop when front before rear by one step so we need to display the last element
    }

    ~CircularQueue()
    {
        delete[] data;
    }
};

int main()
{
    cout << "Circular Queue" << endl;
    CircularQueue<int> queue;
    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);
    queue.enqueue(7);
    queue.enqueue(8);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);
    queue.enqueue(7);
    queue.enqueue(8);
    // will be full
    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);
    queue.enqueue(7);
    queue.enqueue(8);
    cout << "Start Displying ....." << endl;
    queue.display();
    cout << "Enf Displying ...." << endl;
    cout << "Start Dequeue..." << endl;
    cout << queue.dequeue() << endl;
    cout << queue.dequeue() << endl;
    cout << queue.dequeue() << endl;
    cout << queue.dequeue() << endl;
    cout << queue.dequeue() << endl;
    cout << "End Dequeue..." << endl;
    queue.display();
    return 1;
}