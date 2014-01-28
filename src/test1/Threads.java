package test1;

/**
 * Created with IntelliJ IDEA.
 * User: gagandeep
 * Date: 1/28/14
 * Time: 5:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Threads extends Thread {
    Pojo pojo;

    public Threads(Pojo p) {
        pojo = p;
    }

    public void run() {
        for (int i = 0; i < 99999; i++) {
            System.out.println(pojo.show(i));
        }
    }
}
