package gamestory;

import java.util.Scanner;

import console.ClearConsole;
import character.UserInfo;
import farm.Inventory;
import farm.Postbox;

public class WinterStory extends UserInfo {
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
			System.out.println("���� �ܿ��̳�. ���� �츮�� �Բ� �� �� ���� 1���� �� �Ǿ�ٴ�... �ð� �� ����.");
			System.out.println("1�� ���� �츮 �������� ��Ȱ�� ��ſ����ٸ� ���� �ٵ�... �װ� ��� �������� �𸣰ڳ�.");
			System.out.println("�� " + user.getName() + "(��)�� �ͼ� ���� ��ſ��ŵ�.");
			System.out.println("�ʵ� �׷��� �ٶ�.");
			System.out.println("...��·��! �ܿ￡ �� �ؾ� ���� ���� ��Ȳ������ �� �� ���Ƽ� ������ ����.");
			System.out.println("���� �ܿ￣ ���ö�, ���� ����� ���� ��. Ư�� ���� ���Ϸ� ���������� ���� ������ ���͵��� ���ŵ�.");
			System.out.println("��� �� ģ������ ������ ���� ���� �شٰ� �ϴ���. �� �������� 10������ �Ʒ��� ������ ���� ������ ����... ����.");
			System.out.println("�Ƹ� �츮 �������� 30������ ������ ����� �� ����ϰ�? �������� ���! �Ƹ� �� �˰� �� �ž�.");
			System.out.println("��ư, �ܿ￡�� ���� ����������. ���� ���� ���� ������ �����̶� �����϶�!");
			System.out.println("�ܿ￡�� �۹��� �� �Ĵϱ� �� �� �ε��ϰ� �־���. ������, �����̾�!");
			System.out.println("- ���� �ڹٹ�");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("1000��尡 �����Ͽ����ϴ�.");
		user.setGold(1000);
		System.out.println("------------------------------------------------------------------");
		
		int postCount = Postbox.getPostCount();
		postCount--;
		Postbox.setPostCount(postCount);
		}
		else
			return;
	}
	
	public static void ten_day() {
		ClearConsole.clearConsole();
		String userPress = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �����Ͽ����ϴ�. Ȯ���ұ��?(y/other keys)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println(user.getName() + ", ���ش� �� �ʾ���. ����, ����.");
			System.out.println("���� ������ �����̳�. �Ƹ� �ܿ￣ ������� ��� �� �ɽ��� �״�, ȣ������ ���� ��.");
			System.out.println("���� ������ Ư���� ����� �� ���� �����ֵ��� ����. �� �̸��� ���˴뵵 �� �ְ� �� �� ���� �ְ�.");
			System.out.println("��, ��ư. �ܿ� ������ �� 6����. û��, ��¡��, ��ġ, ��ġ, ���뷡��, ���� ����Ⱑ �ִ�.");
			System.out.println("�ܿ￣ ���ð� ������ �� ����? Ư�� ���� �����... ���� �ܿ��� �� �߿��� �� ��Ÿ���ٰ� �ϴ���.");
			System.out.println("���� ���� ���� �� ���� ����, ���ÿ� �� ���� �� ��. ��ٰ� ������� �� �� �ͼ� �ɽ��ϴ� ���̴�.");
			System.out.println("...���Ͱ� �������� �׷��� �� �ƴϴϱ�, �������� ��. �׵� �� ���� �����ٰ�.");
			System.out.println("�ƹ�ư, �̰� ����. �̵��� �츮 ���� ���� ȸ�� ���� �״� �� �����ϰ� �������. �׷�, �̵� ��.");
			System.out.println("- ����");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("��ġ�� �����߽��ϴ�.");
		Inventory.winterF4++;
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
			System.out.println("����... �ȳ�. �츮 �ʸ�����?");
			System.out.println("�ڹٹ����� �� ��⸦... ����ٴ���. ���� �ܼ��̶�� ��.");
			System.out.println("��, 30������ �� ���... �װ� ����. ���� ���� ��... ���� ������ ���̾�. �װ� ���� ���� �� �� �ɷȳ�.");
			System.out.println("�������� ���� ���ð�����... �Ʒ��������� �� ������ �� ���Ƽ�.");
			System.out.println("25�����ʹ�... ���� ���ù����� ģ������ ����. ��Ŭ�׿��� �Ĵ� ������ ���� �� �缭 ���� �ٶ���.");
			System.out.println("�װ� ������ �Ƹ� ������ �����ؼ� ġ��� ���ϰ� �� �Ŷ�. �� �����ϸ� ���� ���� ���;� �Ѵ� ����...");
			System.out.println("�켱 ���� ������ ���͵��� ���� ���, ���� ü���� ���̱⸦ �ٶ���.");
			System.out.println("�� 500���� ���� ������ ü���� ��Ӹ����� �ž�. �ɽ��ϸ� ���� ���� ��.");
			System.out.println("���� ������ �ִ� ������ ���� �� ���� ����. ���� ����� �� �����ٰ�.");
			System.out.println("�̰�... ����. �ڹٹٰ� �� ģ�����״� �̰� �ָ� ������ �Ŷ� �߾�.");
			System.out.println("�׷�, ���߿� ����... ������ ���� �ݰ���.");
			System.out.println("- �ܼ�");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("��Ÿ�ĸ����� �����߽��ϴ�.");
		int fruit = Inventory.getSummerS();
		Inventory.setSummerS(fruit);
		System.out.println("------------------------------------------------------------------");
		
		int postCount = Postbox.getPostCount();
		postCount--;
		Postbox.setPostCount(postCount);
		}
		else
			return;
	}
	
}
