package character;

public abstract class Character {
	protected static Farmer user;
	protected String name; // ĳ���� �̸�
	protected String gender; // ĳ���� ����
	protected int gold; // ������ �ִ� ���(��)
	protected int hp; //ü��
	protected int maxHp; //�ִ� ü��
	protected int power; //���ݷ�
	protected int level; // ����
	
	public Character() {
		;
	}
	
	public Character(String name, String gender, int hp, int maxHp, int power, int gold, int level) {
		this.name =  name;
		this.gender = gender;
		this.hp = hp;
		this.maxHp = maxHp;
		this.power = power;
		this.gold = gold;
		this.level = level;
	}
	
	public abstract void attack(Monster monster, Farmer user); //����
	public abstract void die(Character monster); // Hp�� 0�� ��
	
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
}
