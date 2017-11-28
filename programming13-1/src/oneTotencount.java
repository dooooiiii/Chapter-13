import java.util.Scanner;

public class oneTotencount {

	static public void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("아무 키나 입력>> ");
		scanner.nextLine(); // 아무 키나 입력
		scanner.close();
		
		Thread thread = new Thread(new CountingThread());	
		thread.start();
		
		//  main()은 종료하지만, 스레드 thread는 살아 있음
	}
}

class CountingThread implements Runnable {
	@Override
	public void run() {
		System.out.println("스레드 실행 시작");
		for(int i=1; i<=10; i++)      //1부터 10까지 카운트
			System.out.print(i + " ");
		System.out.println();
		System.out.println("스레드 종료");
	}
}
