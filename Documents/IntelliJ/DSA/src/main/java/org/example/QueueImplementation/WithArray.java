package org.example.QueueImplementation;

//SC:O(N)
class MyQueue{
    private int[] arr;
    private int front;
    private int rear;
    private static final int capacity=100;
    private int curSize;

    public MyQueue(){
        arr = new int[capacity];
        front=-1;
        rear=-1;
        curSize=0;
    }
    public void push(int x){//TC:O(1)
        if(curSize>=capacity){
            System.out.println("Cannot add any more as Queue is full");
        }
        else {
            curSize++;
            rear = (rear + 1) % capacity;
            arr[rear] = x;
        }
    }
    public int pop(){//TC:O(1)
        if(curSize==0){
            return -1;
        }
        curSize--;
        front=(front+1)%capacity;
        return arr[front];
    }
    public int front(){//TC:O(1)
        if(curSize==0){
            return -1;
        }

        return arr[(front+1)%capacity];
    }
    public int size(){//TC:O(1)
        return curSize;
    }
}
public class WithArray {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);

        System.out.println(queue.front());
        System.out.println(queue.pop());
        queue.push(10);
        System.out.println("Front: " + queue.front());
        System.out.println(queue.pop());
        System.out.println("Front: " + queue.front());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println();
        System.out.println(queue.front());
    }
}
