package gamestory;

import java.util.Scanner;

import console.ClearConsole;
import character.Character;
import character.Farmer;
import character.UserInfo;
import farm.Farm;
import farm.Inventory;
import farm.Postbox;

public class SpringStory extends UserInfo {
	
	public static void first_mart() {
		ClearConsole.clearConsole();
		System.out.println("**Press k + enter**");
		String story[] = {"��, �ȳ�! �װ� �̹��� ������ ���� �� ��α���. �ڹٹٿ��� �̾߱� ���� �����.",
				"�̸���... " + user.getName() + "(��)����! �ٻ��� �̸��̾�.",
				"���� ���¸����� ��ȭ���� � ���� ��Ŭ�̶�� ��. ������ �����̱⵵ ����!",
				"�츮 ������ �� �� ���� ȯ����. ù ���̶� ���� ���� �� �𸣰���? �켱 ���忡�� �۹��� ����Ϸ��� �츮 ��ȭ������ ������ ��� ��.",
				"ó���̴ϱ�... �Ľ����� ��� �� ��õ�Ұ�. �� �ڶ�� �ȴٸ� �츮 ��ȭ���� �ͼ� �Ⱦ�! ��ΰ� ���ٰ�.",
				"�����, ��縦 ���� ���� ��Ḧ �� �ѷ��� �ϴµ� ������ ���� 100~300 ��� ���� �ʿ���. ó���� ������ �Ը�� ��� ���� ��!",
				"��, �׸��� �̰� ��� ����! ��¥�� �� �״ϱ� ������. ��� �� �츮 ���Կ� �ͼ� �Ⱦƾ� �Ѵ�?",
				"���� ���̸� ������ ��� �Ѹ��� �� �ʿ��� ��尡 ���� ����, ���� ���� ������ ��Ȯ �� ��� ���ʽ��� �־���! �� ���� �ֱ������� ������ �� �ָ� ������?",
				"��·��, �� �����ϰ� ������ �����ϰ� ���� ��. ������ �� ��������!"
				};
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
		
		
	}
	public static void seven_day() {
		ClearConsole.clearConsole();
		String userPress = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �����Ͽ����ϴ�. Ȯ���ұ��?(y/other keys)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("�ȳ�, " + user.getName() +"!");
			System.out.println("���� �츮 ������ �� �� �������� �Ǿ�����.");
			System.out.println("�׵��� ���� ��Ȱ���� ���� ���߾�? ���� ������ ���ο� ��ο� ���� ��Ⱑ ���� ���� �־�.");
			System.out.println("�׷�, �� ���̾�. " + user.getName() +".");
			System.out.println("�װ� ������ ���� ��Ȱ�� �ϰ� �ִٴ� ���̰���? ���� ����.");
			System.out.println("�����ε� �̷��� ������ ������. �׻� �����Ұ�! �׸��� �̰� �����̾�.");
			System.out.println("-���� �ڹٹ�");
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
	
	public static void twenty_day() {
		ClearConsole.clearConsole();
		String userPress = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �����Ͽ����ϴ�. Ȯ���ұ��?(y/other keys)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("�ȳ�. �� " + user.getName() +" ����?");
			System.out.println("���� ��Ŭ�� ������ ������. �츮 ���� ó�� ����� ���� �� ����.");
			System.out.println("�׵��� ��Ŭ�� ��ȭ���� ���� ���ǵ��� �ȾҴٴ� �ҽ��� ��� �ʿ� ���� �ñ��� ���� �̷��� ������ ��.");
			System.out.println("�ֱٿ� ���� ������� �츮 ��ȭ������ ���ǵ��� ���� �ʰ�, �ٸ� �������� �ŷ��� ���� �ؼ� �� ��ġ ���Ͱŵ�.");
			System.out.println("�� ������ ��ü �������� 50% ���� ��縦 �߾ �� �������� ����������.");
			System.out.println("�ƹ��� �׷��� �̿��鰣�� ���� ����... ���� �ٵ� �ʹ���.");
			System.out.println("...������, �׵��� �װ� �츮 ��ȭ���� ���� ���� ���п� �ѽø� ������. ���� ����.");
			System.out.println("��ʷ� �̰� �ְ� �;�. ���� ���� ������ �ǵ�, �ٽ� �츮 ��ȭ���� �ͼ� �Ⱦ�. �� ��� �����̶�!");
			System.out.println("�׷�, �����ε� ���� ����.");
			System.out.println("-����");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("������ ����Ⱑ �����߽��ϴ�.");
		Inventory.springF6++;
		System.out.println("------------------------------------------------------------------");
		
		int postCount = Postbox.getPostCount();
		postCount--;
		Postbox.setPostCount(postCount);
		}
		else
			return;
	}
	
}
