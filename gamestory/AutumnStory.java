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
		System.out.print("편지가 도착하였습니다. 확인할까요?(y/n)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("안녕, " + user.getName() +"!");
			System.out.println("벌써 가을이야! 지난 두 계절 동안 농사하는 건 어땠어? 힘들지만 나름 뿌듯하지?");
			System.out.println("이제 농사도 가을이 지나면 할 수가 없어. 겨울에는 땅이 얼어서 농사짓기 힘들거든.");
			System.out.println("그러니까, 다가오는 겨울을 생각하면서 가을에 많이 해두는 게 좋을 거야. 이번엔 가을 작물에 대해 소개할게!");
			System.out.println("우리 마을 가을 작물 역시 총 5가지 작물이 있어.");
			System.out.println("마, 포도, 아마란스, 청경채, 호박. 이렇게 말이야!");
			System.out.println("가을 작물은 대체적으로 자라는 기간이 길어서 한 번 씨앗을 심을 때 많이 심어두는 게 좋을 거야.");
			System.out.println("가을에 난 호박으로 립스가 종종 파이를 만드는데, 그게 진짜... 끝내줘. 나중에 같이 립스 집에 가자!");
			System.out.println("그럼, 이번 가을도 힘내! 이건 선물이야. 항상 수고가 많아. 응원할게!");
			System.out.println("- 시장 자바바");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("500골드가 도착하였습니다.");
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
		System.out.print("편지가 도착하였습니다. 확인할까요?(y/n)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("낚시하러 가야 해서 바쁜 관계로 물고기 정보만 적어둘게. 내가 누군진 말 안 해도 알겠지?");
			System.out.println("가을 물고기는 총 6마리야. 정어리, 연어, 타이거 송어, 메기, 월아이, 아귀.");
			System.out.println("올해는 아귀가 잘 잡힐지도 모른다던데, 너도 서둘러 가보라구.");
			System.out.println("이건 선물. 내가 방금 잡은 타이거 송어야.");
			System.out.println("- 윌리");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("타이거 송어가 도착했습니다.");
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
