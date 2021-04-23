package farm;

import java.util.Scanner;

import console.ClearConsole;
import town.Map;
import gamestory.EndStory;
import gamestory.StartStory;

public class Farm{
	private static String FarmName;
	static int year = 1;
	static String season = "��";
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
			System.out.print("���� �̸��� �Է��ϼ���: ");
			userPress = scanner.nextLine();
			if(userPress.equals(""))
				userPress = scanner.nextLine();
			System.out.print(userPress + " �������� �ұ��?(y/n)>");
			userPress2 = scanner.next();
		}
		
		ClearConsole.clearConsole();
		System.out.println();

	}
	
	public void myFarm() {
		/*** ��ü ���� ***/
		Map map = new Map();
		AboutUser aboutUser = new AboutUser();
		Sleep sleep = new Sleep();
		StartStory startStory = new StartStory();
		Inventory inventory = new Inventory();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("============================================================");
		System.out.println("***" + FarmName + " ���� ***");
		System.out.println("---" + year + "���� " + season + "�� " + day + "��°" + "---");
		
		if((Postbox.getPostCount() == 1) && (season.equals("��")) && (day == 1)) {
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
		System.out.println("		" + "�� " + FarmName +" ���� " + year + "��° " + season+ "�� " + day +"��° ��" + "		");
		System.out.println("		" + "���� ��ħ�̿���. ������ ������ �ұ��?" + "		");
		System.out.println("		" + "1. ������ ������" + "		");
		System.out.println("		" + "2. �κ��丮 Ȯ��" + "		");
		System.out.println("		" + "3. �� ���� ����" + "		");
		if(Postbox.hasPost()) {
			System.out.println("		" + "4. ������ Ȯ���ϱ�(New)" + "		");
		}
		else
			System.out.println("		" + "4. ������ Ȯ���ϱ�" + "		");
		if(Field.hasNew())
			System.out.println("		" + "5. ���۹� �����ϱ�(New)" + "		");
		else
			System.out.println("		" + "5. ���۹� �����ϱ�" + "		");
		System.out.println("		" + "6. ���ڱ�(Zzz)" + "		");
		System.out.println("		" + "7. ���� ����" + "		");
		System.out.println("		" + "0. ����� ���ư���(����)" + "		");
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
				System.out.println("������ �����մϴ�.");
				return;
			default: 
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���.");
			}
		}
		}
	}
	
}
