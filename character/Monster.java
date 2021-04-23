package character;

public class Monster extends Character {
	
	public Monster() {
		;
	}
	
	public Monster(String name, String gender, int hp, int maxHp, int power, int gold, int level) {
		super(name, gender, hp, maxHp, power, gold, level);
	}

	@Override
	public void attack(Monster monster, Farmer user) {
		System.out.println("		" + monster.getName() + "(��)�� " +  monster.getPower() + " ��ŭ�� ���ظ� �������!");
		int userHp = user.getHp();
		int damage = monster.getPower();
		user.setHp(userHp - damage);
	}
	
	@Override
	public void die(Character monster) {
		System.out.println("		" + monster.getName() + "(��)�� �����鼭 " + monster.getGold() + "G�� ������.");
		user.setGold(monster.getGold());
		monster.setHp(monster.getMaxHp());
	}
	
}
