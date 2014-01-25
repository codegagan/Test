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
    private Queue queue = null;
    int i = 0;

    public Producer(Queue q) {
        queue = q;
    }

    public void run() {
        while (true) {
            String item = getNextItem();
            System.out.println("Producing Item: " + item);
            synchronized (queue) {
                queue.offer(item);
                queue.notify();
            }
            Thread.yield();
        }
    }

    private String getNextItem() {
        i++;
        try {
            //Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Thread sleep Exception while producing Item: " + i);
        }
        return "Item" + i;
    }

}
