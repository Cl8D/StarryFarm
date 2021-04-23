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
		
		/*********************������*********************/
		/**********************����*********************/
		Item sword1 = new Weapon("�콼 ��", 50, 3);
		Item sword2 = new Weapon("���� ��", 150, 5);
		Item sword3 = new Weapon("��ö �ܰ�", 450, 8);
		Item sword4 = new Weapon("�� �ܰ�", 750, 15);
		Item sword5 = new Weapon("ĿƲ��", 1500, 17);
		Item sword6 = new Weapon("����� ��", 4500, 30);
		Item sword7 = new Weapon("��� ��", 8000, 38);
		Item sword8 = new Weapon("�ż��� ��", 13000, 45);
		Item sword9 = new Weapon("��� ��", 25000, 64);
		Item sword10 = new Weapon("������ ��", 50000, 80); 
		
		/********************����***********************/
		Item tool1 = new Tool("�� �Ѹ���", 0, 10);
		Item tool2 = new Tool("�� ��", 0, 10);
		Item tool3 = new Tool("�� ����", 0, 10);
		Item tool4 = new Tool("�� ���˴�", 0, 10);
		
		Item tool5 = new Tool("���� ��", 1000, 20);
		Item tool6 = new Tool("���� ����", 1000, 20);
		Item tool7 = new Tool("���� ���˴�", 2000, 20);
		
		Item tool8 = new Tool("ö ��", 3000, 50);
		Item tool9 = new Tool("ö ����", 3000, 50);
		Item tool10 = new Tool("ö ���˴�", 5000, 50);
		
		Item tool11 = new Tool("�̸��� ��", 10000, 100);
		Item tool12 = new Tool("�̸��� ����", 10000, 100);
		Item tool13 = new Tool("�̸��� ���˴�", 30000, 100);
		
		/***********************�����********************/
		Item fish1 = new Fish("����ġ", 60, "��", "easy");
		Item fish2 = new Fish("����", 120, "��", "medium");
		Item fish3 = new Fish("��ġ", 60, "��", "easy");
		Item fish4 = new Fish("���", 170, "��", "hard");
		Item fish5 = new Fish("���ڹ�", 200, "��", "hard");
		Item fish6 = new Fish("������ �����", 1000, "��", "expert");
		
		Item fish7 = new Fish("����", 75, "����", "easy");
		Item fish8 = new Fish("ƿ���Ǿ�", 150, "����", "medium");
		Item fish9 = new Fish("����", 300, "����", "hard");
		Item fish10 = new Fish("��ġ", 200, "����", "hard");
		Item fish11 = new Fish("����", 400, "����", "hard");
		Item fish12 = new Fish("ũ�����ǽ�", 3000, "����", "expert");
		
		Item fish13 = new Fish("���", 80, "����", "easy");
		Item fish14 = new Fish("����", 150, "����", "medium");
		Item fish15 = new Fish("Ÿ�̰� �۾�", 300, "����", "hard");
		Item fish16 = new Fish("�ޱ�", 400, "����", "hard");
		Item fish17 = new Fish("������", 210, "����", "hard");
		Item fish18 = new Fish("�Ʊ�", 1800, "����", "expert");
		
		Item fish19 = new Fish("û��", 60, "�ܿ�", "easy");
		Item fish20 = new Fish("��¡��", 160, "�ܿ�", "medium");
		Item fish21 = new Fish("��ġ", 180, "�ܿ�", "medium");
		Item fish22 = new Fish("��ġ", 200, "����", "hard");
		Item fish23 = new Fish("���뷡��", 240, "����", "hard");
		Item fish24 = new Fish("���� �����", 2000, "����", "expert");
		
		/*********************����***********************/
		Item seed1 = new Seed("�Ľ��� ����", 20, "��", 4);
		Item seed2 = new Seed("���� ����", 50, "��", 6);
		Item seed3 = new Seed("�ݸ��ö�� ����", 80, "��", 12);
		Item seed4 = new Seed("���� ����", 40, "��", 4);
		Item seed5 = new Seed("���� ����", 100, "��", 8);
		
		Item seed6 = new Seed("��� ����", 80, "����", 12);
		Item seed7 = new Seed("���� ����� ����", 100, "����", 9);
		Item seed8 = new Seed("��纣�� ����", 80, "����", 5);
		Item seed9 = new Seed("�丶�� ����", 100, "����", 6);
		Item seed10 = new Seed("��Ÿ�ĸ��� ����", 400, "����", 13);
		
		Item seed11 = new Seed("�� ����", 60, "����", 10);
		Item seed12 = new Seed("���� ����", 60, "����", 14);
		Item seed13 = new Seed("�Ƹ����� ����", 70, "����", 7);
		Item seed14 = new Seed("û��ä ����", 50, "����", 4);
		Item seed15 = new Seed("ȣ�� ����", 100, "����", 13);
		
		
		/*********************����***********************/
		Item fruit1 = new Fruit("�Ľ���", 52, "��", 5);
		Item fruit2 = new Fruit("����", 120, "��", 15);
		Item fruit3 = new Fruit("�ݸ��ö��", 262, "��", 38);
		Item fruit4 = new Fruit("����", 90, "��", 10);
		Item fruit5 = new Fruit("����", 180, "��", 25);
		
		Item fruit6 = new Fruit("���", 375, "����", 40);
		Item fruit7 = new Fruit("���� �����", 390, "����", 43);
		Item fruit8 = new Fruit("��纣��", 75, "����", 7);
		Item fruit9 = new Fruit("�丶��", 90, "����", 10);
		Item fruit10 = new Fruit("��Ÿ�ĸ���", 1125, "����", 150);
		
		Item fruit11 = new Fruit("��", 240, "����", 34);
		Item fruit12 = new Fruit("����", 160, "����", 23);
		Item fruit13 = new Fruit("�Ƹ�����", 255, "����", 38);
		Item fruit14 = new Fruit("û��ä", 120, "����", 15);
		Item fruit15 = new Fruit("ȣ��", 480, "����", 57);
		
		/*********************����***********************/
		//���� 1~5��, 
		Monster monster1 = new Monster("����", "����", 1, 1, 8, 10, 1);
		Monster monster2 = new Monster("����", "����", 20, 20, 4, 80, 1);
		Monster monster3 = new Monster("���� ����", "����", 24, 24, 6, 100, 1);
		Monster monster4 = new Monster("�ʷ� ������", "����", 24, 24, 5, 100, 1);
		
		//���� 6~10��
		Monster monster5 = new Monster("���� �ĸ�", "����", 66, 66, 12, 250, 2);
		Monster monster6 = new Monster("��� ����", "����", 80, 80, 15, 320, 2);
		Monster monster7 = new Monster("����", "����", 96, 96, 10, 400, 2);
		
		//���� 11��~15��
		Monster monster8 = new Monster("��� ��", "����", 120, 120, 15, 480, 3);
		Monster monster9 = new Monster("���� ������", "����", 150, 150, 23, 550, 3);
		Monster monster10 = new Monster("���� �׸���", "����", 160, 160, 18, 640, 3);
		
		//���� 16��~20��
		Monster monster11 = new Monster("���� ������", "����", 205, 205, 16, 800, 4);
		Monster monster12 = new Monster("��", "����", 250, 250, 25, 960, 4);
		
		//���� 21��~25��
		Monster monster13 = new Monster("�̶�", "����", 260, 260, 30, 1040, 5);
		Monster monster14 = new Monster("��ź ����", "����", 300, 300, 35, 1200, 5);
		
		//���� 26��~30��
		Monster monster15 = new Monster("���� ������", "����", 410, 410, 16, 1300, 6);
		Monster monster16 = new Monster("�̸��� ��", "����", 450, 450, 50, 1760, 6);
		
		/********************** ����Ʈ�� �ֱ� ***********************/
		
		//���� ����Ʈ
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
		
		// �⺻ ���� ����Ʈ
		List<Tool> basicTool = new ArrayList<Tool>();
		basicTool.add((Tool) tool1);
		basicTool.add((Tool) tool2);
		basicTool.add((Tool) tool3);
		basicTool.add((Tool) tool4);
		
		// ���� ���� ����Ʈ
		List<Tool> copperTool = new ArrayList<Tool>();
		copperTool.add((Tool) tool5);
		copperTool.add((Tool) tool6);
		copperTool.add((Tool) tool7);
		
		// ö ���� ����Ʈ
		List<Tool> ironTool = new ArrayList<Tool>();
		ironTool.add((Tool) tool8);
		ironTool.add((Tool) tool9);
		ironTool.add((Tool) tool10);
		
		// �̸��� ����Ʈ
		List<Tool> iridiumTool = new ArrayList<Tool>();
		iridiumTool.add((Tool) tool11);
		iridiumTool.add((Tool) tool12);
		iridiumTool.add((Tool) tool13);
		
		// �� ���� ����Ʈ
		List<Seed> springSeed = new ArrayList<Seed>();
		springSeed.add((Seed) seed1);
		springSeed.add((Seed) seed2);
		springSeed.add((Seed) seed3);
		springSeed.add((Seed) seed4);
		springSeed.add((Seed) seed5);
		
		// ���� ���� ����Ʈ
		List<Seed> summerSeed = new ArrayList<Seed>();
		summerSeed.add((Seed) seed6);
		summerSeed.add((Seed) seed7);
		summerSeed.add((Seed) seed8);
		summerSeed.add((Seed) seed9);
		summerSeed.add((Seed) seed10);
		
		// ���� ���� ����Ʈ
		List<Seed> autumnSeed = new ArrayList<Seed>();
		autumnSeed.add((Seed) seed11);
		autumnSeed.add((Seed) seed12);
		autumnSeed.add((Seed) seed13);
		autumnSeed.add((Seed) seed14);
		autumnSeed.add((Seed) seed15);
		
		MartItem itemLists = new MartItem(weaponList, basicTool, copperTool, ironTool, iridiumTool, springSeed, summerSeed, autumnSeed);
		Inventory inven_SeedLists = new Inventory("seed", springSeed, summerSeed, autumnSeed);
		Field field_SeedList = new Field("seed", springSeed, summerSeed, autumnSeed);
		
		//�� ���� ����Ʈ
		List<Fruit> springFruit = new ArrayList<Fruit>();
		springFruit.add((Fruit) fruit1);
		springFruit.add((Fruit) fruit2);
		springFruit.add((Fruit) fruit3);
		springFruit.add((Fruit) fruit4);
		springFruit.add((Fruit) fruit5);
		
		//���� ���� ����Ʈ
		List<Fruit> summerFruit = new ArrayList<Fruit>();
		summerFruit.add((Fruit) fruit6);
		summerFruit.add((Fruit) fruit7);
		summerFruit.add((Fruit) fruit8);
		summerFruit.add((Fruit) fruit9);
		summerFruit.add((Fruit) fruit10);
		
		//���� ���� ����Ʈ
		List<Fruit> autumnFruit = new ArrayList<Fruit>();
		autumnFruit.add((Fruit) fruit11);
		autumnFruit.add((Fruit) fruit12);
		autumnFruit.add((Fruit) fruit13);
		autumnFruit.add((Fruit) fruit14);
		autumnFruit.add((Fruit) fruit15);
		
		Inventory inven_FruitList = new Inventory(springFruit, summerFruit, autumnFruit);
		Field field_FruitList = new Field(springFruit, summerFruit, autumnFruit);
		
		// �� ����� ����Ʈ
		List<Fish> springFish = new ArrayList<Fish>();
		springFish.add((Fish) fish1);
		springFish.add((Fish) fish2);
		springFish.add((Fish) fish3);
		springFish.add((Fish) fish4);
		springFish.add((Fish) fish5);
		springFish.add((Fish) fish6);
		
		//���� ����� ����Ʈ
		List<Fish> summerFish= new ArrayList<Fish>();
		summerFish.add((Fish) fish7);
		summerFish.add((Fish) fish8);
		summerFish.add((Fish) fish9);
		summerFish.add((Fish) fish10);
		summerFish.add((Fish) fish11);
		summerFish.add((Fish) fish12);
		
		//���� ����� ����Ʈ
		List<Fish> autumnFish = new ArrayList<Fish>();
		autumnFish.add((Fish) fish13);
		autumnFish.add((Fish) fish14);
		autumnFish.add((Fish) fish15);
		autumnFish.add((Fish) fish16);
		autumnFish.add((Fish) fish17);
		autumnFish.add((Fish) fish18);
		
		//�ܿ� ����� ����Ʈ
		List <Fish> winterFish = new ArrayList<Fish>();
		winterFish.add((Fish) fish19);
		winterFish.add((Fish) fish20);
		winterFish.add((Fish) fish21);
		winterFish.add((Fish) fish22);
		winterFish.add((Fish) fish23);
		winterFish.add((Fish) fish24);
		
		Lake FishList = new Lake(springFish, summerFish, autumnFish, winterFish);
		Inventory fishList = new Inventory(springFish, summerFish, autumnFish, winterFish);
		
		//���� 1~5�� ����
		List <Monster> level1_Monster = new ArrayList<Monster>();
		level1_Monster.add((Monster) monster1);
		level1_Monster.add((Monster) monster2);
		level1_Monster.add((Monster) monster3);
		level1_Monster.add((Monster) monster4);
		
		//6��~10��
		List <Monster> level2_Monster = new ArrayList<Monster>();
		level2_Monster.add((Monster) monster3);
		level2_Monster.add((Monster) monster4);
		level2_Monster.add((Monster) monster5);
		level2_Monster.add((Monster) monster6);
		level2_Monster.add((Monster) monster7);
		
		//11��~15��
		List <Monster> level3_Monster = new ArrayList<Monster>();
		level3_Monster.add((Monster) monster6);
		level3_Monster.add((Monster) monster7);
		level3_Monster.add((Monster) monster8);
		level3_Monster.add((Monster) monster9);
		level3_Monster.add((Monster) monster10);
		
		//16��~20��
		List <Monster> level4_Monster = new ArrayList<Monster>();
		level4_Monster.add((Monster) monster8);
		level4_Monster.add((Monster) monster9);
		level4_Monster.add((Monster) monster10);
		level4_Monster.add((Monster) monster11);
		level4_Monster.add((Monster) monster12);
		
		//21��~25��
		List <Monster> level5_Monster = new ArrayList<Monster>();
		level5_Monster.add((Monster) monster11);
		level5_Monster.add((Monster) monster12);
		level5_Monster.add((Monster) monster13);
		level5_Monster.add((Monster) monster14);
		
		//26��~30��
		List <Monster> level6_Monster = new ArrayList<Monster>();
		level6_Monster.add((Monster) monster13);
		level6_Monster.add((Monster) monster14);
		level6_Monster.add((Monster) monster15);
		level6_Monster.add((Monster) monster16);
		
		Cave MonsterList = new Cave(level1_Monster, level2_Monster, level3_Monster, level4_Monster, level5_Monster, level6_Monster);
		
		/************************�ʱ� ���� ȭ�� ********************************/
		File starryFarm = new File("./StarryFarm.txt");
		FileRead.hasThreadTxt(starryFarm); 
		Scanner scanner = new Scanner(System.in);
		System.out.println("================================================================");
		System.out.println("Starry Farm�� ���� ���� ȯ���մϴ�.");
		System.out.print("������ �����Ͻðڽ��ϱ�?(y/other keys)> ");
		String userPress = scanner.next();
		if(userPress.equals("y")) {
			ClearConsole.clearConsole();
			/*** ĳ���� ���� ***/
			UserInfo.userInfo();
			ClearConsole.clearConsole();
			/*** ���� ���丮 ���� ***/
			StartStory.firstStory(); 
			/*** ���� �̸� ���ϱ� ***/
			Farm myFarm = new Farm();
			myFarm.setFarmName(); 
			/*** �� �������� ���� ***/
			myFarm.myFarm();
		}
		else {
			System.out.println("������ �����մϴ�.");
			System.exit(0);
		}

	}

}




