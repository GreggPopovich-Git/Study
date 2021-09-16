package multichatting;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SenderThread extends Thread{
	Socket socket;
	String name;

	public SenderThread(Socket socket, String name){
		this.socket=socket;
		this.name=name;
	}

	public void run(){
		try{
			Scanner scn = new Scanner(System.in);
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println(name);
			writer.flush();
			while(true){
				String str = scn.nextLine();
				if(str.equals("bye")) {
					writer.println(str);
					writer.flush();
					break;
				}	
				writer.println(str);
				writer.flush();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				socket.close();
			}catch(Exception ee){}
		}
	}
}
