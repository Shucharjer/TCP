package Client;

import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Try to connect...");
            Socket socket = new Socket("192.168.0.124", 60114);
            //The host ip n local ip r static(
            ClientInThread clientInThread = new ClientInThread(socket);
            ClientOutThread clientOutThread = new ClientOutThread(socket);
            clientInThread.start();
            clientOutThread.start();
            System.out.println("Connected!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}