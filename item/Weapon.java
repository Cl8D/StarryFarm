package item;

public class Weapon extends Item {
	private int damage;
	public Weapon(String name, int price, int damage) {
		super(name, price);
		this.damage = damage;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
}
