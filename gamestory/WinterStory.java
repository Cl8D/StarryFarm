package gamestory;

import java.util.Scanner;

import console.ClearConsole;
import character.UserInfo;
import farm.Inventory;
import farm.Postbox;

public class WinterStory extends UserInfo {
	public static void one_day() {
		ClearConsole.clearConsole();
		String userPress = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("편지가 도착하였습니다. 확인할까요?(y/n)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("안녕, " + user.getName() +"!");
			System.out.println("이제 겨울이네. 벌써 우리가 함께 한 지 거의 1년이 다 되어가다니... 시간 참 빨라.");
			System.out.println("1년 동안 우리 마을에서 생활이 즐거웠었다면 좋을 텐데... 네가 어떻게 생각할지 모르겠네.");
			System.out.println("난 " + user.getName() + "(이)가 와서 정말 즐거웠거든.");
			System.out.println("너도 그랬길 바라.");
			System.out.println("...어쨌든! 겨울에 뭘 해야 할지 몰라서 당황스러워 할 것 같아서 편지를 보내.");
			System.out.println("보통 겨울엔 낚시랑, 몬스터 사냥을 많이 해. 특히 몬스터 지하로 내려갈수록 정말 무서운 몬스터들이 많거든.");
			System.out.println("대신 그 친구들을 잡으면 돈을 많이 준다고 하더라구. 난 무서워서 10층보다 아래로 내려간 적은 없지만 말야... 헤헤.");
			System.out.println("아마 우리 마을에서 30층까지 내려간 사람은 한 명뿐일걸? 누군지는 비밀! 아마 곧 알게 될 거야.");
			System.out.println("여튼, 겨울에는 조금 쉬엄쉬엄해. 다음 봄을 위한 에너지 충전이라 생각하라구!");
			System.out.println("겨울에는 작물을 못 파니까 좀 더 두둑하게 넣었어. 가져가, 선물이야!");
			System.out.println("- 시장 자바바");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("1000골드가 도착하였습니다.");
		user.setGold(1000);
		System.out.println("------------------------------------------------------------------");
		
		int postCount = Postbox.getPostCount();
		postCount--;
		Postbox.setPostCount(postCount);
		}
		else
			return;
	}
	
	public static void ten_day() {
		ClearConsole.clearConsole();
		String userPress = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("편지가 도착하였습니다. 확인할까요?(y/other keys)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println(user.getName() + ", 올해는 좀 늦었네. 나야, 윌리.");
			System.out.println("이제 마지막 계절이네. 아마 겨울엔 농삿일이 없어서 좀 심심할 테니, 호숫가에 자주 와.");
			System.out.println("내가 만나면 특별히 물고기 몇 마리 나눠주도록 하지. 내 이리듐 낚싯대도 써 주게 해 줄 수도 있고.");
			System.out.println("뭐, 여튼. 겨울 물고기는 총 6마리. 청어, 오징어, 넙치, 참치, 범노래미, 얼음 물고기가 있다.");
			System.out.println("겨울엔 낚시가 제맛인 거 알지? 특히 얼음 물고기... 올해 겨울은 더 추워서 잘 나타난다고 하던데.");
			System.out.println("괜히 동굴 같은 곳 가지 말고, 낚시에 더 힘을 써 줘. 춤다고 사람들이 잘 안 와서 심심하단 말이다.");
			System.out.println("...몬스터가 무서워서 그러는 거 아니니까, 오해하지 마. 그딴 게 뭐가 무섭다고.");
			System.out.println("아무튼, 이건 선물. 이따가 우리 집에 오면 회로 떠줄 테니 잘 간직하고 있으라고. 그럼, 이따 봐.");
			System.out.println("- 윌리");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("참치가 도착했습니다.");
		Inventory.winterF4++;
		System.out.println("------------------------------------------------------------------");
		
		int postCount = Postbox.getPostCount();
		postCount--;
		Postbox.setPostCount(postCount);
		}
		else
			return;
	}
	
	public static void twenty_day() {
		ClearConsole.clearConsole();
		String userPress = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("편지가 도착하였습니다. 확인할까요?(y/other keys)> ");
		System.out.println();
		userPress = scanner.next();
		if(userPress.equals("y")) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("저기... 안녕. 우리 초면이지?");
			System.out.println("자바바한테 내 얘기를... 들었다던데. 나는 콘솔이라고 해.");
			System.out.println("그, 30층까지 간 사람... 그게 나야. 내가 낯을 좀... 많이 가려서 말이야. 네게 편지 쓰는 게 좀 걸렸네.");
			System.out.println("동굴에는 많이 가봤겠지만... 아랫층까지는 안 가봤을 것 같아서.");
			System.out.println("25층부터는... 정말 무시무시한 친구들이 많아. 이클네에서 파는 갤럭시 검을 꼭 사서 들어가길 바랄게.");
			System.out.println("그거 없으면 아마 가더라도 기절해서 치료비만 어마어마하게 들 거라구. 너 기절하면 내가 끌고 나와야 한단 말야...");
			System.out.println("우선 낮은 층에서 몬스터들을 많이 잡고, 기초 체력을 높이기를 바랄게.");
			System.out.println("한 500마리 정도 잡으면 체력이 어마머마해질 거야. 심심하면 동굴 자주 와.");
			System.out.println("못된 윌리가 있는 낚시터 같은 곳 가지 말고. 몬스터 무찌르는 거 도와줄게.");
			System.out.println("이건... 선물. 자바바가 새 친구한테는 이거 주면 좋아할 거라 했어.");
			System.out.println("그럼, 나중에 보자... 만나서 정말 반가워.");
			System.out.println("- 콘솔");
			System.out.println("----------------------------------------------------------------------");
		
		System.out.println("스타후르츠가 도착했습니다.");
		int fruit = Inventory.getSummerS();
		Inventory.setSummerS(fruit);
		System.out.println("------------------------------------------------------------------");
		
		int postCount = Postbox.getPostCount();
		postCount--;
		Postbox.setPostCount(postCount);
		}
		else
			return;
	}
	
}
