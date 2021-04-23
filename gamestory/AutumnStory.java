package gamestory;

import java.util.Scanner;

import console.ClearConsole;
import character.UserInfo;
import farm.Inventory;
import farm.Postbox;

public class AutumnStory extends UserInfo {
	public static void one_day() {
		ClearConsole.clearConsole();
		String userPress = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �����Ͽ����ϴ�. Ȯ���ұ��?(y/n)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("�ȳ�, " + user.getName() +"!");
			System.out.println("���� �����̾�! ���� �� ���� ���� ����ϴ� �� ���? �������� ���� �ѵ�����?");
			System.out.println("���� ��絵 ������ ������ �� ���� ����. �ܿ￡�� ���� �� ������� ����ŵ�.");
			System.out.println("�׷��ϱ�, �ٰ����� �ܿ��� �����ϸ鼭 ������ ���� �صδ� �� ���� �ž�. �̹��� ���� �۹��� ���� �Ұ��Ұ�!");
			System.out.println("�츮 ���� ���� �۹� ���� �� 5���� �۹��� �־�.");
			System.out.println("��, ����, �Ƹ�����, û��ä, ȣ��. �̷��� ���̾�!");
			System.out.println("���� �۹��� ��ü������ �ڶ�� �Ⱓ�� �� �� �� ������ ���� �� ���� �ɾ�δ� �� ���� �ž�.");
			System.out.println("������ �� ȣ������ ������ ���� ���̸� ����µ�, �װ� ��¥... ������. ���߿� ���� ���� ���� ����!");
			System.out.println("�׷�, �̹� ������ ����! �̰� �����̾�. �׻� ���� ����. �����Ұ�!");
			System.out.println("- ���� �ڹٹ�");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("500��尡 �����Ͽ����ϴ�.");
		user.setGold(500);
		System.out.println("------------------------------------------------------------------");
		
		int postCount = Postbox.getPostCount();
		postCount--;
		Postbox.setPostCount(postCount);
		}
		else
			return;
	}
	
	public static void seven_day() {
		ClearConsole.clearConsole();
		String userPress = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �����Ͽ����ϴ�. Ȯ���ұ��?(y/n)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("�����Ϸ� ���� �ؼ� �ٻ� ����� ����� ������ ����Ѱ�. ���� ������ �� �� �ص� �˰���?");
			System.out.println("���� ������ �� 6������. ���, ����, Ÿ�̰� �۾�, �ޱ�, ������, �Ʊ�.");
			System.out.println("���ش� �ƱͰ� �� �������� �𸥴ٴ���, �ʵ� ���ѷ� ������.");
			System.out.println("�̰� ����. ���� ��� ���� Ÿ�̰� �۾��.");
			System.out.println("- ����");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("Ÿ�̰� �۾ �����߽��ϴ�.");
		Inventory.autumnF3++;
		System.out.println("------------------------------------------------------------------");
		
		int postCount = Postbox.getPostCount();
		postCount--;
		Postbox.setPostCount(postCount);
		}
		else
			return;
	}
}
