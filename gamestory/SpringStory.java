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
		String story[] = {"어, 안녕! 네가 이번에 마을에 새로 온 농부구나. 자바바에게 이야기 많이 들었어.",
				"이름이... " + user.getName() + "(이)구나! 근사한 이름이야.",
				"나는 스태리펌의 잡화점을 운영 중인 이클이라고 해. 립스의 남편이기도 하지!",
				"우리 마을에 온 걸 정말 환영해. 첫 날이라 뭐가 뭔지 잘 모르겠지? 우선 농장에서 작물을 재배하려면 우리 잡화점에서 씨앗을 사야 해.",
				"처음이니까... 파스닙을 사는 걸 추천할게. 다 자라게 된다면 우리 잡화점에 와서 팔아! 비싸게 쳐줄게.",
				"참고로, 농사를 지을 때는 비료를 꼭 뿌려야 하는데 면적에 따라 100~300 골드 정도 필요해. 처음엔 무리한 규모로 농사 짓지 마!",
				"아, 그리고 이건 농사 도구! 공짜로 줄 테니까 가져가. 대신 꼭 우리 가게에 와서 팔아야 한다?",
				"좋은 괭이를 쓸수록 비료 뿌리는 데 필요한 골드가 적게 들어가고, 좋은 낫을 쓸수록 수확 후 골드 보너스가 주어져! 돈 벌면 주기적으로 도구를 사 주면 좋겠지?",
				"어쨌든, 더 구경하고 싶으면 구경하고 가도 돼. 앞으로 잘 지내보자!"
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
		System.out.print("편지가 도착하였습니다. 확인할까요?(y/other keys)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("안녕, " + user.getName() +"!");
			System.out.println("벌써 우리 마을에 온 지 일주일이 되었구나.");
			System.out.println("그동안 농장 생활에는 적응 잘했어? 요즘 마을에 새로운 농부에 대한 얘기가 많이 돌고 있어.");
			System.out.println("그래, 너 말이야. " + user.getName() +".");
			System.out.println("네가 열심히 농장 생활을 하고 있다는 뜻이겠지? 정말 고마워.");
			System.out.println("앞으로도 이렇게 열심히 지내줘. 항상 응원할게! 그리고 이건 선물이야.");
			System.out.println("-시장 자바바");
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
	
	public static void twenty_day() {
		ClearConsole.clearConsole();
		String userPress = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("편지가 도착하였습니다. 확인할까요?(y/other keys)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("안녕. 너 " + user.getName() +" 맞지?");
			System.out.println("나는 이클의 부인인 립스야. 우리 둘은 처음 얘기해 보는 것 같네.");
			System.out.println("그동안 이클의 잡화점에 많은 물건들을 팔았다는 소식을 듣고 너에 대해 궁금해 져서 이렇게 편지를 써.");
			System.out.println("최근에 마을 사람들이 우리 잡화점으로 물건들을 팔지 않고, 다른 마을에서 거래를 많이 해서 꽤 골치 아팠거든.");
			System.out.println("옆 마을인 객체 마을에서 50% 할인 행사를 했어서 다 그쪽으로 몰려갔었어.");
			System.out.println("아무리 그래도 이웃들간의 정이 있지... 정말 다들 너무해.");
			System.out.println("...하지만, 그동안 네가 우리 잡화점에 자주 와준 덕분에 한시름 놨었어. 정말 고마워.");
			System.out.println("답례로 이걸 주고 싶어. 남편 몰래 가져온 건데, 다시 우리 잡화점에 와서 팔아. 꽤 비싼 물건이라구!");
			System.out.println("그럼, 앞으로도 자주 보자.");
			System.out.println("-립스");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("전설의 물고기가 도착했습니다.");
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
