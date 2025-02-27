package org.example.Map;

import java.util.ArrayList;
import java.util.Objects;

class HashMap<K,V>{
    private int capacity;//capacity of bucket
    private ArrayList<Node<K,V>> bucket;
    private int size;//size of map
    private static final int DEFAULT_CAPACITY = 16;

    public HashMap(){
        this.capacity=DEFAULT_CAPACITY;
        bucket=new ArrayList<>();
        for(int i=0;i<capacity;i++){
            bucket.add(null);//If not initialized with null then everytime get() will throw IndexOutOfBound exception
        }
        size=0;
    }
    public HashMap(int cap){
        this.capacity=cap;
        bucket=new ArrayList<>();
        for(int i=0;i<capacity;i++){
            bucket.add(null);
        }
        size=0;
    }

    public V get(K key){
        int bucketIndex=getBucketIndex(key);
        Node<K,V> head = bucket.get(bucketIndex);

        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head=head.next;
        }
        return null;
    }
    public boolean containsKey(K key){
        int bucketIndex=getBucketIndex(key);
        Node<K,V> head=bucket.get(bucketIndex);

        while(head!=null){
            if(head.key.equals(key)){
                return true;
            }
            head=head.next;
        }
        return false;
    }

    public void put(K key, V value){
        int bucketIndex=getBucketIndex(key);
        Node<K,V> head=bucket.get(bucketIndex);

        while(head!=null){//If key already exists
            if(head.key.equals(key)){
                head.value=value;
                return;
            }
            head=head.next;
        }
        size++;

        Node<K,V> newNode = new Node<>(key, value);
        head=bucket.get(bucketIndex);
        newNode.next=head;//insert new key-value pair in start
        bucket.set(bucketIndex,newNode);

        //Check if rehashing is required
        double loadFactor=(size*1.00)/capacity;
        if(loadFactor>0.75){
            System.out.println("Load factor greater then 75%");
            rehash();
        }
    }
    private void rehash(){
        ArrayList<Node<K,V>> temp = bucket;
        bucket = new ArrayList<>();
        size=0;
        capacity=capacity*2;

        for(int i=0;i<capacity;i++){
            bucket.add(null);//If not initialized with null then everytime get() will throw IndexOutOfBound exception
        }

        for(int i=0;i<temp.size();i++){
            Node<K,V> head = temp.get(i);
            while(head!=null){
                put(head.key,head.value);
                head=head.next;
            }
        }
        System.out.println("Increased capacity to " + capacity);
    }

    public void remove(K key){
        int bucketIndex = getBucketIndex(key);
        Node<K,V> head = bucket.get(bucketIndex);
        Node<K,V> pre=null;

        while(head!=null){
            if(head.key.equals(key)){
                if(pre == null){//removing head
                    bucket.set(bucketIndex,head.next);
                }
                else{
                    pre.next=head.next;
                }
                head.next=null;
                size--;
                break;
            }
            pre=head;
            head=head.next;
        }
    }
    public ArrayList<K> keySet(){//TC:O(N)
        ArrayList<K> keys = new ArrayList<>();

        for(int i=0;i<capacity;i++){
            Node<K,V> head = bucket.get(i);

            while(head!=null){
                keys.add(head.key);
                head=head.next;
            }
        }
        return keys;
    }
    public boolean isEmpty(){
        return size==0;
    }
    private int getBucketIndex(K key){
        int hashcode=key.hashCode();
        return hashcode%capacity;
    }

    private static class Node<K,V>{
        K key;
        V value;
        Node<K,V> next;

        public Node(K key, V value){
            this.key=key;
            this.value=value;
        }

        @Override
        public boolean equals(Object obj){//Optional implementation
            if(this==obj){
                return true;
            }
            if(obj==null || this.getClass()!=obj.getClass()){
                return false;
            }
            Node<?,?> node = (Node<?,?>) obj;
            return key.equals(node.key) && value.equals(node.value);
        }
        @Override
        public int hashCode(){//Optional implementation
            return Objects.hash(key, value);
        }
    }
}
public class HashMapImpl {
    public static void main(String[] args) {
        HashMap<String,Integer> map =new HashMap<>(4);

        System.out.println(map.isEmpty());
        map.put("New",1);
        map.put("Dew",3);
        map.put("Gold",1);

        for(String k:map.keySet()){
            System.out.println(k);
            System.out.println(map.get(k));
        }
        map.remove("Dew");

        System.out.println(map.containsKey("Dew"));
    }
}
