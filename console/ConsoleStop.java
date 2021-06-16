package console;

public class ConsoleStop {
	public static void threadSleep(int sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
