package farm;

import console.ClearConsole;
import console.ConsoleStop;
import myNetwork.ClientChatThread;
import myNetwork.SendToServer;
import myNetwork.myClient;

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import character.UserInfo;

public class AboutUser extends UserInfo {
	
	DataOutputStream out;
	DataInputStream in;
	Socket socket;
	
	public AboutUser() {
		
		this.socket = myClient.socket;
		try {
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printUser() {
		ClearConsole.clearConsole();
		System.out.println("------------------------------------------------------------------");
		System.out.println("♥ " + Farm.getYear() +"년차 농장주 " + user.getName());
		System.out.println("♥ Level: " + user.getLevel());
		System.out.println("♥ Hp: " + user.getHp() + "/" + user.getMaxHp());
		System.out.println("♥ 보유 자산: " + user.getGold() + "G");
		System.out.println("------------------------------------------------------------------");
		ConsoleStop.threadSleep(2000);
	}
	
	public void savedUser(String season, int year, int day, String FarmName) {
		ClearConsole.clearConsole();
		Scanner scanner = new Scanner(System.in);
		System.out.println("보유하고 있는 과일, 물고기는 저장되지 않습니다. 정말로 저장하시겠습니까?(y/n)");
		String savecheck = scanner.nextLine();
		if(savecheck.equals("y")) {
			
			/******** 저장 코드 ************/
			try {
				out.writeUTF("1"); // 저장이라고 알림
			} catch (IOException e) {
				e.printStackTrace();
			}
			Runnable T1 = new SendToServer(season, year, day, FarmName);
			Thread saveInf = new Thread(T1); 
			saveInf.start();
		}
	}
	
	public void savedandexit(String season, int year, int day, String FarmName) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("보유하고 있는 과일, 물고기는 저장되지 않습니다. 정말로 종료하시겠습니까?(y/n)");
		String savecheck2 = scanner.nextLine();
		if(savecheck2.equals("y")) {
			/******** 저장 코드 ************/
			try {
				out.writeUTF("1"); // 저장이라고 알림
			} catch (IOException e) {
				e.printStackTrace();
			}
			Runnable T1 = new SendToServer(season, year, day, FarmName);
			Thread saveInf = new Thread(T1); 
			saveInf.start();
		}
		ClearConsole.clearConsole();
		System.out.println("정보를 저장하고 있습니다...");
	}
	
	public void chat() {
		try {
			Scanner scanner = new Scanner(System.in);
			String counter; // 채팅방에 접속중인 인원 받기
			String msg;
			ClearConsole.clearConsole();
			System.out.println("♥ " + Farm.getYear() +"년차 농장주 " + user.getName() +"님 채팅방에 오신걸 환영합니다!!!");
			out.writeUTF("3");// 채팅방 접속을 알림
			counter = in.readUTF();
			out.writeUTF(user.getName());
			System.out.println("♥ " + "현재 본인 제외 "+ counter +"명이 채팅방에 접속 중입니다!!!");
			System.out.println("♥ " + "채팅방을 나가고 싶으시면 >나가기<를 입력해 주세요!!!");
			Thread Clientchat = new ClientChatThread(user.getName());
			Clientchat.start();
			while(true) {
				msg = scanner.nextLine();
				out.writeUTF(user.getName()+ ": " +msg);
				if(msg.equals("나가기")) {
					ConsoleStop.threadSleep(2000);
					break;
				}
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void Fight() {
		ClearConsole.clearConsole();
		Scanner scanner = new Scanner(System.in);
		if(user.getWeapon().getName().equals("없음")) {
			System.out.print("현재 무기를 장착하지 않아 데미지가 0입니다. 정말로 결투장에 입장 하시겠습니까?(y/n)");
			String answer = scanner.nextLine();
			if(answer.equals("y")) {
			}
			else {
				return;
			}
		}

		System.out.println("♥ " + Farm.getYear() +"년차 농장주 " + user.getName() +"님 결투장에 오신걸 환영합니다!!!");
		try {
			out.writeUTF("4");
			out.writeUTF(user.getName());
			out.writeUTF(Integer.toString(user.getHp()));
			out.writeUTF(Integer.toString(user.getMaxHp()));
			out.writeUTF(Integer.toString(user.getGold()));
			out.writeUTF(user.getWeapon().getName());
			out.writeUTF(user.getName());
			while(true) {
				String enemy;
				System.out.println("♥ " + " 상대를 매칭중입니다...");
				enemy = in.readUTF();
				if(enemy.equals("FALSE")) {
					System.out.println("♥ " + " 대결 상대가 없습니다. 메인으로 이동합니다...");
					ConsoleStop.threadSleep(1000);
					return;
				}
				else if(enemy.equals("TRUE")) {
					String enemyname = in.readUTF();
					System.out.println("♥ " + enemyname+ "과 매칭이 성사되었습니다. 대결을 시작합니다.");
					while(true) { // 대결 내용을 받아옴
						String msg = in.readUTF();
						if(msg.equals("WIN")) { // 승리 수당
							String reward = in.readUTF();
							int nowgold = user.getGold() + Integer.parseInt(reward);
							user.setGold2(nowgold);
							String nowhp = in.readUTF();
							user.setHp2(Integer.parseInt(nowhp));
							continue;
						}
						else if(msg.equals("LOSE")) { // 패배시 골드 소모
							String reward = in.readUTF();
							int nowgold = user.getGold() - Integer.parseInt(reward);
							if(nowgold < 0) {
								user.setGold2(0);
							}
							else {
								user.setGold2(nowgold);
							}
							String nowhp = in.readUTF();
							user.setHp2(Integer.parseInt(nowhp));
							continue;
						}
						if(msg.equals("END")) { // 결투 종료
							System.out.println("         집으로 돌아갑니다...");
							ConsoleStop.threadSleep(2000);
							return;
						}
						System.out.println(msg);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
