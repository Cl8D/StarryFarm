package gamestory;
import java.io.File;
import java.util.Scanner;

import console.ClearConsole;
import console.ConsoleStop;
import console.FileRead;
import character.Character;
import character.Farmer;
import character.UserInfo;
import farm.Farm;
import farm.Postbox;

public class StartStory extends UserInfo {
	
	public static void firstStory() {
		String childGender = " ";
		if(user.getGender().equals("m")) {
			childGender = "손주";
		}
		else if(user.getGender().equals("w")) {
			childGender = "손녀";
		}
		
		File letter = new File("./letter.txt");
		FileRead.hasThreadTxt(letter);

		
		ClearConsole.clearConsole();
		System.out.println("**Press k + enter**");
		
		String story[] = {"-20xx년, 3월. 할머니의 왼쪽 서랍에서.",
				"사랑하는 나의 " + childGender + " " + user.getName()+ "에게.",
				"잘 지내고 있었니, 아가야.",
				"네가 이 편지를 읽을 때 즈음이면 나는 이 세상에 없을 것 같구나.",
				"혼자 타지에 올라가, 힘든 날들이 정말 많았을 거라고 생각한다.",
				"문득 모든 걸 포기하고 싶어질 때가 온다면, 북쪽 너머에 있는 StarryFarm 마을로 떠나거라.",
				"이곳에서는 네가 원하는 건 무엇이든지 만들어나갈 수 있을 거야.",
				"늘 응원하고 있으마.",
				".......사랑하는 너의 할머니가."};
		
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
		ConsoleStop.threadSleep(800);
		ClearConsole.clearConsole();
	}
	
	public void firstLetter() {
		ClearConsole.clearConsole();
		String userPress = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("편지가 도착하였습니다.(press y)>> ");
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("안녕, " + user.getName() +"!");
			System.out.println("나는 스태리팜의 시장인 자바바라고 해! 우리 마을에 온 걸 환영해.");
			System.out.println("앞으로 우리 농장의 일원이 될 수 있도록, 너의 농장을 예쁘게 꾸며줘.");
			System.out.println("참고로 우리 마을에는 계절마다 재배할 수 있는 농작물이 달라. 상점에 가면 질 좋은 씨앗들을 듬뿍 팔아.");
			System.out.println("또, 마을에 있는 호숫가에서는 낚시도 할 수 있어. 잡기 까다로운 물고기를 잡아서 팔면 돈을 많이 벌 수 있을 거야!");
			System.out.println("음... 그리고, 북쪽으로 가면 한 동굴이 있는데, 무시무시한 몬스터들이 많아.");
			System.out.println("대신 몬스터 사냥에 성공하면 돈도 벌 수 있고, 너의 기초 체력도 높아질 거야! 적응되면 사냥하러 가 봐.");
			System.out.println("아, 참고로 상점에 가면 농사를 위한 기본 도구들을 줄 거야. 돈을 벌게 된다면 더 좋은 도구들로 바꾸길 바랄게!");
			System.out.println("나머지는 직접 우리 농장에서 살아가며 알 수 있을 거야. 종종 우편 보낼게.");
			System.out.println("아, 그리고 이건 선물. 우리 마을에 온 기념으로 주는 거야.");
			System.out.println("그럼, 행운을 빌게. 다음에 또 보자!");
			System.out.println("----------------------------------------------------------------------");
		}
		
		System.out.println();
		System.out.println("500골드가 도착하였습니다.");
		user.setGold(500);
		System.out.println("------------------------------------------------------------------");
		Postbox.setPostCount(0);
		System.out.println();
		
			
	}
}

