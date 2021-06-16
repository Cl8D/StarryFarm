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
	  //Socket을 매개변수로 받는 생성자.

	  public FirstGameStart(Socket socket){
	      this.socket = socket;
	      
	  }//생성자 --------------------

	 

	  public void run(){ //run()메소드 재정의
	      
		  /************************초기 시작 화면 ********************************/
		  try {
				Thread.sleep(2000); //2초 대기
			   } catch (InterruptedException e) {
				   e.printStackTrace();
			   }
		  
			File starryFarm = new File("./StarryFarm.txt");
			FileRead.hasThreadTxt(starryFarm); 
			Scanner scanner = new Scanner(System.in);
			System.out.println("================================================================");
			System.out.println("처음 Starry Farm에 오신 것을 환영합니다.");
			/*** 캐릭터 설정 ***/
			UserInfo.userInfo();
			ClearConsole.clearConsole();
			/*** 게임 스토리 시작 ***/
			StartStory.firstStory(); 
			/*** 농장 이름 정하기 ***/
			Farm myFarm = new Farm();
			myFarm.setFarmName(); 
			/*** 내 농장으로 가기 ***/
			myFarm.myFarm();
		  

	  }//run()------
}
