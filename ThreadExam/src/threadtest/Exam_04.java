package threadtest;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerThread  extends Thread {
	private JLabel label;

	TimerThread(JLabel label) {
		this.label = label;
	}

	public void run() {
		int n = 0;
		while(true) {
			label.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000); // 1초
			}catch(Exception e) {}
		}
	}
}

public class Exam_04 extends JFrame { // 윈도우 화면 상속
	public Exam_04() {
		setTitle("타이머 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel label = new JLabel();
		label.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(label);
		TimerThread th = new TimerThread(label);
		setSize(400, 400);
		setVisible(true);
		th.start();
	}
	public static void main(String[] args) {
		new Exam_04();
		
	}

}