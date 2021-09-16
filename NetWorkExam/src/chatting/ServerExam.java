package chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExam {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket server = null;
		Socket socket = null;
		Scanner scn = new Scanner(System.in);
		try {
			server = new ServerSocket(8099);
			System.out.println("연결대기중입니다.");
			socket = server.accept();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				String inMsg = in.readLine();
				if(inMsg.equals("bye")) {
					System.out.println("연결종료");
					break;
				}
				System.out.println("받은문자 : " + inMsg);
				System.out.print("클라이언트로 문자보내기 >> ");
				String outMsg = scn.nextLine();
				out.write(outMsg + "\n");
				out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				scn.close();
				socket.close();
				server.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
