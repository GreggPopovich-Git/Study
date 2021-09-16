
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
//�޽����� �۽��ϴ� ������
public class SendMsg extends Thread{
	Socket socket;
	public SendMsg(Socket socket){
		this.socket=socket;
	}
	BufferedWriter out = null;
	Scanner scn = null;
	@Override
	public void run() {
		try {
			scn = new Scanner(System.in);
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//PrintWriter writer = new PrintWriter(socket.getOutputStream());
			while(true) {
				System.out.print("메세지 > ");
				String msg = scn.nextLine();
				if(msg.equalsIgnoreCase("bye")) {
					out.write("길영마왕 : "+msg+"\n");
					out.flush();
					break;
				}
				out.write(msg+"\n");
				//writer.println(msg);
				out.flush();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			}catch(Exception e) {}
		}
	}
}
