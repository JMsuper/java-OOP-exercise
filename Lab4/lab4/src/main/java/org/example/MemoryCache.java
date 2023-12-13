package org.example;


import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;

public class MemoryCache {

    // static
    private static int DEFAULT_LIMIT = 3;
    private static int maxInstanceCount = DEFAULT_LIMIT;
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
    private LinkedList<String> lruList;
    private int maxEntryCount;
    private EvictionPolicy evictionPolicy;

    public String getKey() {
        return key;
    }

    public LinkedList<String> getLruList() {
        return lruList;
    }

    public HashMap<String, String> getEntryMap() {
        return entryMap;
    }

    public void addEntry(String key, String value){
        if(entryMap.containsKey(key)){
            String oldValue = entryMap.replace(key,value);
            lruList.remove(new Pair<>(key,oldValue));
            lruList.addFirst(key);
            return;
        }
        if(maxEntryCount == lruList.size()){
            String removed = lruList.removeLast();
            entryMap.remove(removed);
        }
        entryMap.put(key,value);
        lruList.addFirst(key);
    }

    public void setMaxEntryCount(int count){
        if(count < this.maxEntryCount){
            while(lruList.size() > count){
                String removed = lruList.removeLast();
                instanceMap.remove(removed);
            }
        }
        this.maxEntryCount = count;
    }

    public String getEntryOrNull(String key){return null;}
//
//    public void setEvictionPolicy(EvictionPolicy policy){}

}
