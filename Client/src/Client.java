import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (

            Socket socket = new Socket("127.0.0.1", 8000);

            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream()));

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));
        ) {
            System.out.println("[client]: connected to server");

//            Scanner in = new Scanner(System.in);
//            System.out.println("Input the city:");
            String request = "Moscow";
            writer.write(request);
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println("[client]: Request: " + request);
            System.out.println("[client]: Response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
