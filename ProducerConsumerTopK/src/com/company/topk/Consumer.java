package com.company.topk;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable {
    public static boolean producerFinished = false;

   @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " consumer is starting");
            while (!producerFinished || !Topic.isEmpty()) {

                String line = Topic.consume();
               // System.out.println("line polled from queue: " + line);
                if (line != null) {
                   // System.out.println("line is" + line);
                    processLine(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " consumer is done");
    }

    private void processLine(String line) {

        // hashmap logic
        String[] words = line.trim().split("\\s+");
        for (String w : words) {
            w.replaceAll("[^a-zA-Z]+", "");
            if (!w.isBlank()) {
                Dictionary.map.put(w, Dictionary.map.getOrDefault(w, 0) + 1);

            }
        }
    }
}
