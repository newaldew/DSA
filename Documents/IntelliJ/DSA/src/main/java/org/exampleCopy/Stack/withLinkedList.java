package org.exampleCopy.Stack;

class Node{
    private int val;
    private Node next;
    public Node(int val, Node next){
        this.val=val;
        this.next=next;
    }
    public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getNext() {
        return next;
    }
}

class StackLL{
    Node top;
    int capacity;
    int size;

    public StackLL(int capacity){
        this.capacity=capacity;
        this.top=null;
        size=0;
    }
    public void push(int val){
        if(size>=capacity){
            System.out.println("Cannot push " + val);
            return;
        }
        size++;
        Node newNode=new Node(val,top);
        top=newNode;
    }
    public int pop(){
        if(size==0){
            return -1;
        }
        int val=top.getVal();
        size--;
        top=top.getNext();
        return val;
    }
}

public class withLinkedList {
    public static void main(String[] args) {
        StackLL stack=new StackLL(3);
        stack.push(1);
        stack.push(10);
        stack.push(100);
        stack.push(1000);

        System.out.println(stack.pop());
    }
}
