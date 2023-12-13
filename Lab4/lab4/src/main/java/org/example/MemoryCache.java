package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MemoryCache {

    // static
    private static final int DEFAULT_CACHE_LIMIT = 10;
    private static final int DEFAULT_ENTRY_LIMIT = 100000;
    private static int maxInstanceCount = DEFAULT_CACHE_LIMIT;
    private static HashMap<String, MemoryCache> cacheMap = new HashMap<>();
    private static LinkedList<String> cacheLRUList = new LinkedList<>();

    // MemoryCache 는 LRU 정책을 따름
    public static MemoryCache getInstance(String key){
        if(cacheMap.containsKey(key)){
            MemoryCache theCache = cacheMap.get(key);
            cacheLRUList.remove(key);
            cacheLRUList.addFirst(key);
            return theCache;
        }
        if(cacheMap.keySet().size() >= maxInstanceCount){
            String removedCache = cacheLRUList.removeLast();
            cacheMap.remove(removedCache);
        }
        MemoryCache newCache = new MemoryCache(key);
        cacheMap.put(key, newCache);
        cacheLRUList.addFirst(key);

        return cacheMap.get(key);
    }

    public static List<String> getCacheLRUList() {
        return cacheLRUList;
    }

    public static Map<String, MemoryCache> getInstanceMap() {
        return cacheMap;
    }

    public static void setMaxInstanceCount(int count){
        if(count < maxInstanceCount){
            while(cacheLRUList.size() > count){
                String removed = cacheLRUList.removeLast();
                cacheMap.remove(removed);
            }
        }
        maxInstanceCount = count;
    }

    public static void clear(){
        cacheMap = new HashMap<>();
        cacheLRUList = new LinkedList<>();
        maxInstanceCount = DEFAULT_CACHE_LIMIT;
    }


    // non-static

    private MemoryCache(String key){
        this.key = key;
        this.entryMap = new HashMap<>();
        this.entryListOrderByLRU = new LinkedList<>();
        this.entryListOrderByInsert = new LinkedList<>();
        this.maxEntryCount = DEFAULT_ENTRY_LIMIT;
        this.evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
    }

    private final String key;
    private final HashMap<String,String> entryMap;
    private final LinkedList<String> entryListOrderByLRU;
    private final LinkedList<String> entryListOrderByInsert;
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
            entryListOrderByLRU.remove(key);
            entryListOrderByLRU.addLast(key);
            return;
        }

        // 꽉차 있는데 추가하는 경우
        if(entryMap.size() == maxEntryCount){
            // 지우기 정책
            String removedKey = null;
            switch (evictionPolicy){
                case LEAST_RECENTLY_USED:
                    removedKey = entryListOrderByLRU.removeFirst();
                    entryListOrderByInsert.remove(removedKey);
                    break;
                case FIRST_IN_FIRST_OUT:
                    removedKey = entryListOrderByInsert.removeFirst();
                    entryListOrderByLRU.remove(removedKey);
                    break;
                case LAST_IN_FIRST_OUT:
                    removedKey = entryListOrderByInsert.removeLast();
                    entryListOrderByLRU.remove(removedKey);
                    break;
                default:
                    assert false : "not allowed eviction policy";
            }
            entryMap.remove(removedKey);
        }

        // 캐시 공간에 여유 있는 경우
        entryMap.put(key,value);
        entryListOrderByLRU.addLast(key);
        entryListOrderByInsert.addLast(key);

        assert entryMap.size() == entryListOrderByLRU.size();
        assert entryListOrderByLRU.size() == entryListOrderByInsert.size();
    }

    public void setMaxEntryCount(int count){
        if(count < maxEntryCount){
            while(entryMap.size() > count){
                String removedKey = null;
                switch (evictionPolicy){
                    case LEAST_RECENTLY_USED:
                        removedKey = entryListOrderByLRU.removeFirst();
                        entryListOrderByInsert.remove(removedKey);
                        break;
                    case FIRST_IN_FIRST_OUT:
                        removedKey = entryListOrderByInsert.removeFirst();
                        entryListOrderByLRU.remove(removedKey);
                        break;
                    case LAST_IN_FIRST_OUT:
                        removedKey = entryListOrderByInsert.removeLast();
                        entryListOrderByLRU.remove(removedKey);
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
            entryListOrderByLRU.remove(key);
            entryListOrderByLRU.addLast(key);
            return entryMap.get(key);
        }
        return null;
    }

    public void setEvictionPolicy(EvictionPolicy policy){
        evictionPolicy = policy;
    }

}
