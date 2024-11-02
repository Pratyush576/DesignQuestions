package com.kumar.lrucache;

import main.java.com.kumar.lrucache.LRUCacheImpl;

public class LRUCacheTest {
    public static void main(String[] args) {
        final LRUCacheImpl cache =  new LRUCacheImpl(2);
        cache.put(1, "ONE");
        cache.put(2, "TWO");
        System.out.println(cache.get(1));
        cache.put(3, "THREE");
        cache.put(4, "FOUR");
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
