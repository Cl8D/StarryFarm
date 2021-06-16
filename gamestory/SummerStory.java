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
		System.out.print("편지가 도착하였습니다. 확인할까요?(y/ other keys)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("안녕, 오랜만이야. " + user.getName() +"!");
			System.out.println("벌써 한 계절이 지나다니... 시간이 참 빠르지?");
			System.out.println("혹시 봄에 농사지었던 작물이 없어져서 당황했니? 각 계절의 작물은 그 계절만 수확할 수 있어. 앞으로는 잘 기억해 둬.");
			System.out.println("아, 그리고! 여름이 된 기념으로, 우리 마을의 여름 작물에 대해서 소개해 주려고 해!");
			System.out.println("우리 마을 여름 작물은 봄과 같이 총 5가지 작물이 있어.");
			System.out.println("멜론, 붉은 양배추, 블루베리, 토마토, 스타후르츠. 이렇게 말이야!");
			System.out.println("모두 봄 작물보다 좀 비싼 편이기는 해. 대신 팔면 그만큼 돈이 많이 되겠지?");
			System.out.println("특히 돈이 좀 여유롭다면 스타후르츠 씨앗을 사는 것을 정말 추천할게!");
			System.out.println("달콤해서 먹기도 좋고, 특히 팔면 진짜 깜짝 놀랄걸? 비싼만큼 값어치를 하는 작물이야.");
			System.out.println("그럼, 이번 여름도 힘내! 늘 응원할게. 이건 선물!");
			System.out.println("- 시장 자바바");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("700골드가 도착하였습니다.");
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
		System.out.print("편지가 도착하였습니다. 확인할까요?(y/other keys)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("안녕, " + user.getName() +".");
			System.out.println("내가 누군지 아려나. 난 스태리팜의 대표 낚시꾼인 윌리다.");
			System.out.println("봄 동안에 네가 호숫가에서 낚시를 하는 걸 지켜봤는데, 정말이지... 기초적인 것밖에 못 잡더라군.");
			System.out.println("봄 물고기에 대해 잘 모를 것 같아서 지금이라도 말해 주려고 이렇게 편지를 써.");
			System.out.println("우리 마을 봄 물고기는 총 6마리, 개복치, 멸치, 전어, 장어, 가자미, 전설의 물고기가 있지.");
			System.out.println("나중에 말한 물고기일수록 잡기가 어려워. 특히 전설의 물고기는... 나도 딱 2번밖에 못 잡았어.");
			System.out.println("매번 개복치랑 멸치만 잡아가는 게 안쓰러워서 말해주는 거니, 다음 봄에는 잘 좀 해보라구.");
			System.out.println("아, 여름 물고기에 대해서도 말해 줘야겠지. 여름 물고기 역시 총 6마리다.");
			System.out.println("숭어, 틸라피아, 참치, 문어, 복어, 크림슨피쉬가 있지. 이번엔 물고기 종류라도 알았으니, 잘할 수 있지?");
			System.out.println("네가 잘 못 잡을 것 같아서 선물로 이걸 주마.");
			System.out.println("팔면 돈이 꽤 될 테니 좋은 낚싯대를 사서 하길 바라. 좋은 도구일수록 미끼 사는 돈도 줄고, 잡는 시간도 늘어난다구.");
			System.out.println("아무튼, 열심히 해. 호숫가에서 종종 보자.");
			System.out.println("- 윌리");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("복어가 도착했습니다.");
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
