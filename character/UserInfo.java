package character;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import farm.Inventory;
import item.Weapon;
import town.*;
import myNetwork.*;


public class UserInfo extends Character
{
	
	int size = 0; // 서버에 저장된 정보
	/**유저 객체 생성**/
	public static void userInfo() {

		Socket socket = myClient.socket;
		String duplicate; // 중복인지 아닌지
		try {
        	//Socket으로부터 입력스트림을 얻는다.
			DataInputStream in = new DataInputStream(socket.getInputStream());
			//Socket으로부터 출력스트림을 얻는다.
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		
			Scanner scanner = new Scanner(System.in);
			String name = "";
			String gender = "";
			String userPress = "";
			
			while(true) {
			if(gender.equals("m")|| gender.equals("w"))
				break;
			System.out.println("성별을 선택하세요.");
			System.out.print("남성 > m, 여성 > w : ");
			gender = scanner.next();
			}
			
			while(true) {
				if(userPress.equals("y")) 
					break;
				System.out.print("이름을 입력하세요.(공백 불가능) : ");
				name = scanner.next();
				
				try {
					out.writeUTF("2");
					out.writeUTF(name);
				} catch (IOException e) {
					e.printStackTrace();
				}
				String answer = in.readUTF();
				if(answer.equals("Yes")) {
					System.out.println("중복된 이름입니다. 다시 입력해주세요.");
					continue;
				}
				else if(answer.equals("No")) {
					System.out.print(name + "(이)로 정하시겠습니까?(y/n)> ");
					userPress = scanner.next();
				}
			}
			user = new Farmer(name, gender, 100, 100, 0, 0, 1);
			user.setTools(MartItem.getBasicTools());
			Inventory.setBasicTool(MartItem.getBasicTools().get(1), MartItem.getBasicTools().get(2), MartItem.getBasicTools().get(3));
			Weapon weapon1 = new Weapon("없음",0,0);
			user.setWeapon(weapon1);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void userInfo(String name, int hp, int Maxhp, int gold, String weapon_name) {

			user = new Farmer(name, "없음", hp, Maxhp, 0, gold, 0);
			if(weapon_name.equals("없음")) { // 무기가 없을 때
				Weapon weapon1 = new Weapon("없음",0,0);
				user.setWeapon(weapon1);
			}
			else { // 저장된 무기 장착
				int i = 0;
				for(i = 0; i < MartItem.getWeapons().size(); i++) {
					if( MartItem.getWeapons().get(i).getName().equals(weapon_name)) {
						user.setWeapon( MartItem.getWeapons().get(i));
						user.initItem(MartItem.getWeapons().get(i));
						MartItem.getWeapons().remove(i);
						break;
					}
					 user.initItem(MartItem.getWeapons().get(i));
					 MartItem.getWeapons().remove(i);
				}
			}
			
	}
	
	
	
	public static void userInfo(String name, String gender, int hp, int maxHp, int power, int gold, int level
			,String weapon_name, String sickle_name, String hoe_name, String fishingRod_name) {
		user = new Farmer(name, gender, hp, maxHp, power, gold, level);
		Mart.storyCount = 1;
		if(weapon_name.equals("없음")) { // 무기가 없을 때
			Weapon weapon1 = new Weapon("없음",0,0);
			user.setWeapon(weapon1);
		}
		else { // 저장된 무기 장착
			int i = 0;
			for(i = 0; i < MartItem.getWeapons().size(); i++) {
				if( MartItem.getWeapons().get(i).getName().equals(weapon_name)) {
					user.setWeapon( MartItem.getWeapons().get(i));
					user.initItem(MartItem.getWeapons().get(i));
					MartItem.getWeapons().remove(i);
					break;
				}
				 user.initItem(MartItem.getWeapons().get(i));
				 MartItem.getWeapons().remove(i);
			}
		}
		
		if(sickle_name.equals("돌 낫") && hoe_name.equals("돌 괭이") && fishingRod_name.equals("돌 낚싯대")) {
			user.setTools(MartItem.getBasicTools());
			Inventory.setBasicTool(MartItem.getBasicTools().get(1), MartItem.getBasicTools().get(2), MartItem.getBasicTools().get(3));
		}
		else {
			switch(sickle_name) {
			case "구리 낫":
				user.setSickle(MartItem.getCopperTools().get(0));
				user.initItem(MartItem.getCopperTools().get(0));
				MartItem.getCopperTools().remove(0);
				break;
			case "철 낫":
				user.setSickle(MartItem.getIronTools().get(0));
				user.initItem(MartItem.getIronTools().get(0));
				MartItem.getIronTools().remove(0);
				break;
			case "이리듐 낫":
				user.setSickle(MartItem.getIridiumTools().get(0));
				user.initItem(MartItem.getIridiumTools().get(0));
				MartItem.getIridiumTools().remove(0);
				break;
			}
			switch(hoe_name) {
			case "구리 괭이":
				user.setSickle(MartItem.getCopperTools().get(1));
				user.initItem(MartItem.getCopperTools().get(1));
				MartItem.getCopperTools().remove(1);
				break;
			case "철 괭이":
				user.setSickle(MartItem.getIronTools().get(1));
				user.initItem(MartItem.getIronTools().get(1));
				MartItem.getIronTools().remove(1);
				break;
			case "이리듐 괭이":
				user.setSickle(MartItem.getIridiumTools().get(1));
				user.initItem(MartItem.getIridiumTools().get(1));
				MartItem.getIridiumTools().remove(1);
				break;
			}
			switch(fishingRod_name) {
			case "구리 낚싯대":
				user.setSickle(MartItem.getCopperTools().get(2));
				user.initItem(MartItem.getCopperTools().get(2));
				MartItem.getCopperTools().remove(2);
				break;
			case "철 낚싯대":
				user.setSickle(MartItem.getIronTools().get(2));
				user.initItem(MartItem.getIronTools().get(2));
				MartItem.getIronTools().remove(2);
				break;
			case "이리듐 낚싯대":
				user.setSickle(MartItem.getIridiumTools().get(2));
				user.initItem(MartItem.getIridiumTools().get(2));
				MartItem.getIridiumTools().remove(2);
				break;
			}		
		}	
		
	}
	
	@Override
	public void attack(Monster monster, Farmer user) {
		;
	}

	@Override
	public void die(Character monster) {
		;
	}
	
}
