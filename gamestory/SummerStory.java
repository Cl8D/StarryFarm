package gamestory;

import java.util.Scanner;

import console.ClearConsole;
import character.UserInfo;
import farm.Inventory;
import farm.Postbox;

public class SummerStory extends UserInfo{
	
	public static void one_day() {
		ClearConsole.clearConsole();
		String userPress = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �����Ͽ����ϴ�. Ȯ���ұ��?(y/ other keys)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("�ȳ�, �������̾�. " + user.getName() +"!");
			System.out.println("���� �� ������ �����ٴ�... �ð��� �� ������?");
			System.out.println("Ȥ�� ���� ��������� �۹��� �������� ��Ȳ�ߴ�? �� ������ �۹��� �� ������ ��Ȯ�� �� �־�. �����δ� �� ����� ��.");
			System.out.println("��, �׸���! ������ �� �������, �츮 ������ ���� �۹��� ���ؼ� �Ұ��� �ַ��� ��!");
			System.out.println("�츮 ���� ���� �۹��� ���� ���� �� 5���� �۹��� �־�.");
			System.out.println("���, ���� �����, ��纣��, �丶��, ��Ÿ�ĸ���. �̷��� ���̾�!");
			System.out.println("��� �� �۹����� �� ��� ���̱�� ��. ��� �ȸ� �׸�ŭ ���� ���� �ǰ���?");
			System.out.println("Ư�� ���� �� �����Ӵٸ� ��Ÿ�ĸ��� ������ ��� ���� ���� ��õ�Ұ�!");
			System.out.println("�����ؼ� �Ա⵵ ����, Ư�� �ȸ� ��¥ ��¦ �����? ��Ѹ�ŭ ����ġ�� �ϴ� �۹��̾�.");
			System.out.println("�׷�, �̹� ������ ����! �� �����Ұ�. �̰� ����!");
			System.out.println("- ���� �ڹٹ�");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("700��尡 �����Ͽ����ϴ�.");
		user.setGold(700);
		System.out.println("------------------------------------------------------------------");
		
		int postCount = Postbox.getPostCount();
		postCount--;
		Postbox.setPostCount(postCount);
		}
		else
			return;
	}
	
	public static void fifteen_day() {
		ClearConsole.clearConsole();
		String userPress = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �����Ͽ����ϴ�. Ȯ���ұ��?(y/other keys)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("�ȳ�, " + user.getName() +".");
			System.out.println("���� ������ �Ʒ���. �� ���¸����� ��ǥ ���ò��� ������.");
			System.out.println("�� ���ȿ� �װ� ȣ�������� ���ø� �ϴ� �� ���Ѻôµ�, ��������... �������� �͹ۿ� �� �����.");
			System.out.println("�� ����⿡ ���� �� �� �� ���Ƽ� �����̶� ���� �ַ��� �̷��� ������ ��.");
			System.out.println("�츮 ���� �� ������ �� 6����, ����ġ, ��ġ, ����, ���, ���ڹ�, ������ ����Ⱑ ����.");
			System.out.println("���߿� ���� ������ϼ��� ��Ⱑ �����. Ư�� ������ ������... ���� �� 2���ۿ� �� ��Ҿ�.");
			System.out.println("�Ź� ����ġ�� ��ġ�� ��ư��� �� �Ⱦ������� �����ִ� �Ŵ�, ���� ������ �� �� �غ���.");
			System.out.println("��, ���� ����⿡ ���ؼ��� ���� ��߰���. ���� ����� ���� �� 6������.");
			System.out.println("����, ƿ���Ǿ�, ��ġ, ����, ����, ũ�����ǽ��� ����. �̹��� ����� ������ �˾�����, ���� �� ����?");
			System.out.println("�װ� �� �� ���� �� ���Ƽ� ������ �̰� �ָ�.");
			System.out.println("�ȸ� ���� �� �� �״� ���� ���˴븦 �缭 �ϱ� �ٶ�. ���� �����ϼ��� �̳� ��� ���� �ٰ�, ��� �ð��� �þ�ٱ�.");
			System.out.println("�ƹ�ư, ������ ��. ȣ�������� ���� ����.");
			System.out.println("- ����");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("��� �����߽��ϴ�.");
		Inventory.summerF5++;
		System.out.println("------------------------------------------------------------------");
		
		int postCount = Postbox.getPostCount();
		postCount--;
		Postbox.setPostCount(postCount);
		}
		else
			return;
	}
}
