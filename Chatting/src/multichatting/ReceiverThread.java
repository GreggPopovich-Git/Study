package multichatting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiverThread extends Thread{
	Socket socket;
	public ReceiverThread(Socket socket){
		this.socket=socket;
	}

	public void run(){
		try{
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			while(true){
				String str = reader.readLine();
				if(str.equals("bye")) { 
				    System.out.println("�������");
					break;
				}
				System.out.println(str);
			}
		}catch(Exception e){
			//e.printStackTrace();
		}finally {
			try {
				socket.close();
			}catch(Exception ee) {}
		}
	}
}