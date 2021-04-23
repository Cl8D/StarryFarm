package town;

import java.util.Scanner;

import console.ClearConsole;

interface specialPlace{
	void printPlace();
	void active();
	default public void goTown() {
		System.out.println("		��, �������. ������ ���ư����� �ؿ�.");
	}
}

public class Map {
	/*** ��ü ���� ***/
	Mart mart = new Mart();
	Lake lake = new Lake();
	Cave cave = new Cave();
	
	public void printMap() {
		while(true) {
		ClearConsole.clearConsole();
		System.out.println("==============================================================");
		System.out.println("		������ ���Խ��ϴ�.		");
		System.out.println("		*���� �̵��ұ��?(1~4)*		");
		System.out.println("		��1. ������ ���ư���		");
		System.out.println("		��2. ��ȭ�� ����		");
		System.out.println("		��3. ȣ���� ����		");
		System.out.println("		��4. ���� ����		");
		System.out.println("==============================================================");
		Scanner scanner = new Scanner(System.in);
			System.out.print("(1~4)>>");
			int userPress = 0;
			userPress = scanner.nextInt();
			switch(userPress) {
			case 1 :
				return;
			case 2 :
				mart.showMart();
				break;
			case 3 :
				lake.printPlace();
				break;
			case 4 :
				cave.printPlace();
				break;
			default: 
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���.");
		}	
		}
	}
}
