package town;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import console.ClearConsole;
import console.ConsoleStop;
import console.FileRead;
import character.UserInfo;
import farm.Farm;
import farm.Inventory;
import item.Fish;

public class Lake extends UserInfo implements specialPlace{
	private static List <Fish> springFishes;
	private static List <Fish> summerFishes;
	private static List <Fish> autumnFishes;
	private static List <Fish> winterFishes;
	
	//물고기 파일
	private File fish = new File("./getFish.txt");
	//호수 파일
	private File lake = new File("./Lake.txt");
		
	public Lake(List<Fish> springFishes, List<Fish> summerFishes, List<Fish> autumnFishes, List<Fish> winterFishes) {
		Lake.springFishes = springFishes;
		Lake.summerFishes = summerFishes;
		Lake.autumnFishes = autumnFishes;
		Lake.winterFishes = winterFishes;
	}

	public Lake() {
		;
	}

	@Override
	public void printPlace() {
		ClearConsole.clearConsole();
		System.out.println("		==== 호수에 도착했습니다. ====		");
		FileRead.hasThreadTxt(lake);
		ConsoleStop.threadSleep(1500);
		active();
	}

	@Override
	public void active() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
		ClearConsole.clearConsole();
		System.out.println("==============================================================");
		System.out.println("		낚시를 시작할까요?(y/n) - hp 10 차감	");
		System.out.println("		기본으로 100G 소모됩니다.(좋은 도구일수록 적게 차감)	");
		System.out.println("		현재 유저 Hp: " + user.getHp() + "/" + user.getMaxHp());
		System.out.println("		현재 보유 중인 골드: " + user.getGold() + "G");
		System.out.print("(y/n) >>");
		String userPress = scanner.next();
		
		if(userPress.equals("y")) {
			if(user.getFishingRod() == null) {
				System.out.println("		보유 중인 낚싯대가 없어요. 상점에서 기본 낚싯대를 받아 오세요!");
				ConsoleStop.threadSleep(1500);
				return;
			}
			else {
				if(!user.buyBait(user.getFishingRod())){
					System.out.println("		잔액이 부족합니다.		");
					return;
				}
			
			System.out.println("		물고기를 기다리는 중입니다...	");
			Random random = new Random();
			int wait = random.nextInt(9000) + 1; //1초부터 10초 사이 랜덤으로 발생
			ConsoleStop.threadSleep(wait);
			System.out.println("		엇! 물고기가 잡혔어요!		");
		
			if(Farm.getSeason().equals("봄")) {
				int whatFishIndex = random.nextInt(6);
				Fish springFish = springFishes.get(whatFishIndex);
				
				if(springFish.getDifficulty().equals("easy")) 
					whatDifficulty(springFish, "easy");
				
				else if(springFish.getDifficulty().equals("medium")) 
					whatDifficulty(springFish, "medium");
				
				else if(springFish.getDifficulty().equals("hard")) 
					whatDifficulty(springFish, "hard");
				
				else if(springFish.getDifficulty().equals("expert")) 
					whatDifficulty(springFish, "expert");
			}

			else if(Farm.getSeason().equals("여름")) {
				int whatFishIndex = random.nextInt(6);
				Fish summerFish = summerFishes.get(whatFishIndex);
				
				if(summerFish.getDifficulty().equals("easy")) 
					whatDifficulty(summerFish, "easy");
				
				else if(summerFish.getDifficulty().equals("medium")) 
					whatDifficulty(summerFish, "medium");
				
				else if(summerFish.getDifficulty().equals("hard")) 
					whatDifficulty(summerFish, "hard");
				
				else if(summerFish.getDifficulty().equals("expert")) 
					whatDifficulty(summerFish, "expert");
			}

			else if(Farm.getSeason().equals("가을")) {
				int whatFishIndex = random.nextInt(6);
				Fish autumnFish = autumnFishes.get(whatFishIndex);
				
				if(autumnFish.getDifficulty().equals("easy")) 
					whatDifficulty(autumnFish, "easy");
				
				else if(autumnFish.getDifficulty().equals("medium")) 
					whatDifficulty(autumnFish, "medium");
				
				else if(autumnFish.getDifficulty().equals("hard")) 
					whatDifficulty(autumnFish, "hard");
				
				else if(autumnFish.getDifficulty().equals("expert")) 
					whatDifficulty(autumnFish, "expert");
			}
			
			else if(Farm.getSeason().equals("겨을")) {
				int whatFishIndex = random.nextInt(6);
				Fish winterFish = winterFishes.get(whatFishIndex);
				
				if(winterFish.getDifficulty().equals("easy")) 
					whatDifficulty(winterFish, "easy");
				
				else if(winterFish.getDifficulty().equals("medium")) 
					whatDifficulty(winterFish, "medium");
				
				else if(winterFish.getDifficulty().equals("hard")) 
					whatDifficulty(winterFish, "hard");
				
				else if(winterFish.getDifficulty().equals("expert")) 
					whatDifficulty(winterFish, "expert");
				}
			}
		}
		if(userPress.equals("n")) { 
			return;
		}
		
		}
}
	
	private void whatDifficulty(Fish whatFish, String difficulty) {
		int time = 0;
		if(user.getFishingRod().getName().equals("돌 낚싯대"))
			time = 5;
		else if(user.getFishingRod().getName().equals("구리 낚싯대"))
			time = 10;
		else if(user.getFishingRod().getName().equals("철 낚싯대"))
			time = 15;
		else if(user.getFishingRod().getName().equals("이리듐 낚싯대"))
			time = 20;
		
		Random random = new Random();
		if(difficulty.equals("easy")) {
			int x = random.nextInt(9) + 1; // 1~9
			int y = random.nextInt(9) + 1; 
			int result = x * y;
			System.out.println("		제한 시간 " + time + "초!");
			System.out.print("		" + x + " x " + y + " = ? => ");
			fishTime(time, result, whatFish.getName());
		}
		
		else if(difficulty.equals("medium")) {
			int x = random.nextInt(90) + 10; // 10~99
			int y = random.nextInt(9) + 1; // 1~9
			int z = random.nextInt(90) + 10;
			int result = x * y + z;
			System.out.println("		제한 시간 " + time + "초!");
			System.out.print("		(" + x + " x " + y + ") + " + z + " = ? => ");
			fishTime(time, result, whatFish.getName());
		}
		
		else if(difficulty.equals("hard")) {
			int x = random.nextInt(90) + 10; // 10~99
			int y = random.nextInt(90) + 10;
			int z = random.nextInt(400) + 100; //100~499 
			int result = x * y + z;
			System.out.println("		제한 시간 " + time + "초!");
			System.out.print("		(" + x + " x " + y + ") + " + z + " = ? => ");
			fishTime(time, result, whatFish.getName());
		}
		
		else if(difficulty.equals("expert")) {
			int x =  random.nextInt(900) + 100; // 100~999 
			int y = random.nextInt(90) + 10; 
			int z = random.nextInt(9000) + 1000; // 1000~9999
			int result = x * y + z;
			System.out.println("		제한 시간 " + time + "초!");
			System.out.print("		(" + x + " x " + y + ") + " + z + " = ? => ");
			fishTime(time, result, whatFish.getName());
		}
		
		
	}
	private void fishTime(int time, int result, String fishName) {
		Scanner scanner = new Scanner(System.in);
		int oldTime = (int)System.currentTimeMillis() / 1000;
		int userResult = scanner.nextInt();
		int newTime = (int)System.currentTimeMillis() / 1000 - oldTime; // 걸린 시간
		
		if(newTime <= time) {
			if(result == userResult) {
				FileRead.hasThreadTxt(fish);
				System.out.println("		우와! " + fishName + "을(를) 잡았어요!");
				getFish(fishName);
				ConsoleStop.threadSleep(1000);
			}
			else 
				System.out.println("		물고기를 놓쳤어요. 다시 도전해 보도록 해요!");
		}
		else
			System.out.println("		" + time + "초가 지나서 물고기가 떠나버렸어요. (걸린 시간: " + newTime + "초)");	
		ConsoleStop.threadSleep(1000);
	}
	
	private void getFish(String fishName) {
		if(fishName.equals("개복치"))
			Inventory.springF1++;
		if(fishName.equals("전어"))
			Inventory.springF2++;
		if(fishName.equals("멸치"))
			Inventory.springF3++;
		if(fishName.equals("장어"))
			Inventory.springF4++;
		if(fishName.equals("가자미"))
			Inventory.springF5++;
		if(fishName.equals("전설의 물고기"))
			Inventory.springF6++;
		
		if(fishName.equals("숭어"))
			Inventory.summerF1++;
		if(fishName.equals("틸라피아"))
			Inventory.summerF2++;
		if(fishName.equals("문어"))
			Inventory.summerF3++;
		if(fishName.equals("참치"))
			Inventory.summerF4++;
		if(fishName.equals("복어"))
			Inventory.summerF5++;
		if(fishName.equals("크림슨피쉬"))
			Inventory.summerF6++;
		
		if(fishName.equals("정어리"))
			Inventory.autumnF1++;
		if(fishName.equals("연어"))
			Inventory.autumnF2++;
		if(fishName.equals("타이거 송어"))
			Inventory.autumnF3++;
		if(fishName.equals("메기"))
			Inventory.autumnF4++;
		if(fishName.equals("월아이"))
			Inventory.autumnF5++;
		if(fishName.equals("아귀"))
			Inventory.autumnF6++;
		
		if(fishName.equals("청어"))
			Inventory.winterF1++;
		if(fishName.equals("오징어"))
			Inventory.winterF2++;
		if(fishName.equals("넙치"))
			Inventory.winterF3++;
		if(fishName.equals("참치"))
			Inventory.winterF4++;
		if(fishName.equals("범노래미"))
			Inventory.winterF5++;
		if(fishName.equals("얼음 물고기"))
			Inventory.winterF6++;
	}
	
}
