package imp;

import java.util.*;

public class RandomMapTest {

    public static void main(String[] args){
        RandomMap<String,Integer> rMap = new RandomMap<>();
        rMap.put("a",1);
        rMap.put("b",2);
        rMap.put("c",3);
        rMap.put("d",4);
        rMap.put("e",5);

        System.out.println(rMap.get("b"));
       rMap.delete("c");
       System.out.println(rMap.get("c"));
        System.out.println(rMap.randomValue());


    }
}

class RandomMap<K,V>{

    class MapValue{
        V value;
        Integer index;

        public MapValue(V v,int i){
            this.value = v;
            this. index = Integer.valueOf(i);
        }
    }

    Map<K,MapValue> map = new HashMap<>();
    int length = 0;
    List<K> keyList = new ArrayList<>();

    public V get(K key){
        MapValue mapVal = map.get(key);
        if(mapVal == null) return null;
        else return mapVal.value;
    }

    public void put(K key, V value){
        int index = 0;
        if(length < keyList.size()){
            index = length;
            keyList.set(length,key);


        }else{
            index = keyList.size();
            keyList.add(key);


        }
        length++;

        map.put(key,new MapValue(value,index));
    }

    public void delete(K key){
        MapValue mapValue = map.get(key);
        keyList.set(mapValue.index,keyList.get(length-1));
        map.remove(key);

    }

    public V randomValue(){

       Random r = new Random();
       int random = r.nextInt(length-1);
        System.out.println(random);
        return get(keyList.get(random));
    }
}

