package farm;

import gamestory.AutumnStory;
import gamestory.SpringStory;
import gamestory.SummerStory;
import gamestory.WinterStory;

public class Postbox{
	private static int postCount = 1;
	private static int count = 0;
	
	public static int getPostCount() {
		return postCount;
	}
	
	public static void setPostCount(int postCount) {
		Postbox.postCount = postCount;
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void setCount(int count) {
		Postbox.count = count;
	}
	
	public static boolean hasPost() {
		if(Farm.year == 1) {
		if(Farm.season.equals("봄")) {
			if(count == 0) {
				if(Farm.day == 7) {
					postCount++;
					count++;
				}
			}
			if(count == 0) {
				if(Farm.day == 20) {
					postCount++;
					count++;
				}
			}
		}
		
		else if(Farm.season.equals("여름")) {
			if(count == 0) {
				if(Farm.day == 1) {
					postCount++;
					count++;
				}
			}
			if(count == 0) {
				if(Farm.day == 15) {
					postCount++;
					count++;
				}
			}
		}
		
		else if(Farm.season.equals("가을")) {
			if(count == 0) {
				if(Farm.day == 1) {
					postCount++;
					count++;
				}
			}
			if(count == 0) {
				if(Farm.day == 7) {
					postCount++;
					count++;
				}
			}
		}
		
		if(Farm.season.equals("겨울")) {
			if(count == 0) {
				if(Farm.day == 1) {
					postCount++;
					count++;
				}
			}
			if(count == 0) {
				if(Farm.day == 10) {
					postCount++;
					count++;
				}
			}
			if(count == 0) {
				if(Farm.day == 20) {
					postCount++;
					count++;
				}
			}
		}
	}
		if(postCount == 0)
			return false;
		else
			return true;
		
	}
	
	public static void openPost() {
		if(postCount == 0)
			System.out.println("도착한 우편물이 없어요!");
		
		else {
			if(Farm.season.equals("봄")) {
				if(Farm.day >= 20)
					SpringStory.twenty_day();
				if(Farm.day >= 7) 
					SpringStory.seven_day();
			}
		
			else if(Farm.season.equals("여름")) {
				if(Farm.day >= 15)
					SummerStory.fifteen_day();
				if(Farm.day >= 1) 
					SummerStory.one_day();
			}

			else if(Farm.season.equals("가을")) {
				if(Farm.day >= 7)
					AutumnStory.seven_day();
				if(Farm.day >= 1)
					AutumnStory.one_day();
			}
		
			else if(Farm.season.equals("겨울")) {
				if(Farm.day>=20)
					WinterStory.twenty_day();
				if(Farm.day>=10)
					WinterStory.ten_day();
				if(Farm.day>=1)
					WinterStory.one_day();
				
			}
		}
	
	}

}
