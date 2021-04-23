package gamestory;

import java.io.File;
import java.util.Scanner;

import console.ClearConsole;
import console.ConsoleStop;
import console.FileRead;
import farm.Inventory;

public class EndStory extends Inventory{
	public static void Ending() {
		ClearConsole.clearConsole();
		System.out.println("		엔딩 조건: 모든 무기 및 도구 수집, 해당 계절 작물 및 물고기 100개 이상 소유");
		System.out.println("		바로 엔딩 화면을 로딩하시겠습니까?(y/ other keys) >>");
		Scanner scanner = new Scanner(System.in);
		String userPress = scanner.next();
		if(userPress.equals("y")) {
			EndingScene();
		}
		else {
			if((fruitCount >= 100) && (fishCount >= 100) && (weaponCount == 10) && (toolCount == 13)) 
				EndingScene();
			else {
				System.out.println("		엔딩 조건을 만족하지 못 했습니다.");
				ConsoleStop.threadSleep(1000);
				return;
			}
		}
	}
	
	private static void EndingScene() {
		ClearConsole.clearConsole();
		File EndingScene1 = new File("./EndingScene1.txt");
		File EndingScene2 = new File("./EndingScene2.txt");
		FileRead.hasThreadTxt(EndingScene1);
		ConsoleStop.threadSleep(300);
		ClearConsole.clearConsole();
		FileRead.hasNotThreadTxt(EndingScene2);
		ConsoleStop.threadSleep(300);
		ClearConsole.clearConsole();
		FileRead.hasNotThreadTxt(EndingScene1);
		ConsoleStop.threadSleep(300);
		
		System.out.println();
		System.out.println("**Press k + enter**");
		String story[] = {"안녕, 여기 별이 참 예쁘지?",
				"Starry Farm은, 별이 반짝반짝 빛나는 곳이야. 우리 농장의 이름과 매우 잘 어울리는 곳이지.",
				"그동안, 우리 마을에서의 생활은 어땠니?",
				"네가 열심히 농사를 지어주고, 물고기를 잡고, 몬스터를 잡는 덕분에 우리 마을에는 더 따뜻한 온기가 가득해졌어.",
				"네가 우리 마을에 온 게 너무 고맙다는 말이야.",
				"짧다면 짧고, 길다면 긴 시간이겠지만 우리 마을에 와서, 한 일원이 되어 줘서 정말 고마워.",
				"네가 이렇게 간다고 해도, 우리는 절대 너를 잊지 않을 거야.",
				"너도 이곳에서의 생활과, 이 별이 가득한 하늘은 잊지 않았으면 좋겠어. 물론 우리도 말이야!",
				"헤어짐은 또 다른 만남의 시작이라는 말이 있잖아? 나중에 꼭 다시 만나자.",
				"언제든지 힘들면 다시 와도 좋아. 네 농장은 우리가 잘 관리하고 있을게.",
				"아프지 말고, 건강하게 잘 지내야 해! 네 앞길을 늘 응원할게.",
				"...... - 스태리팜 마을 주민 일동"};
		
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
		ConsoleStop.threadSleep(100);
		System.exit(0);
		
	}
}
