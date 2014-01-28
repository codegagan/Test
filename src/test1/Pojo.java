package test1;

/**
 * Created with IntelliJ IDEA.
 * User: gagandeep
 * Date: 1/28/14
 * Time: 5:25 PM
 * To change this template use File | Settings | File Templates.
 */

public class Pojo {
    public String show(int input) {
        String output = (input * 10) + " " + Thread.currentThread().getName();
        return output;
    }
}
