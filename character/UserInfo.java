package character;

import java.util.Scanner;

public class UserInfo extends Character
{
	/**���� ��ü ����**/
	public static void userInfo() {
		Scanner scanner = new Scanner(System.in);
		String name = "";
		String gender = "";
		String userPress = "";
		while(true) {
		if(gender.equals("m")|| gender.equals("w"))
			break;
		System.out.println("������ �����ϼ���.");
		System.out.print("���� > m, ���� > w : ");
		gender = scanner.next();
		}
		
		while(true) {
			if(userPress.equals("y")) 
				break;
			System.out.print("�̸��� �Է��ϼ���.(���� �Ұ���) : ");
			name = scanner.next();
			System.out.print(name + "(��)�� ���Ͻðڽ��ϱ�?(y/n)> ");
			userPress = scanner.next();
		}
		user = new Farmer(name, gender, 100, 100, 0, 0, 1);
	}

	@Override
	public void attack(Monster monster, Farmer user) {
		;
	}

	@Override
	public void die(Character monster) {
		;
	}
	
}
