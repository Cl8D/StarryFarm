package item;

public class Seed extends Item {
	private String season;
	private int term;
	
	public Seed(String name, int price, String season, int term) {
		super(name, price);
		this.season = season;
		this.term = term;
	}
	
	public String getSeason() {
		return season;
	}
	
	public void setSeason(String season) {
		this.season = season;
	}
	
	public int getTerm() {
		return term;
	}
	
	public void setTerm(int term) {
		this.term = term;
	}
}
