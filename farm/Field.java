package farm;

import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import console.ClearConsole;
import console.ConsoleStop;
import console.FileRead;
import console.FileWrite;
import character.Farmer;
import character.UserInfo;
import item.Fruit;
import item.Seed;

public class Field extends UserInfo{
	/*** ��ü ���� ***/
	static Farm myFarm = new Farm();
	private static int ableFarming;
	private static int firstFarming =  0;
	private static int seedCount = 0; // ���� ������ �� ����
	private static int fruitCount = 0; // ����� ������ �� ���� 
	
	// ���� ���� ��
	private static int springP_day = 999;
	private static int springG_day = 999;
	private static int springC_day = 999;
	private static int springM_day = 999;
	private static int springS_day = 999;
	
	private static int summerM_day = 999;
	private static int summerR_day = 999;
	private static int summerB_day = 999;
	private static int summerT_day = 999;
	private static int summerS_day = 999;
	
	private static int autumnM_day = 999;
	private static int autumnG_day = 999;
	private static int autumnA_day = 999;
	private static int autumnC_day = 999;
	private static int autumnP_day = 999;
	
	// ���� ����
	private static int springP, springG, springC, springM, springS; 
	private static int summerM, summerR, summerB, summerT, summerS;
	private static int autumnM, autumnG, autumnA, autumnC, autumnP;
	
	private static List <Seed> springSeeds;
	private static List <Seed> summerSeeds;
	private static List <Seed> autumnSeeds;
	
	private static List<Fruit> springFruits;
	private static List<Fruit> summerFruits;
	private static List<Fruit> autumnFruits;
	
	//�̹��� ����
	private static File field = new File("./basicField.txt"); // �Թ� 
	private static File hoe = new File("./hoe.txt"); // ����
	private static File fertilizer = new File("./fertilizer.txt"); //���
	private static File seed = new File("./seed.txt"); // ����
	private static File getFruit = new File("./getFruit.txt"); //���� ��Ȯ
	
	static Socket socket;
	
	public Field(String seed, List<Seed> springSeed , List<Seed> summerSeed, List<Seed> autumnSeed) {
		Field.springSeeds = springSeed;
		Field.summerSeeds = summerSeed;
		Field.autumnSeeds = autumnSeed;
		this.socket = super.getSocket();

	}
	

	public Field(List<Fruit> springFruit, List<Fruit> summerFruit, List<Fruit> autumnFruit) {
		Field.springFruits = springFruit;
		Field.summerFruits = summerFruit;
		Field.autumnFruits = autumnFruit;
		this.socket = super.getSocket();
	}
	
	
	public static int getAbleFarming() {
		return ableFarming;
	}
	public static void setAbleFarming(int ableFarming) {
		Field.ableFarming = ableFarming;
	}
	
	private static void showMyField() {
		ClearConsole.clearConsole();
		System.out.println("==============================================================");
		System.out.println("		���� �Թ� �����Դϴ�. 		");
		System.out.println("		��: �ƹ��͵� ���� ���� ��, ��: ������ �� ��, ��: ��� �Ѹ� ��");
		FileRead.hasNotThreadTxt(field);
		System.out.println("==============================================================");
	}
	
	public static boolean hasNew() {
		if((Farm.day >= springP_day) || (Farm.day >= springG_day) || (Farm.day >= springC_day) || (Farm.day >= springM_day) || (Farm.day >= springS_day)) 
			return true;
		else if((Farm.day >= summerM_day) || (Farm.day >= summerR_day) || (Farm.day >= summerB_day) || (Farm.day >= summerT_day) || (Farm.day >= summerS_day)) 
			return true;
	
		else if((Farm.day >= autumnM_day) || (Farm.day >= autumnG_day) || (Farm.day >= autumnA_day) || (Farm.day >= autumnC_day) || (Farm.day >= autumnP_day)) 
			return true;

		else
			return false;
	}
	
	public static void manageMyField() {
		while(true) {
		//�ƹ��͵� ���� ��
		String[] basicField = new String[10];
		for(int i =0; i< 10; i++) {
			basicField[i] = "�����������";
		}
		
		if(seedCount == fruitCount) {
			FileWrite.hasNotThreadTxt(field, basicField);
		}
		
		showMyField();
		System.out.println("==============================================================");
		System.out.println("		������ �ұ��?		");
		System.out.println("		��1. �������	");
		if((Farm.day >= springP_day) || (Farm.day >= springG_day) || (Farm.day >= springC_day) || (Farm.day >= springM_day) || (Farm.day >= springS_day)) 
			System.out.println("		��2. ��Ȯ�ϱ�(NEW!)		");
		else if((Farm.day >= summerM_day) || (Farm.day >= summerR_day) || (Farm.day >= summerB_day) || (Farm.day >= summerT_day) || (Farm.day >= summerS_day)) 
			System.out.println("		��2. ��Ȯ�ϱ�(NEW!)		");
		else if((Farm.day >= autumnM_day) || (Farm.day >= autumnG_day) || (Farm.day >= autumnA_day) || (Farm.day >= autumnC_day) || (Farm.day >= autumnP_day)) 
			System.out.println("		��2. ��Ȯ�ϱ�(NEW!)		");		
		else
			System.out.println("		��2. ��Ȯ�ϱ�		");
		System.out.println("		��3. ����� �۹� ����(Hp ä���)	");
		System.out.println("		��0. �ڷ� ����		");
		
		System.out.println("==============================================================");
		Scanner scanner = new Scanner(System.in);
	
			System.out.print("(1~3)>>");
			int userPress = 0;
			userPress = scanner.nextInt();
			switch(userPress) {
			case 0 :
				return;
			case 1 :
				if((user.getHoe() == null) || (user.getSickle() == null)) {
					System.out.println("		���� ���� ������ �����. �������� �⺻ �������� �޾� ������!");
					ConsoleStop.threadSleep(1000);
					myFarm.myFarm();
				}
				if(firstFarming == 0) {
					firstFarming++;
					doFarming();
				}
				
				else if(ableFarming < 0) {
					doFarming();
				}
				else {
					System.out.println("		��縦 ���� �� �� �� �ƾ��. ��� �۹��� ���� ������ ���� �Ұ����ؿ�.		");
					System.out.println("		" + (ableFarming + 1) + "�� �ڿ� ��簡 �����ؿ�.");
					ConsoleStop.threadSleep(1000);
				}
				break;
			case 2 :
				getFruit();
				break;
			case 3 :
				eatFruit();
				break;

			default: 
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���.");
		}
			
		}
	}
	
	/******************��� ����****************/
	private static void doFarming() {
		while(true) {
		ClearConsole.clearConsole();
		System.out.println("==============================================================");
		System.out.println("		��� ���� ���� ������ ������ �ּ���		");
		System.out.println("		��1. 3 x 3	");
		System.out.println("		��2. 5 x 5		");
		System.out.println("		��3. 10 x 10(ALL)	");
		System.out.println("		��0. �ڷ� ����		");
		System.out.println("==============================================================");
		
		Scanner scanner = new Scanner(System.in);
		
			System.out.print("(0~3)>>");
			int userPress = 0;
			userPress = scanner.nextInt();
			switch(userPress) {
			case 0 :
				return;
			case 1 :
				mulThree();
				break;
			case 2 :
				mulFive();
				break;
			case 3 :
				mulAll();
				break;
			default: 
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���.");
		}
			
		}
	}

	/**************3x3***************/
	private static void mulThree() {
		Scanner scanner = new Scanner(System.in);
		//������ �� �� ǥ��
		String[] mulThree = new String[10];
		mulThree[0] = "�ȢȢȡ�������";
		mulThree[1] = "�ȢȢȡ�������";
		mulThree[2] = "�ȢȢȡ�������";
		for(int i =3; i< 10; i++) {
			mulThree[i] = "�����������";
		}
		
		//��� �Ѹ� �� ǥ��
		String[] mulThree_fer = new String[10];
		mulThree_fer[0] = "�ˢˢˡ�������";
		mulThree_fer[1] = "�ˢˢˡ�������";
		mulThree_fer[2] = "�ˢˢˡ�������";
		for(int i =3; i< 10; i++) {
			mulThree_fer[i] = "�����������";
		}
		
		System.out.println("==============================================================");
		System.out.println("		**�������� �����մϴ�.**		");
		user.doFarming();
		
		FileRead.hasThreadTxt(hoe);
		FileWrite.hasNotThreadTxt(field, mulThree);
		showMyField();
		ConsoleStop.threadSleep(1500);
		
		System.out.println("==============================================================");
		System.out.println("		**��Ḧ �Ѹ��ϴ�.(�⺻: 100��� �Ҹ�), ������ ���� ���� �ݾ� �޶���**		");
		
		if(user.buyFertilizer(3, user.getHoe())) {
			FileRead.hasThreadTxt(fertilizer);
			FileWrite.hasNotThreadTxt(field, mulThree_fer);
		}
		else {
			System.out.println("		�ܾ��� �����մϴ�.		");
			ConsoleStop.threadSleep(1000);
			return;
		}
		
		showMyField();
		ConsoleStop.threadSleep(1500);
		
		ClearConsole.clearConsole();
		System.out.println("==============================================================");
		System.out.println("		**������ �Ѹ��ϴ�.**		");
		System.out.println("		������ �����ϰ� �ִ� ����		");
		Inventory.showSeed();
		ConsoleStop.threadSleep(1500);
		if(Inventory.getSeedCount() > 9) {
			System.out.println("		������ 9������ �Ѹ� �� �־��. ���� �� ũ�� ���� �ּ���.");
			ConsoleStop.threadSleep(1000);
			return;
		}
		
		giveSeed();
		user.doFarming();
		
	}
	
	/**************5x5**************/
	private static void mulFive() {
			//������ �� �� ǥ��
				String[] mulFive = new String[10];
				mulFive[0] = "�ȢȢȢȢȡ�����";
				mulFive[1] = "�ȢȢȢȢȡ�����";
				mulFive[2] = "�ȢȢȢȢȡ�����";
				mulFive[3] = "�ȢȢȢȢȡ�����";
				mulFive[4] = "�ȢȢȢȢȡ�����";
				for(int i =5; i< 10; i++) {
					mulFive[i] = "�����������";
				}
				
				//��� �Ѹ� �� ǥ��
				String[] mulFive_fer = new String[10];
				mulFive_fer[0] = "�ˢˢˢˢˡ�����";
				mulFive_fer[1] = "�ˢˢˢˢˡ�����";
				mulFive_fer[2] = "�ˢˢˢˢˡ�����";
				mulFive_fer[3] = "�ˢˢˢˢˡ�����";
				mulFive_fer[4] = "�ˢˢˢˢˡ�����";
				for(int i =5; i< 10; i++) {
					mulFive_fer[i] = "�����������";
				}
				
				System.out.println("==============================================================");
				System.out.println("		**�������� �����մϴ�.**		");
				user.doFarming();
				FileRead.hasThreadTxt(hoe);
				FileWrite.hasNotThreadTxt(field, mulFive);
				
				showMyField();
				ConsoleStop.threadSleep(1500);
				
				System.out.println("==============================================================");
				System.out.println("		**��Ḧ �Ѹ��ϴ�.(�⺻: 200��� �Ҹ�), ������ ���� ���� �ݾ� �޶���**		");
				if(user.buyFertilizer(5, user.getHoe())) {
					FileRead.hasThreadTxt(fertilizer);
					FileWrite.hasNotThreadTxt(field, mulFive_fer);
				}
				else {
					System.out.println("		�ܾ��� �����մϴ�.		");
					return;
				}
				
				showMyField();
				ConsoleStop.threadSleep(1500);
				
				ClearConsole.clearConsole();
				System.out.println("==============================================================");
				System.out.println("		**������ �Ѹ��ϴ�.**		");
				System.out.println("		������ �����ϰ� �ִ� ����		");
				Inventory.showSeed();
				ConsoleStop.threadSleep(1500);
				if(Inventory.getSeedCount() > 25) {
					System.out.println("		������ 25������ �Ѹ� �� �־��. ���� �� ũ�� ���� �ּ���.");
					ConsoleStop.threadSleep(1000);
					return;
				}
				
				giveSeed();
				user.doFarming();	
			}
	
	/***********10x10***************/
	private static void mulAll() {
		//������ �� �� ǥ��
			String[] mulAll = new String[10];
			for(int i =0; i< 10; i++) {
				mulAll[i] = "�ȢȢȢȢȢȢȢȢȢ�";
			}
			//��� �Ѹ� �� ǥ��
			String[] mulAll_fer = new String[10];
			for(int i =0; i< 10; i++) {
				mulAll_fer[i] = "�ˢˢˢˢˢˢˢˢˢ�";
			}
			
			System.out.println("==============================================================");
			System.out.println("		**�������� �����մϴ�.**		");
			user.doFarming();
			FileRead.hasThreadTxt(hoe);
			FileWrite.hasNotThreadTxt(field, mulAll);
			
			showMyField();
			ConsoleStop.threadSleep(1500);
			
			System.out.println("==============================================================");
			System.out.println("		**��Ḧ �Ѹ��ϴ�.(�⺻: 300��� �Ҹ�, ������ ���� ���� �ݾ� �޶���)**		");
			if(user.buyFertilizer(10, user.getHoe())) {
				FileRead.hasThreadTxt(fertilizer);
				FileWrite.hasNotThreadTxt(field, mulAll_fer);
			}
			else {
				System.out.println("		�ܾ��� �����մϴ�.		");
				return;
			}
			
			showMyField();
			ConsoleStop.threadSleep(1500);
			
			ClearConsole.clearConsole();
			System.out.println("==============================================================");
			System.out.println("		**������ �Ѹ��ϴ�.**		");
			System.out.println("		������ �����ϰ� �ִ� ����		");
			Inventory.showSeed();
			System.out.println();
			ConsoleStop.threadSleep(1500);
			giveSeed();
			user.doFarming();	
		}
	
	/*********������ ���� �ɱ�***********/
	private static void giveSeed() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
		ClearConsole.clearConsole();
		System.out.println("=================================================");
		System.out.println("		���� ������ �Ѹ����?(1-5): ");
		System.out.println("		(�ڷ� ����: 0)		");
		Inventory.showSeed();
		int userPress = scanner.nextInt();
		
		if(userPress == 0)
			return;
		
		//�� �۹�
		if(Farm.getSeason().equals("��")) {
			if(userPress == 1) {
				if(Farmer.getSpringP().size() > 0) {
					System.out.println("		" + springSeeds.get(0).getName() + " " + Farmer.getSpringP().size() + "���� �ѷȾ��.");
					seedCount += Farmer.getSpringP().size();
					springP_day = Farm.day + 4;
					if(ableFarming < 4)
						ableFarming = 4;
					springP = Farmer.getSpringP().size();
					for(int i = 0; i< springP; i++) 
						Farmer.getSpringP().remove(0);
					FileRead.hasThreadTxt(seed);
				}
				else
					System.out.println("		" + springSeeds.get(0).getName() + "�� �����.");
			}
			
			if(userPress == 2) {
				if(Farmer.getSpringG().size() > 0) {
					System.out.println("		" + springSeeds.get(1).getName() + " "+ Farmer.getSpringG().size() + "���� �ѷȾ��.");
					seedCount += Farmer.getSpringG().size();
					springG_day = Farm.day + 6;
					if(ableFarming < 6)
						ableFarming = 6;
					springG = Farmer.getSpringG().size();
					for(int i = 0; i< springG; i++) 
						Farmer.getSpringG().remove(0);
					FileRead.hasThreadTxt(seed);
				}
				else
					System.out.println("		" + springSeeds.get(1).getName() + "�� �����.");
			}
			
			if(userPress == 3) {
				if(Farmer.getSpringC().size() > 0) {
					System.out.println("		" + springSeeds.get(2).getName() + " " + Farmer.getSpringC().size() + "���� �ѷȾ��.");
					seedCount += Farmer.getSpringC().size();
					springC_day = Farm.day + 12;
					if(ableFarming < 12)
						ableFarming = 12;
					springC = Farmer.getSpringC().size();
					for(int i = 0; i< springC; i++) 
						Farmer.getSpringC().remove(0);
					FileRead.hasThreadTxt(seed);
				}
				else
					System.out.println("		" + springSeeds.get(2).getName() + "�� �����.");
			}
			
			if(userPress == 4) {
				if(Farmer.getSpringM().size() > 0) {
					System.out.println("		" + springSeeds.get(3).getName() + " "+ Farmer.getSpringM().size() + "���� �ѷȾ��.");
					seedCount += Farmer.getSpringM().size();
					springM_day = Farm.day + 4;
					if(ableFarming < 4)
						ableFarming = 4;
					springM = Farmer.getSpringM().size();
					for(int i = 0; i< springM; i++) 
						Farmer.getSpringM().remove(0);
					FileRead.hasThreadTxt(seed);
				}
				else
					System.out.println("		" + springSeeds.get(3).getName() + "�� �����.");
			}
			
			if(userPress == 5) {
				if(Farmer.getSpringS().size() > 0) {
					System.out.println("		" + springSeeds.get(4).getName() + " " + Farmer.getSpringS().size() + "���� �ѷȾ��.");
					seedCount += Farmer.getSpringS().size();
					springS_day = Farm.day + 8;
					if(ableFarming < 8)
						ableFarming = 8;
					springS = Farmer.getSpringS().size();
					for(int i = 0; i< springS; i++) 
						Farmer.getSpringS().remove(0);
					FileRead.hasThreadTxt(seed);
				}
				else
					System.out.println("		" + springSeeds.get(4).getName() + "�� �����.");
			}
		}
			
		//���� �۹�
			else if(Farm.getSeason().equals("����")) {
				if(userPress == 1) {
					if(Farmer.getSummerM().size() > 0) {
						System.out.println("		" + summerSeeds.get(0).getName() + " " + Farmer.getSummerM().size() + "���� �ѷȾ��.");
						seedCount += Farmer.getSummerM().size();
						summerM_day = Farm.day + 12;
						if(ableFarming < 12)
							ableFarming = 12;
						summerM = Farmer.getSummerM().size();
						for(int i = 0; i< summerM; i++)
							Farmer.getSummerM().remove(0);
						FileRead.hasThreadTxt(seed);
					}
					else
						System.out.println("		" + summerSeeds.get(0).getName() + "�� �����.");
				}
				
				if(userPress == 2) {
					if(Farmer.getSummerR().size() > 0) {
						System.out.println("		" + summerSeeds.get(1).getName() + " " + Farmer.getSummerR().size() + "���� �ѷȾ��.");
						seedCount += Farmer.getSummerR().size();
						summerR_day = Farm.day + 9;
						if(ableFarming < 9)
							ableFarming = 9;
						summerR = Farmer.getSummerR().size();
						for(int i = 0; i< summerR; i++)
							Farmer.getSummerR().remove(0);
						FileRead.hasThreadTxt(seed);
					}
					else
						System.out.println("		" + summerSeeds.get(1).getName() + "�� �����.");
				}
				
				if(userPress == 3) {
					if(Farmer.getSummerB().size() > 0) {
						System.out.println("		" + summerSeeds.get(2).getName() + " " + Farmer.getSummerB().size() + "���� �ѷȾ��.");
						seedCount += Farmer.getSummerB().size();
						summerB_day = Farm.day + 5;
						if(ableFarming < 5)
							ableFarming = 5;
						summerB = Farmer.getSummerB().size();
						for(int i = 0; i< summerB; i++)
							Farmer.getSummerB().remove(0);
						FileRead.hasThreadTxt(seed);
					}
					else
						System.out.println("		" + summerSeeds.get(2).getName() + "�� �����.");
				}
				
				if(userPress == 4) {
					if(Farmer.getSummerT().size() > 0) {
						System.out.println("		" + summerSeeds.get(3).getName() + " " + Farmer.getSummerT().size() + "���� �ѷȾ��.");
						seedCount += Farmer.getSummerT().size();
						summerT_day = Farm.day + 6;
						if(ableFarming < 6)
							ableFarming = 6;
						summerT = Farmer.getSummerT().size();
						for(int i = 0; i< summerT; i++)
							Farmer.getSummerT().remove(0);
						FileRead.hasThreadTxt(seed);
					}
					else
						System.out.println("		" + summerSeeds.get(3).getName() + "�� �����.");
				}
				
				if(userPress == 5) {
					if(Farmer.getSummerS().size() > 0) {
						System.out.println("		" + summerSeeds.get(4).getName() + " " + Farmer.getSummerS().size() + "���� �ѷȾ��.");
						seedCount += Farmer.getSummerS().size();
						summerS_day = Farm.day + 13;
						if(ableFarming < 13)
							ableFarming = 13;
						summerS = Farmer.getSummerS().size();
						for(int i = 0; i< summerS; i++)
							Farmer.getSummerS().remove(0);
						FileRead.hasThreadTxt(seed);
					}
					else
						System.out.println("		" + summerSeeds.get(4).getName() + "�� �����.");
				}
			}
		
		// ���� �۹�
			else if(Farm.getSeason().equals("����")) {
				if(userPress == 1) {
					if(Farmer.getAutumnM().size() > 0) {
						System.out.println("		" + autumnSeeds.get(0).getName() + " " + Farmer.getAutumnM().size() + "���� �ѷȾ��.");
						seedCount += Farmer.getAutumnM().size();
						autumnM_day = Farm.day + 10;
						if(ableFarming < 10)
							ableFarming = 10;
						autumnM = Farmer.getAutumnM().size();
						for(int i = 0; i<autumnM; i++)
							Farmer.getAutumnM().remove(0);
						FileRead.hasThreadTxt(seed);
					}
					else
						System.out.println("		" + autumnSeeds.get(0).getName() + "�� �����.");
				}
				
				if(userPress == 2) {
					if(Farmer.getAutumnG().size() > 0) {
						System.out.println("		" + autumnSeeds.get(1).getName() + " " + Farmer.getAutumnG().size() + "���� �ѷȾ��.");
						seedCount += Farmer.getAutumnG().size();
						autumnG_day = Farm.day + 14;
						if(ableFarming < 14)
							ableFarming = 14;
						autumnG = Farmer.getAutumnG().size();
						for(int i = 0; i< autumnG; i++)
							Farmer.getAutumnG().remove(0);
						FileRead.hasThreadTxt(seed);
					}
					else
						System.out.println("		" + autumnSeeds.get(1).getName() + "�� �����.");
				}
				
				if(userPress == 3) {
					if(Farmer.getAutumnA().size() > 0) {
						System.out.println("		" + autumnSeeds.get(2).getName() + " " + Farmer.getAutumnA().size() + "���� �ѷȾ��.");
						seedCount += Farmer.getAutumnA().size();
						autumnA_day = Farm.day + 7;
						if(ableFarming < 7)
							ableFarming = 7;
						autumnA = Farmer.getAutumnA().size();
						for(int i = 0; i< autumnA; i++)
							Farmer.getAutumnA().remove(0);
						FileRead.hasThreadTxt(seed);
					}
					else
						System.out.println("		" + autumnSeeds.get(2).getName() + "�� �����.");
				}
				
				if(userPress == 4) {
					if(Farmer.getAutumnC().size() > 0) {
						System.out.println("		" + autumnSeeds.get(3).getName() + " " + Farmer.getAutumnC().size() + "���� �ѷȾ��.");
						seedCount += Farmer.getAutumnC().size();
						autumnC_day = Farm.day + 4;
						if(ableFarming < 4)
							ableFarming = 4;
						autumnC = Farmer.getAutumnC().size();
						for(int i = 0; i< autumnC; i++)
							Farmer.getAutumnC().remove(0);
						FileRead.hasThreadTxt(seed);
					}
					else
						System.out.println("		" + autumnSeeds.get(3).getName() + "�� �����.");
				}
				
				if(userPress == 5) {
					if(Farmer.getAutumnP().size() > 0) {
						System.out.println("		" + autumnSeeds.get(4).getName() + " " + Farmer.getAutumnP().size() + "���� �ѷȾ��.");
						seedCount += Farmer.getAutumnP().size();
						autumnP_day = Farm.day + 13;
						if(ableFarming < 13)
							ableFarming = 13;
						autumnP = Farmer.getAutumnP().size();
						for(int i = 0; i< autumnP; i++)
							Farmer.getAutumnP().remove(0);
						FileRead.hasThreadTxt(seed);
					}
					else
						System.out.println("		" + autumnSeeds.get(4).getName() + "�� �����.");
				}
			}
		}
	}

	/*************����ϱ�***************/
	private static void getFruit() {
		Scanner scanner = new Scanner(System.in);
		ClearConsole.clearConsole();
		System.out.println("==============================================================");
		System.out.println("		����� �� �ִ� ���� ����Դϴ�.		");
		System.out.println("		������ϴ� �� �ɸ��� �ð���	");
		System.out.println("		���� �۹�) �Ľ���: 4��, ����: 6��, �ݸ��ö��: 12��, ����: 4��, ����: 8��	");
		System.out.println("		������ �۹�) ���: 12��, ���� �����: 9��, ��纣��: 5��, �丶��: 6��, ��Ÿ�ĸ���: 13��	");
		System.out.println("		������ �۹�) ��: 10��, ����: 14��, �Ƹ�����: 7��, û��ä: 4��, ȣ��: 13��	");
		System.out.println();
		
		if(Farm.season.equals("��")) {
			int i = 1;
			if(Farm.day >= springP_day) {
				System.out.println("		" + i + ". " + springFruits.get(0).getName() + " ����: " + springP +"��");
				i++;
			}
			if(Farm.day >= springG_day) {
				System.out.println("		" + i + ". " + springFruits.get(1).getName() + " ����: " + springG +"��");
				i++;
			}
			if(Farm.day >= springC_day) {
				System.out.println("		" + i + ". " + springFruits.get(2).getName() + " ����: " + springC +"��");
				i++;
			}
			if(Farm.day >= springM_day) {
				System.out.println("		" + i + ". " + springFruits.get(3).getName() + " ����: " + springM +"��");
				i++;
			}
			if(Farm.day >= springS_day) {
				System.out.println("		" + i + ". " + springFruits.get(4).getName() + " ����: " + springS +"��");
				i++;
			}
			
			if(i==1) {
				System.out.println("------------------------------------------------------------------");
				System.out.println("		���� ���Ű� ������ �ʾҾ��.			");
				System.out.println("------------------------------------------------------------------");
				ConsoleStop.threadSleep(1000);
			}
			else
				getWhatFruit();
		}	
		
		else if(Farm.season.equals("����")) {
			int i = 1;
			if(Farm.day >= summerM_day) {
				System.out.println("		" + i + ". " + summerFruits.get(0).getName() + " ����: " + summerM +"��");
				i++;
			}
			if(Farm.day >= summerR_day) {
				System.out.println("		" + i + ". " + summerFruits.get(1).getName() + " ����: " + summerR +"��");
				i++;
			}
			if(Farm.day >= summerB_day) {
				System.out.println("		" + i + ". " + summerFruits.get(2).getName() + " ����: " + summerB +"��");
				i++;
			}
			if(Farm.day >= summerT_day) {
				System.out.println("		" + i + ". " + summerFruits.get(3).getName() + " ����: " + summerT +"��");
				i++;
			}
			if(Farm.day >= summerS_day) {
				System.out.println("		" + i + ". " + summerFruits.get(4).getName() + " ����: " + summerS +"��");
				i++;
			}
			
			if(i==1) {
				System.out.println("------------------------------------------------------------------");
				System.out.println("		���� ���Ű� ������ �ʾҾ��.			");
				System.out.println("------------------------------------------------------------------");
			}
			else
				getWhatFruit();
		}	
		
		else if(Farm.season.equals("����")) {
			int i = 1;
			if(Farm.day >= autumnM_day) {
				System.out.println("		" + i + ". " + autumnFruits.get(0).getName() + " ����: " + autumnM +"��");
				i++;
			}
			if(Farm.day >= autumnG_day) {
				System.out.println("		" + i + ". " + autumnFruits.get(1).getName() + " ����: " + autumnG +"��");
				i++;
			}
			if(Farm.day >= autumnA_day) {
				System.out.println("		" + i + ". " + autumnFruits.get(2).getName() + " ����: " + autumnA +"��");
				i++;
			}
			if(Farm.day >= autumnC_day) {
				System.out.println("		" + i + ". " + autumnFruits.get(3).getName() + " ����: " + autumnC +"��");
				i++;
			}
			if(Farm.day >= autumnP_day) {
				System.out.println("		" + i + ". " + autumnFruits.get(4).getName() + " ����: " + autumnP +"��");
				i++;
			}
			
			if(i==1) {
				System.out.println("------------------------------------------------------------------");
				System.out.println("		���� ���Ű� ������ �ʾҾ��.			");
				System.out.println("------------------------------------------------------------------");
			}
			else
				getWhatFruit();
		}
		
		System.out.println("==============================================================");
			
	}
	
	private static void getWhatFruit() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("		������ ��Ȯ�Ϸ��� 'y'�� ���� �ּ���		");
		System.out.println("		�ڷ� ����: n");
		String userPress = scanner.next();
		if(userPress.equals("n"))
			return;
		
		if(userPress.equals("y")) {
			int todayFruitCount = 0;
			FileRead.hasThreadTxt(getFruit);
			if(Farm.season.equals("��")) {
				if(Farm.day >= springP_day) {
					System.out.println("		" + springFruits.get(0).getName() + " ���� " + springP +"���� ��Ȯ�߾��.");
					fruitCount += springP;
					todayFruitCount += springP;
					Inventory.springP += springP;
					springP = 0;
					springP_day = 999;		
				}
				if(Farm.day >= springG_day) {
					System.out.println("		" + springFruits.get(1).getName() + " ���� " + springG +"���� ��Ȯ�߾��.");
					fruitCount += springG;
					todayFruitCount += springG;
					Inventory.springG += springG;
					springG = 0;
					springG_day = 999;
				}
				if(Farm.day >= springC_day) {
					System.out.println("		" + springFruits.get(2).getName() + " ���� "  + springC +"���� ��Ȯ�߾��.");
					fruitCount += springC;
					todayFruitCount += springC;
					Inventory.springC += springC;
					springC = 0;
					springC_day = 999;
				}
				if(Farm.day >= springM_day) {
					System.out.println("		" + springFruits.get(3).getName() + " ���� "  + springM +"���� ��Ȯ�߾��.");
					fruitCount += springM;
					todayFruitCount += springM;
					Inventory.springM += springM;
					springM = 0;
					springM_day = 999;
				}
				if(Farm.day >= springS_day) {
					System.out.println("		" + springFruits.get(4).getName() + " ���� "  + springS +"���� ��Ȯ�߾��.");
					fruitCount += springS;
					todayFruitCount += springS;
					Inventory.springS += springS;
					springS = 0;
					springS_day = 999;
				}
			}	
			
			else if(Farm.season.equals("����")) {
				if(Farm.day >= summerM_day) {
					System.out.println("		" + summerFruits.get(0).getName() + " ���� " + summerM +"���� ��Ȯ�߾��.");
					fruitCount += summerM;
					todayFruitCount += summerM;
					Inventory.summerM += summerM;
					summerM = 0;
					summerM_day = 999;
				}
				if(Farm.day >= summerR_day) {
					System.out.println("		" + summerFruits.get(1).getName() + " ���� " + summerR +"���� ��Ȯ�߾��.");
					fruitCount += summerR;
					todayFruitCount += summerR;
					Inventory.summerR += summerR;
					summerR = 0;
					summerR_day = 999;
				}
				if(Farm.day >= summerB_day) {
					System.out.println("		" + summerFruits.get(2).getName() + " ���� " + summerB +"���� ��Ȯ�߾��.");
					fruitCount += summerB;
					todayFruitCount += summerB;
					Inventory.summerB += summerB;
					summerB = 0;
					summerB_day = 999;
				}
				if(farm.Farm.day >= summerT_day) {
					System.out.println("		" + summerFruits.get(3).getName() + " ���� " + summerT +"���� ��Ȯ�߾��.");
					fruitCount += summerT;
					todayFruitCount += summerT;
					Inventory.summerT += summerT;
					summerT = 0;
					summerT_day = 999;
				}
				if(Farm.day >= summerS_day) {
					System.out.println("		" + summerFruits.get(4).getName() + " ���� " + summerS +"���� ��Ȯ�߾��.");
					fruitCount += summerS;
					todayFruitCount += summerS;
					Inventory.summerS += summerS;
					summerS = 0;
					summerS_day = 999;
				}
			}	
			
			else if(Farm.season.equals("����")) {
				if(Farm.day >= autumnM_day) {
					System.out.println("		" + autumnFruits.get(0).getName() + " ���� " + autumnM +"���� ��Ȯ�߾��.");
					fruitCount += autumnM;
					todayFruitCount += autumnM;
					Inventory.autumnM += autumnM;
					autumnM = 0;
					autumnM_day = 999;
				}
				if(Farm.day >= autumnG_day) {
					System.out.println("		" + autumnFruits.get(1).getName() + " ���� "+ autumnG +"���� ��Ȯ�߾��.");
					fruitCount += autumnG;
					todayFruitCount += autumnG;
					Inventory.autumnG += autumnG;
					autumnG = 0;
					autumnG_day = 999;
				}
				if(Farm.day >= autumnA_day) {
					System.out.println("		" + autumnFruits.get(2).getName() + " ���� "+ autumnA +"���� ��Ȯ�߾��.");
					fruitCount += autumnA;
					todayFruitCount += autumnA;
					Inventory.autumnA += autumnA;
					autumnA = 0;
					autumnA_day = 999;
				}
				if(Farm.day >= autumnC_day) {
					System.out.println("		" + autumnFruits.get(3).getName() + " ���� "+ autumnC +"���� ��Ȯ�߾��.");
					fruitCount += autumnC;
					todayFruitCount += autumnC;
					Inventory.autumnC += autumnC;
					autumnC = 0;
					autumnC_day = 999;
				}
				if(Farm.day >= autumnP_day) {
					System.out.println("		" + autumnFruits.get(4).getName() + " ���� "+ autumnP +"���� ��Ȯ�߾��.");
					fruitCount += autumnP;
					todayFruitCount += autumnP;
					Inventory.autumnP += autumnP;
					autumnP = 0;
					autumnP_day = 999;
				}
			}
			
		
			if(user.getSickle().getName().equals("���� ��")) {
				int gold = 50 * todayFruitCount;
				System.out.println("		���� �� ���ʽ� ����(�۹� �� ���� 50G):" + gold + "G");
				user.setGold(gold);
			}
			else if(user.getSickle().getName().equals("ö ��")) {
				int gold = 100 * todayFruitCount;
				System.out.println("		ö �� ���ʽ� ����(�۹� �� ���� 100G):" + gold + "G");
				user.setGold(gold);
			}
			if(user.getSickle().getName().equals("�̸��� ��")) {
				int gold = 200 * todayFruitCount;
				System.out.println("		�̸��� �� ���ʽ� ����(�۹� �� ���� 200G):" + gold + "G");
				user.setGold(gold);
			}
			
			ConsoleStop.threadSleep(1500);
		}
		
		else {
			System.out.println("		���� ��Ȯ�� ����߾��.		 ");
			return;
		}
	}
	
	private static void eatFruit() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			ClearConsole.clearConsole();
			System.out.println("=================================================");
			System.out.println("		������ ������ �������?		");
			System.out.println("		(�ڷ� ����: 0)		");
			System.out.println("		������ ���� ���� �ٷ��̢�		");
			Inventory.showFruit();
			int userPress = scanner.nextInt();
			if(userPress == 0)
				return;
			
			//�� �۹�
			if(Farm.getSeason().equals("��")) {
				if(userPress == 1) {
					if(Inventory.springP > 0) {
						System.out.println("		" + springFruits.get(0).getName()  +" ���Ÿ� �Ծ����.");
						Inventory.springP--;
						int hp = user.getHp();
						hp += springFruits.get(0).getRecoverHp();
						user.setHp(hp);
					}
					else
						System.out.println("		" + springFruits.get(0).getName() + " ���Ű� �����.");
				}
				
				if(userPress == 2) {
					if(Inventory.springG > 0) {
						System.out.println("		" + springFruits.get(1).getName()  +" ���Ÿ� �Ծ����.");
						Inventory.springG--;
						int hp = user.getHp();
						hp += springFruits.get(1).getRecoverHp();
						user.setHp(hp);
					}
					else
						System.out.println("		" + springFruits.get(1).getName() + " ���Ű� �����.");
				}
				
				if(userPress == 3) {
					if(Inventory.springC > 0) {
						System.out.println("		" + springFruits.get(2).getName()  +" ���Ÿ� �Ծ����.");
						Inventory.springC--;
						int hp = user.getHp();
						hp += springFruits.get(2).getRecoverHp();
						user.setHp(hp);
					}
					else
						System.out.println("		" + springFruits.get(2).getName() + " ���Ű� �����.");
				}
				
				if(userPress == 4) {
					if(Inventory.springM > 0) {
						System.out.println("		" + springFruits.get(3).getName()  +" ���Ÿ� �Ծ����.");
						Inventory.springM--;
						int hp = user.getHp();
						hp += springFruits.get(3).getRecoverHp();
						user.setHp(hp);
					}
					else
						System.out.println("		" + springFruits.get(3).getName() + " ���Ű� �����.");
				}
				
				if(userPress == 5) {
					if(Inventory.springS > 0) {
						System.out.println("		" + springFruits.get(4).getName()  +" ���Ÿ� �Ծ����.");
						Inventory.springS--;
						int hp = user.getHp();
						hp += springFruits.get(4).getRecoverHp();
						user.setHp(hp);
					}
					else
						System.out.println("		" + springFruits.get(4).getName() + " ���Ű� �����.");
				}
				
				System.out.println("		���� Hp: " + user.getHp() + "/" + user.getMaxHp());
			}
				
			//���� �۹�
				else if(Farm.getSeason().equals("����")) {
					if(userPress == 1) {
						if(Inventory.summerM > 0) {
							System.out.println("		" + summerFruits.get(0).getName()  +" ���Ÿ� �Ծ����.");
							Inventory.summerM--;
							int hp = user.getHp();
							hp += summerFruits.get(0).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + summerFruits.get(0).getName() + " ���Ű� �����.");
					}
					
					if(userPress == 2) {
						if(Inventory.summerR > 0) {
							System.out.println("		" + summerFruits.get(1).getName()  +" ���Ÿ� �Ծ����.");
							Inventory.summerR--;
							int hp = user.getHp();
							hp += summerFruits.get(1).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + summerFruits.get(1).getName() + " ���Ű� �����.");
					}
					
					if(userPress == 3) {
						if(Inventory.summerB > 0) {
							System.out.println("		" + summerFruits.get(2).getName()  +" ���Ÿ� �Ծ����.");
							Inventory.summerB--;
							int hp = user.getHp();
							hp += summerFruits.get(2).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + summerFruits.get(2).getName() + " ���Ű� �����.");
					}
					
					if(userPress == 4) {
						if(Inventory.summerT > 0) {
							System.out.println("		" + summerFruits.get(3).getName()  +" ���Ÿ� �Ծ����.");
							Inventory.summerT--;
							int hp = user.getHp();
							hp += summerFruits.get(3).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + summerFruits.get(3).getName() + " ���Ű� �����.");
					}
					
					if(userPress == 5) {
						if(Inventory.summerS > 0) {
							System.out.println("		" + summerFruits.get(4).getName()  +" ���Ÿ� �Ծ����.");
							Inventory.summerS--;
							int hp = user.getHp();
							hp += summerFruits.get(4).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + summerFruits.get(4).getName() + " ���Ű� �����.");
					}
					
					System.out.println("		���� Hp: " + user.getHp() + "/" + user.getMaxHp());
				}
			
			// ���� �۹�
				else if(Farm.getSeason().equals("����")) {
					if(userPress == 1) {
						if(Inventory.autumnM > 0) {
							System.out.println("		" + autumnFruits.get(0).getName()  +" ���Ÿ� �Ծ����.");
							Inventory.autumnM--;
							int hp = user.getHp();
							hp += autumnFruits.get(0).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + autumnFruits.get(0).getName() + " ���Ű� �����.");
					}
					
					if(userPress == 2) {
						if(Inventory.autumnG > 0) {
							System.out.println("		" + autumnFruits.get(1).getName()  +" ���Ÿ� �Ծ����.");
							Inventory.autumnG--;
							int hp = user.getHp();
							hp += autumnFruits.get(1).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + autumnFruits.get(1).getName() + " ���Ű� �����.");
					}
					
					if(userPress == 3) {
						if(Inventory.autumnA > 0) {
							System.out.println("		" + autumnFruits.get(2).getName()  +" ���Ÿ� �Ծ����.");
							Inventory.autumnA--;
							int hp = user.getHp();
							hp += autumnFruits.get(2).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + autumnFruits.get(2).getName() + " ���Ű� �����.");
					}
					
					if(userPress == 4) {
						if(Inventory.autumnC > 0) {
							System.out.println("		" + autumnFruits.get(3).getName()  +" ���Ÿ� �Ծ����.");
							Inventory.autumnC--;
							int hp = user.getHp();
							hp += autumnFruits.get(3).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + autumnFruits.get(3).getName() + " ���Ű� �����.");
					}
					
					if(userPress == 5) {
						if(Inventory.autumnP > 0) {
							System.out.println("		" + autumnFruits.get(4).getName()  +" ���Ÿ� �Ծ����.");
							Inventory.autumnP--;
							int hp = user.getHp();
							hp += autumnFruits.get(4).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + autumnFruits.get(4).getName() + " ���Ű� �����.");
					}
					
					System.out.println("		���� Hp: " + user.getHp() + "/" + user.getMaxHp());
				}
			
			ConsoleStop.threadSleep(1000);
			
			System.out.println("---------------------------------------------------------------------");
			}
	}
}

