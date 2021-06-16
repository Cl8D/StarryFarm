package farm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import character.UserInfo;
import console.ClearConsole;
import console.ConsoleStop;
import town.Map;
import gamestory.StartStory;
import myNetwork.*;
public class Farm{

	private static String FarmName;
	static int year = 1;
	static String season = "��";
	static int day = 1;
	public static int first_count = 0;
	DataOutputStream out;
	DataInputStream in;
	Socket socket;

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
	
	public void setFarmName(String farmname, String season ,int year, int day) {
		Farm.FarmName = farmname;
		Farm.year = year;
		Farm.day = day;
		Farm.season = season;
		Postbox.setPostCount(0);
	}
	
	public void myFarm() {
		/*** ��ü ���� ***/
		this.socket = myClient.socket;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		if(first_count == 0) {
			try {  // ���߿� ���� ó�� ����κ� �� �κ� �ʿ���
				out.writeUTF("1"); // �����̶�� �˸�
			} catch (IOException e) {
				e.printStackTrace();
			}
			Runnable T1 = new SendToServer(season, year, day, FarmName);
			Thread saveInf = new Thread(T1); 
			saveInf.start();
			ConsoleStop.threadSleep(1000);
			System.out.println("���� ������ ����Ǿ����ϴ�.");
			System.out.println("");
			first_count++;
		}
		
		while(true) {
		
		ClearConsole.clearConsole();
		System.out.println("============================================================");
		System.out.println("		" + "�� " + FarmName +" ���� " + year + "��° " + season+ "�� " + day +"��° ��" + "		");
		System.out.println("		" + "���� ��ħ�̿���. ������ ������ �ұ��?" + "		");
		System.out.println("		" + "0. �����ϱ�" + "		");
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
		System.out.println("		" + "7. ä���ϱ�" + "		");
		System.out.println("		" + "8. �ٸ� ������ �ο��" + "		");
		System.out.println("		" + "9. �����ϰ� ���� ����" + "		");
		System.out.println("============================================================");
		
			System.out.print("(0~9)>>");
			String userPress2;
			userPress2 = scanner.nextLine();
			switch(userPress2) {
			case "0":
				aboutUser.savedUser(season, year, day, FarmName);
				ClearConsole.clearConsole();
				break;
			case "1" :
				map.printMap();
				break;
			case "2" :
				inventory.showInventory();
				ConsoleStop.threadSleep(2000);
				break;
			case "3" :
				aboutUser.printUser();
				break;
			case "4" :
				Postbox.openPost();
				break;
			case "5" :
				Field.manageMyField();
				break;
			case "6" :
				sleep.sleep();
				break;
			case "7" :
				aboutUser.chat();
				break;
			case "8" :
				aboutUser.Fight();
				break;
			case "9" :
				aboutUser.savedandexit(season, year, day, FarmName);
				ConsoleStop.threadSleep(2000);
				System.out.println("������ �����մϴ�.");
				try {
					myClient.socket.close(); // ���� ���� ����
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			default: 
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���.");
			}
		}
	}
	
}
