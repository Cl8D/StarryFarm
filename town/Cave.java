package town;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import console.ClearConsole;
import console.ConsoleStop;
import console.FileRead;
import character.Monster;
import character.UserInfo;

public class Cave extends UserInfo implements specialPlace{
	private static int huntCount = 0;
	
	private static List <Monster> level1_Monster;
	private static List <Monster> level2_Monster;
	private static List <Monster> level3_Monster;
	private static List <Monster> level4_Monster;
	private static List <Monster> level5_Monster;
	private static List <Monster> level6_Monster;
	
	//몬스터 파일
	private File monsterPicture = new File("./monster.txt");
	//레벨업 파일
	private File levelUp = new File("./LevelUp.txt");
	//동굴 파일
	private File cave = new File("./cave.txt");
	
	public Cave(List<Monster> level1_Monster, List<Monster> level2_Monster, List<Monster> level3_Monster, List<Monster> level4_Monster, List<Monster> level5_Monster, List<Monster> level6_Monster) {
		Cave.level1_Monster = level1_Monster;
		Cave.level2_Monster = level2_Monster;
		Cave.level3_Monster = level3_Monster;
		Cave.level4_Monster = level4_Monster;
		Cave.level5_Monster = level5_Monster;
		Cave.level6_Monster = level6_Monster;
	}

	public Cave() {
		;
	}
	

	@Override
	public void printPlace() {
		ClearConsole.clearConsole();
		System.out.println("		==== 동굴에 도착했습니다. ====		");
		FileRead.hasThreadTxt(cave);
		ConsoleStop.threadSleep(1500);
		active();
	}

	@Override
	public void active() {
		ClearConsole.clearConsole();
		Scanner scanner = new Scanner(System.in);
		System.out.println("==============================================================");
		System.out.print("		굴 안으로 들어갈까요?(y/n) ");
		String userPress = scanner.next();
		if(userPress.equals("y")) {
			if(user.getWeapon() == null) {
				System.out.println("		보유 중인 무기가 없어요. 상점에서 무기 구매 후 인벤토리에서 장착해 주세요.");
				ConsoleStop.threadSleep(1500);
				return;
			}
			else
				enterCave(1);
		}
		
		else if(userPress.equals("n")) {
				goTown();
				return;
		}
	}
	
	private void enterCave(int floor) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			ClearConsole.clearConsole();
			System.out.println("==============================================================");
			System.out.println("		" + floor + "층에 들어왔어요.");
			System.out.println("		▶ 1. " + floor + "층 수색하기");
			int upFloor = floor + 1;
			if(upFloor < 32) {
				System.out.println("		▶ 2. " + upFloor +"층으로 내려가기");
			}
			System.out.println("		▶ 3. 동굴 밖으로 나가기");
			System.out.println("==============================================================");
			
			System.out.print("(1~3)>> ");
			int userPress = scanner.nextInt();
			if(userPress == 1) {
				ClearConsole.clearConsole();
				System.out.println("		여기저기 돌아다니는 중...");
				Random random = new Random();
				int wait = random.nextInt(9000) + 1; //1초부터 10초 사이 랜덤으로 발생
				ConsoleStop.threadSleep(wait);
				
				//1~5층
				if(floor <= 5) {
					List<Monster> monster = level1_Monster;
					int count = level1_Monster.size();
					emergeMonster(monster, count);
				}
				
				//6~10층
				if((floor>5) && (floor <= 10)){
					List<Monster> monster = level2_Monster;
					int count = level2_Monster.size();
					emergeMonster(monster, count);
				}
				
				//11층~15층
				if((floor>10) && (floor <= 15)){
					List<Monster> monster = level3_Monster;
					int count = level3_Monster.size();
					emergeMonster(monster, count);
				}
				
				//16층~20층
				if((floor>15) && (floor <= 20)){
					List<Monster> monster = level4_Monster;
					int count = level4_Monster.size();
					emergeMonster(monster, count);
				}
				
				//21층~25층
				if((floor>20) && (floor <= 25)){
					List<Monster> monster = level5_Monster;
					int count = level5_Monster.size();
					emergeMonster(monster, count);
				}
				
				//26층~30층
				if((floor>25) && (floor <= 30)){
					List<Monster> monster = level6_Monster;
					int count = level6_Monster.size();
					emergeMonster(monster, count);
				}
				
			}
			
			if(userPress == 2) {
				if(floor == 30) {
					System.out.println("		광산의 끝에 도착했어요. 더 이상 내려갈 수 없어요.");
					ConsoleStop.threadSleep(1000);
				}
				else
					floor++;
			}
			
			if(userPress == 3) {
				goTown();
				ConsoleStop.threadSleep(1000);
				return;
				
			}
			
		}
	}
	
	private void emergeMonster(List<Monster> monsterlist, int count) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int monsterCount = random.nextInt(5) + 1; //생성될 몬스터의 수(한 층에 최대 5마리)
		
		for(int i =0; i<monsterCount; i++) {
			int whatMonster = random.nextInt(count); 
			Monster monster = monsterlist.get(whatMonster);
			FileRead.hasThreadTxt(monsterPicture);
			System.out.println("==============================================================");
			System.out.println("		엇! " + monster.getName() + "(이)가 나타났어요!");
			System.out.println("		▶1. 싸우기");
			System.out.println("		▶2. 도망가기(50%의 확률로 가능해요) - hp 10 감소");
			System.out.println("==============================================================");
			
			System.out.print("(1~2)>> ");
			int userPress2 = scanner.nextInt();
			
			if(userPress2 == 1) {
				while(true) {
					if(user.getHp() <= 0) {
						user.die(monster);
						break;
					}
					if(monster.getHp() <= 0) {
						System.out.println("==============================================================");
						System.out.println("		" + monster.getName() + "(을)를 물리쳤어요!");
						monster.die(monster);
						huntCount++;
						System.out.println("		현재 유저 Hp: " + user.getHp() + "/" + user.getMaxHp());
						System.out.println("		현재 유저 골드: " + user.getGold() + "G");
						System.out.println("		현재 " + user.getName() + "님이 잡은 몬스터 수 : " + huntCount + " 마리");
						System.out.println("==============================================================");
						
						//잡은 몬스터 수에 따른 레벨 증가
						int userLevel = user.getLevel();
						if((huntCount == 10) || (huntCount == 30) || (huntCount == 50) ||(huntCount == 100) || (huntCount == 150) ||(huntCount == 200) || (huntCount == 250) || (huntCount == 300) || (huntCount == 500)) { 
							FileRead.hasThreadTxt(levelUp);
							user.setLevel(++userLevel);
							System.out.println("		" + user.getName() +" 님의 레벨이 " + user.getLevel() + " 레벨로 올랐어요!");
						}
						ConsoleStop.threadSleep(1500);
						break;
					}
				
				System.out.println("		" + monster.getName() + "을(를) 공격합니다!");
				user.attack(monster, user);
				System.out.println("		현재 몬스터 Hp: " + monster.getHp() + "/" + monster.getMaxHp());
				ConsoleStop.threadSleep(500);
				System.out.println();
				System.out.println("		" + monster.getName() + "(이)가 " + user.getName() +"에게 반격합니다!");
				monster.attack(monster, user);
				System.out.println("		현재 내 Hp: " + user.getHp() + "/" + user.getMaxHp());
				ConsoleStop.threadSleep(500);
				System.out.println();
				}
			}
			
			if(userPress2 == 2) {
				int isSuccess = random.nextInt(2); //0(실패) or 1(성공)
				if(user.run(isSuccess, 1)) {
					System.out.println("		도망치기 성공! 급하게 도망치느라 30골드를 잃었어요.");
					ConsoleStop.threadSleep(1000);
					break;
				}
				else {
					System.out.println("		도망치기에 실패했어요. ");
					i--;
				}
			}
		}
	}
	
	
	
}
