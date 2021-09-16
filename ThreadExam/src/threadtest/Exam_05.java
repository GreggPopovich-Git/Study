package threadtest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerSec  extends Thread {
	private JLabel label;

	TimerSec(JLabel label) {
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
class TimerMillSec  extends Thread {
	private JLabel label;

	TimerMillSec(JLabel label) {
		this.label = label;
	}

	public void run() {
		int n = 0;
		while(true) {
			label.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(100); // 0.1초
			}catch(Exception e) {}
		}
	}
}
public class Exam_05 extends JFrame { // 윈도우 화면 상속
	public Exam_05() {
		setTitle("타이머 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		//c.setLayout(new FlowLayout());
		JLabel label1 = new JLabel();
		label1.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		JLabel label2 = new JLabel();
		label2.setFont(new Font("Gothic", Font.ITALIC, 50));
		
		c.add(BorderLayout.NORTH, label1);
		c.add(BorderLayout.SOUTH, label2);
		TimerSec th1 = new TimerSec(label1);
		TimerMillSec th2 = new TimerMillSec(label2);
		setSize(400, 400);
		setVisible(true);
		th1.start();
		th2.start();
	}
	public static void main(String[] args) {
		new Exam_05();
		
	}

}