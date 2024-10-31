package com.kumar.lrucache;

public class LRUCacheImpl extends LRUCache<Integer, String>{
    private static final String  EMPTY = "";

    public LRUCacheImpl(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    public String get(Integer key) {
        String value = cache.getOrDefault(Integer.valueOf(key), "");
        if (EMPTY.equals(value)) {
            // move the element to top
            availableCache.remove(Integer.valueOf(key));
            availableCache.add(Integer.valueOf(key));
        }
        return value;
    }

    @Override
    public void put(Integer key, String value) {
        if(EMPTY.equals(cache.getOrDefault(key, EMPTY))) {
            if(isCacheFull()) {
                evictLeastRecentlyElementFromCache();
            }
            cache.put(key, value);
            availableCache.add(key);
        } else {
            // delete specific key and from cache
            evictLeastRecentlyElementFromCache(key);
            cache.put(key, value);
            availableCache.add(key);        }
    }

    public static void main(String[] args) {
        final LRUCacheImpl cache =  new LRUCacheImpl(2);
        cache.put(1, "ONE");
        cache.put(2, "TWO");
        System.out.println("GET RESPONSE for 1 : " + cache.get(1));
        cache.put(3, "THREE");
        cache.put(4, "FOUR");
        System.out.println("GET RESPONSE for 1 : " + cache.get(1));
        System.out.println("GET RESPONSE for 3 : " + cache.get(3));
        System.out.println("GET RESPONSE for 4 : " + cache.get(4));
    }
}
