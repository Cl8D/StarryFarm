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
	static String season = "봄";
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
	
	public void setFarmName(String farmname, String season ,int year, int day) {
		Farm.FarmName = farmname;
		Farm.year = year;
		Farm.day = day;
		Farm.season = season;
		Postbox.setPostCount(0);
	}
	
	public void myFarm() {
		/*** 객체 생성 ***/
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
		System.out.println("***" + FarmName + " 농장 ***");
		System.out.println("---" + year + "년차 " + season + "의 " + day + "일째" + "---");
		
		if((Postbox.getPostCount() == 1) && (season.equals("봄")) && (day == 1)) {
			startStory.firstLetter();
			System.out.println("============================================================");
			System.out.println();
		}
		if(first_count == 0) {
			try {  // 나중에 제거 처음 저장부붐 이 부분 필요함
				out.writeUTF("1"); // 저장이라고 알림
			} catch (IOException e) {
				e.printStackTrace();
			}
			Runnable T1 = new SendToServer(season, year, day, FarmName);
			Thread saveInf = new Thread(T1); 
			saveInf.start();
			ConsoleStop.threadSleep(1000);
			System.out.println("생성 정보가 저장되었습니다.");
			System.out.println("");
			first_count++;
		}
		
		while(true) {
		
		ClearConsole.clearConsole();
		System.out.println("============================================================");
		System.out.println("		" + "♥ " + FarmName +" 농장 " + year + "년째 " + season+ "의 " + day +"일째 ♥" + "		");
		System.out.println("		" + "좋은 아침이에요. 오늘은 무엇을 할까요?" + "		");
		System.out.println("		" + "0. 저장하기" + "		");
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
		System.out.println("		" + "7. 채팅하기" + "		");
		System.out.println("		" + "8. 다른 유저와 싸우기" + "		");
		System.out.println("		" + "9. 저장하고 게임 종료" + "		");
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
				System.out.println("게임을 종료합니다.");
				try {
					myClient.socket.close(); // 소켓 연결 해제
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			default: 
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
			}
		}
	}
	
}
