package farm;

import java.io.File;

import console.ClearConsole;
import console.FileRead;
import character.UserInfo;

public class Sleep extends UserInfo {
	// �̹��� ����
	//private File goodNight = new File("/C:/Users/jun/Desktop/Project/StarryFarm/src/GoodNight.txt");
	private File goodNight = new File("./GoodNight.txt");
	
	public void sleep() {
		int day = Farm.getDay();
		day++;
		Farm.setDay(day);
		
		if(Farm.getDay() == 31) {
			Farm.setDay(1);
			if(Farm.getSeason().equals("��"))
				Farm.setSeason("����");
			else if(Farm.getSeason().equals("����"))
				Farm.setSeason("����");
			else if(Farm.getSeason().equals("����"))
				Farm.setSeason("�ܿ�");
			else if(Farm.getSeason().equals("�ܿ�")) {
				Farm.setSeason("��");
				int year = Farm.getYear();
				year++;
				Farm.setYear(year);
			}
		}
		ClearConsole.clearConsole();
		System.out.println("������ �̸� ���� ������ϴ�...");
		System.out.println("Zzzzz...Zz...");
		FileRead.hasThreadTxt(goodNight);
		
		int ableFarming = Field.getAbleFarming();
		ableFarming = ableFarming - 1;
		Field.setAbleFarming(ableFarming);
		user.setHp(user.getMaxHp());
		
		Postbox.setCount(0);
		return;
	}
	
	
}
