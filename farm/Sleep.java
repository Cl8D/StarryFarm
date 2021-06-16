package farm;

import java.io.File;

import console.ClearConsole;
import console.FileRead;
import character.UserInfo;

public class Sleep extends UserInfo {
	// 이미지 파일
	//private File goodNight = new File("/C:/Users/jun/Desktop/Project/StarryFarm/src/GoodNight.txt");
	private File goodNight = new File("./GoodNight.txt");
	
	public void sleep() {
		int day = Farm.getDay();
		day++;
		Farm.setDay(day);
		
		if(Farm.getDay() == 31) {
			Farm.setDay(1);
			if(Farm.getSeason().equals("봄"))
				Farm.setSeason("여름");
			else if(Farm.getSeason().equals("여름"))
				Farm.setSeason("가을");
			else if(Farm.getSeason().equals("가을"))
				Farm.setSeason("겨울");
			else if(Farm.getSeason().equals("겨울")) {
				Farm.setSeason("봄");
				int year = Farm.getYear();
				year++;
				Farm.setYear(year);
			}
		}
		ClearConsole.clearConsole();
		System.out.println("오늘은 이만 잠이 들었습니다...");
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
