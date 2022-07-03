package HashMap;

import java.util.ArrayList;

public class Implementation<K , V> {
    
    ArrayList<mapList<K,V>> bucket;
    int count;
    int numberOfbuckets;
     
    public Implementation(){
        bucket = new ArrayList<>();
        numberOfbuckets = 20;
        for(int i=0; i<numberOfbuckets; i++){
            bucket.add(null);
        }
    }

    private int getIndex(K key){
        int re = key.hashCode();
        int index = re%numberOfbuckets;
        return index;
    }

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
    }

}



class mapList<K, V>{
    K key;
    V value;
    mapList<K , V> next;

    public mapList(K key , V value){
           this.key = key;
           this .value = value;
    }
}