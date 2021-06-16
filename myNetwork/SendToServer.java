package myNetwork;

import java.io.DataOutputStream;

import java.io.IOException;

import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import character.*;
import console.*;
import farm.*;
import gamestory.*;
import item.*;
import town.*;

public class SendToServer extends Farmer implements Runnable{
	  Socket socket;

	  DataOutputStream out;
	  
	  String season; 
	  int year;
	  int day;
	  String FarmName;
	  public SendToServer(String season, int year, int day, String FarmName){ //소켓과 사용자 이름을 받는다.
		  this.socket = myClient.socket; 
		  this.season = season;
		  this.year = year;
		  this.day = day;
		  this.FarmName = FarmName;
		  
	      try{
	          out = new DataOutputStream(this.socket.getOutputStream());
	          //this.name = name; //받아온 사용자이름을 전역변수에 저장, 다른 메서드인 run()에서 사용하기위함.
	      }catch(Exception e){
	          System.out.println("예외:"+e);
	      }
	  }


	public void run(){ //run()메소드 재정의
	          try {
	        	  	out.writeUTF(season);
					out.writeUTF(Integer.toString(year));
					out.writeUTF(Integer.toString(day));
					out.writeUTF(user.getName());
					out.writeUTF(FarmName);
					out.writeUTF(user.getGender());
					out.writeUTF(Integer.toString(user.getGold()));
					out.writeUTF(Integer.toString(user.getHp()));
					out.writeUTF(Integer.toString(user.getMaxHp()));
					out.writeUTF(Integer.toString(user.getPower()));
					out.writeUTF(Integer.toString(user.getLevel()));
					out.writeUTF(user.getWeapon().getName());
					out.writeUTF(user.getSickle().getName());
					out.writeUTF(user.getHoe().getName());
					out.writeUTF(user.getFishingRod().getName());
					System.out.println("저장이 완료되었습니다.");	
	        	  
			} catch (IOException e) {
				e.printStackTrace();
			}
	  }//run()------

}
