import java.util.Scanner;

public class oneTotencount {

	static public void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ƹ� Ű�� �Է�>> ");
		scanner.nextLine(); // �ƹ� Ű�� �Է�
		scanner.close();
		
		Thread thread = new Thread(new CountingThread());	
		thread.start();
		
		//  main()�� ����������, ������ thread�� ��� ����
	}
}

class CountingThread implements Runnable {
	@Override
	public void run() {
		System.out.println("������ ���� ����");
		for(int i=1; i<=10; i++)      //1���� 10���� ī��Ʈ
			System.out.print(i + " ");
		System.out.println();
		System.out.println("������ ����");
	}
}
