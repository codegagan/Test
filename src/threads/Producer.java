package threads;

import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: gagandeep
 * Date: 1/25/14
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Producer implements Runnable {
    final private Queue queue;
    int i = 0;
    final int limit;

    public Producer(Queue q, int maxSize) {
        queue = q;
        limit = maxSize;
    }

    public void run() {
        while (true) {
            String item = getNextItem();
            System.out.println("Producing Item: " + item);
            synchronized (queue) {
                if (i >= limit) {
                    System.out.println("Limit Reached for Producer, Going to wait for item to be consumed");
                    i = 0;
                    try {
                        queue.wait();
                    } catch (Exception e) {
                        System.out.println("Wait Exception in Producer");
                    }
                }
                queue.offer(item);
                queue.notify();
            }
            Thread.yield();
        }
    }

    private String getNextItem() {
        i++;
        try {
            //Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("Thread sleep Exception while producing Item: " + i);
        }
        return "Item" + i;
    }

}
