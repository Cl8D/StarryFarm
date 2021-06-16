package myNetwork;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientChatThread extends Thread{
	DataInputStream in;
	Socket socket;
	String name;
	public ClientChatThread(String name) {
		this.socket = myClient.socket;
		this.name = name;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		String msg;
		try {
			while(true) {
				msg = in.readUTF();
				if(msg.equals(name +": 나가기")) {
					try {
						System.out.println("채팅방을 나가는 중입니다...");
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				}
				System.out.println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
