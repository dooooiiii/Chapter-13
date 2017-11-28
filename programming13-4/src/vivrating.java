import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;

public class vivrating extends Thread{
	
	JLabel label;
	MyFrame frame;
	
	public vivrating(MyFrame frame, JLabel label) {
		this.label = label;
		this.frame = frame;
	}

	@Override
	public void run() {
		int posX, posY; // 레이블의 위치를 받는 posX, posY
		int x,y = 0; // 레이블의 바꿀 위치 값을 저장할 변수 x,y
		
		posX = label.getX();
		posY = label.getY();
		
		boolean key = true;   // 어느 위치에 있을 지 결정해주는 key
	
		while (true) {
			
			if(key) {
				x = posX + 5; y = posY;
				key = false;
			} else {
				x = posX; y = posY + 5;
				key = true;
			}
			
			label.setLocation(x, y);
			frame.add(label);
			
			try {
				sleep (100);				
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}
class MyFrame extends JFrame {
	
	public MyFrame() {
		setTitle("진동하는 레이블 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = getContentPane();
		
		container.setLayout(null);
		
		JLabel label = new JLabel("진동 레이블"); // "진동레이블"이라는 문자열을 가진 Label 생성
		label.setLocation(100, 100);
		label.setSize(100,20);
		
		container.add(label);	
		
		vivrating mlt = new vivrating(this, label); // Thread 객체 생성
		setSize(500,500);
		setVisible(true);
		mlt.start();
	}
}
