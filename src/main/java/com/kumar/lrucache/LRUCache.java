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
    
    /**
     * Get function returns the value stored against the key(if present in the cache).
     * If element is not present in the cache, it returns -1.
     * 
     * @param key cache key
     * @return value stored against the key
     */
    public abstract V get(K key);
    public abstract void put(K key, V value);

    /**
     * Checks if cache is full.
     * @return
     */
    protected boolean isCacheFull() {
        return availableCache.size() >= maxCapacity ? true : false;
    }

    /**
     * Evicts the least recently used element.
     */
    protected void evictLeastRecentlyElementFromCache() {
        K key = availableCache.removeFirst();
        cache.remove(key);
    }

    /**
     * Evects the input element
     * @param key
     */
    protected void evictLeastRecentlyElementFromCache(K key) {
        availableCache.remove(key);
        cache.remove(key);
    }
}
