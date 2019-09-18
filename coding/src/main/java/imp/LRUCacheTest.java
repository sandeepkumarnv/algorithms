package imp;

import java.util.HashMap;

public class LRUCacheTest{
    public static void main(String[] args){
        LRUCache<Integer,String> cache = new LRUCache<>(4);
        cache.set(1,"One");

        System.out.println("Get 1=>"+cache.get(1));

        cache.set(2,"Two");
        cache.set(3,"Three");
        cache.set(4,"Four");
        cache.set(5,"Five");
        cache.set(6,"Six");

        System.out.println("Get 1 expired=>"+cache.get(1));
        System.out.println("Get 2=>"+cache.get(2));
        cache.set(7,"Seven");
        System.out.println("Get 2 expired=>"+cache.get(2));
        System.out.println("Get 6=>"+cache.get(6));
    }
}

class LRUCache<K,V>{
    private Integer size ;
    private HashMap<K,CacheValue<K,V>> cacheMap ;
    private CacheValue start;
    private CacheValue end;

    public LRUCache(Integer size){
        this.size = size;
        cacheMap = new HashMap<K,CacheValue<K,V>>(size);
    }

    public V get(K key){
        V value = null;
        if(cacheMap.containsKey(key)){
            CacheValue<K,V> cacheValue = cacheMap.get(key);
            remove(cacheValue);
            setStart(cacheValue);
            cacheValue.next = start;
            start = cacheValue;
            value = cacheValue.data;
        }
        return value;
    }

    private void remove(CacheValue cacheValue){
        if(cacheValue != start) {
            cacheValue.previous.next =  cacheValue.next;
        }
        else {
            start=start.next;
        }
        if(cacheValue.next != null){
            cacheValue.next.previous = cacheValue.previous;
        }else{
            end = end.previous;
        }

        cacheMap.remove(cacheValue.key);
    }

    private void setStart(CacheValue cacheValue){
        cacheValue.next = start;
        cacheValue.previous = null;
        if(start != null){
            start.previous = cacheValue;
        }
        start = cacheValue;
        if(end == null) {
            end = start;
        }
    }

    public void set(K key, V value){
        CacheValue cacheValue =  null;
        if(cacheMap.containsKey(key)){
            cacheValue = cacheMap.get(key);
            cacheValue.data = value;
            remove(cacheValue);
            setStart(cacheValue);
        }else{
            cacheValue = new CacheValue(key,value);

            if(cacheMap.size() > size){
                remove(end);
            }
            setStart(cacheValue);

        }
        cacheMap.put(key,cacheValue);
    }



}

class CacheValue<K,V>{
    V data;
    K key;
    CacheValue previous;
    CacheValue next;

    public CacheValue(K key,V data){
        this.key = key;
        this.data=data;
    }
}