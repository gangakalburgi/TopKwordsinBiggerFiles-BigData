package com.company.topk;

import java.util.List;
import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        Long startTime = System.nanoTime();

        Producer producer = new Producer();
        producer.start();


        int maxThread = 10;//thread pool size
        ExecutorService consumerThreads = Executors.newFixedThreadPool(maxThread);
        for (int i = 0; i < maxThread; i++) {
                consumerThreads.submit(new Consumer());
        }


        consumerThreads.shutdown();


        while (!consumerThreads.isTerminated() )
        {

        }

       System.out.println("Finished all threads");

      List<String> res = Dictionary.topKwords(3);
      System.out.println("The top k words are : " + res);

        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
    }
}
