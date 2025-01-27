package org.example.Heap;

class Heap{
    int[] arr;
    int capacity;
    int size;

    public Heap(int cap){
        this.capacity=cap;
        arr=new int[this.capacity];
        size=0;
    }
    int parent(int i){
        return (i-1)/2;
    }
    int left(int i){
        return 2*i+1;
    }
    int right(int i){
        return 2*i+2;
    }
    public void push(int val){//TC:O(logN)
        if(size==capacity){
            System.out.println("Heap capacity is full");
            return;
        }
        arr[size]=val;
        int k=size;
        size++;
        while(k>0 && arr[parent(k)]>arr[k]){
            swap(parent(k),k);
            k=parent(k);
        }
    }
    public void delete(int idx){//TC:O(2logN)
        decreaseKey(idx,Integer.MIN_VALUE);
        poll();
    }
    private void decreaseKey(int idx, int val){//TC:O(logN)
        arr[idx]=val;
        int k=idx;

        while(k>0 && arr[parent(k)]>arr[k]){
            swap(k,parent(k));
            k=parent(k);
        }
    }
    public int poll(){//TC:O(logN)
        if(size<=0){
            return Integer.MAX_VALUE;
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
    public int peek(){
        return arr[0];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void heapify(int i){//TC:O(logN)
//        if(i>=size/2){
//            return;
//        }
        int left=left(i);
        int right=right(i);
        int smallest=i;

        if(left<size && arr[left]<arr[smallest]){
            smallest=left;
        }
        if(right<size && arr[right]<arr[smallest]){
            smallest=right;
        }

        if(smallest!=i){
            swap(i,smallest);
            heapify(smallest);
        }
    }
    private void heapifyIterative(int idx){
        int k=idx;
        while(k<size/2){
            int left=left(k);
            int right=right(k);
            int smallest=k;

            if(left<size && arr[left]<arr[smallest]){
                smallest=left;
            }
            if(right<size && arr[right]<arr[smallest]){
                smallest=right;
            }

            if(smallest!=k){
                swap(smallest,k);
                k=smallest;
            }
            else{
                break;
            }
        }
    }
    private void swap(int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}

public class MinHeap {
    public static void main(String[] args) {
        Heap heap=new Heap(5);
        heap.push(10);
        heap.push(100);
        heap.push(1);
        heap.push(5);
        heap.push(13);
        heap.delete(heap.size-1);//delete 13 value which is last index pushed
        heap.push(25);

//        System.out.println(heap.size());
//        System.out.println(heap.peek());

//        while(!heap.isEmpty()){
//            System.out.println(heap.poll());
//        }

        //System.out.println(heap.peek());
        //heap.delete(2);

        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}
