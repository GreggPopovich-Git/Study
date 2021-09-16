
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveMsg extends Thread{
	Socket socket;
	public ReceiveMsg(Socket socket) {
		this.socket=socket;
	}
	BufferedReader reader = null;
	@Override
	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				
				String msg = reader.readLine();
				if(msg.equals("bye")) {
					System.out.println("연결종료");
					break;
				}
				System.out.println(msg);
			}
		
		}catch(Exception e) {
			e.getStackTrace();
			//e.printStackTrace();
		}finally {
			try {
				reader.close();
				socket.close();
			}catch(Exception ee) {ee.printStackTrace();}
		}
	}
}
