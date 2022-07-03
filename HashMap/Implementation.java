package HashMap;

import java.util.ArrayList;

class mapList<K, V>{
    K key;
    V value;
    mapList<K , V> next;

    public mapList(K key , V value){
           this.key = key;
           this .value = value;
    }
}


public class Implementation<K , V> {
    
    ArrayList<mapList<K,V>> bucket;
    int count;
    int numberOfbuckets;
     
    public Implementation(){
        bucket = new ArrayList<>();
        numberOfbuckets = 5;
        for(int i=0; i<numberOfbuckets; i++){
            bucket.add(null);
        }
    }

    //find size of HashMap
    public int size(){
        return count;
    }

    //find Load factor of HashMap
    public double loadFactor(){
        return 1.0*count/numberOfbuckets;
    }

    //find frequency of particular key
    public V getKey(K key){
        int bucketIndex = getIndex(key);
        mapList<K,V> head = bucket.get(bucketIndex);
        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    //To delete key from HashMap
    public V remove(K key){
       int bucketIndex = getIndex(key);
       mapList<K,V> head = bucket.get(bucketIndex);
       mapList<K,V> prev = null;
       while(head!=null){
        if(head.key.equals(key)){
        if(prev!=null){
            prev.next = head.next;
        }
        else{
            bucket.set(bucketIndex , head.next);
        }
        count--;
        return head.value;
    }
        prev = head;
        head = head.next;
       }
       
       return null;
    }

    //find index of key in ArrayList
    private int getIndex(K key){
        int re = key.hashCode();
        int index = re%numberOfbuckets;
        return index;
    }

    //Insert function - to insert element in HashMap
    public void insert(K key , V value){
        int bucketIndex = getIndex(key);
        mapList<K,V> head = bucket.get(bucketIndex);
        while(head!=null){
              if(head.key.equals(key)){
                head.value = value;
                return;
              }
              head = head.next;
        }

        head = bucket.get(bucketIndex);
        mapList<K,V> newNode = new mapList<>(key, value);
        newNode.next= head;
        bucket.set(bucketIndex, newNode);
        count++;

        double loadFactor = 1.0*count/numberOfbuckets;
        if(loadFactor > 0.7){
            reHash();
        }
    }

    //Reshashing
    private void reHash(){
        ArrayList<mapList<K,V>> temp = bucket;
        bucket = new ArrayList<>();
        for(int i=0; i<2*numberOfbuckets; i++){
            bucket.add(null);
        } 
        count = 0;
        numberOfbuckets = 2*numberOfbuckets;
        
        for(int i=0; i<temp.size(); i++){
            mapList<K,V> head = temp.get(i);
            while(head!=null){
                K key = head.key;
                V value = head.value;
                insert(key ,value);
                head = head.next;
            }
        }
    }

}

