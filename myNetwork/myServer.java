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
    static int in_counter = 0; // 접속 인원
    static int ct_counter = 0; // 채팅방 접속 인원
    static HashMap<String, Object> UserMap; // 채팅을 저장할 해쉬맵
	static List<myMap> savedUserInfo = new ArrayList<myMap>(); // 유저들의 정보 저장
	static List<myMap> savedFightUserInfo = new ArrayList<myMap>(); // 결투장 유저들의 정보 저장
	static Semaphore server_semaphore; // 동기화를 위한 세마포어
	String name;
    DataInputStream in3;
    
    //생성자
    public myServer(){
    	UserMap = new HashMap<String, Object>();
    	Collections.synchronizedMap(UserMap); //해쉬맵 동기화 설정.

    	server_semaphore = new Semaphore(1); // 세마포어를 1로 설정
    }//생성자

   
    public void main(){
        try{
            serverSocket = new ServerSocket(7777); //7777포트 열기.
            System.out.println("서버가 시작되었습니다");//서버시작을 알렸다.
            while(true){ //서버가 실행되는 동안 클라이언트들의 접속을 기다림.
                socket = serverSocket.accept(); //클라이언트가 접속을 했다.
                in3 = new DataInputStream(socket.getInputStream());
                System.out.println(socket.getInetAddress()+":"+socket.getPort()); //클라이언트 정보 (ip, 포트) 출력
      
                in_counter++; // 클라이언트가 연결되면 counter값 증가
                System.out.println("접속자 수 : "+ Integer.toString(in_counter)); // 접속 중인 인원 출력
                name = in3.readUTF(); // 이름 받아오기
                if(name.equals("first")) { // 처음이면 정보 저장할 information 스레드 시작
                	Thread getInformation = new DataAcceptServer(socket, name); //쓰레드 생성.
                	getInformation.start(); //쓰레드 시작
                }
                else { // 처음이 아니면 저장된 데이터가 있을 수 있으니깐 정보 확인
                	Thread getInformation = new DataAcceptServer(socket, name); //쓰레드 생성.
                    getInformation.start(); //쓰레드 시작
                }
            }      
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
