
import java.net.Socket;

public class ClientExam {
	//private static Socket socket = null;
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("192.168.0.22", 8090);
			Thread thread1 = new SendMsg(socket);
			Thread thread2 = new ReceiveMsg(socket);
			thread1.start();
			thread2.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
