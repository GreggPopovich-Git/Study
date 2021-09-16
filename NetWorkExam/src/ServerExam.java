
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(8888);
			socket = serverSocket.accept();
			System.out.println("연결대기중입니다...");
			Thread thread1 = new SendMsg(socket);
			Thread thread2 = new ReceiveMsg(socket);
			
			thread1.start();
			thread2.start();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//socket.close();
				serverSocket.close();
			}catch(Exception e) {}
		}
	}
}