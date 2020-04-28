package com.company.topk;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer extends Thread {

    public void run() {
        try {

            System.out.println(Thread.currentThread().getName() + "producer is starting");

            System.out.println("opening the file to read");
           File myObj = new File("D:\\dataset-8GB.txt");


            Scanner myReader = new Scanner(myObj);



            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!data.isEmpty())
                {
                    //System.out.println("data read from file is" + data);
                    Topic.add(data);
                }


            }




            Consumer.producerFinished = true;

        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " Producer is done");
    }

    }

