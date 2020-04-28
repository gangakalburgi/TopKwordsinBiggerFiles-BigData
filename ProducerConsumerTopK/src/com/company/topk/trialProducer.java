package com.company.topk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class trialProducer {
    public static void main(String[] args) {
        Producer1 producer1 = new Producer1();
        producer1.start();


    }
}

class Producer1 extends Thread {
    public static boolean producerIsDone = false;

    public void run() {
        try {
            System.out.println("Current thread name: " + Thread.currentThread().getName());

            System.out.println("reading 400mb file");
            File myObj = new File("D:\\dataset-400MB.txt");

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println("Extracted Line : " + line);
                Topic.add(line);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        producerIsDone = true;
        System.out.println(Thread.currentThread().getName() + " producer is done");
    }
}
