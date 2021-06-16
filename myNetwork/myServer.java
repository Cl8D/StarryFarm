package myNetwork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

import character.*;
import console.*;
import farm.*;
import gamestory.*;
import item.*;
import town.*;


public class myServer {
	//HashMap clientMap;
    ServerSocket serverSocket = null;
    Socket socket = null;
    static int in_counter = 0; // ���� �ο�
    static int ct_counter = 0; // ä�ù� ���� �ο�
    static HashMap<String, Object> UserMap; // ä���� ������ �ؽ���
	static List<myMap> savedUserInfo = new ArrayList<myMap>(); // �������� ���� ����
	static List<myMap> savedFightUserInfo = new ArrayList<myMap>(); // ������ �������� ���� ����
	static Semaphore server_semaphore; // ����ȭ�� ���� ��������
	String name;
    DataInputStream in3;
    
    //������
    public myServer(){
    	UserMap = new HashMap<String, Object>();
    	Collections.synchronizedMap(UserMap); //�ؽ��� ����ȭ ����.

    	server_semaphore = new Semaphore(1); // ������� 1�� ����
    }//������

   
    public void main(){
        try{
            serverSocket = new ServerSocket(7777); //7777��Ʈ ����.
            System.out.println("������ ���۵Ǿ����ϴ�");//���������� �˷ȴ�.
            while(true){ //������ ����Ǵ� ���� Ŭ���̾�Ʈ���� ������ ��ٸ�.
                socket = serverSocket.accept(); //Ŭ���̾�Ʈ�� ������ �ߴ�.
                in3 = new DataInputStream(socket.getInputStream());
                System.out.println(socket.getInetAddress()+":"+socket.getPort()); //Ŭ���̾�Ʈ ���� (ip, ��Ʈ) ���
      
                in_counter++; // Ŭ���̾�Ʈ�� ����Ǹ� counter�� ����
                System.out.println("������ �� : "+ Integer.toString(in_counter)); // ���� ���� �ο� ���
                name = in3.readUTF(); // �̸� �޾ƿ���
                if(name.equals("first")) { // ó���̸� ���� ������ information ������ ����
                	Thread getInformation = new DataAcceptServer(socket, name); //������ ����.
                	getInformation.start(); //������ ����
                }
                else { // ó���� �ƴϸ� ����� �����Ͱ� ���� �� �����ϱ� ���� Ȯ��
                	Thread getInformation = new DataAcceptServer(socket, name); //������ ����.
                    getInformation.start(); //������ ����
                }
            }      
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
