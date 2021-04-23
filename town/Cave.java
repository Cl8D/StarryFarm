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
	
	//���� ����
	private File monsterPicture = new File("./monster.txt");
	//������ ����
	private File levelUp = new File("./LevelUp.txt");
	//���� ����
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
		System.out.println("		==== ������ �����߽��ϴ�. ====		");
		FileRead.hasThreadTxt(cave);
		ConsoleStop.threadSleep(1500);
		active();
	}

	@Override
	public void active() {
		ClearConsole.clearConsole();
		Scanner scanner = new Scanner(System.in);
		System.out.println("==============================================================");
		System.out.print("		�� ������ �����?(y/n) ");
		String userPress = scanner.next();
		if(userPress.equals("y")) {
			if(user.getWeapon() == null) {
				System.out.println("		���� ���� ���Ⱑ �����. �������� ���� ���� �� �κ��丮���� ������ �ּ���.");
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
			System.out.println("		" + floor + "���� ���Ծ��.");
			System.out.println("		�� 1. " + floor + "�� �����ϱ�");
			int upFloor = floor + 1;
			if(upFloor < 32) {
				System.out.println("		�� 2. " + upFloor +"������ ��������");
			}
			System.out.println("		�� 3. ���� ������ ������");
			System.out.println("==============================================================");
			
			System.out.print("(1~3)>> ");
			int userPress = scanner.nextInt();
			if(userPress == 1) {
				ClearConsole.clearConsole();
				System.out.println("		�������� ���ƴٴϴ� ��...");
				Random random = new Random();
				int wait = random.nextInt(9000) + 1; //1�ʺ��� 10�� ���� �������� �߻�
				ConsoleStop.threadSleep(wait);
				
				//1~5��
				if(floor <= 5) {
					List<Monster> monster = level1_Monster;
					int count = level1_Monster.size();
					emergeMonster(monster, count);
				}
				
				//6~10��
				if((floor>5) && (floor <= 10)){
					List<Monster> monster = level2_Monster;
					int count = level2_Monster.size();
					emergeMonster(monster, count);
				}
				
				//11��~15��
				if((floor>10) && (floor <= 15)){
					List<Monster> monster = level3_Monster;
					int count = level3_Monster.size();
					emergeMonster(monster, count);
				}
				
				//16��~20��
				if((floor>15) && (floor <= 20)){
					List<Monster> monster = level4_Monster;
					int count = level4_Monster.size();
					emergeMonster(monster, count);
				}
				
				//21��~25��
				if((floor>20) && (floor <= 25)){
					List<Monster> monster = level5_Monster;
					int count = level5_Monster.size();
					emergeMonster(monster, count);
				}
				
				//26��~30��
				if((floor>25) && (floor <= 30)){
					List<Monster> monster = level6_Monster;
					int count = level6_Monster.size();
					emergeMonster(monster, count);
				}
				
			}
			
			if(userPress == 2) {
				if(floor == 30) {
					System.out.println("		������ ���� �����߾��. �� �̻� ������ �� �����.");
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
		
		int monsterCount = random.nextInt(5) + 1; //������ ������ ��(�� ���� �ִ� 5����)
		
		for(int i =0; i<monsterCount; i++) {
			int whatMonster = random.nextInt(count); 
			Monster monster = monsterlist.get(whatMonster);
			FileRead.hasThreadTxt(monsterPicture);
			System.out.println("==============================================================");
			System.out.println("		��! " + monster.getName() + "(��)�� ��Ÿ�����!");
			System.out.println("		��1. �ο��");
			System.out.println("		��2. ��������(50%�� Ȯ���� �����ؿ�) - hp 10 ����");
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
						System.out.println("		" + monster.getName() + "(��)�� �����ƾ��!");
						monster.die(monster);
						huntCount++;
						System.out.println("		���� ���� Hp: " + user.getHp() + "/" + user.getMaxHp());
						System.out.println("		���� ���� ���: " + user.getGold() + "G");
						System.out.println("		���� " + user.getName() + "���� ���� ���� �� : " + huntCount + " ����");
						System.out.println("==============================================================");
						
						//���� ���� ���� ���� ���� ����
						int userLevel = user.getLevel();
						if((huntCount == 10) || (huntCount == 30) || (huntCount == 50) ||(huntCount == 100) || (huntCount == 150) ||(huntCount == 200) || (huntCount == 250) || (huntCount == 300) || (huntCount == 500)) { 
							FileRead.hasThreadTxt(levelUp);
							user.setLevel(++userLevel);
							System.out.println("		" + user.getName() +" ���� ������ " + user.getLevel() + " ������ �ö����!");
						}
						ConsoleStop.threadSleep(1500);
						break;
					}
				
				System.out.println("		" + monster.getName() + "��(��) �����մϴ�!");
				user.attack(monster, user);
				System.out.println("		���� ���� Hp: " + monster.getHp() + "/" + monster.getMaxHp());
				ConsoleStop.threadSleep(500);
				System.out.println();
				System.out.println("		" + monster.getName() + "(��)�� " + user.getName() +"���� �ݰ��մϴ�!");
				monster.attack(monster, user);
				System.out.println("		���� �� Hp: " + user.getHp() + "/" + user.getMaxHp());
				ConsoleStop.threadSleep(500);
				System.out.println();
				}
			}
			
			if(userPress2 == 2) {
				int isSuccess = random.nextInt(2); //0(����) or 1(����)
				if(user.run(isSuccess, 1)) {
					System.out.println("		����ġ�� ����! ���ϰ� ����ġ���� 30��带 �Ҿ����.");
					ConsoleStop.threadSleep(1000);
					break;
				}
				else {
					System.out.println("		����ġ�⿡ �����߾��. ");
					i--;
				}
			}
		}
	}
	
	
	
}
