package com.dezhi.leetcode.lru;

import java.util.LinkedHashMap;
import java.util.Map;

// 参考MyBatis LRU缓存实现
public class LRUCache {

    Map<Integer, Integer> keyMap;

    public LRUCache(int capacity) {
        keyMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        Integer val = keyMap.get(key);
        return val == null ? -1 : val;
    }

    public void put(int key, int value) {
        keyMap.put(key, value);
    }

    public static void main(String[] args) {

    }
}
