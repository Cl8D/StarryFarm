package town;
import java.util.ArrayList;
import java.util.List;

import item.Seed;
import item.Tool;
import item.Weapon;

public class MartItem {
	private static List <Weapon> weapons;
	
	private static List <Tool> basicTools;
	private static List <Tool> copperTools;
	private static List <Tool> ironTools;
	private static List <Tool> iridiumTools;
	
	private static List <Seed> springSeeds;
	private static List <Seed> summerSeeds;
	private static List <Seed> autumnSeeds;

	public MartItem(List<Weapon> weapons, List<Tool> basicTools, List<Tool> copperTools, List<Tool> ironTools, List<Tool> iridiumTools, List<Seed> springSeeds, List<Seed> summerSeeds, List<Seed> autumnSeeds) {
		MartItem.weapons = weapons;
		MartItem.basicTools = basicTools;
		MartItem.copperTools = copperTools;
		MartItem.ironTools = ironTools;
		MartItem.iridiumTools = iridiumTools;
		MartItem.springSeeds = springSeeds;
		MartItem.summerSeeds = summerSeeds;
		MartItem.autumnSeeds = autumnSeeds;
	}
	
	public static List<Weapon> getWeapons(){
		return weapons;
	}
	
	public void setWeapons(List <Weapon> weapons) {
		MartItem.weapons = weapons;
	}
	
	public static List<Tool> getBasicTools(){
		return basicTools;
	}
	
	public void setBasicTools(List <Tool> basicTools) {
		MartItem.basicTools = basicTools;
	}
	
	public static List<Tool> getCopperTools(){
		return copperTools;
	}
	
	public void setCopperTools(List <Tool> copperTools) {
		MartItem.copperTools = copperTools;
	}
	
	public static List<Tool> getIronTools(){
		return ironTools;
	}
	
	public void setIronTools(List <Tool> ironTools) {
		MartItem.ironTools = ironTools;
	}
	
	public static List<Tool> getIridiumTools(){
		return iridiumTools;
	}
	
	public void setIridiumTools(List <Tool> iridiumTools) {
		MartItem.iridiumTools = iridiumTools;
	}
	
	public static List<Seed> getSpringSeeds(){
		return springSeeds;
	}
	
	public void setSpringSeeds(List <Seed> springSeeds) {
		MartItem.springSeeds = springSeeds;
	}
	
	public static List<Seed> getSummerSeeds(){
		return summerSeeds;
	}
	
	public void setSummerSeeds(List <Seed> summerSeeds) {
		MartItem.summerSeeds = summerSeeds;
	}
	
	public static List<Seed> getAutumnSeeds(){
		return autumnSeeds;
	}
	
	public void setAutumnSeeds(List <Seed> autumnSeeds) {
		MartItem.autumnSeeds = autumnSeeds;
	}
	
	
	
}
