import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)  { // catches input-output exceptions

        try (ServerSocket server = new ServerSocket(8000)) // server waiting on 8000 port
        {
            System.out.println("[server]: started!");

            while (true) {
                try (
                Socket socket = server.accept(); // conncection
    //            System.out.println("[server]: client connected!");

                BufferedWriter writer = // writer
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream()));

                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()));

                ) {
                    String request = reader.readLine();
                    System.out.println("REQUEST: " + request);
                    String response = "Hello, new client from " + request + " with the temperature: " + (int)Math.random();
                    System.out.println("RESPONSE: " + response);
                    writer.write(response);
                    writer.newLine();
                    writer.flush(); // send data before closing writer

                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
