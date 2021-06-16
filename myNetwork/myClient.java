package myNetwork;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.Socket;

import java.net.UnknownHostException;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

import character.*;
import console.*;
import farm.*;
import gamestory.*;
import item.*;
import town.*;

public class myClient {
	public static Socket socket;
    DataOutputStream out3;
    
    public myClient(){
    }
    
	public void main() {
		Scanner sc = new Scanner(System.in);   
		System.out.print("save�� �̸��� �Է����ּ���. ó���̸� first�� �Է����ּ���.");//ó���� �̸��� ������ ���ؼ��̴�.
		String name = sc.nextLine();
		System.out.print("ip�� �Է��ϼ��� : ");
		String ip = sc.nextLine();
		try{
			String ServerIP = ip;
			socket = new Socket(ServerIP, 7777); //���� ��ü ����
			
			try {
				out3 = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e1) {
			}
			System.out.println("������ ������ �Ǿ����ϴ�......");
   
			if(name.equals("first")) { // ���� ù �����̸� ����
				out3.writeUTF(name);
				Thread receiver = new FirstGameStart(socket);        
				System.out.println("������ �����մϴ�.");
				receiver.start(); //�Ծ� ������ �õ�
			}
			else {
				out3.writeUTF(name);
				Thread receiver = new GameStart(socket, name);        
				receiver.start(); //�Ծ� ������ �õ�
			}
			
		}catch(UnknownHostException e) {
		}catch (IOException e) {
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}
