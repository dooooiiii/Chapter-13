import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 
import java.util.Timer; 
import javax.swing.*; 
public class bubble extends JFrame 
{ 
	int bubbleRadius = 5;//버블의 반지름 
	ArrayList<Point> bubblePosition = new  ArrayList<Point>();//버블을 저장할 리스트 
	public bubble() {// TODO Auto-generated constructor stub 
		setVisible(true); 
		setSize(500,500); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		Timer timer = new Timer();//타이머 생성 
		timer.schedule(new TimerTask()
		{    
			@Override 
			public void run() { // TODO Auto-generated method stub 
				//리스트에 들어있는 버블을 움직임 
				for(int i=0;i < bubblePosition.size();i++) 
				{ 
					bubblePosition.get(i).y -= 5;//위로 이동 
					if(bubblePosition.get(i).y < 0)//위로 다 올라갔다면 
					{ 
						bubblePosition.remove(i);//리스트에서 삭제       
					} 
				}     
				repaint();//화면 갱신 
			} 
		}, 0, 20); 
		//마우스 리스너 추가 
		addMouseListener(new MouseAdapter() 
		{ 
			@Override 
			public void mousePressed(MouseEvent e) 
			{// TODO Auto-generated method stub 
				bubblePosition.add(e.getPoint());//마우스를 누루면 누룬위치를 리스트에 저장 
			} 
		}); 
} 
	@Override 
	public void paint(Graphics g) 
	{// TODO Auto-generated method stub   
		//백버퍼 생성 
		Image img = createImage(getWidth(), getHeight()); 
		Graphics bg = img.getGraphics();//백버퍼 조작을 위해 
		for(int i=0;i < bubblePosition.size();i++) 
		{//버블의 위치 얻어오기 
			int x = bubblePosition.get(i).x; 
			int y = bubblePosition.get(i).y; 
			bg.drawOval(x-bubbleRadius, y-bubbleRadius, bubbleRadius+bubbleRadius, bubbleRadius+bubbleRadius); 
		} 
		//백 버퍼를 보이게 출력 
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

