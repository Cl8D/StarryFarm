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
	  public SendToServer(String season, int year, int day, String FarmName){ //���ϰ� ����� �̸��� �޴´�.
		  this.socket = myClient.socket; 
		  this.season = season;
		  this.year = year;
		  this.day = day;
		  this.FarmName = FarmName;
		  
	      try{
	          out = new DataOutputStream(this.socket.getOutputStream());
	          //this.name = name; //�޾ƿ� ������̸��� ���������� ����, �ٸ� �޼����� run()���� ����ϱ�����.
	      }catch(Exception e){
	          System.out.println("����:"+e);
	      }
	  }


	public void run(){ //run()�޼ҵ� ������
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
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");	
	        	  
			} catch (IOException e) {
				e.printStackTrace();
			}
	  }//run()------

}
