import java.awt.*;
import javax.swing.*;

public class CircleRandom extends JFrame {
	
	private MyPanel panel = new MyPanel();
	
	public CircleRandom() {
		setTitle("원을 랜덤한 위치 이동");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);

		TimerThread tt = new TimerThread(panel); // Thread 객체를 만든다.
		
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
		g.drawOval(10, 10, 50, 50); // 초기 위치는 (10,10), 지름이 50인 원이므로 전체 크기는 50x50
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
			int y = (int) (Math.random()*400+50); // x와 y 랜덤으로 값을 받는다.
			
			panel.setBounds(x, y, panel.getWidth(), panel.getHeight());
			panel.getParent().repaint();
			// 위치를 변경시킨 후 다시 그려지게 하는 코드
		}
	}
}

