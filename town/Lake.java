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
	
	//����� ����
	private File fish = new File("./getFish.txt");
	//ȣ�� ����
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
		System.out.println("		==== ȣ���� �����߽��ϴ�. ====		");
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
		System.out.println("		���ø� �����ұ��?(y/n) - hp 10 ����	");
		System.out.println("		�⺻���� 100G �Ҹ�˴ϴ�.(���� �����ϼ��� ���� ����)	");
		System.out.println("		���� ���� Hp: " + user.getHp() + "/" + user.getMaxHp());
		System.out.println("		���� ���� ���� ���: " + user.getGold() + "G");
		System.out.print("(y/n) >>");
		String userPress = scanner.next();
		
		if(userPress.equals("y")) {
			if(user.getFishingRod() == null) {
				System.out.println("		���� ���� ���˴밡 �����. �������� �⺻ ���˴븦 �޾� ������!");
				ConsoleStop.threadSleep(1500);
				return;
			}
			else {
				if(!user.buyBait(user.getFishingRod())){
					System.out.println("		�ܾ��� �����մϴ�.		");
					return;
				}
			
			System.out.println("		����⸦ ��ٸ��� ���Դϴ�...	");
			Random random = new Random();
			int wait = random.nextInt(9000) + 1; //1�ʺ��� 10�� ���� �������� �߻�
			ConsoleStop.threadSleep(wait);
			System.out.println("		��! ����Ⱑ �������!		");
		
			if(Farm.getSeason().equals("��")) {
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

			else if(Farm.getSeason().equals("����")) {
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

			else if(Farm.getSeason().equals("����")) {
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
			
			else if(Farm.getSeason().equals("����")) {
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
		if(user.getFishingRod().getName().equals("�� ���˴�"))
			time = 5;
		else if(user.getFishingRod().getName().equals("���� ���˴�"))
			time = 10;
		else if(user.getFishingRod().getName().equals("ö ���˴�"))
			time = 15;
		else if(user.getFishingRod().getName().equals("�̸��� ���˴�"))
			time = 20;
		
		Random random = new Random();
		if(difficulty.equals("easy")) {
			int x = random.nextInt(9) + 1; // 1~9
			int y = random.nextInt(9) + 1; 
			int result = x * y;
			System.out.println("		���� �ð� " + time + "��!");
			System.out.print("		" + x + " x " + y + " = ? => ");
			fishTime(time, result, whatFish.getName());
		}
		
		else if(difficulty.equals("medium")) {
			int x = random.nextInt(90) + 10; // 10~99
			int y = random.nextInt(9) + 1; // 1~9
			int z = random.nextInt(90) + 10;
			int result = x * y + z;
			System.out.println("		���� �ð� " + time + "��!");
			System.out.print("		(" + x + " x " + y + ") + " + z + " = ? => ");
			fishTime(time, result, whatFish.getName());
		}
		
		else if(difficulty.equals("hard")) {
			int x = random.nextInt(90) + 10; // 10~99
			int y = random.nextInt(90) + 10;
			int z = random.nextInt(400) + 100; //100~499 
			int result = x * y + z;
			System.out.println("		���� �ð� " + time + "��!");
			System.out.print("		(" + x + " x " + y + ") + " + z + " = ? => ");
			fishTime(time, result, whatFish.getName());
		}
		
		else if(difficulty.equals("expert")) {
			int x =  random.nextInt(900) + 100; // 100~999 
			int y = random.nextInt(90) + 10; 
			int z = random.nextInt(9000) + 1000; // 1000~9999
			int result = x * y + z;
			System.out.println("		���� �ð� " + time + "��!");
			System.out.print("		(" + x + " x " + y + ") + " + z + " = ? => ");
			fishTime(time, result, whatFish.getName());
		}
		
		
	}
	private void fishTime(int time, int result, String fishName) {
		Scanner scanner = new Scanner(System.in);
		int oldTime = (int)System.currentTimeMillis() / 1000;
		int userResult = scanner.nextInt();
		int newTime = (int)System.currentTimeMillis() / 1000 - oldTime; // �ɸ� �ð�
		
		if(newTime <= time) {
			if(result == userResult) {
				FileRead.hasThreadTxt(fish);
				System.out.println("		���! " + fishName + "��(��) ��Ҿ��!");
				getFish(fishName);
				ConsoleStop.threadSleep(1000);
			}
			else 
				System.out.println("		����⸦ ���ƾ��. �ٽ� ������ ������ �ؿ�!");
		}
		else
			System.out.println("		" + time + "�ʰ� ������ ����Ⱑ �������Ⱦ��. (�ɸ� �ð�: " + newTime + "��)");	
		ConsoleStop.threadSleep(1000);
	}
	
	private void getFish(String fishName) {
		if(fishName.equals("����ġ"))
			Inventory.springF1++;
		if(fishName.equals("����"))
			Inventory.springF2++;
		if(fishName.equals("��ġ"))
			Inventory.springF3++;
		if(fishName.equals("���"))
			Inventory.springF4++;
		if(fishName.equals("���ڹ�"))
			Inventory.springF5++;
		if(fishName.equals("������ �����"))
			Inventory.springF6++;
		
		if(fishName.equals("����"))
			Inventory.summerF1++;
		if(fishName.equals("ƿ���Ǿ�"))
			Inventory.summerF2++;
		if(fishName.equals("����"))
			Inventory.summerF3++;
		if(fishName.equals("��ġ"))
			Inventory.summerF4++;
		if(fishName.equals("����"))
			Inventory.summerF5++;
		if(fishName.equals("ũ�����ǽ�"))
			Inventory.summerF6++;
		
		if(fishName.equals("���"))
			Inventory.autumnF1++;
		if(fishName.equals("����"))
			Inventory.autumnF2++;
		if(fishName.equals("Ÿ�̰� �۾�"))
			Inventory.autumnF3++;
		if(fishName.equals("�ޱ�"))
			Inventory.autumnF4++;
		if(fishName.equals("������"))
			Inventory.autumnF5++;
		if(fishName.equals("�Ʊ�"))
			Inventory.autumnF6++;
		
		if(fishName.equals("û��"))
			Inventory.winterF1++;
		if(fishName.equals("��¡��"))
			Inventory.winterF2++;
		if(fishName.equals("��ġ"))
			Inventory.winterF3++;
		if(fishName.equals("��ġ"))
			Inventory.winterF4++;
		if(fishName.equals("���뷡��"))
			Inventory.winterF5++;
		if(fishName.equals("���� �����"))
			Inventory.winterF6++;
	}
	
}
