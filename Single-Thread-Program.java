import java.util.*;
import  java.io.*;
import java.util.concurrent.TimeUnit;

class Solution {
    public static List<String> topKFrequent(int k) {
        //List<String>words = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        try
        {

            File myObj = new File("D:\\dataset-8GB.txt");

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data = data.trim();

             //   System.out.println(data);
               // String [] tempList = data.split(" ");
                String [] tempList = data.split("\\s+");

                for(String word : tempList){
                    word.replaceAll("[^a-zA-Z]+","");
                    if (!word.isBlank())
                    {
                        map.put(word,map.getOrDefault(word,0)+1);
                    }
                  //  System.out.println(newWord);

                }

            }
        } catch (Exception e) {
            System.out.println("error opening file");
            e.printStackTrace();
        }



        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1,w2) -> map.get(w1).equals(map.get(w2)) ?
                        w2.compareTo(w1) : map.get(w1) - map.get(w2));

        for(String word : map.keySet()){
            heap.offer(word);
            if(heap.size() > k)
                heap.poll();
        }
        List<String>res = new ArrayList<>();

        while(!heap.isEmpty()){
            res.add(heap.poll());
        }

        Collections.reverse(res);
        return res;

    }

    public static void main(String[] args) {

        Long startTime = System.nanoTime();


        List<String>res = topKFrequent(3);
        System.out.println(res);
        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");

//
    }
}