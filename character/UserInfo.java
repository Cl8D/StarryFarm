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
	
	int size = 0; // ������ ����� ����
	/**���� ��ü ����**/
	public static void userInfo() {

		Socket socket = myClient.socket;
		String duplicate; // �ߺ����� �ƴ���
		try {
        	//Socket���κ��� �Է½�Ʈ���� ��´�.
			DataInputStream in = new DataInputStream(socket.getInputStream());
			//Socket���κ��� ��½�Ʈ���� ��´�.
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		
			Scanner scanner = new Scanner(System.in);
			String name = "";
			String gender = "";
			String userPress = "";
			
			while(true) {
			if(gender.equals("m")|| gender.equals("w"))
				break;
			System.out.println("������ �����ϼ���.");
			System.out.print("���� > m, ���� > w : ");
			gender = scanner.next();
			}
			
			while(true) {
				if(userPress.equals("y")) 
					break;
				System.out.print("�̸��� �Է��ϼ���.(���� �Ұ���) : ");
				name = scanner.next();
				
				try {
					out.writeUTF("2");
					out.writeUTF(name);
				} catch (IOException e) {
					e.printStackTrace();
				}
				String answer = in.readUTF();
				if(answer.equals("Yes")) {
					System.out.println("�ߺ��� �̸��Դϴ�. �ٽ� �Է����ּ���.");
					continue;
				}
				else if(answer.equals("No")) {
					System.out.print(name + "(��)�� ���Ͻðڽ��ϱ�?(y/n)> ");
					userPress = scanner.next();
				}
			}
			user = new Farmer(name, gender, 100, 100, 0, 0, 1);
			user.setTools(MartItem.getBasicTools());
			Inventory.setBasicTool(MartItem.getBasicTools().get(1), MartItem.getBasicTools().get(2), MartItem.getBasicTools().get(3));
			Weapon weapon1 = new Weapon("����",0,0);
			user.setWeapon(weapon1);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void userInfo(String name, int hp, int Maxhp, int gold, String weapon_name) {

			user = new Farmer(name, "����", hp, Maxhp, 0, gold, 0);
			if(weapon_name.equals("����")) { // ���Ⱑ ���� ��
				Weapon weapon1 = new Weapon("����",0,0);
				user.setWeapon(weapon1);
			}
			else { // ����� ���� ����
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
		if(weapon_name.equals("����")) { // ���Ⱑ ���� ��
			Weapon weapon1 = new Weapon("����",0,0);
			user.setWeapon(weapon1);
		}
		else { // ����� ���� ����
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
		
		if(sickle_name.equals("�� ��") && hoe_name.equals("�� ����") && fishingRod_name.equals("�� ���˴�")) {
			user.setTools(MartItem.getBasicTools());
			Inventory.setBasicTool(MartItem.getBasicTools().get(1), MartItem.getBasicTools().get(2), MartItem.getBasicTools().get(3));
		}
		else {
			switch(sickle_name) {
			case "���� ��":
				user.setSickle(MartItem.getCopperTools().get(0));
				user.initItem(MartItem.getCopperTools().get(0));
				MartItem.getCopperTools().remove(0);
				break;
			case "ö ��":
				user.setSickle(MartItem.getIronTools().get(0));
				user.initItem(MartItem.getIronTools().get(0));
				MartItem.getIronTools().remove(0);
				break;
			case "�̸��� ��":
				user.setSickle(MartItem.getIridiumTools().get(0));
				user.initItem(MartItem.getIridiumTools().get(0));
				MartItem.getIridiumTools().remove(0);
				break;
			}
			switch(hoe_name) {
			case "���� ����":
				user.setSickle(MartItem.getCopperTools().get(1));
				user.initItem(MartItem.getCopperTools().get(1));
				MartItem.getCopperTools().remove(1);
				break;
			case "ö ����":
				user.setSickle(MartItem.getIronTools().get(1));
				user.initItem(MartItem.getIronTools().get(1));
				MartItem.getIronTools().remove(1);
				break;
			case "�̸��� ����":
				user.setSickle(MartItem.getIridiumTools().get(1));
				user.initItem(MartItem.getIridiumTools().get(1));
				MartItem.getIridiumTools().remove(1);
				break;
			}
			switch(fishingRod_name) {
			case "���� ���˴�":
				user.setSickle(MartItem.getCopperTools().get(2));
				user.initItem(MartItem.getCopperTools().get(2));
				MartItem.getCopperTools().remove(2);
				break;
			case "ö ���˴�":
				user.setSickle(MartItem.getIronTools().get(2));
				user.initItem(MartItem.getIronTools().get(2));
				MartItem.getIronTools().remove(2);
				break;
			case "�̸��� ���˴�":
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
