package farm;

import console.ClearConsole;
import character.UserInfo;

public class AboutUser extends UserInfo {
	public void printUser() {
		ClearConsole.clearConsole();
		System.out.println("------------------------------------------------------------------");
		System.out.println("�� " + Farm.getYear() +"���� ������ " + user.getName());
		System.out.println("�� Level: " + user.getLevel());
		System.out.println("�� Hp: " + user.getHp() + "/" + user.getMaxHp());
		System.out.println("�� ���� �ڻ�: " + user.getGold() + "G");
		System.out.println("------------------------------------------------------------------");
	}
}
