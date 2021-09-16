package multichatting;

import java.net.Socket;

public class ClientExam {

	public static void main(String[] args) {
		Socket socket = null;
		try{
			socket = new Socket("192.168.0.18", 8090);
			Thread thread1 = new SenderThread(socket,"아라가키유이");
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}


	}

}
