package org.example.Heap;

class HeapMax{
    int capacity;
    int size;
    int[] arr;

    public HeapMax(int cap){
        this.capacity=cap;
        arr=new int[this.capacity];
        size=0;
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private int left(int i){
        return 2*i+1;
    }
    private int right(int i){
        return 2*i+2;
    }
    public void push(int val){
        if(size==capacity){
            System.out.println("Heap size is full!");
        }
        arr[size]=val;
        int k=size;
        size++;

        while(k>0 && arr[parent(k)]<arr[k]){
            swap(parent(k),k);
            k=parent(k);
        }
    }
    public int poll(){
        if(size<=0){
            return Integer.MIN_VALUE;
        }
        if(size==1){
            size--;
            return arr[0];
        }
        int ans=arr[0];
        arr[0]=arr[size-1];
        size--;
        heapify(0);
        return ans;
    }
    private void heapifyIterative(int idx){
        int k=idx;
        while(k<size/2){
            int left=left(k);
            int right=right(k);
            int greatest=k;

            if(left<size && arr[left]>arr[greatest]){
                greatest=left;
            }
            if(right<size && arr[right]>arr[greatest]){
                greatest=right;
            }
            if(greatest!=k){
                swap(greatest,k);
                k=greatest;
            }
            else{
                break;
            }
        }
    }
    private void heapify(int idx){
        int left=left(idx);
        int right=right(idx);
        int greatest=idx;

        if(left<size && arr[left]>arr[greatest]){
            greatest=left;
        }
        if(right<size && arr[right]>arr[greatest]){
            greatest=right;
        }
        if(greatest!=idx){
            swap(greatest,idx);
            heapify(greatest);
        }
    }
    public void delete(int idx){
        decreaseKey(idx,Integer.MAX_VALUE);
        poll();
    }
    private void decreaseKey(int idx, int val){
        arr[idx]=val;
        int k=idx;

        while(k>0 && arr[parent(k)]<arr[k]){
            swap(parent(k),k);
            k=parent(k);
        }
    }
    public int peek(){
        return arr[0];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    private void swap(int x, int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}
public class MaxHeap {
    public static void main(String[] args) {

        HeapMax heap=new HeapMax(5);
        System.out.println(heap.isEmpty());
        heap.push(10);
        heap.push(100);
        heap.push(1);
        heap.push(5);
        heap.push(13);
        heap.delete(heap.size-1);//delete 10 value which is last index pushed
        heap.push(25);

//        System.out.println(heap.size());
//        System.out.println(heap.peek());

        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }

    }
}
