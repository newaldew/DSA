package org.example.Heap;

//TC:O((1.5)NlogN)
//SC:O(1), ASC:O(logN)
public class HeapSort {
    private static void heapify(int[] arr, int n, int i){
        int left=2*i+1;
        int right=2*i+2;
        int greatest=i;

        if(left<n && arr[left]>arr[greatest]){
            greatest=left;
        }
        if(right<n && arr[right]>arr[greatest]){
            greatest=right;
        }
        if(greatest!=i){
            swap(arr,i,greatest);
            heapify(arr,n,greatest);
        }
    }
    private static void swap(int[] arr,int x, int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    private static void sort(int[] arr){
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }

        for(int i=n-1;i>=0;i--){
            swap(arr,i,0);
            heapify(arr,i,0);
        }
    }
    public static void main(String[] args) {
        int[] arr={9, 4, 3, 8, 10, 2, 5};
        HeapSort.sort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
