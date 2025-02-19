package org.exampleCopy.Stack;

import java.util.LinkedList;
import java.util.Queue;

class StackQ{
    Queue<Integer>q;
    int start;
    int end;
    int capacity;
    int size;
    public StackQ(int capacity){
        this.capacity=capacity;
        this.q=new LinkedList<>();
        this.start=0;
        this.end=0;
        this.size=0;
    }
    public void push(int val){
        if(size==capacity){
            System.out.println("Cannot add further");
            return;
        }
        q.add(val);
    }
}
public class withQueue {
    public static void main(String[] args) {

    }
}
