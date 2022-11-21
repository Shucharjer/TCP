package Client;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientOutThread extends Thread {
    private Socket socket;
    public ClientOutThread(Socket socket) { this.socket = socket; }
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String text;
            while (true) {
                text = scanner.nextLine();
                dataOutputStream.write(text.getBytes());
                dataOutputStream.flush();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
