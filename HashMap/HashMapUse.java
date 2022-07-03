package HashMap;

public class HashMapUse {
    
    public static void main(String[] args) {
        
        Implementation<String, Integer> map = new Implementation<>();

        for(int i=0; i<10; i++){
            map.insert("abc" + i, i);
        }
        
        for(int i=1; i<10; i++){
             System.out.println(map.getKey("abc" +i));
        }
      
        System.out.println();
        System.out.println("Size of Hashmap : " + map.size());
        
    }
}
