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
	
	protected static int fruitCount = 0; // 재배한 과일
	protected static int fishCount = 0; // 물고기
	protected static int weaponCount = 0; //무기(몬스터 처치용)
	protected static int toolCount = 0; // 도구(농작물 및 낚시용)
	protected static int seedCount = 0; // 씨앗
	protected static int allCount = 0;
	
	// 열매 개수
	protected static int springP = 0; // 파스닙
	protected static int springG = 0; // 감자
	protected static int springC = 0; // 콜리플라워
	protected static int springM = 0; //마늘
	protected static int springS = 0; //딸기
	
	protected static int summerM = 0; // 멜론
	protected static int summerR = 0; // 붉은 양배추
	protected static int summerB = 0; // 블루베리
	protected static int summerT = 0; // 토마토
	protected static int summerS = 0; // 스타후르츠
	
	protected static int autumnM = 0; // 마
	protected static int autumnG = 0; // 포도
	protected static int autumnA = 0; // 아마란스
	protected static int autumnC = 0; // 청경채
	protected static int autumnP = 0; // 호박
	
	//물고기 수
	public static int springF1 = 0; //개복치
	public static int springF2 = 0; //전어
	public static int springF3 = 0; //멸치
	public static int springF4 = 0; //장어
	public static int springF5 = 0; //가자미
	public static int springF6 = 0; //전설의 물고기
	
	public static int summerF1 = 0; //숭어
	public static int summerF2 = 0; //틸라피아
	public static int summerF3 = 0; //문어
	public static int summerF4 = 0; //참치
	public static int summerF5 = 0; //복어
	public static int summerF6 = 0; //크림슨피쉬
	
	public static int autumnF1 = 0; //정어리
	public static int autumnF2 = 0; //연어
	public static int autumnF3 = 0; //타이거 송어
	public static int autumnF4 = 0; //메기
	public static int autumnF5 = 0; //월아이
	public static int autumnF6 = 0; //아귀
	
	public static int winterF1 = 0; //청어
	public static int winterF2 = 0; //오징어
	public static int winterF3 = 0; //넙치
	public static int winterF4 = 0; //참치
	public static int winterF5 = 0; //범노래미
	public static int winterF6 = 0; //얼음 물고기
	
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
		System.out.println("		인벤토리 창을 확인합니다.		");
		if(allCount == 0) {
			System.out.println("		가지고 있는 게 아무것도 없어요.		");
		}
		
		else {
			System.out.println("		▶보유 무기		");
			for(int i =0; i< weaponCount; i++) 
				System.out.println("		▶" + (i+1) + ". " + user.getWeapons().get(i).getName());
			
			System.out.println();
			System.out.println("		▶보유 도구		");
			for(int i=0; i< toolCount; i++)
				System.out.println("		▶" + (i+1) + ". " + user.getTools().get(i).getName());
			System.out.println();
			System.out.println("		▶보유 씨앗		");
				showSeed();	
			System.out.println();
			System.out.println("		▶보유 과일		");
				showFruit();
			System.out.println();
			System.out.println("		▶보유 물고기		");
				showFish();
				
		System.out.println();
		System.out.println("		---------------------------------");
		System.out.print("		도구 및 무기를 장착하시겠습니까?(y/other keys) ");
			Scanner scanner = new Scanner(System.in);
			String userPress = scanner.next();
			if(userPress.equals("y")) {
				if((user.getFishingRod() == null) || (user.getHoe() == null) || (user.getSickle() == null)) {
					System.out.println("		보유 중인 도구가 없어요. 상점에서 기본 도구들을 받아 오세요!");
					ConsoleStop.threadSleep(1000);
					return;
				}
				
				System.out.println("		가장 성능이 좋은 도구를 장착 중입니다.		");
				
				for(int i=0; i< user.getTools().size(); i++) {
					if(user.getTools().get(i).getName().equals("구리 괭이")) 
							user.setHoe(user.getTools().get(i));
					
					if(user.getTools().get(i).getName().equals("구리 낫"))
							user.setSickle(user.getTools().get(i));
					
						
					if(user.getTools().get(i).getName().equals("구리 낚싯대")) 
							user.setFishingRod(user.getTools().get(i));
					
					
					if(user.getTools().get(i).getName().equals("철 괭이")) 
							user.setHoe(user.getTools().get(i));	
					
					
					if(user.getTools().get(i).getName().equals("철 낫"))
							user.setSickle(user.getTools().get(i));
					
					
					if(user.getTools().get(i).getName().equals("철 낚싯대"))
							user.setFishingRod(user.getTools().get(i));
					
								
					if(user.getTools().get(i).getName().equals("이리듐 괭이"))
							user.setHoe(user.getTools().get(i));
				
					
					if(user.getTools().get(i).getName().equals("이리듐 낫"))
							user.setSickle(user.getTools().get(i));	
					
					
					if(user.getTools().get(i).getName().equals("이리듐 낚싯대")) 
							user.setFishingRod(user.getTools().get(i));	
				}
				
				System.out.println("		현재 장착 중인 도구: " + user.getHoe().getName() + ", " + user.getSickle().getName() + ", " + user.getFishingRod().getName());
				
				
				if((user.getWeapons() == null)) {
					System.out.println("		보유 중인 무기가 없어요. 상점에서 무기 구매 후 인벤토리에서 장착해 주세요.");
					ConsoleStop.threadSleep(1500);
					return;
				}
				
				System.out.println("		가장 성능이 좋은 무기를 장착 중입니다.		");
				
				
				for(int i=0; i< user.getWeapons().size(); i++) {
					if(user.getWeapons().get(i).getName().equals("녹슨 검")) 
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("나무 검")) 
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("강철 단검"))
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("은 단검")) 
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("커틀라스")) 
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("어둠의 검")) 
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("흑요 검")) 
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("신성의 검"))
							user.setWeapon(user.getWeapons().get(i));
					
					if(user.getWeapons().get(i).getName().equals("용암 검")) 
							user.setWeapon(user.getWeapons().get(i));	
					
					if(user.getWeapons().get(i).getName().equals("갤럭시 검")) 
							user.setWeapon(user.getWeapons().get(i));
				}
				
				if(user.getWeapon() == null) {
					System.out.println("		보유 중인 무기가 없어요. 상점에서 무기 구매 후 인벤토리에서 장착해 주세요.");
					ConsoleStop.threadSleep(1500);
					return;
				}
				
				System.out.println("		현재 장착 중인 무기: " + user.getWeapon().getName());
				
			}
		}
		System.out.println("------------------------------------------------------------------");
	}
	
	protected static void showSeed() {
		if(Farm.getSeason().equals("봄")) {
			System.out.println("		1. " + springSeeds.get(0).getName() + ": ---------- " + Farmer.getSpringP().size() +"개");
			System.out.println("		2. " + springSeeds.get(1).getName() + ": ---------- " + Farmer.getSpringG().size() +"개");
			System.out.println("		3. " + springSeeds.get(2).getName() + ": ---------- " + Farmer.getSpringC().size() +"개");
			System.out.println("		4. " + springSeeds.get(3).getName() + ": ---------- " + Farmer.getSpringM().size() +"개");
			System.out.println("		5. " + springSeeds.get(4).getName() + ": ---------- " + Farmer.getSpringS().size() +"개");
			seedCount = Farmer.getSpringP().size() + Farmer.getSpringG().size() + Farmer.getSpringC().size() + Farmer.getSpringM().size() + Farmer.getSpringS().size();

		}
		else if(Farm.getSeason().equals("여름")) {
			System.out.println("		1. " + summerSeeds.get(0).getName() + ": ---------- " + Farmer.getSummerM().size() +"개");
			System.out.println("		2. " + summerSeeds.get(1).getName() + ": ---------- " + Farmer.getSummerR().size() +"개");
			System.out.println("		3. " + summerSeeds.get(2).getName() + ": ---------- " + Farmer.getSummerB().size() +"개");
			System.out.println("		4. " + summerSeeds.get(3).getName() + ": ---------- " + Farmer.getSummerT().size() +"개");
			System.out.println("		5. " + summerSeeds.get(4).getName() + ": ---------- " + Farmer.getSummerS().size() +"개");
			seedCount = Farmer.getSummerM().size() + Farmer.getSummerR().size() + Farmer.getSummerB().size() + Farmer.getSummerT().size() + Farmer.getSpringS().size();
		}
		else if(Farm.getSeason().equals("가을")) {
			System.out.println("		1. " + autumnSeeds.get(0).getName() + ": ---------- " + Farmer.getAutumnM().size() +"개");
			System.out.println("		2. " + autumnSeeds.get(0).getName() + ": ---------- " + Farmer.getAutumnG().size() +"개");
			System.out.println("		3. " + autumnSeeds.get(0).getName() + ": ---------- " + Farmer.getAutumnA().size() +"개");
			System.out.println("		4. " + autumnSeeds.get(0).getName() + ": ---------- " + Farmer.getAutumnC().size() +"개");
			System.out.println("		5. " + autumnSeeds.get(0).getName() + ": ---------- " + Farmer.getAutumnP().size() +"개");
			seedCount = Farmer.getAutumnM().size() + Farmer.getAutumnG().size() + Farmer.getAutumnA().size() + Farmer.getAutumnC().size() + Farmer.getAutumnP().size();
		}
	}
	
	protected static int getSeedCount() {
		return seedCount;
	}
	
	protected static void showFruit() {
		if(Farm.getSeason().equals("봄")) {
			System.out.println("		1. " + springFruits.get(0).getName() + ": ---------- " + springP +"개");
			System.out.println("		2. " + springFruits.get(1).getName() + ": ---------- " + springG +"개");
			System.out.println("		3. " + springFruits.get(2).getName() + ": ---------- " + springC +"개");
			System.out.println("		4. " + springFruits.get(3).getName() + ": ---------- " + springM +"개");
			System.out.println("		5. " + springFruits.get(4).getName() + ": ---------- " + springS +"개");
		}
		else if(Farm.getSeason().equals("여름")) {
			System.out.println("		1. " + summerFruits.get(0).getName() + ": ---------- " + summerM +"개");
			System.out.println("		2. " + summerFruits.get(1).getName() + ": ---------- " + summerR +"개");
			System.out.println("		3. " + summerFruits.get(2).getName() + ": ---------- " + summerB +"개");
			System.out.println("		4. " + summerFruits.get(3).getName() + ": ---------- " + summerT +"개");
			System.out.println("		5. " + summerFruits.get(4).getName() + ": ---------- " + summerS +"개");
		}
		else if(Farm.getSeason().equals("가을")) {
			System.out.println("		1. " + autumnFruits.get(0).getName() + ": ---------- " + autumnM +"개");
			System.out.println("		2. " + autumnFruits.get(1).getName() + ": ---------- " + autumnG +"개");
			System.out.println("		3. " + autumnFruits.get(2).getName() + ": ---------- " + autumnA +"개");
			System.out.println("		4. " + autumnFruits.get(3).getName() + ": ---------- " + autumnC +"개");
			System.out.println("		5. " + autumnFruits.get(4).getName() + ": ---------- " + autumnP +"개");
		}
	}
	
	protected static void showFish() {
		if(Farm.getSeason().equals("봄")) {
			System.out.println("		1. " + springFishes.get(0).getName() + ": ---------- " + springF1+"마리");
			System.out.println("		2. " + springFishes.get(1).getName() + ": ---------- " + springF2 +"마리");
			System.out.println("		3. " + springFishes.get(2).getName() + ": ---------- " + springF3 +"마리");
			System.out.println("		4. " + springFishes.get(3).getName() + ": ---------- " + springF4 +"마리");
			System.out.println("		5. " + springFishes.get(4).getName() + ": ---------- " + springF5 +"마리");
			System.out.println("		6. " + springFishes.get(5).getName() + ": ---------- " + springF6 +"마리");
		}
		else if(Farm.getSeason().equals("여름")) {
			System.out.println("		1. " + summerFishes.get(0).getName() + ": ---------- " + summerF1 +"마리");
			System.out.println("		2. " + summerFishes.get(1).getName() + ": ---------- " + summerF2 +"마리");
			System.out.println("		3. " + summerFishes.get(2).getName() + ": ---------- " + summerF3 +"마리");
			System.out.println("		4. " + summerFishes.get(3).getName() + ": ---------- " + summerF4 +"마리");
			System.out.println("		5. " + summerFishes.get(4).getName() + ": ---------- " + summerF5 +"마리");
			System.out.println("		6. " + summerFishes.get(5).getName() + ": ---------- " + summerF6 +"마리");
		}
		else if(Farm.getSeason().equals("가을")) {
			System.out.println("		1. " + autumnFishes.get(0).getName() + ": ---------- " + autumnF1 +"개");
			System.out.println("		2. " + autumnFishes.get(1).getName() + ": ---------- " + autumnF2 +"개");
			System.out.println("		3  " + autumnFishes.get(2).getName() + ": ---------- " + autumnF3 +"개");
			System.out.println("		4. " + autumnFishes.get(3).getName() + ": ---------- " + autumnF4 +"개");
			System.out.println("		5. " + autumnFishes.get(4).getName() + ": ---------- " + autumnF5 +"개");
			System.out.println("		6. " + autumnFishes.get(5).getName() + ": ---------- " + autumnF6 +"개");
		}
		else if(Farm.getSeason().equals("겨을")) {
			System.out.println("		1. " + winterFishes.get(0).getName() + ": ---------- " + winterF1 +"개");
			System.out.println("		2. " + winterFishes.get(1).getName() + ": ---------- " + winterF2 +"개");
			System.out.println("		3. " + winterFishes.get(2).getName() + ": ---------- " + winterF3 +"개");
			System.out.println("		4. " + winterFishes.get(3).getName() + ": ---------- " + winterF4 +"개");
			System.out.println("		5. " + winterFishes.get(4).getName() + ": ---------- " + winterF5 +"개");
			System.out.println("		6. " + winterFishes.get(5).getName() + ": ---------- " + winterF6 +"개");
		}
	}
	
	// 기본 도구 세팅
	public static void setBasicTool(Tool sickle, Tool hoe, Tool fishingRod) {
		user.setHoe(hoe);
		user.setSickle(sickle);
		user.setFishingRod(fishingRod);
	}
	
	//스타후르츠 받아오기(winterStory 전용)
	public static int getSummerS() {
		return summerS;
	}
	
	public static void setSummerS(int summerS) {
		Inventory.summerS = summerS;
	}
}
