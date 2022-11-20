package hspedu.TCPServe;

/**
 * @author LZ
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class ServerThread extends Thread {
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    // 执行线程的操作
    public void run() {

        File file2 = new File("D:\\Procedure\\javacode\\com\\src\\hspedu\\TCPServe\\TCP.png");
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file2));
            // DataOutputStream dos1 = new DataOutputStream(socket.getOutputStream());
            byte[] buf = new byte[1024 * 9];
            int len = 0;

            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("你好帅");

            while ((len = dis.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));

            }
            pw.flush();
            pw.close();
            dos.flush();
            System.out.println("文件接受结束，，，，");
            dis.close();
            dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}


