import ndr.model.RatGame;
import ndr.model.TryResult;

public class GameEngine {
	final static public String EXIT = "exit";
	int iteration = 0;
	RatGame game;

	public void handleStringEvent(String action) {
		switch (action) {
		case EXIT:
			throw new java.lang.InternalError("Juego terminado");
		default:
			if (iteration == 0) {
				System.out.println("Juego creado");
				game = new RatGame(action);
			} else {
				TryResult result = game.tryNumber(action);
				System.out.println(result);
				if (result.isWin())
					throw new java.lang.InternalError("Juego terminado");
			}
			iteration ++;
		}
	}
}
