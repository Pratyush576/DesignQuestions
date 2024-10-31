package com.kumar.lrucache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class LRUCache<K, V> {
    final LinkedList<K> availableCache = new LinkedList<K>();
    final Map<K, V> cache = new HashMap();
    final int maxCapacity;

    protected LRUCache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    
    public abstract V get(K key);
    public abstract void put(K key, V value);

    protected boolean isCacheFull() {
        return availableCache.size() >= maxCapacity ? true : false;
    }

    protected void evictLeastRecentlyElementFromCache() {
        K key = availableCache.removeFirst();
        cache.remove(key);
    }

    protected void evictLeastRecentlyElementFromCache(K key) {
        availableCache.remove(key);
        cache.remove(key);
    }
}
