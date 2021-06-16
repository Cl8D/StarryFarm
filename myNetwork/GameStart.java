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
	  //Socket을 매개변수로 받는 생성자.
	  String name;
	  public GameStart(Socket socket, String name){
	      this.socket = socket;
	      this.name = name;
	      mymap = new myMap();
	      try{
	          in = new DataInputStream(this.socket.getInputStream());
	          out = new DataOutputStream(socket.getOutputStream());
	      }catch(Exception e){
	          System.out.println("예외:"+e);
	      }
	  }//생성자 --------------------

	  public void run(){ //run()메소드 재정의
	      
		  try {
			out.writeUTF("2");
			out.writeUTF(name);
			try {
				System.out.println("정보를 검색 중입니다...");
				Thread.sleep(1000); // 잠시 대기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String check_name = in.readUTF();
			if(check_name.equals("No")) {
				System.out.println("저장된 정보가 없습니다. 게임을 종료합니다.");
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
					System.out.println("정보를 검색 중입니다...");
					Thread.sleep(1000); // 잠시 대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		  	}
			catch (Exception e) {
				e.printStackTrace();
			}

		  
		  
		  try {
				Thread.sleep(2000); //2초 대기
			   } catch (InterruptedException e) {
				   e.printStackTrace();
			   }  
		  
		  /************************초기 시작 화면 ********************************/

			File starryFarm = new File("./StarryFarm.txt");
			FileRead.hasThreadTxt(starryFarm); 
			Scanner scanner = new Scanner(System.in);
			System.out.println("================================================================");
			System.out.println("Starry Farm 재방문을 환영합니다.");
			Farm.first_count = 1;
			UserInfo.userInfo(mymap.getName(), mymap.getGender(), mymap.getHp(), mymap.getMaxHp(),mymap.getPower()
					,mymap.getGold(), mymap.getLevel(), mymap.getWeapon_name(), mymap.getSickle_name(),
					mymap.getHoe_name(),mymap.getFishingRod_name());
			Farm myFarm = new Farm();
			myFarm.setFarmName(mymap.getFarmname(), mymap.getSeason(), mymap.getYear(), mymap.getDay()); 
			/*** 내 농장으로 가기 ***/
			myFarm.myFarm();		  
		 
	  }//run()------
}
