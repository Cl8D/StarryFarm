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
		System.out.println("�� " + Farm.getYear() +"���� ������ " + user.getName());
		System.out.println("�� Level: " + user.getLevel());
		System.out.println("�� Hp: " + user.getHp() + "/" + user.getMaxHp());
		System.out.println("�� ���� �ڻ�: " + user.getGold() + "G");
		System.out.println("------------------------------------------------------------------");
		ConsoleStop.threadSleep(2000);
	}
	
	public void savedUser(String season, int year, int day, String FarmName) {
		ClearConsole.clearConsole();
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����ϰ� �ִ� ����, ������ ������� �ʽ��ϴ�. ������ �����Ͻðڽ��ϱ�?(y/n)");
		String savecheck = scanner.nextLine();
		if(savecheck.equals("y")) {
			
			/******** ���� �ڵ� ************/
			try {
				out.writeUTF("1"); // �����̶�� �˸�
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
		System.out.print("�����ϰ� �ִ� ����, ������ ������� �ʽ��ϴ�. ������ �����Ͻðڽ��ϱ�?(y/n)");
		String savecheck2 = scanner.nextLine();
		if(savecheck2.equals("y")) {
			/******** ���� �ڵ� ************/
			try {
				out.writeUTF("1"); // �����̶�� �˸�
			} catch (IOException e) {
				e.printStackTrace();
			}
			Runnable T1 = new SendToServer(season, year, day, FarmName);
			Thread saveInf = new Thread(T1); 
			saveInf.start();
		}
		ClearConsole.clearConsole();
		System.out.println("������ �����ϰ� �ֽ��ϴ�...");
	}
	
	public void chat() {
		try {
			Scanner scanner = new Scanner(System.in);
			String counter; // ä�ù濡 �������� �ο� �ޱ�
			String msg;
			ClearConsole.clearConsole();
			System.out.println("�� " + Farm.getYear() +"���� ������ " + user.getName() +"�� ä�ù濡 ���Ű� ȯ���մϴ�!!!");
			out.writeUTF("3");// ä�ù� ������ �˸�
			counter = in.readUTF();
			out.writeUTF(user.getName());
			System.out.println("�� " + "���� ���� ���� "+ counter +"���� ä�ù濡 ���� ���Դϴ�!!!");
			System.out.println("�� " + "ä�ù��� ������ �����ø� >������<�� �Է��� �ּ���!!!");
			Thread Clientchat = new ClientChatThread(user.getName());
			Clientchat.start();
			while(true) {
				msg = scanner.nextLine();
				out.writeUTF(user.getName()+ ": " +msg);
				if(msg.equals("������")) {
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
		if(user.getWeapon().getName().equals("����")) {
			System.out.print("���� ���⸦ �������� �ʾ� �������� 0�Դϴ�. ������ �����忡 ���� �Ͻðڽ��ϱ�?(y/n)");
			String answer = scanner.nextLine();
			if(answer.equals("y")) {
			}
			else {
				return;
			}
		}

		System.out.println("�� " + Farm.getYear() +"���� ������ " + user.getName() +"�� �����忡 ���Ű� ȯ���մϴ�!!!");
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
				System.out.println("�� " + " ��븦 ��Ī���Դϴ�...");
				enemy = in.readUTF();
				if(enemy.equals("FALSE")) {
					System.out.println("�� " + " ��� ��밡 �����ϴ�. �������� �̵��մϴ�...");
					ConsoleStop.threadSleep(1000);
					return;
				}
				else if(enemy.equals("TRUE")) {
					String enemyname = in.readUTF();
					System.out.println("�� " + enemyname+ "�� ��Ī�� ����Ǿ����ϴ�. ����� �����մϴ�.");
					while(true) { // ��� ������ �޾ƿ�
						String msg = in.readUTF();
						if(msg.equals("WIN")) { // �¸� ����
							String reward = in.readUTF();
							int nowgold = user.getGold() + Integer.parseInt(reward);
							user.setGold2(nowgold);
							String nowhp = in.readUTF();
							user.setHp2(Integer.parseInt(nowhp));
							continue;
						}
						else if(msg.equals("LOSE")) { // �й�� ��� �Ҹ�
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
						if(msg.equals("END")) { // ���� ����
							System.out.println("         ������ ���ư��ϴ�...");
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
