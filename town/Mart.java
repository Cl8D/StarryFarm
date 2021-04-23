package town;

import java.util.Scanner;

import console.ClearConsole;
import console.ConsoleStop;
import character.UserInfo;
import farm.Farm;
import farm.Inventory;
import gamestory.SpringStory;

class Mart extends Inventory{
	private int storyCount = 0;
	
	WhatItem whatItem = new WhatItem();
	
	 void showMart() {
		while(true) {
		ClearConsole.clearConsole();
		System.out.println("============================================================");
		System.out.println("		띠링- 어서오세요. 이클의 잡화점입니다.		");
		System.out.println("============================================================");
		ConsoleStop.threadSleep(500);
		if((storyCount == 0) && (Farm.getYear() == 1) && (Farm.getSeason().equals("봄")) && (Farm.getDay() == 1)){
			SpringStory.first_mart();
			System.out.println("============================================================");
			
			for(int i =0; i< MartItem.getBasicTools().size(); i++) {
				if(i == MartItem.getBasicTools().size() - 1)
					System.out.println(MartItem.getBasicTools().get(i).getName() + "을(를) 얻었습니다!");
				else
					System.out.print(MartItem.getBasicTools().get(i).getName() + ",");
			}
		
			user.setTools(MartItem.getBasicTools());
			ConsoleStop.threadSleep(1000);
			storyCount++;
		}
		Inventory.setBasicTool(MartItem.getBasicTools().get(1), MartItem.getBasicTools().get(2), MartItem.getBasicTools().get(3));
		ClearConsole.clearConsole();
		while(true) {
		System.out.println("============================================================");
		System.out.println("		무엇을 하시겠어요?		");
		System.out.println("		▶1. 물건 구매하기		");
		System.out.println("		▶2. 물건 판매하기		");
		System.out.println("		▶3. 마트에서 나오기		");
		System.out.println("============================================================");
		
		Scanner scanner = new Scanner(System.in);
			System.out.print("(1~3)>>");
			int userPress = 0;
			userPress = scanner.nextInt();
			switch(userPress) {
			case 1 :
				buyItem();
				break;
			case 2 :
				sellItem();
				break;
			case 3 :
				return;
			default: 
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
			}
		}
		}
	}
	
	private void buyItem() {
		while(true) {
		ClearConsole.clearConsole();
		System.out.println("============================================================");
		System.out.println("		구매하고자 하는 아이템을 선택해 주세요.		");
		System.out.println("		(무기/도구류는 한 번만 구입이 가능해요.(영구제)) - 구매 후 인벤토리에서 장착 필수");
		System.out.println("		▶1. 무기		");
		System.out.println("		▶2. 도구		");
		System.out.println("		▶3. 씨앗 		");
		System.out.println("		▶0. 뒤로 가기 		");
		System.out.println("=============================================================");
		
		Scanner scanner = new Scanner(System.in);
			System.out.print("(0~3)>>");
			int userPress = 0;
			userPress = scanner.nextInt();
			switch(userPress) {
			case 0 :
				return;
			case 1 :
				whatItem.weaponList();
				break;
			case 2 :
				whatItem.toolList();
				break;
			case 3 :
				whatItem.seedList();
				break;
			default: 
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
		
			}
		}
	}
	
	public void sellItem() {
		ClearConsole.clearConsole();
		System.out.println("============================================================");
		System.out.println("		판매하고자 하는 아이템을 선택해 주세요.		");
		System.out.println("============================================================");
		System.out.println("		▶1. 과일		");
		System.out.println("		▶2. 물고기		");
		System.out.println("		▶0. 뒤로 가기		");
		System.out.println("=============================================================");
		Scanner scanner = new Scanner(System.in);
		int userPress = 0;
		System.out.print("(0~2)>>");
		userPress = scanner.nextInt();
		
		if(userPress == 0)
			return;
		
		else if(userPress == 1) {
			while(true) {
			ClearConsole.clearConsole();
			System.out.println("=============================================================");
			System.out.println("		▶보유 과일		");
			showFruit();
			System.out.println("		판매할 과일을 골라 주세요.		");
			System.out.println("		(뒤로 가기: 0)		");
			System.out.println("=============================================================");
			System.out.print("(0~5)>>");
			userPress = scanner.nextInt();
			int fruitCount = 0;
			switch(userPress) {
			case 0 :
				return;
				
			case 1 :
				System.out.print("		판매할 개수를 입력해 주세요(보유 수보다 큰 수 입력 시 전부가 팔아집니다!): ");
				fruitCount = scanner.nextInt();
				if(Farm.getSeason().equals("봄")) {
					int count = springP;
					springP -= fruitCount;
					if(springP < 0) {
						fruitCount = count;
						springP = 0;
					}
					user.setGold(springFruits.get(0).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("여름")) {
					int count = summerM;
					summerM -= fruitCount;
					if(summerM < 0) {
						fruitCount = count;
						summerM = 0;
					}
					user.setGold(summerFruits.get(0).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("가을")) {
					int count = autumnM;
					autumnM -= fruitCount;
					if(autumnM < 0) {
						fruitCount = count;
						autumnM = 0;
					}
					user.setGold(autumnFruits.get(0).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				break;
				
			case 2:
				System.out.print("		판매할 개수를 입력해 주세요(보유 수보다 큰 수 입력 시 전부가 팔아집니다!): ");
				fruitCount = scanner.nextInt();
				if(Farm.getSeason().equals("봄")) {
					int count = springG;
					springG -= fruitCount;
					if(springG < 0) {
						fruitCount = count;
						springG = 0;
					}
					user.setGold(springFruits.get(1).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("여름")) {
					int count = summerR;
					summerR -= fruitCount;
					if(summerR < 0) {
						fruitCount = count;
						summerR = 0;
					}
					user.setGold(summerFruits.get(1).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("가을")) {
					int count = autumnG;
					autumnG -= fruitCount;
					if(autumnG < 0) {
						fruitCount = count;
						autumnG = 0;
					}
					user.setGold(autumnFruits.get(1).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				break;
				
			case 3:
				System.out.print("		판매할 개수를 입력해 주세요(보유 수보다 큰 수 입력 시 전부가 팔아집니다!): ");
				fruitCount = scanner.nextInt();
				if(Farm.getSeason().equals("봄")) {
					int count = springC;
					springC -= fruitCount;
					if(springC < 0) {
						fruitCount = count;
						springC = 0;
					}
					user.setGold(springFruits.get(2).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("여름")) {
					int count = summerB;
					summerB -= fruitCount;
					if(summerB < 0) {
						fruitCount = count;
						summerB = 0;
					}
					user.setGold(summerFruits.get(2).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("가을")) {
					int count = autumnA;
					autumnA -= fruitCount;
					if(autumnA < 0) {
						fruitCount = count;
						autumnA = 0;
					}
					user.setGold(autumnFruits.get(2).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				break;
				
			case 4 :
				System.out.print("		판매할 개수를 입력해 주세요(보유 수보다 큰 수 입력 시 전부가 팔아집니다!): ");
				fruitCount = scanner.nextInt();
				if(Farm.getSeason().equals("봄")) {
					int count = springM;
					springM -= fruitCount;
					if(springM < 0) {
						fruitCount = count;
						springM = 0;
					}
					user.setGold(springFruits.get(3).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("여름")) {
					int count = summerT;
					summerT -= fruitCount;
					if(summerT < 0) {
						fruitCount = count;
						summerT = 0;
					}
					user.setGold(summerFruits.get(3).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("가을")) {
					int count = autumnC;
					autumnC -= fruitCount;	
					if(autumnC < 0) {
						fruitCount = count;
						autumnC = 0;
					}
					user.setGold(autumnFruits.get(3).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				break;
			case 5:
				System.out.print("		판매할 개수를 입력해 주세요(보유 수보다 큰 수 입력 시 전부가 팔아집니다!): ");
				fruitCount = scanner.nextInt();
				if(Farm.getSeason().equals("봄")) {
					int count = springS;
					springS -= fruitCount;
					if(springS < 0) {
						fruitCount = count;
						springS = 0;
					}
					user.setGold(springFruits.get(4).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("여름")) {
					int count = summerS;
					summerS -= fruitCount;
					if(summerS < 0) {
						fruitCount = count;
						summerS = 0;
					}
					user.setGold(summerFruits.get(4).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("가을")) {
					int count = autumnP;
					autumnP -= fruitCount;
					if(autumnP < 0) {
						fruitCount = count;
						autumnP = 0;
					}
					user.setGold(autumnFruits.get(4).getPrice() * fruitCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				break;
			}
			ConsoleStop.threadSleep(1000);
			}
		}
		
		else if(userPress == 2) {
			while(true) {
			ClearConsole.clearConsole();
			System.out.println("=============================================================");
			System.out.println("		▶보유 물고기		");
			showFish();
			System.out.println("		판매할 물고기를 골라 주세요.		");
			System.out.println("		(뒤로 가기: 0)		");
			System.out.println("=============================================================");
			System.out.print("(0~6)>>");
			userPress = scanner.nextInt();
			int fishCount = 0;
			switch(userPress) {
			case 0 :
				return;
			case 1 :
				System.out.print("		판매할 개수를 입력해 주세요(보유 수보다 큰 수 입력 시 전부가 팔아집니다!): ");
				fishCount = scanner.nextInt();
			
				if(Farm.getSeason().equals("봄")) {
					int count = springF1;
					springF1 -= fishCount;
					if(springF1 < 0) {
						fishCount = count;
						springF1 = 0;
					}
					user.setGold(springFishes.get(0).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("여름")) {
					int count = summerF1;
					summerF1 -= fishCount;
					if(summerF1 < 0) {
						fishCount = count;
						summerF1 = 0;
					}
					user.setGold(summerFishes.get(0).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("가을")) {
					int count = autumnF1;
					autumnF1 -= fishCount;
					if(autumnF1 < 0) {
						fishCount = count;
						autumnF1 = 0;
					}
					user.setGold(autumnFishes.get(0).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("겨을")) {
					int count = winterF1;
					winterF1 -= fishCount;
					if(winterF1 < 0) {
						fishCount = count;
						winterF1 = 0;
					}
					user.setGold(winterFishes.get(0).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				break;
				
			case 2:
				System.out.print("		판매할 개수를 입력해 주세요(보유 수보다 큰 수 입력 시 전부가 팔아집니다!): ");
				fishCount = scanner.nextInt();
				if(Farm.getSeason().equals("봄")) {
					int count = springF2;
					springF2 -= fishCount;
					if(springF2 < 0) {
						fishCount = count;
						springF2 = 0;
					}
					user.setGold(springFishes.get(1).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("여름")) {
					int count = summerF2;
					summerF2 -= fishCount;
					if(summerF2 < 0) {
						fishCount = count;
						summerF2 = 0;
					}
					user.setGold(summerFishes.get(1).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("가을")) {
					int count = autumnF2;
					autumnF2 -= fishCount;
					if(autumnF2 < 0) {
						fishCount = count;
						autumnF2 = 0;
					}
					user.setGold(autumnFishes.get(1).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("겨을")) {
					int count = winterF2;
					winterF2 -= fishCount;
					if(winterF2 < 0) {
						fishCount = count;
						winterF2 = 0;
					}
					user.setGold(winterFishes.get(0).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				break;
				
			case 3:
				System.out.print("		판매할 개수를 입력해 주세요(보유 수보다 큰 수 입력 시 전부가 팔아집니다!): ");
				fishCount = scanner.nextInt();
				if(Farm.getSeason().equals("봄")) {
					int count = springF3;
					springF3 -= fishCount;
					if(springF3 < 0) {
						fishCount = count;
						springF3 = 0;
					}
					user.setGold(springFishes.get(2).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("여름")) {
					int count = summerF3;
					summerF3 -= fishCount;
					if(summerF3 < 0) {
						fishCount = count;
						summerF3 = 0;
					}
					user.setGold(summerFishes.get(2).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("가을")) {
					int count = autumnF3;
					autumnF3 -= fishCount;
					if(autumnF3 < 0) {
						fishCount = count;
						autumnF3 = 0;
					}
					user.setGold(autumnFishes.get(2).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("겨을")) {
					int count = winterF3;
					winterF3 -= fishCount;
					if(winterF3 < 0) {
						fishCount = count;
						winterF3 = 0;
					}
					user.setGold(winterFishes.get(0).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				break;
				
			case 4 :
				System.out.print("		판매할 개수를 입력해 주세요(보유 수보다 큰 수 입력 시 전부가 팔아집니다!): ");
				fishCount = scanner.nextInt();
				if(Farm.getSeason().equals("봄")) {
					int count = springF4;
					springF4 -= fishCount;
					if(springF4 < 0) {
						fishCount = count;
						springF4 = 0;
					}
					user.setGold(springFishes.get(3).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("여름")) {
					int count = summerF4;
					summerF4 -= fishCount;
					if(summerF4 < 0) {
						fishCount = count;
						summerF4 = 0;
					}
					user.setGold(summerFishes.get(3).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("가을")) {
					int count = autumnF4;
					autumnF4 -= fishCount;	
					if(autumnF4 < 0) {
						fishCount = count;
						autumnF4 = 0;
					}
					user.setGold(autumnFishes.get(3).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("겨을")) {
					int count = winterF4;
					winterF4 -= fishCount;
					if(winterF4 < 0) {
						fishCount = count;
						winterF4 = 0;
					}
					user.setGold(winterFishes.get(0).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				break;
			case 5:
				System.out.print("		판매할 개수를 입력해 주세요(보유 수보다 큰 수 입력 시 전부가 팔아집니다!): ");
				fishCount = scanner.nextInt();
				if(Farm.getSeason().equals("봄")) {
					int count = springF5;
					springF5 -= fishCount;
					if(springF5 < 0) {
						fishCount = count;
						springF5 = 0;
					}
					user.setGold(springFishes.get(4).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("여름")) {
					int count = summerF5;
					summerF5 -= fishCount;
					if(summerF5 < 0) {
						fishCount = count;
						summerF5 = 0;
					}
					user.setGold(summerFishes.get(4).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("가을")) {
					int count = autumnF5;
					autumnF5 -= fishCount;
					if(autumnF5 < 0) {
						fishCount = count;
						autumnF5 = 0;
					}
					user.setGold(autumnFishes.get(4).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("겨을")) {
					int count = winterF5;
					winterF5 -= fishCount;
					if(winterF5 < 0) {
						fishCount = count;
						winterF5 = 0;
					}
					user.setGold(winterFishes.get(0).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
			case 6:
				System.out.print("		판매할 개수를 입력해 주세요(보유 수보다 큰 수 입력 시 전부가 팔아집니다!): ");
				fishCount = scanner.nextInt();
				if(Farm.getSeason().equals("봄")) {
					int count = springF6;
					springF6 -= fishCount;
					if(springF6 < 0) {
						fishCount = count;
						springF6 = 0;
					}
					user.setGold(springFishes.get(5).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("여름")) {
					int count = summerF6;
					summerF6 -= fishCount;
					if(summerF6 < 0) {
						fishCount = count;
						summerF6 = 0;
					}
					user.setGold(summerFishes.get(5).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("가을")) {
					int count = autumnF6;
					autumnF6 -= fishCount;
					if(autumnF6 < 0) {
						fishCount = count;
						autumnF6 = 0;
					}
					user.setGold(autumnFishes.get(5).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				if(Farm.getSeason().equals("겨을")) {
					int count = winterF6;
					winterF6 -= fishCount;
					if(winterF6 < 0) {
						fishCount = count;
						winterF6 = 0;
					}
					user.setGold(winterFishes.get(0).getPrice() * fishCount);
					System.out.println("		잔액: " + user.getGold() + "G");
				}
				break;
				}
			ConsoleStop.threadSleep(1000);
			}
	}
	}
}

/************************아이템 리스트 출력 *********************************/
class WhatItem extends UserInfo{
	
	public void weaponList() {
		while(true) {
		ClearConsole.clearConsole();
		System.out.println("======================================================================================");
		System.out.println("		**무기 리스트입니다. 구매하고자 하는 무기를 선택해 주세요.**		");
		System.out.println("		▶0. 뒤로 가기		");
		for(int i=0; i< MartItem.getWeapons().size(); i++) {
			System.out.println("		▶" + (i+1) + ". " + MartItem.getWeapons().get(i).getName() + "( 데미지: " + MartItem.getWeapons().get(i).getDamage() + " ) ------- 가격: " + MartItem.getWeapons().get(i).getPrice() +"G");
		}
		System.out.println("=====================================================================================");
		
		Scanner scanner = new Scanner(System.in);
		
			System.out.print("(0~10)>>");
			int userPress = 0;
			userPress = scanner.nextInt();
			String isSuccess = "";
			
			switch(userPress) {
			case 0 :
				return;
			case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10:
				for(int i =0; i< MartItem.getWeapons().size(); i++) {
					if(userPress == (i+1)) {
						isSuccess = user.buyItem(MartItem.getWeapons().get(i));
						if(isSuccess.equals("Success")) {
							System.out.println("		" + MartItem.getWeapons().get(i).getName() + "(이)가 구매 완료되었습니다!		");
							System.out.println("		잔액: " + user.getGold() + "G");
							MartItem.getWeapons().remove(i);
						}
						else
							System.out.println("		 잔액이 부족합니다.		");
						ConsoleStop.threadSleep(1000);
					}
				}
				break;
				
			default: 
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
		}
		
		}
	}
	
	public void toolList() {
		while(true) {
		ClearConsole.clearConsole();
		System.out.println("======================================================================================");
		System.out.println("		**도구 리스트입니다. 구매하고자 하는 도구를 선택해 주세요.**		");
		System.out.println("		▶1. 구리 재질 도구		");
		System.out.println("		▶2. 철 재질 도구		");
		System.out.println("		▶3. 이리듐 재질 도구		");
		System.out.println("		▶0. 뒤로 가기		");
		System.out.println("=====================================================================================");
		
		Scanner scanner = new Scanner(System.in);
			System.out.print("(0~3)>>");
			int userPress = 0;
			userPress = scanner.nextInt();
			switch(userPress) {
			case 0:
				return;
			case 1 :
				copperList();
				break;
			case 2 :
				ironList();
				break;
			case 3 :
				iridiumList();
				break;
			default: 
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
		}
		}
	}
	
	private void copperList() {
		while(true) {
		ClearConsole.clearConsole();
		System.out.println("======================================================================================");
		System.out.println("		**구리 재질 무기 리스트입니다. 구매하고자 하는 무기를 선택해 주세요.**		");
		System.out.println("		▶0. 뒤로 가기		");
		for(int i=0; i< MartItem.getCopperTools().size(); i++) {
			System.out.println("		▶" + (i+1) + ". " + MartItem.getCopperTools().get(i).getName() + "( 내구도: " + MartItem.getCopperTools().get(i).getPower() + " ) ------- 가격: " + MartItem.getCopperTools().get(i).getPrice() +"G");
		}
		System.out.println("=====================================================================================");
		
		Scanner scanner = new Scanner(System.in);
		
			System.out.print("(0~3)>>");
			int userPress = 0;
			userPress = scanner.nextInt();
			String isSuccess = "";
			switch(userPress) {
			case 0 :
				return;
			case 1: case 2: case 3: 
				for(int i =0; i< MartItem.getCopperTools().size(); i++) {
					if(userPress == (i+1)) {
						isSuccess = user.buyItem(MartItem.getCopperTools().get(i));
						if(isSuccess.equals("Success")) {
							System.out.println("		" + MartItem.getCopperTools().get(i).getName() + "(이)가 구매 완료되었습니다!		");
							MartItem.getCopperTools().remove(i);
							System.out.println("		잔액: " + user.getGold() + "G");
						}
						else
							System.out.println("		 잔액이 부족합니다.		");
						ConsoleStop.threadSleep(1000);
					}
				}
				break;
			default: 
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
		}
			
		}
	}
	
	private void ironList() {
		while(true) {
		ClearConsole.clearConsole();
		System.out.println("======================================================================================");
		System.out.println("		**철 재질 무기 리스트입니다. 구매하고자 하는 무기를 선택해 주세요.**		");
		System.out.println("		▶0. 뒤로 가기		");
		for(int i=0; i< MartItem.getIronTools().size(); i++) {
			System.out.println("		▶" + (i+1) + ". " + MartItem.getIronTools().get(i).getName() + "( 내구도: " + MartItem.getIronTools().get(i).getPower() + " ) ------- 가격: " + MartItem.getIronTools().get(i).getPrice() +"G");
		}
		System.out.println("=====================================================================================");
		
		Scanner scanner = new Scanner(System.in);
		
			System.out.print("(0~3)>>");
			int userPress = 0;
			userPress = scanner.nextInt();
			String isSuccess = "";
			switch(userPress) {
			case 0 :
				return;
			case 1 : case 2: case 3: 
				for(int i =0; i< MartItem.getIronTools().size(); i++) {
					if(userPress == (i+1)) {
						isSuccess = user.buyItem(MartItem.getIronTools().get(i));
						if(isSuccess.equals("Success")) {
							System.out.println("		" + MartItem.getIronTools().get(i).getName() + "(이)가 구매 완료되었습니다!		");
							MartItem.getIronTools().remove(i);
							System.out.println("		잔액: " + user.getGold() + "G");
						}
						else
							System.out.println("		 잔액이 부족합니다.		");
						ConsoleStop.threadSleep(1000);
					}
				}
				break;
			default: 
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
		}
		}
	}
	
	private void iridiumList() {
		while(true) {
		ClearConsole.clearConsole();
		System.out.println("======================================================================================");
		System.out.println("		**이리듐 재질 무기 리스트입니다. 구매하고자 하는 무기를 선택해 주세요.**		");
		System.out.println("		▶0. 뒤로 가기		");
		for(int i=0; i< MartItem.getIridiumTools().size(); i++) {
			System.out.println("		▶" + (i+1) + ". " + MartItem.getIridiumTools().get(i).getName() + "( 내구도: " + MartItem.getIridiumTools().get(i).getPower() + " ) ------- 가격: " + MartItem.getIridiumTools().get(i).getPrice() +"G");
		}
		System.out.println("=====================================================================================");
		
		Scanner scanner = new Scanner(System.in);
		
			System.out.print("(0~3)>>");
			int userPress = 0;
			userPress = scanner.nextInt();
			String isSuccess = "";
			switch(userPress) {
			case 0 :
				return;
			case 1: case 2 : case 3: 
				for(int i =0; i< MartItem.getIridiumTools().size(); i++) {
					if(userPress == (i+1)) {
						isSuccess = user.buyItem(MartItem.getIridiumTools().get(i));
						if(isSuccess.equals("Success")) {
							System.out.println("		" + MartItem.getIridiumTools().get(i).getName() + "(이)가 구매 완료되었습니다!		");
							MartItem.getIridiumTools().remove(i);
							System.out.println("		잔액: " + user.getGold() + "G");
						}
						else
							System.out.println("		 잔액이 부족합니다.		");
						ConsoleStop.threadSleep(1000);
					}
				}
				break;
			default: 
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
		}
		}
		
	}
	
	public void seedList() {
		while(true) {
		ClearConsole.clearConsole();
		Scanner scanner = new Scanner(System.in);
		String whatSeason = Farm.getSeason();
		System.out.println("======================================================================================");
		System.out.println("		**" + whatSeason +" 씨앗 리스트입니다. 구매하고자 하는 씨앗을 선택해 주세요.**		");
		System.out.println("		(계절에 해당하는 씨앗만 구매할 수 있습니다. 겨울용 씨앗은 판매하지 않아요.(겨울에는 농사 불가능))		");
		System.out.println("		▶0. 뒤로 가기		");
		
		if(whatSeason.equals("봄")) {
			for(int i=0; i< MartItem.getSpringSeeds().size(); i++) {
				System.out.println("		▶" + (i+1) + ". " + MartItem.getSpringSeeds().get(i).getName() + "( 자라는 기간: " + MartItem.getSpringSeeds().get(i).getTerm() + "일 ) ------- 가격: " + MartItem.getSpringSeeds().get(i).getPrice() +"G");
			}
			System.out.println("=====================================================================================");
		
				System.out.print("(0~5)>>");
				int userPress = 0;
				userPress = scanner.nextInt();
				String isSuccess = "";
				switch(userPress) {
				case 0 :
					return;
				case 1: case 2: case 3: case 4: case 5:
					System.out.print("		구입할 개수를 입력해 주세요: ");
					int seedCount = scanner.nextInt();
					for(int i =0; i< MartItem.getSpringSeeds().size(); i++) {
						if(userPress == (i+1)) {
							isSuccess = user.buyItem(MartItem.getSpringSeeds().get(i), seedCount, "봄");
							if(isSuccess.equals("Success")) { 
								System.out.println("		" + MartItem.getSpringSeeds().get(i).getName() + "(이)가 구매 완료되었습니다!		");
								System.out.println("		잔액: " + user.getGold() + "G");
							}
							else
								System.out.println("		 잔액이 부족합니다.		");
							ConsoleStop.threadSleep(1000);
						}
					}
					break;
				default: 
					System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
			}
		
		}

		
		else if(whatSeason.equals("여름")) {
			while(true) {
			for(int i=0; i< MartItem.getSummerSeeds().size(); i++) {
				System.out.println("		▶" + (i+1) + ". " + MartItem.getSummerSeeds().get(i).getName() + "( 자라는 기간: " + MartItem.getSummerSeeds().get(i).getTerm() + "일 ) ------- 가격: " + MartItem.getSummerSeeds().get(i).getPrice() +"G");
			}
			System.out.println("=====================================================================================");
				System.out.print("(0~5)>>");
				int userPress = 0;
				userPress = scanner.nextInt();
				String isSuccess = "";
				switch(userPress) {
				case 0 :
					return;
				case 1: case 2: case 3: case 4: case 5:
					System.out.print("		구입할 개수를 입력해 주세요: ");
					int seedCount = scanner.nextInt();
					for(int i =0; i< MartItem.getSummerSeeds().size(); i++) {
						if(userPress == (i+1)) {
							isSuccess = user.buyItem(MartItem.getSummerSeeds().get(i), seedCount, "여름");
							if(isSuccess.equals("Success")) { 
								System.out.println("		" + MartItem.getSummerSeeds().get(i).getName() + "(이)가 구매 완료되었습니다!		");
								System.out.println("		잔액: " + user.getGold() + "G");
							}
							else
								System.out.println("		 잔액이 부족합니다.		");
							ConsoleStop.threadSleep(1000);
						}
					}
					break;
				default: 
					System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
			}
			}
		}
		
		else if(whatSeason.equals("가을")) {
			while(true) {
			for(int i=0; i< MartItem.getAutumnSeeds().size(); i++) {
				System.out.println("		▶" + (i+1) + ". " + MartItem.getAutumnSeeds().get(i).getName() + "( 자라는 기간: " + MartItem.getAutumnSeeds().get(i).getTerm() + "일 ) ------- 가격: " + MartItem.getAutumnSeeds().get(i).getPrice() +"G");
			}
			System.out.println("=====================================================================================");
				System.out.print("(0~5)>>");
				int userPress = 0;
				userPress = scanner.nextInt();
				String isSuccess = "";
				switch(userPress) {
				case 0 :
					return;
				case 1: case 2: case 3: case 4: case 5:
					System.out.print("		구입할 개수를 입력해 주세요: ");
					int seedCount = scanner.nextInt();
					for(int i =0; i< MartItem.getAutumnSeeds().size(); i++) {
						if(userPress == (i+1)) {
							isSuccess = user.buyItem(MartItem.getAutumnSeeds().get(i), seedCount, "가을");
							if(isSuccess.equals("Success")) { 
								System.out.println("		" + MartItem.getAutumnSeeds().get(i).getName() + "(이)가 구매 완료되었습니다!		");
								System.out.println("		잔액: " + user.getGold() + "G");
							}
							else
								System.out.println("		 잔액이 부족합니다.		");
							ConsoleStop.threadSleep(1000);
						}
					}
					break;
				default: 
					System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				}
			}
		}
		
		else if(whatSeason.equals("겨울")) {
					int userPress = 0;
					userPress = scanner.nextInt();
					switch(userPress) {
					case 0 :
						return;
					default: 
						System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
					}
				}
		}
	}
}



