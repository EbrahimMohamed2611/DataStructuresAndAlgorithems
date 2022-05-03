#include <iostream>
using namespace std;

template <class T>
class StackBasedArray
{
private:
    int top, maxSize;
    T* stack;

    bool isEmpty()
    {
        return top == -1;
    }

    bool isFull()
    {
        return top == maxSize;
    }

    void resize()
    {
        int newSize = maxSize * 2;
        T* temp = stack;
        stack = new T[newSize];
        for (int i = 0; i <= maxSize; i++)
            stack[i] = temp[i];

        maxSize = newSize;
        delete[] temp;
    }

public:
    StackBasedArray()
    {
        top = -1;
        stack = new T[10];
        maxSize = 10;
    }

    StackBasedArray(int size)
    {
        top = -1;
        stack = new T[size];
        maxSize = size;
    }

    void push(T element);

    T pop();

    T peek();

    int size();

    void print();

    ~StackBasedArray()
    {
        delete[] stack;
    }
};

template <class T>
void StackBasedArray<T>::push(T element)
{
    if (isFull())
        resize();

    stack[++top] = element;
}

template <class T>
T StackBasedArray<T>::pop()
{
    return stack[top--];
}

template <class T>
T StackBasedArray<T>::peek()
{
    return stack[top];
}

template <class T>
int StackBasedArray<T>::size()
{
    return maxSize;
}

template <class T>
void StackBasedArray<T>::print()
{
    for (int i = 0; i < maxSize; i++)
    {
        cout << stack[i] << "   ";
    }
    cout << endl;
}

int main()
{

    cout << "Stack Based Arrays" << endl;

    StackBasedArray<int> stack;
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    stack.push(50);
    stack.push(60);
    stack.push(70);
    stack.push(80);
    stack.push(90);
    stack.push(100);
    stack.push(110);
    stack.push(120);
    stack.push(130);
    stack.push(140);
    stack.print();

    stack.pop();

    stack.push(50);
    stack.print();

    return 1;
}