package farm;

import java.util.List;
import java.util.Scanner;

import console.ClearConsole;
import console.ConsoleStop;
import character.Farmer;
import character.UserInfo;
import item.Fish;
import item.Fruit;
import item.Seed;
import item.Tool;

public class Inventory extends UserInfo{
	
	protected static int fruitCount = 0; // ����� ����
	protected static int fishCount = 0; // �����
	protected static int weaponCount = 0; //����(���� óġ��)
	protected static int toolCount = 0; // ����(���۹� �� ���ÿ�)
	protected static int seedCount = 0; // ����
	protected static int allCount = 0;
	
	// ���� ����
	protected static int springP = 0; // �Ľ���
	protected static int springG = 0; // ����
	protected static int springC = 0; // �ݸ��ö��
	protected static int springM = 0; //����
	protected static int springS = 0; //����
	
	protected static int summerM = 0; // ���
	protected static int summerR = 0; // ���� �����
	protected static int summerB = 0; // ��纣��
	protected static int summerT = 0; // �丶��
	protected static int summerS = 0; // ��Ÿ�ĸ���
	
	protected static int autumnM = 0; // ��
	protected static int autumnG = 0; // ����
	protected static int autumnA = 0; // �Ƹ�����
	protected static int autumnC = 0; // û��ä
	protected static int autumnP = 0; // ȣ��
	
	//����� ��
	public static int springF1 = 0; //����ġ
	public static int springF2 = 0; //����
	public static int springF3 = 0; //��ġ
	public static int springF4 = 0; //���
	public static int springF5 = 0; //���ڹ�
	public static int springF6 = 0; //������ �����
	
	public static int summerF1 = 0; //����
	public static int summerF2 = 0; //ƿ���Ǿ�
	public static int summerF3 = 0; //����
	public static int summerF4 = 0; //��ġ
	public static int summerF5 = 0; //����
	public static int summerF6 = 0; //ũ�����ǽ�
	
	public static int autumnF1 = 0; //���
	public static int autumnF2 = 0; //����
	public static int autumnF3 = 0; //Ÿ�̰� �۾�
	public static int autumnF4 = 0; //�ޱ�
	public static int autumnF5 = 0; //������
	public static int autumnF6 = 0; //�Ʊ�
	
	public static int winterF1 = 0; //û��
	public static int winterF2 = 0; //��¡��
	public static int winterF3 = 0; //��ġ
	public static int winterF4 = 0; //��ġ
	public static int winterF5 = 0; //���뷡��
	public static int winterF6 = 0; //���� �����
	
	private static List <Seed> springSeeds;
	private static List <Seed> summerSeeds;
	private static List <Seed> autumnSeeds;
	
	protected static List<Fruit> springFruits;
	protected static List<Fruit> summerFruits;
	protected static List<Fruit> autumnFruits;
	
	protected static List <Fish> springFishes;
	protected static List <Fish> summerFishes;
	protected static List <Fish> autumnFishes;
	protected static List <Fish> winterFishes;
	
	
	public Inventory(List<Fruit> springFruit, List<Fruit> summerFruit, List<Fruit> autumnFruit) {
		Inventory.springFruits = springFruit;
		Inventory.summerFruits = summerFruit;
		Inventory.autumnFruits = autumnFruit;
	}
	
	public Inventory(String seed, List<Seed> springSeed , List<Seed> summerSeed, List<Seed> autumnSeed) {
		Inventory.springSeeds = springSeed;
		Inventory.summerSeeds = summerSeed;
		Inventory.autumnSeeds = autumnSeed;
	}
	
	public Inventory(List<Fish> springFishes, List<Fish> summerFishes, List<Fish> autumnFishes, List<Fish> winterFishes) {
		Inventory.springFishes = springFishes;
		Inventory.summerFishes = summerFishes;
		Inventory.autumnFishes = autumnFishes;
		Inventory.winterFishes = winterFishes;
	}

	
	public Inventory() {
		;
	}

	protected void showInventory(){
		fishCount = springF1 + springF2 + springF3 + springF4 + springF5 + springF6 + summerF1 + summerF2 +  summerF3 +  summerF4 + summerF5 +  summerF6 + autumnF1 + autumnF2 + autumnF3 + autumnF4 + autumnF5 + autumnF6 + winterF1 + winterF2 + winterF3 + winterF4 + winterF5 + winterF6;
		fruitCount = springP + springG + springC + springM + springS + summerM + summerR + summerB + summerT + summerS + autumnM + autumnG + autumnA + autumnC + autumnP;
		weaponCount = user.getWeapons().size();
		toolCount = user.getTools().size();
		seedCount = Farmer.getSpringP().size() + Farmer.getSpringG().size() + Farmer.getSpringC().size() + Farmer.getSpringM().size() + Farmer.getSpringS().size() +  Farmer.getSummerM().size() + Farmer.getSummerR().size() + Farmer.getSummerB().size() + Farmer.getSummerT().size() + Farmer.getSpringS().size() + Farmer.getAutumnM().size() + Farmer.getAutumnG().size() + Farmer.getAutumnA().size() + Farmer.getAutumnC().size() + Farmer.getAutumnP().size();
		allCount =  seedCount + fruitCount + fishCount + weaponCount + toolCount;
		ClearConsole.clearConsole();
		System.out.println("------------------------------------------------------------------");
		System.out.println("		�κ��丮 â�� Ȯ���մϴ�.		");
		if(allCount == 0) {
			System.out.println("		������ �ִ� �� �ƹ��͵� �����.		");
		}
		
		else {
			System.out.println("		������ ����		");
			for(int i =0; i< weaponCount; i++) 
				System.out.println("		��" + (i+1) + ". " + user.getWeapons().get(i).getName());
			
			System.out.println();
			System.out.println("		������ ����		");
			for(int i=0; i< toolCount; i++)
				System.out.println("		��" + (i+1) + ". " + user.getTools().get(i).getName());
			System.out.println();
			System.out.println("		������ ����		");
				showSeed();	
			System.out.println();
			System.out.println("		������ ����		");
				showFruit();
			System.out.println();
			System.out.println("		������ �����		");
				showFish();
				
		System.out.println();
		System.out.println("		---------------------------------");
		System.out.print("		���� �� ���⸦ �����Ͻðڽ��ϱ�?(y/other keys) ");
			Scanner scanner = new Scanner(System.in);
			String userPress = scanner.next();
			if(userPress.equals("y")) {
				if((user.getFishingRod() == null) || (user.getHoe() == null) || (user.getSickle() == null)) {
					System.out.println("		���� ���� ������ �����. �������� �⺻ �������� �޾� ������!");
					ConsoleStop.threadSleep(1000);
					return;
				}
				
				System.out.println("		���� ������ ���� ������ ���� ���Դϴ�.		");
				
				for(int i=0; i< user.getTools().size(); i++) {
					if(user.getTools().get(i).getName().equals("���� ����")) 
							user.setHoe(user.getTools().get(i));
					
					if(user.getTools().get(i).getName().equals("���� ��"))
							user.setSickle(user.getTools().get(i));
					
						
					if(user.getTools().get(i).getName().equals("���� ���˴�")) 
							user.setFishingRod(user.getTools().get(i));
					
					
					if(user.getTools().get(i).getName().equals("ö ����")) 
							user.setHoe(user.getTools().get(i));	
					
					
					if(user.getTools().get(i).getName().equals("ö ��"))
							user.setSickle(user.getTools().get(i));
					
					
					if(user.getTools().get(i).getName().equals("ö ���˴�"))
							user.setFishingRod(user.getTools().get(i));
					
								
					if(user.getTools().get(i).getName().equals("�̸��� ����"))
							user.setHoe(user.getTools().get(i));
				
					
					if(user.getTools().get(i).getName().equals("�̸��� ��"))
							user.setSickle(user.getTools().get(i));	
					
					
					if(user.getTools().get(i).getName().equals("�̸��� ���˴�")) 
							user.setFishingRod(user.getTools().get(i));	
				}
				
				System.out.println("		���� ���� ���� ����: " + user.getHoe().getName() + ", " + user.getSickle().getName() + ", " + user.getFishingRod().getName());
				
				
				if((user.getWeapons() == null)) {
					System.out.println("		���� ���� ���Ⱑ �����. �������� ���� ���� �� �κ��丮���� ������ �ּ���.");
					ConsoleStop.threadSleep(1500);
					return;
				}
				
				System.out.println("		���� ������ ���� ���⸦ ���� ���Դϴ�.		");
				
				
				for(int i=0; i< user.getWeapons().size(); i++) {
					if(user.getWeapons().get(i).getName().equals("�콼 ��")) 
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("���� ��")) 
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("��ö �ܰ�"))
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("�� �ܰ�")) 
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("ĿƲ��")) 
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("����� ��")) 
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("��� ��")) 
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("�ż��� ��"))
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("��� ��")) 
							user.setWeapon(user.getWeapons().get(i));	
					
					if(user.getWeapons().get(i).getName().equals("������ ��")) 
							user.setWeapon(user.getWeapons().get(i));
				}
				
				if(user.getWeapon() == null) {
					System.out.println("		���� ���� ���Ⱑ �����. �������� ���� ���� �� �κ��丮���� ������ �ּ���.");
					ConsoleStop.threadSleep(1500);
					return;
				}
				
				System.out.println("		���� ���� ���� ����: " + user.getWeapon().getName());
				
			}
		}
		System.out.println("------------------------------------------------------------------");
	}
	
	protected static void showSeed() {
		if(Farm.getSeason().equals("��")) {
			System.out.println("		1. " + springSeeds.get(0).getName() + ": ---------- " + Farmer.getSpringP().size() +"��");
			System.out.println("		2. " + springSeeds.get(1).getName() + ": ---------- " + Farmer.getSpringG().size() +"��");
			System.out.println("		3. " + springSeeds.get(2).getName() + ": ---------- " + Farmer.getSpringC().size() +"��");
			System.out.println("		4. " + springSeeds.get(3).getName() + ": ---------- " + Farmer.getSpringM().size() +"��");
			System.out.println("		5. " + springSeeds.get(4).getName() + ": ---------- " + Farmer.getSpringS().size() +"��");
			seedCount = Farmer.getSpringP().size() + Farmer.getSpringG().size() + Farmer.getSpringC().size() + Farmer.getSpringM().size() + Farmer.getSpringS().size();

		}
		else if(Farm.getSeason().equals("����")) {
			System.out.println("		1. " + summerSeeds.get(0).getName() + ": ---------- " + Farmer.getSummerM().size() +"��");
			System.out.println("		2. " + summerSeeds.get(1).getName() + ": ---------- " + Farmer.getSummerR().size() +"��");
			System.out.println("		3. " + summerSeeds.get(2).getName() + ": ---------- " + Farmer.getSummerB().size() +"��");
			System.out.println("		4. " + summerSeeds.get(3).getName() + ": ---------- " + Farmer.getSummerT().size() +"��");
			System.out.println("		5. " + summerSeeds.get(4).getName() + ": ---------- " + Farmer.getSummerS().size() +"��");
			seedCount = Farmer.getSummerM().size() + Farmer.getSummerR().size() + Farmer.getSummerB().size() + Farmer.getSummerT().size() + Farmer.getSpringS().size();
		}
		else if(Farm.getSeason().equals("����")) {
			System.out.println("		1. " + autumnSeeds.get(0).getName() + ": ---------- " + Farmer.getAutumnM().size() +"��");
			System.out.println("		2. " + autumnSeeds.get(0).getName() + ": ---------- " + Farmer.getAutumnG().size() +"��");
			System.out.println("		3. " + autumnSeeds.get(0).getName() + ": ---------- " + Farmer.getAutumnA().size() +"��");
			System.out.println("		4. " + autumnSeeds.get(0).getName() + ": ---------- " + Farmer.getAutumnC().size() +"��");
			System.out.println("		5. " + autumnSeeds.get(0).getName() + ": ---------- " + Farmer.getAutumnP().size() +"��");
			seedCount = Farmer.getAutumnM().size() + Farmer.getAutumnG().size() + Farmer.getAutumnA().size() + Farmer.getAutumnC().size() + Farmer.getAutumnP().size();
		}
	}
	
	protected static int getSeedCount() {
		return seedCount;
	}
	
	protected static void showFruit() {
		if(Farm.getSeason().equals("��")) {
			System.out.println("		1. " + springFruits.get(0).getName() + ": ---------- " + springP +"��");
			System.out.println("		2. " + springFruits.get(1).getName() + ": ---------- " + springG +"��");
			System.out.println("		3. " + springFruits.get(2).getName() + ": ---------- " + springC +"��");
			System.out.println("		4. " + springFruits.get(3).getName() + ": ---------- " + springM +"��");
			System.out.println("		5. " + springFruits.get(4).getName() + ": ---------- " + springS +"��");
		}
		else if(Farm.getSeason().equals("����")) {
			System.out.println("		1. " + summerFruits.get(0).getName() + ": ---------- " + summerM +"��");
			System.out.println("		2. " + summerFruits.get(1).getName() + ": ---------- " + summerR +"��");
			System.out.println("		3. " + summerFruits.get(2).getName() + ": ---------- " + summerB +"��");
			System.out.println("		4. " + summerFruits.get(3).getName() + ": ---------- " + summerT +"��");
			System.out.println("		5. " + summerFruits.get(4).getName() + ": ---------- " + summerS +"��");
		}
		else if(Farm.getSeason().equals("����")) {
			System.out.println("		1. " + autumnFruits.get(0).getName() + ": ---------- " + autumnM +"��");
			System.out.println("		2. " + autumnFruits.get(1).getName() + ": ---------- " + autumnG +"��");
			System.out.println("		3. " + autumnFruits.get(2).getName() + ": ---------- " + autumnA +"��");
			System.out.println("		4. " + autumnFruits.get(3).getName() + ": ---------- " + autumnC +"��");
			System.out.println("		5. " + autumnFruits.get(4).getName() + ": ---------- " + autumnP +"��");
		}
	}
	
	protected static void showFish() {
		if(Farm.getSeason().equals("��")) {
			System.out.println("		1. " + springFishes.get(0).getName() + ": ---------- " + springF1+"����");
			System.out.println("		2. " + springFishes.get(1).getName() + ": ---------- " + springF2 +"����");
			System.out.println("		3. " + springFishes.get(2).getName() + ": ---------- " + springF3 +"����");
			System.out.println("		4. " + springFishes.get(3).getName() + ": ---------- " + springF4 +"����");
			System.out.println("		5. " + springFishes.get(4).getName() + ": ---------- " + springF5 +"����");
			System.out.println("		6. " + springFishes.get(5).getName() + ": ---------- " + springF6 +"����");
		}
		else if(Farm.getSeason().equals("����")) {
			System.out.println("		1. " + summerFishes.get(0).getName() + ": ---------- " + summerF1 +"����");
			System.out.println("		2. " + summerFishes.get(1).getName() + ": ---------- " + summerF2 +"����");
			System.out.println("		3. " + summerFishes.get(2).getName() + ": ---------- " + summerF3 +"����");
			System.out.println("		4. " + summerFishes.get(3).getName() + ": ---------- " + summerF4 +"����");
			System.out.println("		5. " + summerFishes.get(4).getName() + ": ---------- " + summerF5 +"����");
			System.out.println("		6. " + summerFishes.get(5).getName() + ": ---------- " + summerF6 +"����");
		}
		else if(Farm.getSeason().equals("����")) {
			System.out.println("		1. " + autumnFishes.get(0).getName() + ": ---------- " + autumnF1 +"��");
			System.out.println("		2. " + autumnFishes.get(1).getName() + ": ---------- " + autumnF2 +"��");
			System.out.println("		3  " + autumnFishes.get(2).getName() + ": ---------- " + autumnF3 +"��");
			System.out.println("		4. " + autumnFishes.get(3).getName() + ": ---------- " + autumnF4 +"��");
			System.out.println("		5. " + autumnFishes.get(4).getName() + ": ---------- " + autumnF5 +"��");
			System.out.println("		6. " + autumnFishes.get(5).getName() + ": ---------- " + autumnF6 +"��");
		}
		else if(Farm.getSeason().equals("����")) {
			System.out.println("		1. " + winterFishes.get(0).getName() + ": ---------- " + winterF1 +"��");
			System.out.println("		2. " + winterFishes.get(1).getName() + ": ---------- " + winterF2 +"��");
			System.out.println("		3. " + winterFishes.get(2).getName() + ": ---------- " + winterF3 +"��");
			System.out.println("		4. " + winterFishes.get(3).getName() + ": ---------- " + winterF4 +"��");
			System.out.println("		5. " + winterFishes.get(4).getName() + ": ---------- " + winterF5 +"��");
			System.out.println("		6. " + winterFishes.get(5).getName() + ": ---------- " + winterF6 +"��");
		}
	}
	
	// �⺻ ���� ����
	public static void setBasicTool(Tool sickle, Tool hoe, Tool fishingRod) {
		user.setHoe(hoe);
		user.setSickle(sickle);
		user.setFishingRod(fishingRod);
	}
	
	//��Ÿ�ĸ��� �޾ƿ���(winterStory ����)
	public static int getSummerS() {
		return summerS;
	}
	
	public static void setSummerS(int summerS) {
		Inventory.summerS = summerS;
	}
}
