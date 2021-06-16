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
    DataInputStream in; // in ��Ʈ��
    DataOutputStream out; // out ��Ʈ��
    String name;
    myMap mymap; // ���� ���� ������ ���� Map
    myMap mymap2; // �ο� ���� ���� ������ ���� Map
    String where_from; // 1�̸� ���� ����
    Monster monster;
    Farmer user;
    
    //������.
    
    public DataAcceptServer(Socket socket, String name){
        this.socket = socket;
        this.name = name;
        mymap = new myMap();
        mymap2 = new myMap();
        try{
            //Socket���κ��� �Է½�Ʈ���� ��´�.
            in = new DataInputStream(socket.getInputStream());
            //Socket���κ��� ��½�Ʈ���� ��´�.
            out = new DataOutputStream(socket.getOutputStream());
        }catch(Exception e){
            System.out.println("����:"+e);
        }
    }//������ 

   

    @Override
    public void run(){ //�����带 ����ϱ� ���ؼ� run()�޼��� ������
        try { 
            while(in!=null){ //�Է½�Ʈ���� null�� �ƴϸ� �ݺ�.
            	where_from = in.readUTF();
            	if(where_from.equals("1")){
            		try {
            			myServer.server_semaphore.acquire(); // ���� ���� ������ ���� ���ϵ��� �������� ����
            		} catch (InterruptedException e1) {
            			e1.printStackTrace();
            		}
            		int check = 0; // ã������ 1�� ǥ��
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
            		if(check == 0) { // ��ϵǾ��ִ� ȸ���� �ƴ� ��
            			myServer.savedUserInfo.add(mymap);
            		}
            		myServer.server_semaphore.release(); // ���� �Ǹ� ũ��Ƽ�� ���� block ����
            	}
            	
            	else if(where_from.equals("2")) { // �̸��� �ߺ����� üũ
            		try {
            			myServer.server_semaphore.acquire(); // ���� ���� ������ ���� ���ϵ��� �������� ����
            		} catch (InterruptedException e1) {
            			e1.printStackTrace();
            		}
            		String namecheck = in.readUTF();
            		int duplicate = 0;
            		for(int i = 0; i < myServer.savedUserInfo.size(); i++) {
            			if(myServer.savedUserInfo.get(i).getName().equals(namecheck)) {
            				out.writeUTF("Yes"); // �ߺ��̶�� ����
            				duplicate = 1;
            				break;
            			}
            		}
            		if(duplicate == 0) {
            			out.writeUTF("No"); // �ߺ��� �ƴ϶�� ����
            		}
            		myServer.server_semaphore.release();
            	}
            	else if(where_from.equals("3")) { // ä�ù� ������ �˸�
            		try {
            			myServer.server_semaphore.acquire(); // ���� ���� ������ ���� ���ϵ��� �������� ����
            		} catch (InterruptedException e1) {
            			e1.printStackTrace();
            		}
            		out.writeUTF(Integer.toString(myServer.ct_counter));
            		String Clientname = in.readUTF();
            		sendtoClient(Clientname + "���� �����ϼ̽��ϴ�."); // ���� ���Ͽ��� �о�� �޽����� �ؽ��ʿ� ����� ��½�Ʈ������ ����
            		myServer.ct_counter++;
            		myServer.UserMap.put(Clientname, out);  // �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ���� 
            		myServer.server_semaphore.release();
            		while(true) {
            			String msg = in.readUTF();
            			Thread.sleep(1000);
            			sendtoClient(msg); // ���� ���Ͽ��� �о�� �޽����� �ؽ��ʿ� ����� ��½�Ʈ������ ����
            			if(msg.equals(Clientname +": ������")) {
            				Thread.sleep(2000);
            				try {
                    			myServer.server_semaphore.acquire(); // ���� ���� ������ ���� ���ϵ��� �������� ����
                    		} catch (InterruptedException e1) {
                    			e1.printStackTrace();
                    		}
            				myServer.UserMap.remove(Clientname);
            				myServer.ct_counter--;
            				myServer.server_semaphore.release();
            				sendtoClient(Clientname +"���� ä�ù��� �����̽��ϴ�.");
            				break;
            			}
            			
            		}
            	}
            	else if(where_from.equals("4")) { // ������
            		mymap2.setSeason("����");
            		mymap2.setYear(Integer.parseInt("0"));
            		mymap2.setDay(Integer.parseInt("0"));
            		mymap2.setName(in.readUTF());
            		mymap2.setFarmname("����");
            		mymap2.setGender("����");
            		mymap2.setHp2(Integer.parseInt(in.readUTF()));
            		mymap2.setMaxHp(Integer.parseInt(in.readUTF()));
            		mymap2.setGold2(Integer.parseInt(in.readUTF()));
            		mymap2.setPower(Integer.parseInt("0"));
            		mymap2.setLevel(Integer.parseInt("0"));
            		mymap2.setWeapon_name(in.readUTF());
            		mymap2.setSickle_name("����");
            		mymap2.setHoe_name("����");
            		mymap2.setFishingRod_name("����");
            		try {
            			myServer.server_semaphore.acquire(); // ���� ���� ������ ���� ���ϵ��� �������� ����
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
            	else if(where_from.equals("5")) { // ����� ���� Ŭ���̾�Ʈ�� �����ֱ�
            		try {
            			myServer.server_semaphore.acquire(); // ���� ���� ������ ���� ���ϵ��� �������� ����
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
        	System.out.println("�� ������ �� : " + myServer.in_counter);
        }finally{             
        }

    }//run()------------
    public void sendtoClient(String message) { // ������ Ŭ���̾�Ʈ�鿡�� ä�� ���� �����ϱ�
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
    
    
    public int create_user(String myname) { // ������ ���� �ο� ����
    	ConsoleStop.threadSleep(5000); // 10�� ��� �� �Ǻ� 
    	try {
			myServer.server_semaphore.acquire(); // ���� ���� ������ ���� ���ϵ��� �������� ����
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	if(myServer.savedFightUserInfo.size() < 2) { // ���θ� �����Ƿ�
    		try {

				for(int i = 0; i < myServer.savedFightUserInfo.size(); i++) {
					if(myServer.savedFightUserInfo.get(i).getName().equals(myname)) {
						myServer.savedFightUserInfo.remove(i);
						break;
					}
				}
				out.writeUTF("FALSE"); // ���� ���Ѵٰ� ������� �˸�
			} catch (IOException e) {
				e.printStackTrace();
			} 
    		myServer.server_semaphore.release();
    		return 2;
    	}
    	else {
    		for(int i = 0; i < myServer.savedFightUserInfo.size(); i++) {
    			if(myServer.savedFightUserInfo.get(i).getName().equals(myname)) { // �ڱ� �ڽ� ����
    				int mypower = 0;
    				if(myServer.savedFightUserInfo.get(i).getWeapon_name().equals("����")) { // ���Ⱑ ���� ��
    					mypower=0;
    					user = new Farmer(myServer.savedFightUserInfo.get(i).getName(), "����" ,myServer.savedFightUserInfo.get(i).getHp(),
								myServer.savedFightUserInfo.get(i).getMaxHp(), mypower, myServer.savedFightUserInfo.get(i).getGold(), 0);
    				}
    				else { // ����� ���� ����
    					for(int m = 0; m < MartItem.getWeapons().size(); m++) {
    						if(MartItem.getWeapons().get(m).getName().equals(myServer.savedFightUserInfo.get(i).getWeapon_name())) {
    							mypower = MartItem.getWeapons().get(m).getDamage();
    							user = new Farmer(myServer.savedFightUserInfo.get(i).getName(), "����" ,myServer.savedFightUserInfo.get(i).getHp(),
    									myServer.savedFightUserInfo.get(i).getMaxHp(), mypower, myServer.savedFightUserInfo.get(i).getGold(), 0);
    						}
    					}
						break;
    				}
    			}
    		}
    		int size = myServer.savedFightUserInfo.size();
    		int power; // ���� ���ݷ�
    		while(true) {
    			Random randomnumber = new Random();
    			int random = randomnumber.nextInt(size);
    			if(myServer.savedFightUserInfo.get(random).getName().equals(myname)) { // �������� �ڱ� �ڽ��� ����Ű�� �ٽ�
    				continue;
    			}
    			else {
    				if(myServer.savedFightUserInfo.get(random).getWeapon_name().equals("����")) { // ���Ⱑ ���� ��
    					power=0;
    					monster = new Monster(myServer.savedFightUserInfo.get(random).getName(), 
								myServer.savedFightUserInfo.get(random).getHp(), myServer.savedFightUserInfo.get(random).getMaxHp(),
								myServer.savedFightUserInfo.get(random).getGold(), power);
    				}
    				else { // ����� ���� ����
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
    			} // new monster ����

	    		try {
					out.writeUTF("TRUE"); // ������ ��ġ�� ���� �Ǿ��ٰ� �˸�
					out.writeUTF(myServer.savedFightUserInfo.get(random).getName()); // ������ ��Ī ����� �̸� ����								
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
    			int miss = random.nextInt(5); // 20�� ��Ʈ�� Ȯ���� ������ ȸ����
    			if(user.getHp() <= 0) {
    					out.writeUTF("		" + monster.getName() + "���� ���߾��.");
    					if(user.getGold() > 0)
    						out.writeUTF("		Hp�� 0�� �Ǿ� �����߾��. ġ���� " + "300" + "G�� �����Ǿ����.");
    					else
    						out.writeUTF("		Hp�� 0�� �Ǿ� �����߾��. ���� ���� �ڹٹٿ��� ����� ġ��޾Ҿ��.");
    					out.writeUTF("LOSE");
    					out.writeUTF("300");
    					out.writeUTF(Integer.toString(20));
    					
    					try {
    		    			myServer.server_semaphore.acquire(); // ���� ���� ������ ���� ���ϵ��� �������� ����
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
    				out.writeUTF("		" + monster.getName() + "(��)�� �����ƾ��!");
    				out.writeUTF("		" + "�¸� �������� " + "300" + "G�� ������.");
    				out.writeUTF("WIN");
    				out.writeUTF("300");
    				out.writeUTF(Integer.toString(user.getHp()));				
    				out.writeUTF("		���� ���� Hp: " + user.getHp() + "/" + user.getMaxHp());
    				out.writeUTF("==============================================================");
    				
    				try {
		    			myServer.server_semaphore.acquire(); // ���� ���� ������ ���� ���ϵ��� �������� ����
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
    				out.writeUTF("		" + monster.getName() + "(��)�� ������ ȸ���մϴ�.");
    				out.writeUTF("		���� ��� Hp: " + monster.getHp() + "/" + monster.getMaxHp());
    				out.writeUTF("\n");
        			ConsoleStop.threadSleep(1000);
    			}
    			else if(miss == 0) { //ũ��Ƽ��
    				out.writeUTF("		" + user.getName() + "(��)�� "+monster.getName() + "��(��) >ũ��Ƽ��< �����մϴ�!!!!");
        			int damage = user.getPower() * 2;
        			int monsterHp = monster.getHp();
        			monster.setHp(monsterHp - damage);
        			out.writeUTF("		" + user.getName() + "(��)�� "+monster.getName() + "���� " + damage + " ��ŭ�� ���ظ� �������!");
        			out.writeUTF("		���� ��� Hp: " + monster.getHp() + "/" + monster.getMaxHp());
        			out.writeUTF("\n");
        			ConsoleStop.threadSleep(1000);
    			}
    			else {
    				out.writeUTF("		" + user.getName() + "(��)�� "+monster.getName() + "��(��) �����մϴ�!");
        			int damage = user.getPower();
        			int monsterHp = monster.getHp();
        			monster.setHp(monsterHp - damage);
        			out.writeUTF("		" + user.getName() + "(��)�� "+monster.getName() + "���� " + damage + " ��ŭ�� ���ظ� �������!");
        			out.writeUTF("		���� ��� Hp: " + monster.getHp() + "/" + monster.getMaxHp());
        			out.writeUTF("\n");
        			ConsoleStop.threadSleep(1000);
    			}
    			if(miss == 1) {
    				out.writeUTF("		" + user.getName() + "(��)�� ������ ȸ���մϴ�.");
    				out.writeUTF("		���� �� Hp: " + user.getHp() + "/" + user.getMaxHp());
    				out.writeUTF("\n");
        			ConsoleStop.threadSleep(1000);
    			}
    			else if(miss == 3) { //ũ��Ƽ��
    				out.writeUTF("		" + monster.getName() + "(��)�� " + user.getName() +"���� >ũ��Ƽ��< �ݰ��մϴ�!!!!");
    				int userHp = user.getHp();
    				int damage2 = monster.getPower()*2;
    				user.setHp(userHp - damage2);
    				out.writeUTF("		" + monster.getName() + "(��)�� " +  damage2 + " ��ŭ�� ���ظ� �������!");
    				out.writeUTF("		���� �� Hp: " + user.getHp() + "/" + user.getMaxHp());
    				out.writeUTF("\n");
    				ConsoleStop.threadSleep(1000);
    			}
    			else {
    				out.writeUTF("		" + monster.getName() + "(��)�� " + user.getName() +"���� �ݰ��մϴ�!");
        			out.writeUTF("		" + monster.getName() + "(��)�� " +  monster.getPower() + " ��ŭ�� ���ظ� �������!");
    				int userHp = user.getHp();
    				int damage2 = monster.getPower();
    				user.setHp(userHp - damage2);
    				out.writeUTF("		���� �� Hp: " + user.getHp() + "/" + user.getMaxHp());
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


