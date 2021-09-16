package multichatting;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try{
			serverSocket = new ServerSocket(8090);
			while(true){
				Socket socket = serverSocket.accept();
				System.out.println("서버오픈...");
				Thread thread = new PerClientThread(socket);
				thread.start();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			try {
				serverSocket.close();
			}catch(Exception ee) {}
		}
	}

}
