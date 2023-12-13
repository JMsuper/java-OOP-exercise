package org.example;


import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;

public class MemoryCache {

    // static
    private static int DEFAULT_LIMIT = 3;
    private static int maxInstanceCount = DEFAULT_LIMIT;
    private static HashMap<String, MemoryCache> instanceMap = new HashMap<>();
    private static LinkedList<MemoryCache> memoryCacheLruList = new LinkedList<>();

    // MemoryCache 는 LRU 정책을 따름
    public static MemoryCache getInstance(String key){
        if(instanceMap.containsKey(key)){
            MemoryCache returnCache = instanceMap.get(key);
            memoryCacheLruList.remove(returnCache);
            memoryCacheLruList.addFirst(returnCache);
            return returnCache;
        }
        if(instanceMap.keySet().size() >= maxInstanceCount){
            MemoryCache removed = memoryCacheLruList.removeLast();
            instanceMap.remove(removed.key);
        }
        MemoryCache newMemoryCache = new MemoryCache(key);
        instanceMap.put(key,newMemoryCache);
        memoryCacheLruList.addFirst(newMemoryCache);

        return instanceMap.get(key);
    }

    public static LinkedList<MemoryCache> getMemoryCacheLruList() {
        return memoryCacheLruList;
    }

    public static HashMap<String, MemoryCache> getInstanceMap() {
        return instanceMap;
    }

    public static void setMaxInstanceCount(int count){
        if(count < maxInstanceCount){
            while(memoryCacheLruList.size() > count){
                MemoryCache removed = memoryCacheLruList.removeLast();
                instanceMap.remove(removed.key);
            }
        }
    }

    public static void clear(){
        instanceMap = new HashMap<>();
        memoryCacheLruList = new LinkedList<>();
    }


    // non-static

    private MemoryCache(String key){
        this.key = key;
        this.entryMap = new HashMap<>();
        this.lruList = new LinkedList<>();
        this.maxEntryCount = DEFAULT_LIMIT;
        this.evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
    }

    private String key;
    private HashMap<String,String> entryMap;
    // Pair<Key, Value>
    private LinkedList<Pair<String,String>> lruList;
    private int maxEntryCount;
    private EvictionPolicy evictionPolicy;

    public String getKey() {
        return key;
    }

    public LinkedList<Pair<String, String>> getLruList() {
        return lruList;
    }

    public HashMap<String, String> getEntryMap() {
        return entryMap;
    }

    public void addEntry(String key, String value){
        if(entryMap.containsKey(key)){
            String oldValue = entryMap.replace(key,value);
            lruList.remove(new Pair<>(key,oldValue));
            lruList.addFirst(new Pair<>(key,value));
            return;
        }
        if(maxEntryCount == lruList.size()){
            Pair<String,String> removed = lruList.removeLast();
            entryMap.remove(removed.getKey());
        }
        entryMap.put(key,value);
        lruList.addFirst(new Pair<>(key,value));
    }

    public void setMaxEntryCount(int cnt){}

    public String getEntryOrNull(String key){return null;}
//
//    public void setEvictionPolicy(EvictionPolicy policy){}

}
