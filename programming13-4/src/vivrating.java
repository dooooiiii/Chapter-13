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
		int posX, posY; // ���̺��� ��ġ�� �޴� posX, posY
		int x,y = 0; // ���̺��� �ٲ� ��ġ ���� ������ ���� x,y
		
		posX = label.getX();
		posY = label.getY();
		
		boolean key = true;   // ��� ��ġ�� ���� �� �������ִ� key
	
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
		setTitle("�����ϴ� ���̺� �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = getContentPane();
		
		container.setLayout(null);
		
		JLabel label = new JLabel("���� ���̺�"); // "�������̺�"�̶�� ���ڿ��� ���� Label ����
		label.setLocation(100, 100);
		label.setSize(100,20);
		
		container.add(label);	
		
		vivrating mlt = new vivrating(this, label); // Thread ��ü ����
		setSize(500,500);
		setVisible(true);
		mlt.start();
	}
}
