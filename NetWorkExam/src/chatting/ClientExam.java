package chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientExam {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scn = new Scanner(System.in);
		try {
			socket = new Socket("192.168.0.45", 8095); // 채팅서버
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				System.out.print("서버로 문자 보내기 >> ");
				String outMsg = scn.nextLine();
				if (outMsg.equals("bye")) {
					out.write(outMsg + "\n");
					out.flush();
					break;
				}
				out.write(outMsg + "\n");
				out.flush();
				String inMsg = in.readLine();
				System.out.println("서버로부터 받은 메세지 : " + inMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				scn.close();
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
