package town;

import java.util.Scanner;

import console.ClearConsole;

interface specialPlace{
	void printPlace();
	void active();
	default public void goTown() {
		System.out.println("		휴, 힘들었다. 마을로 돌아가도록 해요.");
	}
}

public class Map {
	/*** 객체 생성 ***/
	Mart mart = new Mart();
	Lake lake = new Lake();
	Cave cave = new Cave();
	
	public void printMap() {
		while(true) {
		ClearConsole.clearConsole();
		System.out.println("==============================================================");
		System.out.println("		마을로 나왔습니다.		");
		System.out.println("		*어디로 이동할까요?(1~4)*		");
		System.out.println("		▶1. 집으로 돌아가기		");
		System.out.println("		▶2. 잡화점 가기		");
		System.out.println("		▶3. 호숫가 가기		");
		System.out.println("		▶4. 동굴 가기		");
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
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
		}	
		}
	}
}
