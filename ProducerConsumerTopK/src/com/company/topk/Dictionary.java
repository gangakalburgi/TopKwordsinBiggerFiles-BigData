package com.company.topk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Dictionary {
    public static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public static List<String> topKwords(int k) {
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                        w2.compareTo(w1) : map.get(w1) - map.get(w2));


        for (String word : map.keySet())
        {
            heap.offer(word);
            if (heap.size() > k)
                heap.poll();
        }

        List<String> res = new ArrayList<>();

        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }

        Collections.reverse(res);
        return res;

    }
}
