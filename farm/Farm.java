package farm;

import java.util.Scanner;

import console.ClearConsole;
import town.Map;
import gamestory.EndStory;
import gamestory.StartStory;

public class Farm{
	private static String FarmName;
	static int year = 1;
	static String season = "봄";
	static int day = 1;
	
	public static int getYear() {
		return year;
	}
	
	public static void setYear(int year) {
		Farm.year = year;
	}
	
	public static int getDay() {
		return day;
	}
	
	public static void setDay(int day) {
		Farm.day = day;
	}
	
	public static String getSeason() {
		return season;
	}
	
	public static void setSeason(String season) {
		Farm.season = season;
	}
	
	public void setFarmName() {
		Scanner scanner = new Scanner(System.in);
		String userPress = "";
		String userPress2 = "";
		ClearConsole.clearConsole();
		System.out.println("==============================================================");
		while(true) {
			if(userPress2.equals("y")) {
				FarmName = userPress;
				break;
			}
			System.out.print("농장 이름을 입력하세요: ");
			userPress = scanner.nextLine();
			if(userPress.equals(""))
				userPress = scanner.nextLine();
			System.out.print(userPress + " 농장으로 할까요?(y/n)>");
			userPress2 = scanner.next();
		}
		
		ClearConsole.clearConsole();
		System.out.println();

	}
	
	public void myFarm() {
		/*** 객체 생성 ***/
		Map map = new Map();
		AboutUser aboutUser = new AboutUser();
		Sleep sleep = new Sleep();
		StartStory startStory = new StartStory();
		Inventory inventory = new Inventory();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("============================================================");
		System.out.println("***" + FarmName + " 농장 ***");
		System.out.println("---" + year + "년차 " + season + "의 " + day + "일째" + "---");
		
		if((Postbox.getPostCount() == 1) && (season.equals("봄")) && (day == 1)) {
			startStory.firstLetter();
			System.out.println("============================================================");
			System.out.println();
		}
		
		
		while(true) {
		System.out.println("**Press k + enter**");
		String userPress = "";
		userPress = scanner.next();
		
		if(userPress.equals("k")) {
		ClearConsole.clearConsole();
		System.out.println("============================================================");
		System.out.println("		" + "♥ " + FarmName +" 농장 " + year + "년째 " + season+ "의 " + day +"일째 ♥" + "		");
		System.out.println("		" + "좋은 아침이에요. 오늘은 무엇을 할까요?" + "		");
		System.out.println("		" + "1. 마을로 나가기" + "		");
		System.out.println("		" + "2. 인벤토리 확인" + "		");
		System.out.println("		" + "3. 내 정보 보기" + "		");
		if(Postbox.hasPost()) {
			System.out.println("		" + "4. 우편함 확인하기(New)" + "		");
		}
		else
			System.out.println("		" + "4. 우편함 확인하기" + "		");
		if(Field.hasNew())
			System.out.println("		" + "5. 농작물 관리하기(New)" + "		");
		else
			System.out.println("		" + "5. 농작물 관리하기" + "		");
		System.out.println("		" + "6. 잠자기(Zzz)" + "		");
		System.out.println("		" + "7. 게임 종료" + "		");
		System.out.println("		" + "0. 서울로 돌아가기(엔딩)" + "		");
		System.out.println("============================================================");
		
			System.out.print("(0~7)>>");
			int userPress2 = 0;
			userPress2 = scanner.nextInt();
			switch(userPress2) {
			case 0:
				EndStory.Ending();
			case 1 :
				map.printMap();
				break;
			case 2 :
				inventory.showInventory();
				break;
			case 3 :
				aboutUser.printUser();
				break;
			case 4 :
				Postbox.openPost();
				break;
			case 5 :
				Field.manageMyField();
				break;
			case 6 :
				sleep.sleep();
				break;
			case 7:
				System.out.println("게임을 종료합니다.");
				return;
			default: 
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
			}
		}
		}
	}
	
}
