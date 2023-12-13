package org.example;

import java.util.HashMap;
import java.util.LinkedList;

public class MemoryCache {

    // static
    private static int DEFAULT_CACHE_LIMIT = 10;
    private static int DEFAULT_ENTRY_LIMIT = 100000;
    private static int maxInstanceCount = DEFAULT_CACHE_LIMIT;
    private static HashMap<String, MemoryCache> instanceMap = new HashMap<>();
    private static LinkedList<String> memoryCacheLruList = new LinkedList<>();

    // MemoryCache 는 LRU 정책을 따름
    public static MemoryCache getInstance(String key){
        if(instanceMap.containsKey(key)){
            MemoryCache returnCache = instanceMap.get(key);
            memoryCacheLruList.remove(key);
            memoryCacheLruList.addFirst(key);
            return returnCache;
        }
        if(instanceMap.keySet().size() >= maxInstanceCount){
            String removed = memoryCacheLruList.removeLast();
            instanceMap.remove(removed);
        }
        MemoryCache newMemoryCache = new MemoryCache(key);
        instanceMap.put(key,newMemoryCache);
        memoryCacheLruList.addFirst(key);

        return instanceMap.get(key);
    }

    public static LinkedList<String> getMemoryCacheLruList() {
        return memoryCacheLruList;
    }

    public static HashMap<String, MemoryCache> getInstanceMap() {
        return instanceMap;
    }

    public static void setMaxInstanceCount(int count){
        if(count < maxInstanceCount){
            while(memoryCacheLruList.size() > count){
                String removed = memoryCacheLruList.removeLast();
                instanceMap.remove(removed);
            }
        }
        maxInstanceCount = count;
    }

    public static void clear(){
        instanceMap = new HashMap<>();
        memoryCacheLruList = new LinkedList<>();
        maxInstanceCount = DEFAULT_CACHE_LIMIT;
    }


    // non-static

    private MemoryCache(String key){
        this.key = key;
        this.entryMap = new HashMap<>();
        this.lruList = new LinkedList<>();
        this.orderList = new LinkedList<>();
        this.maxEntryCount = DEFAULT_ENTRY_LIMIT;
        this.evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
    }

    private final String key;
    private final HashMap<String,String> entryMap;
    private final LinkedList<String> lruList;
    private final LinkedList<String> orderList;
    private int maxEntryCount;
    private EvictionPolicy evictionPolicy;

    public String getKey() {
        return key;
    }

    public void addEntry(String key, String value){
        // 이미 있는 경우
        if(entryMap.containsKey(key)){
            entryMap.replace(key,value);
            // LRU 적용
            lruList.remove(key);
            lruList.addLast(key);
            return;
        }

        // 꽉차 있는데 추가하는 경우
        if(entryMap.size() == maxEntryCount){
            // 지우기 정책
            String removedKey = null;
            switch (evictionPolicy){
                case LEAST_RECENTLY_USED:
                    removedKey = lruList.removeFirst();
                    orderList.remove(removedKey);
                    break;
                case FIRST_IN_FIRST_OUT:
                    removedKey = orderList.removeFirst();
                    lruList.remove(removedKey);
                    break;
                case LAST_IN_FIRST_OUT:
                    removedKey = orderList.removeLast();
                    lruList.remove(removedKey);
                    break;
                default:
                    assert false : "not allowed eviction policy";
            }
            entryMap.remove(removedKey);
        }

        // 널널할 경우
        entryMap.put(key,value);
        lruList.addLast(key);
        orderList.addLast(key);

        assert entryMap.size() == lruList.size();
        assert lruList.size() == orderList.size();
    }

    public void setMaxEntryCount(int count){
        if(count < maxEntryCount){
            while(entryMap.size() > count){
                String removedKey = null;
                switch (evictionPolicy){
                    case LEAST_RECENTLY_USED:
                        removedKey = lruList.removeFirst();
                        orderList.remove(removedKey);
                        break;
                    case FIRST_IN_FIRST_OUT:
                        removedKey = orderList.removeFirst();
                        lruList.remove(removedKey);
                        break;
                    case LAST_IN_FIRST_OUT:
                        removedKey = orderList.removeLast();
                        lruList.remove(removedKey);
                        break;
                    default:
                        assert false : "not allowed eviction policy";
                }
                entryMap.remove(removedKey);
            }
        }
        maxEntryCount = count;
    }

    public String getEntryOrNull(String key){
        if(entryMap.containsKey(key)){
            lruList.remove(key);
            lruList.addLast(key);
            return entryMap.get(key);
        }
        return null;
    }

    public void setEvictionPolicy(EvictionPolicy policy){
        evictionPolicy = policy;
    }

}
