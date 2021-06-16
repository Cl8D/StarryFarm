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
		System.out.print("save된 이름을 입력해주세요. 처음이면 first를 입력해주세요.");//처음에 이름을 보내기 위해서이다.
		String name = sc.nextLine();
		System.out.print("ip를 입력하세요 : ");
		String ip = sc.nextLine();
		try{
			String ServerIP = ip;
			socket = new Socket(ServerIP, 7777); //소켓 객체 생성
			
			try {
				out3 = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e1) {
			}
			System.out.println("서버와 연결이 되었습니다......");
   
			if(name.equals("first")) { // 게임 첫 시작이면 실행
				out3.writeUTF(name);
				Thread receiver = new FirstGameStart(socket);        
				System.out.println("게임을 시작합니다.");
				receiver.start(); //게암 스레드 시동
			}
			else {
				out3.writeUTF(name);
				Thread receiver = new GameStart(socket, name);        
				receiver.start(); //게암 스레드 시동
			}
			
		}catch(UnknownHostException e) {
		}catch (IOException e) {
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}
