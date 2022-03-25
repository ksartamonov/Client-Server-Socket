import Connection.Phone;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Phone phone = new Phone("127.0.0.1", 8000)) {

            System.out.println("[client]: connected to server");

//            Scanner in = new Scanner(System.in);
//            System.out.println("Input the city:");
            String request = "Moscow";
            phone.writeLine(request);
            String response = phone.readLine();

//            System.out.println("[dbg]: Request: " + request);
//            System.out.println("[dbg]: Response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
