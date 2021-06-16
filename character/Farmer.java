package character;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import console.ConsoleStop;
import farm.Farm;
import item.Item;
import item.Seed;
import item.Tool;
import item.Weapon;

public class Farmer extends Character {
	Farm farm = new Farm();
	
	private Weapon weapon; // ÀåÂø ÁßÀÎ ¹«±â
	private Tool hoe; // ±ªÀÌ
	private Tool sickle; // ³´ 
	private Tool fishingRod; // ÀåÂø ÁßÀÎ µµ±¸(³¬½Ë´ë)

	private static List<Weapon> weapons = new ArrayList<Weapon>(); //¹«±â ¸ðÀ½
	private static List<Tool> tools = new ArrayList<Tool>(); //µµ±¸ ¸ðÀ½
	
	private static List<Seed> springP = new ArrayList<Seed>(); //ÆÄ½º´Õ ¾¾¾Ñ
	private static List<Seed> springG = new ArrayList<Seed>(); //°¨ÀÚ ¾¾¾Ñ
	private static List<Seed> springC = new ArrayList<Seed>();  //ÄÝ¸®ÇÃ¶ó¿ö ¾¾¾Ñ
	private static List<Seed> springM = new ArrayList<Seed>();  //¸¶´Ã ¾¾¾Ñ
	private static List<Seed> springS = new ArrayList<Seed>();  //µþ±â ¾¾¾Ñ
	
	private static List<Seed> summerM = new ArrayList<Seed>(); //¸á·Ð ¾¾¾Ñ
	private static List<Seed> summerR = new ArrayList<Seed>();  //ºÓÀº ¾ç¹èÃß ¾¾¾Ñ
	private static List<Seed> summerB = new ArrayList<Seed>();  //ºí·çº£¸® ¾¾¾Ñ
	private static List<Seed> summerT = new ArrayList<Seed>();  //Åä¸¶Åä ¾¾¾Ñ
	private static List<Seed> summerS = new ArrayList<Seed>();  //½ºÅ¸ÈÄ¸£Ã÷ ¾¾¾Ñ
	
	private static List<Seed> AutumnM = new ArrayList<Seed>();  // ¸¶ ¾¾¾Ñ
	private static List<Seed> AutumnG = new ArrayList<Seed>();  // Æ÷µµ ¾¾¾Ñ
	private static List<Seed> AutumnA = new ArrayList<Seed>();  // ¾Æ¸¶¶õ½º ¾¾¾Ñ
	private static List<Seed> AutumnC = new ArrayList<Seed>();  // Ã»°æÃ¤ ¾¾¾Ñ
	private static List<Seed> AutumnP = new ArrayList<Seed>();  // È£¹Ú ¾¾¾Ñ
	
	public Farmer() {
		;
	}

	
	public Farmer(String name, String gender, int hp, int maxHp, int power, int gold, int level) {
		super(name, gender, hp, maxHp, power, gold, level);
	}
	
	@Override
	public void attack(Monster monster, Farmer user) {
		System.out.println("		" + user.getWeapon().getName() + "(À¸)·Î " + monster.getName() + "À» Âî¸¨´Ï´Ù!");
		int damage = weapon.getDamage();
		int monsterHp = monster.getHp();
		monster.setHp(monsterHp - damage);
		System.out.println("		" + monster.getName() + "¿¡°Ô " + damage + " ¸¸Å­ÀÇ ÇÇÇØ¸¦ ÀÔÇû¾î¿ä!");
	}
	
	@Override
	public void die(Character monster) {
		System.out.println("		" + monster.getName() + "¿¡°Ô ´çÇß¾î¿ä.");
		if(this.gold > 0)
			System.out.println("		Hp°¡ 0ÀÌ µÇ¾î ±âÀýÇß¾î¿ä. Ä¡·áºñ·Î " + user.getGold() / 2 + "G°¡ Â÷°¨µÇ¾ú¾î¿ä.");
		else
			System.out.println("		Hp°¡ 0ÀÌ µÇ¾î ±âÀýÇß¾î¿ä. µ·ÀÌ ¾ø¾î ÀÚ¹Ù¹Ù¿¡°Ô ¹«·á·Î Ä¡·á¹Þ¾Ò¾î¿ä.");
		int now_gold = user.getGold()/2;
		user.setGold2(now_gold);
		System.out.println("		ÁýÀ¸·Î µ¹¾Æ°©´Ï´Ù.");
		user.setHp(20);
		ConsoleStop.threadSleep(1500);
		farm.myFarm();
	}
	
	public boolean run(int isSuccess, int level) {
		if(isSuccess == 0) {
			return false;
		}
		else {
			user.setHp(hp -= 10);
			if(level == 1)
				this.gold -= 50;
			else if(level == 2)
				this.gold -= 100;
			else if(level == 3)
				this.gold -= 200;
			else if(level == 4)
				this.gold -= 300;
			else if(level == 5)
				this.gold -= 400;
			else if(level == 6)
				this.gold -= 500;
			return true;
		}
	}
	
	public String buyItem(Item item) {
		if(item instanceof Weapon) {
			Weapon weapon = (Weapon) item;
			this.gold -= weapon.getPrice();
			
			if(this.gold < 0) {
				this.gold += weapon.getPrice();
				return "Fail";
			}
			
			Farmer.weapons.add(weapon);	
		}
		
		else if(item instanceof Tool) {
			Tool tool = (Tool) item;
			this.gold -= tool.getPrice();
			
			if(this.gold < 0) { 
				this.gold += tool.getPrice();
				return "Fail";
			}
			
			Farmer.tools.add(tool);
		}	
		return "Success";
	}
	
	
	public void initItem(Item item) {
		if(item instanceof Weapon) {
			Weapon weapon = (Weapon) item;
			Farmer.weapons.add(weapon);	
		}
		
		else if(item instanceof Tool) {
			Tool tool = (Tool) item;
			Farmer.tools.add(tool);
		}	
	}
	
	
	
	
	public String buyItem(Seed seed, int seedCount, String season) {
		this.gold -= seed.getPrice() * seedCount;
		
		if(this.gold < 0) { 
			this.gold += seed.getPrice() * seedCount;
			return "Fail";
		}
		
		if(season.equals("º½")) {
			if(seed.getName().equals("ÆÄ½º´Õ ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					springP.add(seed);
			}
			else if(seed.getName().equals("°¨ÀÚ ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					springG.add(seed);
			}
			else if(seed.getName().equals("ÄÝ¸®ÇÃ¶ó¿ö ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					springC.add(seed);
			}
			else if(seed.getName().equals("¸¶´Ã ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					springM.add(seed);
			}
			else if(seed.getName().equals("µþ±â ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					springS.add(seed);
			}
		}
		
		else if(season.equals("¿©¸§")) {
			if(seed.getName().equals("¸á·Ð ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					Farmer.summerM.add(seed);
			}
			else if(seed.getName().equals("ºÓÀº ¾ç¹èÃß ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					Farmer.summerR.add(seed);
			}
			else if(seed.getName().equals("ºí·çº£¸® ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					Farmer.summerB.add(seed);
			}
			else if(seed.getName().equals("Åä¸¶Åä ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					Farmer.summerT.add(seed);
			}
			else if(seed.getName().equals("½ºÅ¸ÈÄ¸£Ã÷ ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					Farmer.summerS.add(seed);
			}
		}
		
		else if(season.equals("°¡À»")) {
			if(seed.getName().equals("¸¶ ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					Farmer.AutumnM.add(seed);
			}
			else if(seed.getName().equals("Æ÷µµ ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					Farmer.AutumnG.add(seed);
			}
			else if(seed.getName().equals("¾Æ¸¶¶õ½º ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					Farmer.AutumnA.add(seed);
			}
			if(seed.getName().equals("Ã»°æÃ¤ ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					Farmer.AutumnC.add(seed);
			}
			if(seed.getName().equals("È£¹Ú ¾¾¾Ñ")) {
				for(int i =0; i< seedCount; i++)
					Farmer.AutumnP.add(seed);
			}
		}
		return "Success";
	}
	
	public void doFarming() {
		this.hp -= 10;
	}
	
	public boolean buyFertilizer(int area, Tool whatHoe) {
		this.hp -= 10;
		
		if(area == 3) {
			if(whatHoe.getName().equals("µ¹ ±ªÀÌ")) {
				this.gold -= 100;
				if(this.gold < 0) {
					this.gold += 100;
					return false;
				}
			}
		
			else if(whatHoe.getName().equals("±¸¸® ±ªÀÌ")) {
				this.gold -= 70;
				if(this.gold < 0) {
					this.gold += 70;
					return false;
				}
			}
		
			else if(whatHoe.getName().equals("Ã¶ ±ªÀÌ")) {
				this.gold -= 30;
				if(this.gold < 0) {
					this.gold += 30;
					return false;
				}
			}
		
			else if(whatHoe.getName().equals("ÀÌ¸®µã ±ªÀÌ"))
				;
			
		}
		
		if(area == 5) {
			if(whatHoe.getName().equals("µ¹ ±ªÀÌ")) {
				this.gold -= 200;
				if(this.gold < 0) {
					this.gold += 200;
					return false;
				}
			}
		
			else if(whatHoe.getName().equals("±¸¸® ±ªÀÌ")) {
				this.gold -= 100;
				if(this.gold < 0) {
					this.gold += 100;
					return false;
				}
			}
		
			else if(whatHoe.getName().equals("Ã¶ ±ªÀÌ")) {
				this.gold -= 50;
				if(this.gold < 0) {
					this.gold += 50;
					return false;
				}
			}
		
			else if(whatHoe.getName().equals("ÀÌ¸®µã ±ªÀÌ"))
				;
		}
		
		if(area == 10) {
			if(whatHoe.getName().equals("µ¹ ±ªÀÌ")) {
				this.gold -= 300;
				if(this.gold < 0) {
					this.gold += 300;
					return false;
				}
			}
		
			else if(whatHoe.getName().equals("±¸¸® ±ªÀÌ")) {
				this.gold -= 150;
				if(this.gold < 0) {
					this.gold += 150;
					return false;
				}
			}
		
			else if(whatHoe.getName().equals("Ã¶ ±ªÀÌ")) {
				this.gold -= 100;
				if(this.gold < 0) {
					this.gold += 100;
					return false;
				}
			}
		
			else if(whatHoe.getName().equals("ÀÌ¸®µã ±ªÀÌ"))
				;
		}
		
		return true;
	}
	
	public boolean buyBait(Tool whatFishingRod) {
		this.hp -= 10;
		
		if(whatFishingRod.getName().equals("µ¹ ³¬½Ë´ë")) {
			this.gold -= 100;
			if(this.gold < 0) {
				this.gold += 100;
				return false;
			}
		}
	
		else if(whatFishingRod.getName().equals("±¸¸® ³¬½Ë´ë")) {
			this.gold -= 70;
			if(this.gold < 0) { 
				this.gold += 70;
				return false;
			}
		}
	
		else if(whatFishingRod.getName().equals("Ã¶ ³¬½Ë´ë")) {
			this.gold -= 30;
			if(this.gold < 0) {
				this.gold += 30;
				return false;
			}
		}
	
		else if(whatFishingRod.getName().equals("ÀÌ¸®µã ³¬½Ë´ë"))
			;
		
		return true;
	}
	
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	 
	public Tool getHoe() {
		return hoe;
	}
	
	public void setHoe(Tool hoe) {
		this.hoe = hoe;
	}
	
	public Tool getSickle() {
		return sickle;
	}
	
	public void setSickle(Tool sickle) {
		this.sickle = sickle;
	}
	
	public Tool getFishingRod() {
		return fishingRod;
	}
	
	public void setFishingRod(Tool fishingRod) {
		this.fishingRod = fishingRod;
	}
	
	public List<Weapon> getWeapons(){
		return weapons;
	}
	
	public void setWeapons(List<Weapon> weapons) {
		Farmer.weapons = weapons;
	}
	
	public List<Tool> getTools(){
		return tools;
	}
	
	public void setTools(List<Tool> tools) {
		Farmer.tools = tools;
	}
	
	public static List<Seed> getSpringP(){
		return springP;
	}
	
	public static List<Seed> getSpringG(){
		return springG;
	}
	
	public static List<Seed> getSpringC(){
		return springC;
	}
	
	public static List<Seed> getSpringM(){
		return springM;
	}
	
	public static List<Seed> getSpringS(){
		return springS;
	}
	
	public static List<Seed> getSummerM(){
		return summerM;
	}
	
	public static List<Seed> getSummerR(){
		return summerR;
	}
	
	public static List<Seed> getSummerB(){
		return summerB;
	}
	
	public static List<Seed> getSummerT(){
		return summerT;
	}
	
	public static List<Seed> getSummerS(){
		return summerS;
	}
	
	public static List<Seed> getAutumnM(){
		return AutumnM;
	}
	
	public static List<Seed> getAutumnG(){
		return AutumnG;
	}
	
	public static List<Seed> getAutumnA(){
		return AutumnA;
	}
	
	public static List<Seed> getAutumnC(){
		return AutumnC;
	}
	
	public static List<Seed> getAutumnP(){
		return AutumnP;
	}

}
