
import java.io.IOException;
import java.io.*;
import java.net.Socket;


public class TCPClient {

    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("172.21.48.133",20002);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);

            outToServer.println("20777");
            outToServer.println("192.168.55.113");


            String line;
            while ((line = inFromServer.readLine()) != null) {
                System.out.println(line);
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

