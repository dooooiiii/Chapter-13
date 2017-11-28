import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 
import java.util.Timer; 
import javax.swing.*; 
public class bubble extends JFrame 
{ 
	int bubbleRadius = 5;//������ ������ 
	ArrayList<Point> bubblePosition = new  ArrayList<Point>();//������ ������ ����Ʈ 
	public bubble() {// TODO Auto-generated constructor stub 
		setVisible(true); 
		setSize(500,500); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		Timer timer = new Timer();//Ÿ�̸� ���� 
		timer.schedule(new TimerTask()
		{    
			@Override 
			public void run() { // TODO Auto-generated method stub 
				//����Ʈ�� ����ִ� ������ ������ 
				for(int i=0;i < bubblePosition.size();i++) 
				{ 
					bubblePosition.get(i).y -= 5;//���� �̵� 
					if(bubblePosition.get(i).y < 0)//���� �� �ö󰬴ٸ� 
					{ 
						bubblePosition.remove(i);//����Ʈ���� ����       
					} 
				}     
				repaint();//ȭ�� ���� 
			} 
		}, 0, 20); 
		//���콺 ������ �߰� 
		addMouseListener(new MouseAdapter() 
		{ 
			@Override 
			public void mousePressed(MouseEvent e) 
			{// TODO Auto-generated method stub 
				bubblePosition.add(e.getPoint());//���콺�� ����� ������ġ�� ����Ʈ�� ���� 
			} 
		}); 
} 
	@Override 
	public void paint(Graphics g) 
	{// TODO Auto-generated method stub   
		//����� ���� 
		Image img = createImage(getWidth(), getHeight()); 
		Graphics bg = img.getGraphics();//����� ������ ���� 
		for(int i=0;i < bubblePosition.size();i++) 
		{//������ ��ġ ������ 
			int x = bubblePosition.get(i).x; 
			int y = bubblePosition.get(i).y; 
			bg.drawOval(x-bubbleRadius, y-bubbleRadius, bubbleRadius+bubbleRadius, bubbleRadius+bubbleRadius); 
		} 
		//�� ���۸� ���̰� ��� 
		g.drawImage(img, 0, 0, this); 
	} 
	@Override 
	public void update(Graphics g) 
	{ 
		// TODO Auto-generated method stub 
		paint(g); 
	} 
	static public void main(String str[]) 
	{ 
		new bubble(); 
	} 
} 

