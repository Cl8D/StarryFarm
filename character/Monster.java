package character;

import java.net.Socket;

import item.Weapon;
import myNetwork.myServer;
import town.MartItem;

public class Monster extends Character {
	
	public Monster() {
		;
	}

	
	
	public Monster(String name, int hp, int maxHp, int gold, int power) { // 결투장을 위한 생성자
		super(name, "없음", hp, maxHp, power, gold, 0); 

	}
	
	
	public Monster(String name, String gender, int hp, int maxHp, int power, int gold, int level) {
		super(name, gender, hp, maxHp, power, gold, level);
	}

	@Override
	public void attack(Monster monster, Farmer user) {
		System.out.println("		" + monster.getName() + "(이)가 " +  monster.getPower() + " 만큼의 피해를 입혔어요!");
		int userHp = user.getHp();
		int damage = monster.getPower();
		user.setHp(userHp - damage);
	}
	
	@Override
	public void die(Character monster) {
		System.out.println("		" + monster.getName() + "(이)가 죽으면서 " + monster.getGold() + "G를 얻었어요.");
		user.setGold(monster.getGold());
		monster.setHp(monster.getMaxHp());
	}



	




	
}
