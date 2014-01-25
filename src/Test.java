import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test{
    public static void main(String ... args){
        try {
            Socket socket = new Socket("192.168.1.3",8088);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Thread.sleep(2000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("Hi i am Client1\n");
            out.flush();
            System.out.println("Client calling");
            System.out.println(in.readLine());
            System.out.println("Read");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}