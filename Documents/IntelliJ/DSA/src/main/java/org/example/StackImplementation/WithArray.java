package org.example.StackImplementation;

//SC:O(N)
class StackImpl{
    private int top;
    private static final int capacity=100;
    private int[] arr;

    public StackImpl(){
        this.top=-1;
        this.arr=new int[capacity];
    }
    public boolean push(int x){//TC:O(1)
        if(top>=capacity){
            return false;
        }
        top++;
        arr[top]=x;
        return true;
    }
    public int pop(){//TC:O(1)
        if(top==-1){
            return -1;
        }
        int ans=arr[top];
        top--;
        return ans;
    }
    public int top(){//TC:O(1)
        if(top==-1){
            return -1;
        }
        return arr[top];
    }
    public int size(){//TC:O(1)
        return 1+top;
    }
}
public class WithArray {
    public static void main(String[] args) {

        StackImpl stack = new StackImpl();
        stack.push(3);
        stack.push(4);
        stack.push(2);

        System.out.println("Size: " + stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println("Size: " + stack.size());
    }
}
