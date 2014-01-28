package test1;

/**
 * Created with IntelliJ IDEA.
 * User: gagandeep
 * Date: 1/28/14
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class RunThreads {
    public static void main(String... args) {
        Pojo pojo = new Pojo();
        for (int i = 0; i < 999; i++) {
            new Threads(pojo).start();
        }
    }
}
