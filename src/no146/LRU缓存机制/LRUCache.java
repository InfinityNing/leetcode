package no146.LRU缓存机制;

import java.util.HashMap;

public class LRUCache {
    class Node{
        int key;
        int value;
        Node prev,next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            prev=null;
            next=null;
        }
    }
    HashMap<Integer,Node> map;
    int capacity;
    Node head,tail,cur,temp;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
        head=new Node(Integer.MIN_VALUE,Integer.MIN_VALUE);
        tail=new Node(Integer.MAX_VALUE,Integer.MAX_VALUE);
        head.next=tail;
        tail.prev=head;
    }

    public void moveCurToHead(){
        if(cur.prev!=null&&cur.next!=null){
            cur.prev.next=cur.next;
            cur.next.prev=cur.prev;
        }
        cur.next=head.next;
        head.next=cur;
        cur.prev=head;
        cur.next.prev=cur;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        cur=map.get(key);
        moveCurToHead();
        return cur.value;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            cur=map.get(key);
            cur.value=value;
            moveCurToHead();
            return ;
        }
        cur=new Node(key,value);
        map.put(key,cur);
        moveCurToHead();
        if(map.size()>capacity){
            cur=tail.prev;
            cur.prev.next=cur.next;
            cur.next.prev=cur.prev;
            map.remove(cur.key);
        }
    }

    public void print(){
        cur=head.next;
        while(cur!=tail){
            System.out.print(cur.value);
            cur=cur.next;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.put(7,7);
        lruCache.print();
    }
}
