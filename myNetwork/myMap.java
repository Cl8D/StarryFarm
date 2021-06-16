package myNetwork;

import character.Farmer;


public class myMap {
	protected static Farmer user;
	protected String name; // 캐릭터 이름
	protected String Farmname; // 농장 이름
	protected String gender; // 캐릭터 성별
	protected int gold; // 가지고 있는 골드(돈)
	protected int hp; //체력
	protected int maxHp; //최대 체력
	protected int power; //공격력
	protected int level; // 레벨
	protected String season; // 계절
	protected int year; // 년
	protected int day; // 일
	protected String weapon_name; // 착용 중인 무기 이름
	protected String hoe_name; // 착용 중인 괭이 이름
	protected String sickle_name; // 착용 중인 낫 이름
	protected String fishingRod_name; // 착용 중인 낚싯대 이름
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getGold() {
		return gold;
	}
	
	public void setGold(int gold) {
		this.gold += gold;
	}
	public void setGold2(int gold) {
		this.gold = gold;
	}
	
	
	public String getSeason() {
		return season;
	}
	
	public void setSeason(String season) {
		this.season = season;
	}
	
	public String getFarmname() {
		return Farmname;
	}
	
	public void setFarmname(String farmname) {
		this.Farmname = farmname;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	
	
	public int getHp() {
		return hp;
	}
	
	
	public void setHp(int hp) {
		if(hp > maxHp)
			;
		else if(hp <= 0) {
			this.hp = 0;
		}
		else {
			this.hp = hp;
		}
	}
	
	public void setHp2(int hp) {
		this.hp = hp;
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	public int getPower() {
		return power;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
		if(level == 2)
			user.setMaxHp(150);
		else if(level == 3)
			user.setMaxHp(200);
		else if(level == 4)
			user.setMaxHp(250);
		else if(level == 5)
			user.setMaxHp(300);
		else if(level == 6)
			user.setMaxHp(350);
		else if(level == 7)
			user.setMaxHp(400);
		else if(level == 8)
			user.setMaxHp(450);
		else if(level == 9)
			user.setMaxHp(500);
		else if(level == 10)
			user.setMaxHp(1000);
	}

	public String getWeapon_name() {
		return weapon_name;
	}
	
	public void setWeapon_name(String weapon_name) {
		this.weapon_name = weapon_name;
	}
	
	public String getHoe_name() {
		return hoe_name;
	}
	
	public void setHoe_name(String hoe_name) {
		this.hoe_name = hoe_name;
	}
	
	public String getSickle_name() {
		return sickle_name;
	}
	
	public void setSickle_name(String sickle_name) {
		this.sickle_name = sickle_name;
	}
	
	public String getFishingRod_name() {
		return fishingRod_name;
	}
	
	public void setFishingRod_name(String fishingRod_name) {
		this.fishingRod_name = fishingRod_name;
	}
	
}
