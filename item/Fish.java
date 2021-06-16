package item;

public class Fish extends Item{
	private String season;
	private String difficulty;
	
	public Fish(String name, int price, String season, String difficulty) {
		super(name, price);
		this.season = season;
		this.difficulty = difficulty;
	}
	
	public String getSeason() {
		return season;
	}
	
	public void setSeason(String season) {
		this.season = season;
	}
	
	public String getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
}
