package threads;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: gagandeep
 * Date: 1/25/14
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Initiate {
    public static void main(String ... args)throws Exception{
        Queue q= new PriorityQueue();
        Thread producer=new Thread(new Producer(q));
        Thread consumer=new Thread(new Consumer(q));
        System.out.println("Starting Process");
        Thread.sleep(1000);

        consumer.start();
       System.out.println("Consumer Started");
        Thread.sleep(700);
        producer.start();
        System.out.println("Producer Started");
    }
}
