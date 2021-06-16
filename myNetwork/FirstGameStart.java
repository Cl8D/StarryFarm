package myNetwork;
import java.io.DataInputStream;
import java.io.File;
import java.net.Socket;
import java.util.Scanner;

import character.*;
import console.*;
import farm.*;
import gamestory.*;


public class FirstGameStart extends Thread {
	
	
	
	  Socket socket;
	  //Socket�� �Ű������� �޴� ������.

	  public FirstGameStart(Socket socket){
	      this.socket = socket;
	      
	  }//������ --------------------

	 

	  public void run(){ //run()�޼ҵ� ������
	      
		  /************************�ʱ� ���� ȭ�� ********************************/
		  try {
				Thread.sleep(2000); //2�� ���
			   } catch (InterruptedException e) {
				   e.printStackTrace();
			   }
		  
			File starryFarm = new File("./StarryFarm.txt");
			FileRead.hasThreadTxt(starryFarm); 
			Scanner scanner = new Scanner(System.in);
			System.out.println("================================================================");
			System.out.println("ó�� Starry Farm�� ���� ���� ȯ���մϴ�.");
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
		  

	  }//run()------
}
