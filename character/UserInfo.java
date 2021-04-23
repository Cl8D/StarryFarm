package character;

import java.util.Scanner;

public class UserInfo extends Character
{
	/**유저 객체 생성**/
	public static void userInfo() {
		Scanner scanner = new Scanner(System.in);
		String name = "";
		String gender = "";
		String userPress = "";
		while(true) {
		if(gender.equals("m")|| gender.equals("w"))
			break;
		System.out.println("성별을 선택하세요.");
		System.out.print("남성 > m, 여성 > w : ");
		gender = scanner.next();
		}
		
		while(true) {
			if(userPress.equals("y")) 
				break;
			System.out.print("이름을 입력하세요.(공백 불가능) : ");
			name = scanner.next();
			System.out.print(name + "(이)로 정하시겠습니까?(y/n)> ");
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
