package gamestory;

import java.io.File;
import java.util.Scanner;

import console.ClearConsole;
import console.ConsoleStop;
import console.FileRead;
import farm.Inventory;

public class EndStory extends Inventory{
	public static void Ending() {
		ClearConsole.clearConsole();
		System.out.println("		���� ����: ��� ���� �� ���� ����, �ش� ���� �۹� �� ����� 100�� �̻� ����");
		System.out.println("		�ٷ� ���� ȭ���� �ε��Ͻðڽ��ϱ�?(y/ other keys) >>");
		Scanner scanner = new Scanner(System.in);
		String userPress = scanner.next();
		if(userPress.equals("y")) {
			EndingScene();
		}
		else {
			if((fruitCount >= 100) && (fishCount >= 100) && (weaponCount == 10) && (toolCount == 13)) 
				EndingScene();
			else {
				System.out.println("		���� ������ �������� �� �߽��ϴ�.");
				ConsoleStop.threadSleep(1000);
				return;
			}
		}
	}
	
	private static void EndingScene() {
		ClearConsole.clearConsole();
		File EndingScene1 = new File("./EndingScene1.txt");
		File EndingScene2 = new File("./EndingScene2.txt");
		FileRead.hasThreadTxt(EndingScene1);
		ConsoleStop.threadSleep(300);
		ClearConsole.clearConsole();
		FileRead.hasNotThreadTxt(EndingScene2);
		ConsoleStop.threadSleep(300);
		ClearConsole.clearConsole();
		FileRead.hasNotThreadTxt(EndingScene1);
		ConsoleStop.threadSleep(300);
		
		System.out.println();
		System.out.println("**Press k + enter**");
		String story[] = {"�ȳ�, ���� ���� �� ������?",
				"Starry Farm��, ���� ��¦��¦ ������ ���̾�. �츮 ������ �̸��� �ſ� �� ��︮�� ������.",
				"�׵���, �츮 ���������� ��Ȱ�� ���?",
				"�װ� ������ ��縦 �����ְ�, ����⸦ ���, ���͸� ��� ���п� �츮 �������� �� ������ �±Ⱑ ����������.",
				"�װ� �츮 ������ �� �� �ʹ� ���ٴ� ���̾�.",
				"ª�ٸ� ª��, ��ٸ� �� �ð��̰����� �츮 ������ �ͼ�, �� �Ͽ��� �Ǿ� �༭ ���� ����.",
				"�װ� �̷��� ���ٰ� �ص�, �츮�� ���� �ʸ� ���� ���� �ž�.",
				"�ʵ� �̰������� ��Ȱ��, �� ���� ������ �ϴ��� ���� �ʾ����� ���ھ�. ���� �츮�� ���̾�!",
				"������� �� �ٸ� ������ �����̶�� ���� ���ݾ�? ���߿� �� �ٽ� ������.",
				"�������� ����� �ٽ� �͵� ����. �� ������ �츮�� �� �����ϰ� ������.",
				"������ ����, �ǰ��ϰ� �� ������ ��! �� �ձ��� �� �����Ұ�.",
				"...... - ���¸��� ���� �ֹ� �ϵ�"};
		
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
		ConsoleStop.threadSleep(100);
		System.exit(0);
		
	}
}
