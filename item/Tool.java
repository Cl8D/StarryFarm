package item;

public class Tool extends Item {
	private int power;
	public Tool(String name, int price, int power) {
		super(name, price);
		this.power = power;
	}
	
	public int getPower() {
		return power;
	}
	
	public void setPower(int power) {
		this.power = power;
	}

}
