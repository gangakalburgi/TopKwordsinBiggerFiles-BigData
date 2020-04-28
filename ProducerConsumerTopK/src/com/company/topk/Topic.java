package com.company.topk;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.*;

public class Topic {
    private static BlockingQueue<String> queue = new LinkedBlockingQueue<>();


    public static void add(String s) {
     //   System.out.println("string adding to queue:" + s);

        queue.add(s);
      //  System.out.println("queue size is: " + queue.size());
    }

    public static String consume() throws InterruptedException {

        return queue.poll(1000,TimeUnit.MILLISECONDS);
    }

    public static boolean isEmpty() {
       return queue.isEmpty();
    }
}
