package hspedu.TCPServe;

/**
 * @author LZ
 */
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            int count=0;
            ServerSocket serverSocket=new ServerSocket(60114);
            System.out.println("服务器启动");
            Socket socket=null;
            while(true) {
                socket=serverSocket.accept();
                ServerThread serverThread=new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("客户端的数量是："+count);

                InetAddress address=socket.getInetAddress();
                System.out.println("当前客户的ip地址是："+address);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

