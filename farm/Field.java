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
	/*** 객체 생성 ***/
	static Farm myFarm = new Farm();
	private static int ableFarming;
	private static int firstFarming =  0;
	private static int seedCount = 0; // 심은 씨앗의 총 개수
	private static int fruitCount = 0; // 재배한 과일의 총 개수 
	
	// 과일 생성 날
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
	
	// 과일 개수
	private static int springP, springG, springC, springM, springS; 
	private static int summerM, summerR, summerB, summerT, summerS;
	private static int autumnM, autumnG, autumnA, autumnC, autumnP;
	
	private static List <Seed> springSeeds;
	private static List <Seed> summerSeeds;
	private static List <Seed> autumnSeeds;
	
	private static List<Fruit> springFruits;
	private static List<Fruit> summerFruits;
	private static List<Fruit> autumnFruits;
	
	//이미지 파일
	private static File field = new File("./basicField.txt"); // 텃밭 
	private static File hoe = new File("./hoe.txt"); // 괭이
	private static File fertilizer = new File("./fertilizer.txt"); //비료
	private static File seed = new File("./seed.txt"); // 씨앗
	private static File getFruit = new File("./getFruit.txt"); //열매 수확
	
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
		System.out.println("		현재 텃밭 상태입니다. 		");
		System.out.println("		□: 아무것도 하지 않은 땅, ▥: 괭이질 한 땅, ▦: 비료 뿌린 땅");
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
		//아무것도 없는 땅
		String[] basicField = new String[10];
		for(int i =0; i< 10; i++) {
			basicField[i] = "□□□□□□□□□□";
		}
		
		if(seedCount == fruitCount) {
			FileWrite.hasNotThreadTxt(field, basicField);
		}
		
		showMyField();
		System.out.println("==============================================================");
		System.out.println("		무엇을 할까요?		");
		System.out.println("		▶1. 농사짓기	");
		if((Farm.day >= springP_day) || (Farm.day >= springG_day) || (Farm.day >= springC_day) || (Farm.day >= springM_day) || (Farm.day >= springS_day)) 
			System.out.println("		▶2. 수확하기(NEW!)		");
		else if((Farm.day >= summerM_day) || (Farm.day >= summerR_day) || (Farm.day >= summerB_day) || (Farm.day >= summerT_day) || (Farm.day >= summerS_day)) 
			System.out.println("		▶2. 수확하기(NEW!)		");
		else if((Farm.day >= autumnM_day) || (Farm.day >= autumnG_day) || (Farm.day >= autumnA_day) || (Farm.day >= autumnC_day) || (Farm.day >= autumnP_day)) 
			System.out.println("		▶2. 수확하기(NEW!)		");		
		else
			System.out.println("		▶2. 수확하기		");
		System.out.println("		▶3. 재배한 작물 섭취(Hp 채우기)	");
		System.out.println("		▶0. 뒤로 가기		");
		
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
					System.out.println("		보유 중인 도구가 없어요. 상점에서 기본 도구들을 받아 오세요!");
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
					System.out.println("		농사를 지은 지 얼마 안 됐어요. 모든 작물이 재배될 때까지 농사는 불가능해요.		");
					System.out.println("		" + (ableFarming + 1) + "일 뒤에 농사가 가능해요.");
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
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
		}
			
		}
	}
	
	/******************농사 짓기****************/
	private static void doFarming() {
		while(true) {
		ClearConsole.clearConsole();
		System.out.println("==============================================================");
		System.out.println("		농사 지을 땅의 면적을 선택해 주세요		");
		System.out.println("		▶1. 3 x 3	");
		System.out.println("		▶2. 5 x 5		");
		System.out.println("		▶3. 10 x 10(ALL)	");
		System.out.println("		▶0. 뒤로 가기		");
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
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
		}
			
		}
	}

	/**************3x3***************/
	private static void mulThree() {
		Scanner scanner = new Scanner(System.in);
		//괭이질 한 땅 표현
		String[] mulThree = new String[10];
		mulThree[0] = "▥▥▥□□□□□□□";
		mulThree[1] = "▥▥▥□□□□□□□";
		mulThree[2] = "▥▥▥□□□□□□□";
		for(int i =3; i< 10; i++) {
			mulThree[i] = "□□□□□□□□□□";
		}
		
		//비료 뿌린 땅 표현
		String[] mulThree_fer = new String[10];
		mulThree_fer[0] = "▦▦▦□□□□□□□";
		mulThree_fer[1] = "▦▦▦□□□□□□□";
		mulThree_fer[2] = "▦▦▦□□□□□□□";
		for(int i =3; i< 10; i++) {
			mulThree_fer[i] = "□□□□□□□□□□";
		}
		
		System.out.println("==============================================================");
		System.out.println("		**괭이질을 시작합니다.**		");
		user.doFarming();
		
		FileRead.hasThreadTxt(hoe);
		FileWrite.hasNotThreadTxt(field, mulThree);
		showMyField();
		ConsoleStop.threadSleep(1500);
		
		System.out.println("==============================================================");
		System.out.println("		**비료를 뿌립니다.(기본: 100골드 소모), 도구에 따라 차감 금액 달라짐**		");
		
		if(user.buyFertilizer(3, user.getHoe())) {
			FileRead.hasThreadTxt(fertilizer);
			FileWrite.hasNotThreadTxt(field, mulThree_fer);
		}
		else {
			System.out.println("		잔액이 부족합니다.		");
			ConsoleStop.threadSleep(1000);
			return;
		}
		
		showMyField();
		ConsoleStop.threadSleep(1500);
		
		ClearConsole.clearConsole();
		System.out.println("==============================================================");
		System.out.println("		**씨앗을 뿌립니다.**		");
		System.out.println("		▶현재 보유하고 있는 씨앗		");
		Inventory.showSeed();
		ConsoleStop.threadSleep(1500);
		if(Inventory.getSeedCount() > 9) {
			System.out.println("		씨앗은 9개까지 뿌릴 수 있어요. 밭을 더 크게 갈아 주세요.");
			ConsoleStop.threadSleep(1000);
			return;
		}
		
		giveSeed();
		user.doFarming();
		
	}
	
	/**************5x5**************/
	private static void mulFive() {
			//괭이질 한 땅 표현
				String[] mulFive = new String[10];
				mulFive[0] = "▥▥▥▥▥□□□□□";
				mulFive[1] = "▥▥▥▥▥□□□□□";
				mulFive[2] = "▥▥▥▥▥□□□□□";
				mulFive[3] = "▥▥▥▥▥□□□□□";
				mulFive[4] = "▥▥▥▥▥□□□□□";
				for(int i =5; i< 10; i++) {
					mulFive[i] = "□□□□□□□□□□";
				}
				
				//비료 뿌린 땅 표현
				String[] mulFive_fer = new String[10];
				mulFive_fer[0] = "▦▦▦▦▦□□□□□";
				mulFive_fer[1] = "▦▦▦▦▦□□□□□";
				mulFive_fer[2] = "▦▦▦▦▦□□□□□";
				mulFive_fer[3] = "▦▦▦▦▦□□□□□";
				mulFive_fer[4] = "▦▦▦▦▦□□□□□";
				for(int i =5; i< 10; i++) {
					mulFive_fer[i] = "□□□□□□□□□□";
				}
				
				System.out.println("==============================================================");
				System.out.println("		**괭이질을 시작합니다.**		");
				user.doFarming();
				FileRead.hasThreadTxt(hoe);
				FileWrite.hasNotThreadTxt(field, mulFive);
				
				showMyField();
				ConsoleStop.threadSleep(1500);
				
				System.out.println("==============================================================");
				System.out.println("		**비료를 뿌립니다.(기본: 200골드 소모), 도구에 따라 차감 금액 달라짐**		");
				if(user.buyFertilizer(5, user.getHoe())) {
					FileRead.hasThreadTxt(fertilizer);
					FileWrite.hasNotThreadTxt(field, mulFive_fer);
				}
				else {
					System.out.println("		잔액이 부족합니다.		");
					return;
				}
				
				showMyField();
				ConsoleStop.threadSleep(1500);
				
				ClearConsole.clearConsole();
				System.out.println("==============================================================");
				System.out.println("		**씨앗을 뿌립니다.**		");
				System.out.println("		▶현재 보유하고 있는 씨앗		");
				Inventory.showSeed();
				ConsoleStop.threadSleep(1500);
				if(Inventory.getSeedCount() > 25) {
					System.out.println("		씨앗은 25개까지 뿌릴 수 있어요. 밭을 더 크게 갈아 주세요.");
					ConsoleStop.threadSleep(1000);
					return;
				}
				
				giveSeed();
				user.doFarming();	
			}
	
	/***********10x10***************/
	private static void mulAll() {
		//괭이질 한 땅 표현
			String[] mulAll = new String[10];
			for(int i =0; i< 10; i++) {
				mulAll[i] = "▥▥▥▥▥▥▥▥▥▥";
			}
			//비료 뿌린 땅 표현
			String[] mulAll_fer = new String[10];
			for(int i =0; i< 10; i++) {
				mulAll_fer[i] = "▦▦▦▦▦▦▦▦▦▦";
			}
			
			System.out.println("==============================================================");
			System.out.println("		**괭이질을 시작합니다.**		");
			user.doFarming();
			FileRead.hasThreadTxt(hoe);
			FileWrite.hasNotThreadTxt(field, mulAll);
			
			showMyField();
			ConsoleStop.threadSleep(1500);
			
			System.out.println("==============================================================");
			System.out.println("		**비료를 뿌립니다.(기본: 300골드 소모, 도구에 따라 차감 금액 달라짐)**		");
			if(user.buyFertilizer(10, user.getHoe())) {
				FileRead.hasThreadTxt(fertilizer);
				FileWrite.hasNotThreadTxt(field, mulAll_fer);
			}
			else {
				System.out.println("		잔액이 부족합니다.		");
				return;
			}
			
			showMyField();
			ConsoleStop.threadSleep(1500);
			
			ClearConsole.clearConsole();
			System.out.println("==============================================================");
			System.out.println("		**씨앗을 뿌립니다.**		");
			System.out.println("		▶현재 보유하고 있는 씨앗		");
			Inventory.showSeed();
			System.out.println();
			ConsoleStop.threadSleep(1500);
			giveSeed();
			user.doFarming();	
		}
	
	/*********계절별 씨앗 심기***********/
	private static void giveSeed() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
		ClearConsole.clearConsole();
		System.out.println("=================================================");
		System.out.println("		무슨 씨앗을 뿌릴까요?(1-5): ");
		System.out.println("		(뒤로 가기: 0)		");
		Inventory.showSeed();
		int userPress = scanner.nextInt();
		
		if(userPress == 0)
			return;
		
		//봄 작물
		if(Farm.getSeason().equals("봄")) {
			if(userPress == 1) {
				if(Farmer.getSpringP().size() > 0) {
					System.out.println("		" + springSeeds.get(0).getName() + " " + Farmer.getSpringP().size() + "개를 뿌렸어요.");
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
					System.out.println("		" + springSeeds.get(0).getName() + "이 없어요.");
			}
			
			if(userPress == 2) {
				if(Farmer.getSpringG().size() > 0) {
					System.out.println("		" + springSeeds.get(1).getName() + " "+ Farmer.getSpringG().size() + "개를 뿌렸어요.");
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
					System.out.println("		" + springSeeds.get(1).getName() + "이 없어요.");
			}
			
			if(userPress == 3) {
				if(Farmer.getSpringC().size() > 0) {
					System.out.println("		" + springSeeds.get(2).getName() + " " + Farmer.getSpringC().size() + "개를 뿌렸어요.");
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
					System.out.println("		" + springSeeds.get(2).getName() + "이 없어요.");
			}
			
			if(userPress == 4) {
				if(Farmer.getSpringM().size() > 0) {
					System.out.println("		" + springSeeds.get(3).getName() + " "+ Farmer.getSpringM().size() + "개를 뿌렸어요.");
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
					System.out.println("		" + springSeeds.get(3).getName() + "이 없어요.");
			}
			
			if(userPress == 5) {
				if(Farmer.getSpringS().size() > 0) {
					System.out.println("		" + springSeeds.get(4).getName() + " " + Farmer.getSpringS().size() + "개를 뿌렸어요.");
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
					System.out.println("		" + springSeeds.get(4).getName() + "이 없어요.");
			}
		}
			
		//여름 작물
			else if(Farm.getSeason().equals("여름")) {
				if(userPress == 1) {
					if(Farmer.getSummerM().size() > 0) {
						System.out.println("		" + summerSeeds.get(0).getName() + " " + Farmer.getSummerM().size() + "개를 뿌렸어요.");
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
						System.out.println("		" + summerSeeds.get(0).getName() + "이 없어요.");
				}
				
				if(userPress == 2) {
					if(Farmer.getSummerR().size() > 0) {
						System.out.println("		" + summerSeeds.get(1).getName() + " " + Farmer.getSummerR().size() + "개를 뿌렸어요.");
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
						System.out.println("		" + summerSeeds.get(1).getName() + "이 없어요.");
				}
				
				if(userPress == 3) {
					if(Farmer.getSummerB().size() > 0) {
						System.out.println("		" + summerSeeds.get(2).getName() + " " + Farmer.getSummerB().size() + "개를 뿌렸어요.");
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
						System.out.println("		" + summerSeeds.get(2).getName() + "이 없어요.");
				}
				
				if(userPress == 4) {
					if(Farmer.getSummerT().size() > 0) {
						System.out.println("		" + summerSeeds.get(3).getName() + " " + Farmer.getSummerT().size() + "개를 뿌렸어요.");
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
						System.out.println("		" + summerSeeds.get(3).getName() + "이 없어요.");
				}
				
				if(userPress == 5) {
					if(Farmer.getSummerS().size() > 0) {
						System.out.println("		" + summerSeeds.get(4).getName() + " " + Farmer.getSummerS().size() + "개를 뿌렸어요.");
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
						System.out.println("		" + summerSeeds.get(4).getName() + "이 없어요.");
				}
			}
		
		// 가을 작물
			else if(Farm.getSeason().equals("가을")) {
				if(userPress == 1) {
					if(Farmer.getAutumnM().size() > 0) {
						System.out.println("		" + autumnSeeds.get(0).getName() + " " + Farmer.getAutumnM().size() + "개를 뿌렸어요.");
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
						System.out.println("		" + autumnSeeds.get(0).getName() + "이 없어요.");
				}
				
				if(userPress == 2) {
					if(Farmer.getAutumnG().size() > 0) {
						System.out.println("		" + autumnSeeds.get(1).getName() + " " + Farmer.getAutumnG().size() + "개를 뿌렸어요.");
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
						System.out.println("		" + autumnSeeds.get(1).getName() + "이 없어요.");
				}
				
				if(userPress == 3) {
					if(Farmer.getAutumnA().size() > 0) {
						System.out.println("		" + autumnSeeds.get(2).getName() + " " + Farmer.getAutumnA().size() + "개를 뿌렸어요.");
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
						System.out.println("		" + autumnSeeds.get(2).getName() + "이 없어요.");
				}
				
				if(userPress == 4) {
					if(Farmer.getAutumnC().size() > 0) {
						System.out.println("		" + autumnSeeds.get(3).getName() + " " + Farmer.getAutumnC().size() + "개를 뿌렸어요.");
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
						System.out.println("		" + autumnSeeds.get(3).getName() + "이 없어요.");
				}
				
				if(userPress == 5) {
					if(Farmer.getAutumnP().size() > 0) {
						System.out.println("		" + autumnSeeds.get(4).getName() + " " + Farmer.getAutumnP().size() + "개를 뿌렸어요.");
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
						System.out.println("		" + autumnSeeds.get(4).getName() + "이 없어요.");
				}
			}
		}
	}

	/*************재배하기***************/
	private static void getFruit() {
		Scanner scanner = new Scanner(System.in);
		ClearConsole.clearConsole();
		System.out.println("==============================================================");
		System.out.println("		재배할 수 있는 과일 목록입니다.		");
		System.out.println("		♣재배하는 데 걸리는 시간♣	");
		System.out.println("		▶봄 작물) 파스닙: 4일, 감자: 6일, 콜리플라워: 12일, 마늘: 4일, 딸기: 8일	");
		System.out.println("		▶여름 작물) 멜론: 12일, 붉은 양배추: 9일, 블루베리: 5일, 토마토: 6일, 스타후르츠: 13일	");
		System.out.println("		▶가을 작물) 마: 10일, 포도: 14일, 아마란스: 7일, 청경채: 4일, 호박: 13일	");
		System.out.println();
		
		if(Farm.season.equals("봄")) {
			int i = 1;
			if(Farm.day >= springP_day) {
				System.out.println("		" + i + ". " + springFruits.get(0).getName() + " 열매: " + springP +"개");
				i++;
			}
			if(Farm.day >= springG_day) {
				System.out.println("		" + i + ". " + springFruits.get(1).getName() + " 열매: " + springG +"개");
				i++;
			}
			if(Farm.day >= springC_day) {
				System.out.println("		" + i + ". " + springFruits.get(2).getName() + " 열매: " + springC +"개");
				i++;
			}
			if(Farm.day >= springM_day) {
				System.out.println("		" + i + ". " + springFruits.get(3).getName() + " 열매: " + springM +"개");
				i++;
			}
			if(Farm.day >= springS_day) {
				System.out.println("		" + i + ". " + springFruits.get(4).getName() + " 열매: " + springS +"개");
				i++;
			}
			
			if(i==1) {
				System.out.println("------------------------------------------------------------------");
				System.out.println("		아직 열매가 열리지 않았어요.			");
				System.out.println("------------------------------------------------------------------");
				ConsoleStop.threadSleep(1000);
			}
			else
				getWhatFruit();
		}	
		
		else if(Farm.season.equals("여름")) {
			int i = 1;
			if(Farm.day >= summerM_day) {
				System.out.println("		" + i + ". " + summerFruits.get(0).getName() + " 열매: " + summerM +"개");
				i++;
			}
			if(Farm.day >= summerR_day) {
				System.out.println("		" + i + ". " + summerFruits.get(1).getName() + " 열매: " + summerR +"개");
				i++;
			}
			if(Farm.day >= summerB_day) {
				System.out.println("		" + i + ". " + summerFruits.get(2).getName() + " 열매: " + summerB +"개");
				i++;
			}
			if(Farm.day >= summerT_day) {
				System.out.println("		" + i + ". " + summerFruits.get(3).getName() + " 열매: " + summerT +"개");
				i++;
			}
			if(Farm.day >= summerS_day) {
				System.out.println("		" + i + ". " + summerFruits.get(4).getName() + " 열매: " + summerS +"개");
				i++;
			}
			
			if(i==1) {
				System.out.println("------------------------------------------------------------------");
				System.out.println("		아직 열매가 열리지 않았어요.			");
				System.out.println("------------------------------------------------------------------");
			}
			else
				getWhatFruit();
		}	
		
		else if(Farm.season.equals("가을")) {
			int i = 1;
			if(Farm.day >= autumnM_day) {
				System.out.println("		" + i + ". " + autumnFruits.get(0).getName() + " 열매: " + autumnM +"개");
				i++;
			}
			if(Farm.day >= autumnG_day) {
				System.out.println("		" + i + ". " + autumnFruits.get(1).getName() + " 열매: " + autumnG +"개");
				i++;
			}
			if(Farm.day >= autumnA_day) {
				System.out.println("		" + i + ". " + autumnFruits.get(2).getName() + " 열매: " + autumnA +"개");
				i++;
			}
			if(Farm.day >= autumnC_day) {
				System.out.println("		" + i + ". " + autumnFruits.get(3).getName() + " 열매: " + autumnC +"개");
				i++;
			}
			if(Farm.day >= autumnP_day) {
				System.out.println("		" + i + ". " + autumnFruits.get(4).getName() + " 열매: " + autumnP +"개");
				i++;
			}
			
			if(i==1) {
				System.out.println("------------------------------------------------------------------");
				System.out.println("		아직 열매가 열리지 않았어요.			");
				System.out.println("------------------------------------------------------------------");
			}
			else
				getWhatFruit();
		}
		
		System.out.println("==============================================================");
			
	}
	
	private static void getWhatFruit() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("		과일을 수확하려면 'y'를 눌러 주세요		");
		System.out.println("		뒤로 가기: n");
		String userPress = scanner.next();
		if(userPress.equals("n"))
			return;
		
		if(userPress.equals("y")) {
			int todayFruitCount = 0;
			FileRead.hasThreadTxt(getFruit);
			if(Farm.season.equals("봄")) {
				if(Farm.day >= springP_day) {
					System.out.println("		" + springFruits.get(0).getName() + " 열매 " + springP +"개를 수확했어요.");
					fruitCount += springP;
					todayFruitCount += springP;
					Inventory.springP += springP;
					springP = 0;
					springP_day = 999;		
				}
				if(Farm.day >= springG_day) {
					System.out.println("		" + springFruits.get(1).getName() + " 열매 " + springG +"개를 수확했어요.");
					fruitCount += springG;
					todayFruitCount += springG;
					Inventory.springG += springG;
					springG = 0;
					springG_day = 999;
				}
				if(Farm.day >= springC_day) {
					System.out.println("		" + springFruits.get(2).getName() + " 열매 "  + springC +"개를 수확했어요.");
					fruitCount += springC;
					todayFruitCount += springC;
					Inventory.springC += springC;
					springC = 0;
					springC_day = 999;
				}
				if(Farm.day >= springM_day) {
					System.out.println("		" + springFruits.get(3).getName() + " 열매 "  + springM +"개를 수확했어요.");
					fruitCount += springM;
					todayFruitCount += springM;
					Inventory.springM += springM;
					springM = 0;
					springM_day = 999;
				}
				if(Farm.day >= springS_day) {
					System.out.println("		" + springFruits.get(4).getName() + " 열매 "  + springS +"개를 수확했어요.");
					fruitCount += springS;
					todayFruitCount += springS;
					Inventory.springS += springS;
					springS = 0;
					springS_day = 999;
				}
			}	
			
			else if(Farm.season.equals("여름")) {
				if(Farm.day >= summerM_day) {
					System.out.println("		" + summerFruits.get(0).getName() + " 열매 " + summerM +"개를 수확했어요.");
					fruitCount += summerM;
					todayFruitCount += summerM;
					Inventory.summerM += summerM;
					summerM = 0;
					summerM_day = 999;
				}
				if(Farm.day >= summerR_day) {
					System.out.println("		" + summerFruits.get(1).getName() + " 열매 " + summerR +"개를 수확했어요.");
					fruitCount += summerR;
					todayFruitCount += summerR;
					Inventory.summerR += summerR;
					summerR = 0;
					summerR_day = 999;
				}
				if(Farm.day >= summerB_day) {
					System.out.println("		" + summerFruits.get(2).getName() + " 열매 " + summerB +"개를 수확했어요.");
					fruitCount += summerB;
					todayFruitCount += summerB;
					Inventory.summerB += summerB;
					summerB = 0;
					summerB_day = 999;
				}
				if(farm.Farm.day >= summerT_day) {
					System.out.println("		" + summerFruits.get(3).getName() + " 열매 " + summerT +"개를 수확했어요.");
					fruitCount += summerT;
					todayFruitCount += summerT;
					Inventory.summerT += summerT;
					summerT = 0;
					summerT_day = 999;
				}
				if(Farm.day >= summerS_day) {
					System.out.println("		" + summerFruits.get(4).getName() + " 열매 " + summerS +"개를 수확했어요.");
					fruitCount += summerS;
					todayFruitCount += summerS;
					Inventory.summerS += summerS;
					summerS = 0;
					summerS_day = 999;
				}
			}	
			
			else if(Farm.season.equals("가을")) {
				if(Farm.day >= autumnM_day) {
					System.out.println("		" + autumnFruits.get(0).getName() + " 열매 " + autumnM +"개를 수확했어요.");
					fruitCount += autumnM;
					todayFruitCount += autumnM;
					Inventory.autumnM += autumnM;
					autumnM = 0;
					autumnM_day = 999;
				}
				if(Farm.day >= autumnG_day) {
					System.out.println("		" + autumnFruits.get(1).getName() + " 열매 "+ autumnG +"개를 수확했어요.");
					fruitCount += autumnG;
					todayFruitCount += autumnG;
					Inventory.autumnG += autumnG;
					autumnG = 0;
					autumnG_day = 999;
				}
				if(Farm.day >= autumnA_day) {
					System.out.println("		" + autumnFruits.get(2).getName() + " 열매 "+ autumnA +"개를 수확했어요.");
					fruitCount += autumnA;
					todayFruitCount += autumnA;
					Inventory.autumnA += autumnA;
					autumnA = 0;
					autumnA_day = 999;
				}
				if(Farm.day >= autumnC_day) {
					System.out.println("		" + autumnFruits.get(3).getName() + " 열매 "+ autumnC +"개를 수확했어요.");
					fruitCount += autumnC;
					todayFruitCount += autumnC;
					Inventory.autumnC += autumnC;
					autumnC = 0;
					autumnC_day = 999;
				}
				if(Farm.day >= autumnP_day) {
					System.out.println("		" + autumnFruits.get(4).getName() + " 열매 "+ autumnP +"개를 수확했어요.");
					fruitCount += autumnP;
					todayFruitCount += autumnP;
					Inventory.autumnP += autumnP;
					autumnP = 0;
					autumnP_day = 999;
				}
			}
			
		
			if(user.getSickle().getName().equals("구리 낫")) {
				int gold = 50 * todayFruitCount;
				System.out.println("		구리 낫 보너스 지급(작물 한 개당 50G):" + gold + "G");
				user.setGold(gold);
			}
			else if(user.getSickle().getName().equals("철 낫")) {
				int gold = 100 * todayFruitCount;
				System.out.println("		철 낫 보너스 지급(작물 한 개당 100G):" + gold + "G");
				user.setGold(gold);
			}
			if(user.getSickle().getName().equals("이리듐 낫")) {
				int gold = 200 * todayFruitCount;
				System.out.println("		이리듐 낫 보너스 지급(작물 한 개당 200G):" + gold + "G");
				user.setGold(gold);
			}
			
			ConsoleStop.threadSleep(1500);
		}
		
		else {
			System.out.println("		과일 수확을 취소했어요.		 ");
			return;
		}
	}
	
	private static void eatFruit() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			ClearConsole.clearConsole();
			System.out.println("=================================================");
			System.out.println("		▶무슨 과일을 먹을까요?		");
			System.out.println("		(뒤로 가기: 0)		");
			System.out.println("		♠보유 중인 과일 꾸러미♠		");
			Inventory.showFruit();
			int userPress = scanner.nextInt();
			if(userPress == 0)
				return;
			
			//봄 작물
			if(Farm.getSeason().equals("봄")) {
				if(userPress == 1) {
					if(Inventory.springP > 0) {
						System.out.println("		" + springFruits.get(0).getName()  +" 열매를 먹었어요.");
						Inventory.springP--;
						int hp = user.getHp();
						hp += springFruits.get(0).getRecoverHp();
						user.setHp(hp);
					}
					else
						System.out.println("		" + springFruits.get(0).getName() + " 열매가 없어요.");
				}
				
				if(userPress == 2) {
					if(Inventory.springG > 0) {
						System.out.println("		" + springFruits.get(1).getName()  +" 열매를 먹었어요.");
						Inventory.springG--;
						int hp = user.getHp();
						hp += springFruits.get(1).getRecoverHp();
						user.setHp(hp);
					}
					else
						System.out.println("		" + springFruits.get(1).getName() + " 열매가 없어요.");
				}
				
				if(userPress == 3) {
					if(Inventory.springC > 0) {
						System.out.println("		" + springFruits.get(2).getName()  +" 열매를 먹었어요.");
						Inventory.springC--;
						int hp = user.getHp();
						hp += springFruits.get(2).getRecoverHp();
						user.setHp(hp);
					}
					else
						System.out.println("		" + springFruits.get(2).getName() + " 열매가 없어요.");
				}
				
				if(userPress == 4) {
					if(Inventory.springM > 0) {
						System.out.println("		" + springFruits.get(3).getName()  +" 열매를 먹었어요.");
						Inventory.springM--;
						int hp = user.getHp();
						hp += springFruits.get(3).getRecoverHp();
						user.setHp(hp);
					}
					else
						System.out.println("		" + springFruits.get(3).getName() + " 열매가 없어요.");
				}
				
				if(userPress == 5) {
					if(Inventory.springS > 0) {
						System.out.println("		" + springFruits.get(4).getName()  +" 열매를 먹었어요.");
						Inventory.springS--;
						int hp = user.getHp();
						hp += springFruits.get(4).getRecoverHp();
						user.setHp(hp);
					}
					else
						System.out.println("		" + springFruits.get(4).getName() + " 열매가 없어요.");
				}
				
				System.out.println("		현재 Hp: " + user.getHp() + "/" + user.getMaxHp());
			}
				
			//여름 작물
				else if(Farm.getSeason().equals("여름")) {
					if(userPress == 1) {
						if(Inventory.summerM > 0) {
							System.out.println("		" + summerFruits.get(0).getName()  +" 열매를 먹었어요.");
							Inventory.summerM--;
							int hp = user.getHp();
							hp += summerFruits.get(0).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + summerFruits.get(0).getName() + " 열매가 없어요.");
					}
					
					if(userPress == 2) {
						if(Inventory.summerR > 0) {
							System.out.println("		" + summerFruits.get(1).getName()  +" 열매를 먹었어요.");
							Inventory.summerR--;
							int hp = user.getHp();
							hp += summerFruits.get(1).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + summerFruits.get(1).getName() + " 열매가 없어요.");
					}
					
					if(userPress == 3) {
						if(Inventory.summerB > 0) {
							System.out.println("		" + summerFruits.get(2).getName()  +" 열매를 먹었어요.");
							Inventory.summerB--;
							int hp = user.getHp();
							hp += summerFruits.get(2).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + summerFruits.get(2).getName() + " 열매가 없어요.");
					}
					
					if(userPress == 4) {
						if(Inventory.summerT > 0) {
							System.out.println("		" + summerFruits.get(3).getName()  +" 열매를 먹었어요.");
							Inventory.summerT--;
							int hp = user.getHp();
							hp += summerFruits.get(3).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + summerFruits.get(3).getName() + " 열매가 없어요.");
					}
					
					if(userPress == 5) {
						if(Inventory.summerS > 0) {
							System.out.println("		" + summerFruits.get(4).getName()  +" 열매를 먹었어요.");
							Inventory.summerS--;
							int hp = user.getHp();
							hp += summerFruits.get(4).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + summerFruits.get(4).getName() + " 열매가 없어요.");
					}
					
					System.out.println("		현재 Hp: " + user.getHp() + "/" + user.getMaxHp());
				}
			
			// 가을 작물
				else if(Farm.getSeason().equals("가을")) {
					if(userPress == 1) {
						if(Inventory.autumnM > 0) {
							System.out.println("		" + autumnFruits.get(0).getName()  +" 열매를 먹었어요.");
							Inventory.autumnM--;
							int hp = user.getHp();
							hp += autumnFruits.get(0).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + autumnFruits.get(0).getName() + " 열매가 없어요.");
					}
					
					if(userPress == 2) {
						if(Inventory.autumnG > 0) {
							System.out.println("		" + autumnFruits.get(1).getName()  +" 열매를 먹었어요.");
							Inventory.autumnG--;
							int hp = user.getHp();
							hp += autumnFruits.get(1).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + autumnFruits.get(1).getName() + " 열매가 없어요.");
					}
					
					if(userPress == 3) {
						if(Inventory.autumnA > 0) {
							System.out.println("		" + autumnFruits.get(2).getName()  +" 열매를 먹었어요.");
							Inventory.autumnA--;
							int hp = user.getHp();
							hp += autumnFruits.get(2).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + autumnFruits.get(2).getName() + " 열매가 없어요.");
					}
					
					if(userPress == 4) {
						if(Inventory.autumnC > 0) {
							System.out.println("		" + autumnFruits.get(3).getName()  +" 열매를 먹었어요.");
							Inventory.autumnC--;
							int hp = user.getHp();
							hp += autumnFruits.get(3).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + autumnFruits.get(3).getName() + " 열매가 없어요.");
					}
					
					if(userPress == 5) {
						if(Inventory.autumnP > 0) {
							System.out.println("		" + autumnFruits.get(4).getName()  +" 열매를 먹었어요.");
							Inventory.autumnP--;
							int hp = user.getHp();
							hp += autumnFruits.get(4).getRecoverHp();
							user.setHp(hp);
						}
						else
							System.out.println("		" + autumnFruits.get(4).getName() + " 열매가 없어요.");
					}
					
					System.out.println("		현재 Hp: " + user.getHp() + "/" + user.getMaxHp());
				}
			
			ConsoleStop.threadSleep(1000);
			
			System.out.println("---------------------------------------------------------------------");
			}
	}
}

