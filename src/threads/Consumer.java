package threads;

import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: gagandeep
 * Date: 1/25/14
 * Time: 8:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Consumer implements Runnable {
    Queue queue=null;
    public Consumer(Queue q){
        queue=q;
    }
    public void run(){
        String item=null;
        while(true){
            synchronized (queue){
                if(queue.isEmpty()){
                    try{
                        System.out.println("Queue Empty, Going to wait for item to be produced");
                    queue.wait();
                    }catch(Exception e){
                        System.out.println("Wait Exception in Consumer");
                    }
                }
                item=(String)queue.poll();
            }
            consumeItem(item);
            Thread.yield();
        }
    }

    private void consumeItem(String item){
        System.out.println("Consuming Item: "+item);
        try{
        //Thread.sleep(700);
        }catch (Exception e){
            System.out.println("Sleep Exception while Consuming Item: "+item);
        }
    }

}
