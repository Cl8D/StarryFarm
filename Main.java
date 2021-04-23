import character.Monster;
import character.UserInfo;
import farm.Farm;
import farm.Field;
import farm.Inventory;
import gamestory.StartStory;
import town.Cave;
import town.Lake;
import town.MartItem;

import item.Fish;
import item.Fruit;
import item.Item;
import item.Seed;
import item.Tool;
import item.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import console.ClearConsole;
import console.FileRead;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		
		/*********************¾ÆÀÌÅÛ*********************/
		/**********************¹«±â*********************/
		Item sword1 = new Weapon("³ì½¼ °Ë", 50, 3);
		Item sword2 = new Weapon("³ª¹« °Ë", 150, 5);
		Item sword3 = new Weapon("°­Ã¶ ´Ü°Ë", 450, 8);
		Item sword4 = new Weapon("Àº ´Ü°Ë", 750, 15);
		Item sword5 = new Weapon("Ä¿Æ²¶ó½º", 1500, 17);
		Item sword6 = new Weapon("¾îµÒÀÇ °Ë", 4500, 30);
		Item sword7 = new Weapon("Èæ¿ä °Ë", 8000, 38);
		Item sword8 = new Weapon("½Å¼ºÀÇ °Ë", 13000, 45);
		Item sword9 = new Weapon("¿ë¾Ï °Ë", 25000, 64);
		Item sword10 = new Weapon("°¶·°½Ã °Ë", 50000, 80); 
		
		/********************µµ±¸***********************/
		Item tool1 = new Tool("¹° »Ñ¸®°³", 0, 10);
		Item tool2 = new Tool("µ¹ ³´", 0, 10);
		Item tool3 = new Tool("µ¹ ±ªÀÌ", 0, 10);
		Item tool4 = new Tool("µ¹ ³¬½Ë´ë", 0, 10);
		
		Item tool5 = new Tool("±¸¸® ³´", 1000, 20);
		Item tool6 = new Tool("±¸¸® ±ªÀÌ", 1000, 20);
		Item tool7 = new Tool("±¸¸® ³¬½Ë´ë", 2000, 20);
		
		Item tool8 = new Tool("Ã¶ ³´", 3000, 50);
		Item tool9 = new Tool("Ã¶ ±ªÀÌ", 3000, 50);
		Item tool10 = new Tool("Ã¶ ³¬½Ë´ë", 5000, 50);
		
		Item tool11 = new Tool("ÀÌ¸®µã ³´", 10000, 100);
		Item tool12 = new Tool("ÀÌ¸®µã ±ªÀÌ", 10000, 100);
		Item tool13 = new Tool("ÀÌ¸®µã ³¬½Ë´ë", 30000, 100);
		
		/***********************¹°°í±â********************/
		Item fish1 = new Fish("°³º¹Ä¡", 60, "º½", "easy");
		Item fish2 = new Fish("Àü¾î", 120, "º½", "medium");
		Item fish3 = new Fish("¸êÄ¡", 60, "º½", "easy");
		Item fish4 = new Fish("Àå¾î", 170, "º½", "hard");
		Item fish5 = new Fish("°¡ÀÚ¹Ì", 200, "º½", "hard");
		Item fish6 = new Fish("Àü¼³ÀÇ ¹°°í±â", 1000, "º½", "expert");
		
		Item fish7 = new Fish("¼þ¾î", 75, "¿©¸§", "easy");
		Item fish8 = new Fish("Æ¿¶óÇÇ¾Æ", 150, "¿©¸§", "medium");
		Item fish9 = new Fish("¹®¾î", 300, "¿©¸§", "hard");
		Item fish10 = new Fish("ÂüÄ¡", 200, "¿©¸§", "hard");
		Item fish11 = new Fish("º¹¾î", 400, "¿©¸§", "hard");
		Item fish12 = new Fish("Å©¸²½¼ÇÇ½¬", 3000, "¿©¸§", "expert");
		
		Item fish13 = new Fish("Á¤¾î¸®", 80, "°¡À»", "easy");
		Item fish14 = new Fish("¿¬¾î", 150, "°¡À»", "medium");
		Item fish15 = new Fish("Å¸ÀÌ°Å ¼Û¾î", 300, "°¡À»", "hard");
		Item fish16 = new Fish("¸Þ±â", 400, "°¡À»", "hard");
		Item fish17 = new Fish("¿ù¾ÆÀÌ", 210, "°¡À»", "hard");
		Item fish18 = new Fish("¾Æ±Í", 1800, "°¡À»", "expert");
		
		Item fish19 = new Fish("Ã»¾î", 60, "°Ü¿ï", "easy");
		Item fish20 = new Fish("¿ÀÂ¡¾î", 160, "°Ü¿ï", "medium");
		Item fish21 = new Fish("³ÒÄ¡", 180, "°Ü¿ï", "medium");
		Item fish22 = new Fish("ÂüÄ¡", 200, "¿©¸§", "hard");
		Item fish23 = new Fish("¹ü³ë·¡¹Ì", 240, "¿©¸§", "hard");
		Item fish24 = new Fish("¾óÀ½ ¹°°í±â", 2000, "¿©¸§", "expert");
		
		/*********************¾¾¾Ñ***********************/
		Item seed1 = new Seed("ÆÄ½º´Õ ¾¾¾Ñ", 20, "º½", 4);
		Item seed2 = new Seed("°¨ÀÚ ¾¾¾Ñ", 50, "º½", 6);
		Item seed3 = new Seed("ÄÝ¸®ÇÃ¶ó¿ö ¾¾¾Ñ", 80, "º½", 12);
		Item seed4 = new Seed("¸¶´Ã ¾¾¾Ñ", 40, "º½", 4);
		Item seed5 = new Seed("µþ±â ¾¾¾Ñ", 100, "º½", 8);
		
		Item seed6 = new Seed("¸á·Ð ¾¾¾Ñ", 80, "¿©¸§", 12);
		Item seed7 = new Seed("ºÓÀº ¾ç¹èÃß ¾¾¾Ñ", 100, "¿©¸§", 9);
		Item seed8 = new Seed("ºí·çº£¸® ¾¾¾Ñ", 80, "¿©¸§", 5);
		Item seed9 = new Seed("Åä¸¶Åä ¾¾¾Ñ", 100, "¿©¸§", 6);
		Item seed10 = new Seed("½ºÅ¸ÈÄ¸£Ã÷ ¾¾¾Ñ", 400, "¿©¸§", 13);
		
		Item seed11 = new Seed("¸¶ ¾¾¾Ñ", 60, "°¡À»", 10);
		Item seed12 = new Seed("Æ÷µµ ¾¾¾Ñ", 60, "°¡À»", 14);
		Item seed13 = new Seed("¾Æ¸¶¶õ½º ¾¾¾Ñ", 70, "°¡À»", 7);
		Item seed14 = new Seed("Ã»°æÃ¤ ¾¾¾Ñ", 50, "°¡À»", 4);
		Item seed15 = new Seed("È£¹Ú ¾¾¾Ñ", 100, "°¡À»", 13);
		
		
		/*********************°úÀÏ***********************/
		Item fruit1 = new Fruit("ÆÄ½º´Õ", 52, "º½", 5);
		Item fruit2 = new Fruit("°¨ÀÚ", 120, "º½", 15);
		Item fruit3 = new Fruit("ÄÝ¸®ÇÃ¶ó¿ö", 262, "º½", 38);
		Item fruit4 = new Fruit("¸¶´Ã", 90, "º½", 10);
		Item fruit5 = new Fruit("µþ±â", 180, "º½", 25);
		
		Item fruit6 = new Fruit("¸á·Ð", 375, "¿©¸§", 40);
		Item fruit7 = new Fruit("ºÓÀº ¾ç¹èÃß", 390, "¿©¸§", 43);
		Item fruit8 = new Fruit("ºí·çº£¸®", 75, "¿©¸§", 7);
		Item fruit9 = new Fruit("Åä¸¶Åä", 90, "¿©¸§", 10);
		Item fruit10 = new Fruit("½ºÅ¸ÈÄ¸£Ã÷", 1125, "¿©¸§", 150);
		
		Item fruit11 = new Fruit("¸¶", 240, "°¡À»", 34);
		Item fruit12 = new Fruit("Æ÷µµ", 160, "°¡À»", 23);
		Item fruit13 = new Fruit("¾Æ¸¶¶õ½º", 255, "°¡À»", 38);
		Item fruit14 = new Fruit("Ã»°æÃ¤", 120, "°¡À»", 15);
		Item fruit15 = new Fruit("È£¹Ú", 480, "°¡À»", 57);
		
		/*********************¸ó½ºÅÍ***********************/
		//µ¿±¼ 1~5Ãþ, 
		Monster monster1 = new Monster("¹ú·¹", "¼öÄÆ", 1, 1, 8, 10, 1);
		Monster monster2 = new Monster("À¯Ãæ", "¼öÄÆ", 20, 20, 4, 80, 1);
		Monster monster3 = new Monster("°ËÁ¤ ¹ÚÁã", "¾ÏÄÆ", 24, 24, 6, 100, 1);
		Monster monster4 = new Monster("ÃÊ·Ï ½½¶óÀÓ", "¾ÏÄÆ", 24, 24, 5, 100, 1);
		
		//µ¿±¼ 6~10Ãþ
		Monster monster5 = new Monster("º¯Á¾ ÆÄ¸®", "¼öÄÆ", 66, 66, 12, 250, 2);
		Monster monster6 = new Monster("¿ë¾Ï ¹ÚÁã", "¼öÄÆ", 80, 80, 15, 320, 2);
		Monster monster7 = new Monster("À¯·É", "¾ÏÄÆ", 96, 96, 10, 400, 2);
		
		//µ¿±¼ 11Ãþ~15Ãþ
		Monster monster8 = new Monster("¿ë¾Ï °Ô", "¼öÄÆ", 120, 120, 15, 480, 3);
		Monster monster9 = new Monster("´«²É ½½¶óÀÓ", "¼öÄÆ", 150, 150, 23, 550, 3);
		Monster monster10 = new Monster("°ËÀº ±×¸²ÀÚ", "¾ÏÄÆ", 160, 160, 18, 640, 3);
		
		//µ¿±¼ 16Ãþ~20Ãþ
		Monster monster11 = new Monster("»¡°­ ½½¶óÀÓ", "¾ÏÄÆ", 205, 205, 16, 800, 4);
		Monster monster12 = new Monster("¿ë", "¼öÄÆ", 250, 250, 25, 960, 4);
		
		//µ¿±¼ 21Ãþ~25Ãþ
		Monster monster13 = new Monster("¹Ì¶ó", "¾ÏÄÆ", 260, 260, 30, 1040, 5);
		Monster monster14 = new Monster("¼®Åº ±«¹°", "¼öÄÆ", 300, 300, 35, 1200, 5);
		
		//µ¿±¼ 26Ãþ~30Ãþ
		Monster monster15 = new Monster("º¸¶ó ½½¶óÀÓ", "¼öÄÆ", 410, 410, 16, 1300, 6);
		Monster monster16 = new Monster("ÀÌ¸®µã °ñ·½", "¾ÏÄÆ", 450, 450, 50, 1760, 6);
		
		/********************** ¸®½ºÆ®¿¡ ³Ö±â ***********************/
		
		//¹«±â ¸®½ºÆ®
		List<Weapon> weaponList = new ArrayList<Weapon>();
		weaponList.add((Weapon) sword1);
		weaponList.add((Weapon) sword2);
		weaponList.add((Weapon) sword3);
		weaponList.add((Weapon) sword4);
		weaponList.add((Weapon) sword5);
		weaponList.add((Weapon) sword6);
		weaponList.add((Weapon) sword7);
		weaponList.add((Weapon) sword8);
		weaponList.add((Weapon) sword9);
		weaponList.add((Weapon) sword10);
		
		// ±âº» µµ±¸ ¸®½ºÆ®
		List<Tool> basicTool = new ArrayList<Tool>();
		basicTool.add((Tool) tool1);
		basicTool.add((Tool) tool2);
		basicTool.add((Tool) tool3);
		basicTool.add((Tool) tool4);
		
		// ±¸¸® µµ±¸ ¸®½ºÆ®
		List<Tool> copperTool = new ArrayList<Tool>();
		copperTool.add((Tool) tool5);
		copperTool.add((Tool) tool6);
		copperTool.add((Tool) tool7);
		
		// Ã¶ µµ±¸ ¸®½ºÆ®
		List<Tool> ironTool = new ArrayList<Tool>();
		ironTool.add((Tool) tool8);
		ironTool.add((Tool) tool9);
		ironTool.add((Tool) tool10);
		
		// ÀÌ¸®µã ¸®½ºÆ®
		List<Tool> iridiumTool = new ArrayList<Tool>();
		iridiumTool.add((Tool) tool11);
		iridiumTool.add((Tool) tool12);
		iridiumTool.add((Tool) tool13);
		
		// º½ ¾¾¾Ñ ¸®½ºÆ®
		List<Seed> springSeed = new ArrayList<Seed>();
		springSeed.add((Seed) seed1);
		springSeed.add((Seed) seed2);
		springSeed.add((Seed) seed3);
		springSeed.add((Seed) seed4);
		springSeed.add((Seed) seed5);
		
		// ¿©¸§ ¾¾¾Ñ ¸®½ºÆ®
		List<Seed> summerSeed = new ArrayList<Seed>();
		summerSeed.add((Seed) seed6);
		summerSeed.add((Seed) seed7);
		summerSeed.add((Seed) seed8);
		summerSeed.add((Seed) seed9);
		summerSeed.add((Seed) seed10);
		
		// °¡À» ¾¾¾Ñ ¸®½ºÆ®
		List<Seed> autumnSeed = new ArrayList<Seed>();
		autumnSeed.add((Seed) seed11);
		autumnSeed.add((Seed) seed12);
		autumnSeed.add((Seed) seed13);
		autumnSeed.add((Seed) seed14);
		autumnSeed.add((Seed) seed15);
		
		MartItem itemLists = new MartItem(weaponList, basicTool, copperTool, ironTool, iridiumTool, springSeed, summerSeed, autumnSeed);
		Inventory inven_SeedLists = new Inventory("seed", springSeed, summerSeed, autumnSeed);
		Field field_SeedList = new Field("seed", springSeed, summerSeed, autumnSeed);
		
		//º½ °úÀÏ ¸®½ºÆ®
		List<Fruit> springFruit = new ArrayList<Fruit>();
		springFruit.add((Fruit) fruit1);
		springFruit.add((Fruit) fruit2);
		springFruit.add((Fruit) fruit3);
		springFruit.add((Fruit) fruit4);
		springFruit.add((Fruit) fruit5);
		
		//¿©¸§ °úÀÏ ¸®½ºÆ®
		List<Fruit> summerFruit = new ArrayList<Fruit>();
		summerFruit.add((Fruit) fruit6);
		summerFruit.add((Fruit) fruit7);
		summerFruit.add((Fruit) fruit8);
		summerFruit.add((Fruit) fruit9);
		summerFruit.add((Fruit) fruit10);
		
		//°¡À» °úÀÏ ¸®½ºÆ®
		List<Fruit> autumnFruit = new ArrayList<Fruit>();
		autumnFruit.add((Fruit) fruit11);
		autumnFruit.add((Fruit) fruit12);
		autumnFruit.add((Fruit) fruit13);
		autumnFruit.add((Fruit) fruit14);
		autumnFruit.add((Fruit) fruit15);
		
		Inventory inven_FruitList = new Inventory(springFruit, summerFruit, autumnFruit);
		Field field_FruitList = new Field(springFruit, summerFruit, autumnFruit);
		
		// º½ ¹°°í±â ¸®½ºÆ®
		List<Fish> springFish = new ArrayList<Fish>();
		springFish.add((Fish) fish1);
		springFish.add((Fish) fish2);
		springFish.add((Fish) fish3);
		springFish.add((Fish) fish4);
		springFish.add((Fish) fish5);
		springFish.add((Fish) fish6);
		
		//¿©¸§ ¹°°í±â ¸®½ºÆ®
		List<Fish> summerFish= new ArrayList<Fish>();
		summerFish.add((Fish) fish7);
		summerFish.add((Fish) fish8);
		summerFish.add((Fish) fish9);
		summerFish.add((Fish) fish10);
		summerFish.add((Fish) fish11);
		summerFish.add((Fish) fish12);
		
		//°¡À» ¹°°í±â ¸®½ºÆ®
		List<Fish> autumnFish = new ArrayList<Fish>();
		autumnFish.add((Fish) fish13);
		autumnFish.add((Fish) fish14);
		autumnFish.add((Fish) fish15);
		autumnFish.add((Fish) fish16);
		autumnFish.add((Fish) fish17);
		autumnFish.add((Fish) fish18);
		
		//°Ü¿ï ¹°°í±â ¸®½ºÆ®
		List <Fish> winterFish = new ArrayList<Fish>();
		winterFish.add((Fish) fish19);
		winterFish.add((Fish) fish20);
		winterFish.add((Fish) fish21);
		winterFish.add((Fish) fish22);
		winterFish.add((Fish) fish23);
		winterFish.add((Fish) fish24);
		
		Lake FishList = new Lake(springFish, summerFish, autumnFish, winterFish);
		Inventory fishList = new Inventory(springFish, summerFish, autumnFish, winterFish);
		
		//µ¿±¼ 1~5Ãþ ¸ó½ºÅÍ
		List <Monster> level1_Monster = new ArrayList<Monster>();
		level1_Monster.add((Monster) monster1);
		level1_Monster.add((Monster) monster2);
		level1_Monster.add((Monster) monster3);
		level1_Monster.add((Monster) monster4);
		
		//6Ãþ~10Ãþ
		List <Monster> level2_Monster = new ArrayList<Monster>();
		level2_Monster.add((Monster) monster3);
		level2_Monster.add((Monster) monster4);
		level2_Monster.add((Monster) monster5);
		level2_Monster.add((Monster) monster6);
		level2_Monster.add((Monster) monster7);
		
		//11Ãþ~15Ãþ
		List <Monster> level3_Monster = new ArrayList<Monster>();
		level3_Monster.add((Monster) monster6);
		level3_Monster.add((Monster) monster7);
		level3_Monster.add((Monster) monster8);
		level3_Monster.add((Monster) monster9);
		level3_Monster.add((Monster) monster10);
		
		//16Ãþ~20Ãþ
		List <Monster> level4_Monster = new ArrayList<Monster>();
		level4_Monster.add((Monster) monster8);
		level4_Monster.add((Monster) monster9);
		level4_Monster.add((Monster) monster10);
		level4_Monster.add((Monster) monster11);
		level4_Monster.add((Monster) monster12);
		
		//21Ãþ~25Ãþ
		List <Monster> level5_Monster = new ArrayList<Monster>();
		level5_Monster.add((Monster) monster11);
		level5_Monster.add((Monster) monster12);
		level5_Monster.add((Monster) monster13);
		level5_Monster.add((Monster) monster14);
		
		//26Ãþ~30Ãþ
		List <Monster> level6_Monster = new ArrayList<Monster>();
		level6_Monster.add((Monster) monster13);
		level6_Monster.add((Monster) monster14);
		level6_Monster.add((Monster) monster15);
		level6_Monster.add((Monster) monster16);
		
		Cave MonsterList = new Cave(level1_Monster, level2_Monster, level3_Monster, level4_Monster, level5_Monster, level6_Monster);
		
		/************************ÃÊ±â ½ÃÀÛ È­¸é ********************************/
		File starryFarm = new File("./StarryFarm.txt");
		FileRead.hasThreadTxt(starryFarm); 
		Scanner scanner = new Scanner(System.in);
		System.out.println("================================================================");
		System.out.println("Starry Farm¿¡ ¿À½Å °ÍÀ» È¯¿µÇÕ´Ï´Ù.");
		System.out.print("°ÔÀÓÀ» ½ÃÀÛÇÏ½Ã°Ú½À´Ï±î?(y/other keys)> ");
		String userPress = scanner.next();
		if(userPress.equals("y")) {
			ClearConsole.clearConsole();
			/*** Ä³¸¯ÅÍ ¼³Á¤ ***/
			UserInfo.userInfo();
			ClearConsole.clearConsole();
			/*** °ÔÀÓ ½ºÅä¸® ½ÃÀÛ ***/
			StartStory.firstStory(); 
			/*** ³óÀå ÀÌ¸§ Á¤ÇÏ±â ***/
			Farm myFarm = new Farm();
			myFarm.setFarmName(); 
			/*** ³» ³óÀåÀ¸·Î °¡±â ***/
			myFarm.myFarm();
		}
		else {
			System.out.println("°ÔÀÓÀ» Á¾·áÇÕ´Ï´Ù.");
			System.exit(0);
		}

	}

}




