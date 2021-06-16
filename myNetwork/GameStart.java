package myNetwork;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import character.*;
import console.*;
import farm.*;
import gamestory.*;
import item.*;
import town.*;

public class GameStart extends Thread {
	
	
	  static myMap mymap;
	  DataOutputStream out;
	  Socket socket;
	  DataInputStream in;
	  //Socket�� �Ű������� �޴� ������.
	  String name;
	  public GameStart(Socket socket, String name){
	      this.socket = socket;
	      this.name = name;
	      mymap = new myMap();
	      try{
	          in = new DataInputStream(this.socket.getInputStream());
	          out = new DataOutputStream(socket.getOutputStream());
	      }catch(Exception e){
	          System.out.println("����:"+e);
	      }
	  }//������ --------------------

	  public void run(){ //run()�޼ҵ� ������
	      
		  try {
			out.writeUTF("2");
			out.writeUTF(name);
			try {
				System.out.println("������ �˻� ���Դϴ�...");
				Thread.sleep(1000); // ��� ���
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String check_name = in.readUTF();
			if(check_name.equals("No")) {
				System.out.println("����� ������ �����ϴ�. ������ �����մϴ�.");
				System.exit(0);
			}
		  	} catch (IOException e1) {
			e1.printStackTrace();
		  	}
		  
		  try {
				out.writeUTF("5");
				try {
					GameStart.mymap.setSeason(in.readUTF());
	            	GameStart.mymap.setYear(Integer.parseInt(in.readUTF()));
	            	GameStart.mymap.setDay(Integer.parseInt(in.readUTF()));
	            	GameStart.mymap.setName(in.readUTF());
	            	GameStart.mymap.setFarmname(in.readUTF());
	            	GameStart.mymap.setGender(in.readUTF());
	            	GameStart.mymap.setGold2(Integer.parseInt(in.readUTF()));
	            	GameStart.mymap.setHp2(Integer.parseInt(in.readUTF()));
	            	GameStart.mymap.setMaxHp(Integer.parseInt(in.readUTF()));
	            	GameStart.mymap.setPower(Integer.parseInt(in.readUTF()));
	            	GameStart.mymap.setLevel(Integer.parseInt(in.readUTF()));
	            	GameStart.mymap.setWeapon_name(in.readUTF());
	            	GameStart.mymap.setSickle_name(in.readUTF());
	            	GameStart.mymap.setHoe_name(in.readUTF());
	            	GameStart.mymap.setFishingRod_name(in.readUTF());
					System.out.println("������ �˻� ���Դϴ�...");
					Thread.sleep(1000); // ��� ���
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		  	}
			catch (Exception e) {
				e.printStackTrace();
			}

		  
		  
		  try {
				Thread.sleep(2000); //2�� ���
			   } catch (InterruptedException e) {
				   e.printStackTrace();
			   }  
		  
		  /************************�ʱ� ���� ȭ�� ********************************/

			File starryFarm = new File("./StarryFarm.txt");
			FileRead.hasThreadTxt(starryFarm); 
			Scanner scanner = new Scanner(System.in);
			System.out.println("================================================================");
			System.out.println("Starry Farm ��湮�� ȯ���մϴ�.");
			Farm.first_count = 1;
			UserInfo.userInfo(mymap.getName(), mymap.getGender(), mymap.getHp(), mymap.getMaxHp(),mymap.getPower()
					,mymap.getGold(), mymap.getLevel(), mymap.getWeapon_name(), mymap.getSickle_name(),
					mymap.getHoe_name(),mymap.getFishingRod_name());
			Farm myFarm = new Farm();
			myFarm.setFarmName(mymap.getFarmname(), mymap.getSeason(), mymap.getYear(), mymap.getDay()); 
			/*** �� �������� ���� ***/
			myFarm.myFarm();		  
		 
	  }//run()------
}
