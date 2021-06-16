package myNetwork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Random;

import character.Farmer;
import character.Monster;
import console.ConsoleStop;
import town.MartItem;

public class DataAcceptServer extends Thread {
    Socket socket;
    DataInputStream in; // in 스트림
    DataOutputStream out; // out 스트림
    String name;
    myMap mymap; // 유저 정보 저장을 위한 Map
    myMap mymap2; // 싸움 유저 정보 저장을 위한 Map
    String where_from; // 1이면 상태 저장
    Monster monster;
    Farmer user;
    
    //생성자.
    
    public DataAcceptServer(Socket socket, String name){
        this.socket = socket;
        this.name = name;
        mymap = new myMap();
        mymap2 = new myMap();
        try{
            //Socket으로부터 입력스트림을 얻는다.
            in = new DataInputStream(socket.getInputStream());
            //Socket으로부터 출력스트림을 얻는다.
            out = new DataOutputStream(socket.getOutputStream());
        }catch(Exception e){
            System.out.println("예외:"+e);
        }
    }//생성자 

   

    @Override
    public void run(){ //쓰레드를 사용하기 위해서 run()메서드 재정의
        try { 
            while(in!=null){ //입력스트림이 null이 아니면 반복.
            	where_from = in.readUTF();
            	if(where_from.equals("1")){
            		try {
            			myServer.server_semaphore.acquire(); // 같은 공유 변수에 접근 못하도록 세마포어 설정
            		} catch (InterruptedException e1) {
            			e1.printStackTrace();
            		}
            		int check = 0; // 찾았으면 1로 표시
            		mymap.setSeason(in.readUTF());
            		mymap.setYear(Integer.parseInt(in.readUTF()));
            		mymap.setDay(Integer.parseInt(in.readUTF()));
            		mymap.setName(in.readUTF());
            		mymap.setFarmname(in.readUTF());
            		mymap.setGender(in.readUTF());
            		mymap.setGold2(Integer.parseInt(in.readUTF()));
            		mymap.setHp2(Integer.parseInt(in.readUTF()));
            		mymap.setMaxHp(Integer.parseInt(in.readUTF()));
            		mymap.setPower(Integer.parseInt(in.readUTF()));
            		mymap.setLevel(Integer.parseInt(in.readUTF()));
            		mymap.setWeapon_name(in.readUTF());
            		mymap.setSickle_name(in.readUTF());
            		mymap.setHoe_name(in.readUTF());
            		mymap.setFishingRod_name(in.readUTF());
            		for(int i = 0; i < myServer.savedUserInfo.size(); i++) {
            			if(myServer.savedUserInfo.get(i).getName().equals(mymap.getName())) {
            				myServer.savedUserInfo.remove(i);
            				myServer.savedUserInfo.add(mymap);
            				check = 1;
            				break;
            			}
            		}
            		if(check == 0) { // 등록되어있는 회원이 아닐 때
            			myServer.savedUserInfo.add(mymap);
            		}
            		myServer.server_semaphore.release(); // 종료 되면 크리티컬 섹션 block 해제
            	}
            	
            	else if(where_from.equals("2")) { // 이름이 중복인지 체크
            		try {
            			myServer.server_semaphore.acquire(); // 같은 공유 변수에 접근 못하도록 세마포어 설정
            		} catch (InterruptedException e1) {
            			e1.printStackTrace();
            		}
            		String namecheck = in.readUTF();
            		int duplicate = 0;
            		for(int i = 0; i < myServer.savedUserInfo.size(); i++) {
            			if(myServer.savedUserInfo.get(i).getName().equals(namecheck)) {
            				out.writeUTF("Yes"); // 중복이라고 전달
            				duplicate = 1;
            				break;
            			}
            		}
            		if(duplicate == 0) {
            			out.writeUTF("No"); // 중복이 아니라고 전달
            		}
            		myServer.server_semaphore.release();
            	}
            	else if(where_from.equals("3")) { // 채팅방 입장을 알림
            		try {
            			myServer.server_semaphore.acquire(); // 같은 공유 변수에 접근 못하도록 세마포어 설정
            		} catch (InterruptedException e1) {
            			e1.printStackTrace();
            		}
            		out.writeUTF(Integer.toString(myServer.ct_counter));
            		String Clientname = in.readUTF();
            		sendtoClient(Clientname + "님이 입장하셨습니다."); // 현재 소켓에서 읽어온 메시지를 해쉬맵에 저장된 출력스트림으로 보냄
            		myServer.ct_counter++;
            		myServer.UserMap.put(Clientname, out);  // 해쉬맵에 키를 name으로 출력스트림 객체를 저장 
            		myServer.server_semaphore.release();
            		while(true) {
            			String msg = in.readUTF();
            			Thread.sleep(1000);
            			sendtoClient(msg); // 현재 소켓에서 읽어온 메시지를 해쉬맵에 저장된 출력스트림으로 보냄
            			if(msg.equals(Clientname +": 나가기")) {
            				Thread.sleep(2000);
            				try {
                    			myServer.server_semaphore.acquire(); // 같은 공유 변수에 접근 못하도록 세마포어 설정
                    		} catch (InterruptedException e1) {
                    			e1.printStackTrace();
                    		}
            				myServer.UserMap.remove(Clientname);
            				myServer.ct_counter--;
            				myServer.server_semaphore.release();
            				sendtoClient(Clientname +"님이 채팅방을 나가셨습니다.");
            				break;
            			}
            			
            		}
            	}
            	else if(where_from.equals("4")) { // 결투장
            		mymap2.setSeason("없음");
            		mymap2.setYear(Integer.parseInt("0"));
            		mymap2.setDay(Integer.parseInt("0"));
            		mymap2.setName(in.readUTF());
            		mymap2.setFarmname("없음");
            		mymap2.setGender("없음");
            		mymap2.setHp2(Integer.parseInt(in.readUTF()));
            		mymap2.setMaxHp(Integer.parseInt(in.readUTF()));
            		mymap2.setGold2(Integer.parseInt(in.readUTF()));
            		mymap2.setPower(Integer.parseInt("0"));
            		mymap2.setLevel(Integer.parseInt("0"));
            		mymap2.setWeapon_name(in.readUTF());
            		mymap2.setSickle_name("없음");
            		mymap2.setHoe_name("없음");
            		mymap2.setFishingRod_name("없음");
            		try {
            			myServer.server_semaphore.acquire(); // 같은 공유 변수에 접근 못하도록 세마포어 설정
            		} catch (InterruptedException e1) {
            			e1.printStackTrace();
            		}
            		myServer.savedFightUserInfo.add(mymap2);
            		myServer.server_semaphore.release();
            		String myname = in.readUTF();
            		int check = create_user(myname);
            		if(check == 1) {
            			Fighting(myname);
            		}
            		
            	}
            	else if(where_from.equals("5")) { // 저장된 정보 클라이언트에 보내주기
            		try {
            			myServer.server_semaphore.acquire(); // 같은 공유 변수에 접근 못하도록 세마포어 설정
            		} catch (InterruptedException e1) {
            			e1.printStackTrace();
            		}
            		for(int i = 0; i < myServer.savedUserInfo.size(); i++) {
						if(myServer.savedUserInfo.get(i).getName().equals(name)) {
							mymap = myServer.savedUserInfo.get(i);

							out.writeUTF(mymap.getSeason());
					
							out.writeUTF(Integer.toString(mymap.getYear()));
					
							out.writeUTF(Integer.toString(mymap.getDay()));
					
							out.writeUTF(mymap.getName());
					
							out.writeUTF(mymap.getFarmname());
					
							out.writeUTF(mymap.getGender());
					
							out.writeUTF(Integer.toString(mymap.getGold()));
						
							out.writeUTF(Integer.toString(mymap.getHp()));
					
							out.writeUTF(Integer.toString(mymap.getMaxHp()));
					
							out.writeUTF(Integer.toString(mymap.getPower()));
					
							out.writeUTF(Integer.toString(mymap.getLevel()));
					
							out.writeUTF(mymap.getWeapon_name());

							out.writeUTF(mymap.getSickle_name());
					
							out.writeUTF(mymap.getHoe_name());
					
							out.writeUTF(mymap.getFishingRod_name());
							myServer.server_semaphore.release();
							break;
						}
					}
            	}
            	
            	
            }//while()---------

        }catch(Exception e){
        	myServer.in_counter--;
        	System.out.println("총 접속자 수 : " + myServer.in_counter);
        }finally{             
        }

    }//run()------------
    public void sendtoClient(String message) { // 접속한 클라이언트들에게 채팅 내용 전송하기
    	Iterator keys = myServer.UserMap.keySet().iterator();
    	while (keys.hasNext()){
            try {
            	DataOutputStream ssendout = (DataOutputStream) myServer.UserMap.get(keys.next());
            	ssendout.writeUTF(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
    
    public int create_user(String myname) { // 결투장 입장 인원 생성
    	ConsoleStop.threadSleep(5000); // 10초 대기 후 판별 
    	try {
			myServer.server_semaphore.acquire(); // 같은 공유 변수에 접근 못하도록 세마포어 설정
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	if(myServer.savedFightUserInfo.size() < 2) { // 본인만 있으므로
    		try {

				for(int i = 0; i < myServer.savedFightUserInfo.size(); i++) {
					if(myServer.savedFightUserInfo.get(i).getName().equals(myname)) {
						myServer.savedFightUserInfo.remove(i);
						break;
					}
				}
				out.writeUTF("FALSE"); // 진행 못한다고 나가라고 알림
			} catch (IOException e) {
				e.printStackTrace();
			} 
    		myServer.server_semaphore.release();
    		return 2;
    	}
    	else {
    		for(int i = 0; i < myServer.savedFightUserInfo.size(); i++) {
    			if(myServer.savedFightUserInfo.get(i).getName().equals(myname)) { // 자기 자신 생성
    				int mypower = 0;
    				if(myServer.savedFightUserInfo.get(i).getWeapon_name().equals("없음")) { // 무기가 없을 때
    					mypower=0;
    					user = new Farmer(myServer.savedFightUserInfo.get(i).getName(), "없음" ,myServer.savedFightUserInfo.get(i).getHp(),
								myServer.savedFightUserInfo.get(i).getMaxHp(), mypower, myServer.savedFightUserInfo.get(i).getGold(), 0);
    				}
    				else { // 저장된 무기 장착
    					for(int m = 0; m < MartItem.getWeapons().size(); m++) {
    						if(MartItem.getWeapons().get(m).getName().equals(myServer.savedFightUserInfo.get(i).getWeapon_name())) {
    							mypower = MartItem.getWeapons().get(m).getDamage();
    							user = new Farmer(myServer.savedFightUserInfo.get(i).getName(), "없음" ,myServer.savedFightUserInfo.get(i).getHp(),
    									myServer.savedFightUserInfo.get(i).getMaxHp(), mypower, myServer.savedFightUserInfo.get(i).getGold(), 0);
    						}
    					}
						break;
    				}
    			}
    		}
    		int size = myServer.savedFightUserInfo.size();
    		int power; // 무기 공격력
    		while(true) {
    			Random randomnumber = new Random();
    			int random = randomnumber.nextInt(size);
    			if(myServer.savedFightUserInfo.get(random).getName().equals(myname)) { // 랜덤값이 자기 자신을 가리키면 다시
    				continue;
    			}
    			else {
    				if(myServer.savedFightUserInfo.get(random).getWeapon_name().equals("없음")) { // 무기가 없을 때
    					power=0;
    					monster = new Monster(myServer.savedFightUserInfo.get(random).getName(), 
								myServer.savedFightUserInfo.get(random).getHp(), myServer.savedFightUserInfo.get(random).getMaxHp(),
								myServer.savedFightUserInfo.get(random).getGold(), power);
    				}
    				else { // 저장된 무기 장착
    					int i1 = 0;
    					for(i1 = 0; i1 < MartItem.getWeapons().size(); i1++) {
    						if( MartItem.getWeapons().get(i1).getName().equals(myServer.savedFightUserInfo.get(random).getWeapon_name())) {
    							power = MartItem.getWeapons().get(i1).getDamage();
    							monster = new Monster(myServer.savedFightUserInfo.get(random).getName(), 
    									myServer.savedFightUserInfo.get(random).getHp(), myServer.savedFightUserInfo.get(random).getMaxHp(),
    									myServer.savedFightUserInfo.get(random).getGold(), power);
    						}
    					} //-----for()
    				} // ----else
    			} // new monster 생성

	    		try {
					out.writeUTF("TRUE"); // 결투장 매치가 성사 되었다고 알림
					out.writeUTF(myServer.savedFightUserInfo.get(random).getName()); // 결투장 매칭 상대의 이름 전달								
				} catch (IOException e) {
					e.printStackTrace();
				}
	    		break;
    		} // ---while()
    		
    		
    		
    	} //----else
    	myServer.server_semaphore.release();
    	return 1;
    }


    public void Fighting(String myname) {
    	try {
    		while(true) {
    		    Random random = new Random();
    			int miss = random.nextInt(5); // 20퍼 센트의 확률로 공격을 회피함
    			if(user.getHp() <= 0) {
    					out.writeUTF("		" + monster.getName() + "에게 당했어요.");
    					if(user.getGold() > 0)
    						out.writeUTF("		Hp가 0이 되어 기절했어요. 치료비로 " + "300" + "G가 차감되었어요.");
    					else
    						out.writeUTF("		Hp가 0이 되어 기절했어요. 돈이 없어 자바바에게 무료로 치료받았어요.");
    					out.writeUTF("LOSE");
    					out.writeUTF("300");
    					out.writeUTF(Integer.toString(20));
    					
    					try {
    		    			myServer.server_semaphore.acquire(); // 같은 공유 변수에 접근 못하도록 세마포어 설정
    		    		} catch (InterruptedException e1) {
    		    			e1.printStackTrace();
    		    		}
    					
    					for(int i = 0; i < myServer.savedFightUserInfo.size(); i++) {
    						if(myServer.savedFightUserInfo.get(i).getName().equals(myname)) {
    							myServer.savedFightUserInfo.remove(i);
    							break;
    						}
    					}
    					
    					myServer.server_semaphore.release();
    					
    					out.writeUTF("END");
    					break;
    			}
    			if(monster.getHp() <= 0) {
    				out.writeUTF("==============================================================");
    				out.writeUTF("		" + monster.getName() + "(을)를 물리쳤어요!");
    				out.writeUTF("		" + "승리 보상으로 " + "300" + "G를 얻었어요.");
    				out.writeUTF("WIN");
    				out.writeUTF("300");
    				out.writeUTF(Integer.toString(user.getHp()));				
    				out.writeUTF("		현재 유저 Hp: " + user.getHp() + "/" + user.getMaxHp());
    				out.writeUTF("==============================================================");
    				
    				try {
		    			myServer.server_semaphore.acquire(); // 같은 공유 변수에 접근 못하도록 세마포어 설정
		    		} catch (InterruptedException e1) {
		    			e1.printStackTrace();
		    		}
					
					for(int i = 0; i < myServer.savedFightUserInfo.size(); i++) {
						if(myServer.savedFightUserInfo.get(i).getName().equals(myname)) {
							myServer.savedFightUserInfo.remove(i);
							break;
						}
					}
					
					myServer.server_semaphore.release();
    				
    				out.writeUTF("END");
					ConsoleStop.threadSleep(1000);
					break;
    			}
    			if(miss == 2) {
    				out.writeUTF("		" + monster.getName() + "(이)가 공격을 회피합니다.");
    				out.writeUTF("		현재 상대 Hp: " + monster.getHp() + "/" + monster.getMaxHp());
    				out.writeUTF("\n");
        			ConsoleStop.threadSleep(1000);
    			}
    			else if(miss == 0) { //크리티컬
    				out.writeUTF("		" + user.getName() + "(이)가 "+monster.getName() + "을(를) >크리티컬< 공격합니다!!!!");
        			int damage = user.getPower() * 2;
        			int monsterHp = monster.getHp();
        			monster.setHp(monsterHp - damage);
        			out.writeUTF("		" + user.getName() + "(이)가 "+monster.getName() + "에게 " + damage + " 만큼의 피해를 입혔어요!");
        			out.writeUTF("		현재 상대 Hp: " + monster.getHp() + "/" + monster.getMaxHp());
        			out.writeUTF("\n");
        			ConsoleStop.threadSleep(1000);
    			}
    			else {
    				out.writeUTF("		" + user.getName() + "(이)가 "+monster.getName() + "을(를) 공격합니다!");
        			int damage = user.getPower();
        			int monsterHp = monster.getHp();
        			monster.setHp(monsterHp - damage);
        			out.writeUTF("		" + user.getName() + "(이)가 "+monster.getName() + "에게 " + damage + " 만큼의 피해를 입혔어요!");
        			out.writeUTF("		현재 상대 Hp: " + monster.getHp() + "/" + monster.getMaxHp());
        			out.writeUTF("\n");
        			ConsoleStop.threadSleep(1000);
    			}
    			if(miss == 1) {
    				out.writeUTF("		" + user.getName() + "(이)가 공격을 회피합니다.");
    				out.writeUTF("		현재 내 Hp: " + user.getHp() + "/" + user.getMaxHp());
    				out.writeUTF("\n");
        			ConsoleStop.threadSleep(1000);
    			}
    			else if(miss == 3) { //크리티컬
    				out.writeUTF("		" + monster.getName() + "(이)가 " + user.getName() +"에게 >크리티컬< 반격합니다!!!!");
    				int userHp = user.getHp();
    				int damage2 = monster.getPower()*2;
    				user.setHp(userHp - damage2);
    				out.writeUTF("		" + monster.getName() + "(이)가 " +  damage2 + " 만큼의 피해를 입혔어요!");
    				out.writeUTF("		현재 내 Hp: " + user.getHp() + "/" + user.getMaxHp());
    				out.writeUTF("\n");
    				ConsoleStop.threadSleep(1000);
    			}
    			else {
    				out.writeUTF("		" + monster.getName() + "(이)가 " + user.getName() +"에게 반격합니다!");
        			out.writeUTF("		" + monster.getName() + "(이)가 " +  monster.getPower() + " 만큼의 피해를 입혔어요!");
    				int userHp = user.getHp();
    				int damage2 = monster.getPower();
    				user.setHp(userHp - damage2);
    				out.writeUTF("		현재 내 Hp: " + user.getHp() + "/" + user.getMaxHp());
    				out.writeUTF("\n");
    				ConsoleStop.threadSleep(1000);
    			}
				}
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
}


