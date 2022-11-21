package Client;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientInThread extends Thread{
    private Socket socket = null;
    public ClientInThread(Socket socket) {
        this.socket = socket;
    }
    public void run()
    {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            byte[] data = new byte[1024];
            int length;
            while ((length = dataInputStream.read(data)) != -1) {
                System.out.println(new String(data, 0, length));
            }
            dataInputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}