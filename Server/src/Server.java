import Connection.Phone;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)  { // catches input-output exceptions

        try (ServerSocket server = new ServerSocket(8000)) // server waiting on 8000 port
        {
            System.out.println("[server]: started!");

            while (true) {
                try (Phone phone = new Phone (server)) {
                    String request = phone.readLine();
//                    System.out.println("[dbg]: REQUEST: " + request);
                    String response = "Hello, new client from " + request + " with the temperature: " + (int)Math.random();
//                    System.out.println("[dbg]: RESPONSE: " + response);
                    phone.writeLine(response);

            } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
