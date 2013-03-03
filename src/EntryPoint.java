import java.util.Scanner;

public class EntryPoint {

	private GameEngine ge;
	private Scanner in;

	public void processEvent() {
		if (in.hasNext() == false)
			throw new java.lang.RuntimeException("El juego termino");
		String action = in.next();
		ge.handleStringEvent(action);
	}

	public EntryPoint(GameEngine ge) {
		this.ge = ge;
		in = new Scanner(System.in);
	}

	public static void main(String[] args) {
						
		GameEngine gameEngine = new GameEngine();
		EntryPoint eventCycle = new EntryPoint(gameEngine);
		while (true) {
			try {
				eventCycle.processEvent();
			} catch (InternalError e) {
				System.out.println(e.getMessage());
				break;
			} catch (Exception e ){
				System.out.println(e.getMessage());
				break;
			}
		}
	}

}
