package item;

public class Fruit extends Item{
	private String season;
	private int recoverHp;
	
	public Fruit(String name, int price, String season, int recoverHp) {
		super(name, price);
		this.season = season;
		this.recoverHp = recoverHp;
	}
	
	public String getSeason() {
		return season;
	}
	
	public void setSeason(String season) {
		this.season = season;
	}
	
	public int getRecoverHp() {
		return recoverHp;
	}
	
	public void setRecoverHp(int recoverHp) {
		this.recoverHp = recoverHp;
	}
	

}
