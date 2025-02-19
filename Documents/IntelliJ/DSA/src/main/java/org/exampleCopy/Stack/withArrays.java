package org.exampleCopy.Stack;

class Stack{
    private int[] arr;
    private final int capacity;
    private int top;

    public Stack(int capacity){
        this.capacity=capacity;
        arr=new int[capacity];
        top=-1;
    }
    public void push(int val){
        if(top>=capacity) {
            System.out.println("Stack is full cannot insert " + val);
            return;
        }
        top++;
        arr[top]=val;
        System.out.println("Inserted value " + val);
    }
    public int pop(){
        if(top==-1){
            System.out.println("Stack is empty cannot pop value" );
            return -1;
        }
        int popValue=arr[top];
        top--;
        return popValue;
    }
    public int peek(){
        if(top==-1){
            return -1;
        }
        return arr[top];
    }
}
public class withArrays {
    public static void main(String[] args) {
        Stack stack=new Stack(3);
        stack.push(1);
        stack.push(10);
        stack.push(100);
        stack.push(1000);
        System.out.println(stack.pop());
        stack.push(1000);
        System.out.println(stack.pop());
    }
}
