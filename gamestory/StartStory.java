package gamestory;
import java.io.File;
import java.util.Scanner;

import console.ClearConsole;
import console.ConsoleStop;
import console.FileRead;
import character.Character;
import character.Farmer;
import character.UserInfo;
import farm.Farm;
import farm.Postbox;

public class StartStory extends UserInfo {
	
	public static void firstStory() {
		String childGender = " ";
		if(user.getGender().equals("m")) {
			childGender = "����";
		}
		else if(user.getGender().equals("w")) {
			childGender = "�ճ�";
		}
		
		File letter = new File("./letter.txt");
		FileRead.hasThreadTxt(letter);

		
		ClearConsole.clearConsole();
		System.out.println("**Press k + enter**");
		
		String story[] = {"-20xx��, 3��. �ҸӴ��� ���� ��������.",
				"����ϴ� ���� " + childGender + " " + user.getName()+ "����.",
				"�� ������ �־���, �ư���.",
				"�װ� �� ������ ���� �� �����̸� ���� �� ���� ���� �� ������.",
				"ȥ�� Ÿ���� �ö�, ���� ������ ���� ������ �Ŷ�� �����Ѵ�.",
				"���� ��� �� �����ϰ� �;��� ���� �´ٸ�, ���� �ʸӿ� �ִ� StarryFarm ������ �����Ŷ�.",
				"�̰������� �װ� ���ϴ� �� �����̵��� ������ �� ���� �ž�.",
				"�� �����ϰ� ������.",
				".......����ϴ� ���� �ҸӴϰ�."};
		
		String userPress = "";
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i< story.length; i++) {
			userPress = scanner.next();
			if(userPress.equals("k")) {
				System.out.println(story[i]);
			}
			else
				i--;
		}
		
		System.out.println();
		ConsoleStop.threadSleep(800);
		ClearConsole.clearConsole();
	}
	
	public void firstLetter() {
		ClearConsole.clearConsole();
		String userPress = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �����Ͽ����ϴ�.(press y)>> ");
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("�ȳ�, " + user.getName() +"!");
			System.out.println("���� ���¸����� ������ �ڹٹٶ�� ��! �츮 ������ �� �� ȯ����.");
			System.out.println("������ �츮 ������ �Ͽ��� �� �� �ֵ���, ���� ������ ���ڰ� �ٸ���.");
			System.out.println("����� �츮 �������� �������� ����� �� �ִ� ���۹��� �޶�. ������ ���� �� ���� ���ѵ��� ��� �Ⱦ�.");
			System.out.println("��, ������ �ִ� ȣ���������� ���õ� �� �� �־�. ��� ��ٷο� ����⸦ ��Ƽ� �ȸ� ���� ���� �� �� ���� �ž�!");
			System.out.println("��... �׸���, �������� ���� �� ������ �ִµ�, ���ù����� ���͵��� ����.");
			System.out.println("��� ���� ��ɿ� �����ϸ� ���� �� �� �ְ�, ���� ���� ü�µ� ������ �ž�! �����Ǹ� ����Ϸ� �� ��.");
			System.out.println("��, ����� ������ ���� ��縦 ���� �⺻ �������� �� �ž�. ���� ���� �ȴٸ� �� ���� ������� �ٲٱ� �ٶ���!");
			System.out.println("�������� ���� �츮 ���忡�� ��ư��� �� �� ���� �ž�. ���� ���� ������.");
			System.out.println("��, �׸��� �̰� ����. �츮 ������ �� ������� �ִ� �ž�.");
			System.out.println("�׷�, ����� ����. ������ �� ����!");
			System.out.println("----------------------------------------------------------------------");
		}
		
		System.out.println();
		System.out.println("500��尡 �����Ͽ����ϴ�.");
		user.setGold(500);
		System.out.println("------------------------------------------------------------------");
		Postbox.setPostCount(0);
		System.out.println();
		
			
	}
}

