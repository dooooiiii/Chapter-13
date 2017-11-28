import java.awt.*;
import javax.swing.*;

public class CircleRandom extends JFrame {
	
	private MyPanel panel = new MyPanel();
	
	public CircleRandom() {
		setTitle("���� ������ ��ġ �̵�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);

		TimerThread tt = new TimerThread(panel); // Thread ��ü�� �����.
		
		setSize(800,500);
		setVisible(true);
		
		tt.start();
	}
	public static void main(String args[]) {
		new CircleRandom();
	}
	
}
class MyPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.magenta);
		g.drawOval(10, 10, 50, 50); // �ʱ� ��ġ�� (10,10), ������ 50�� ���̹Ƿ� ��ü ũ��� 50x50
	}
}
class TimerThread extends Thread{
	private MyPanel panel;
	public TimerThread(MyPanel panel) {
		this.panel = panel;
	}
	@Override
	public void run() {
		while (true) {
			System.out.println("x : " + panel.getX() + ", y : " + panel.getY());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
			
			int x = (int) (Math.random()*700+50);
			int y = (int) (Math.random()*400+50); // x�� y �������� ���� �޴´�.
			
			panel.setBounds(x, y, panel.getWidth(), panel.getHeight());
			panel.getParent().repaint();
			// ��ġ�� �����Ų �� �ٽ� �׷����� �ϴ� �ڵ�
		}
	}
}

