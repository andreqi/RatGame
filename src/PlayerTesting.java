import ndr.model.RatGame;
import ndr.model.TryResult;
import ndr.player.HumanPlayer;
import ndr.player.IPlayer;

public class PlayerTesting {

	private int iterations;

	public void play(RatGame game, IPlayer player) {
		iterations = 0;
		TryResult result = null;
		String guess = null;
		while(true){
			iterations++;
			guess = player.guessNumber();
			result = game.tryNumber( guess );
			if (result.isWin() ) break;
			player.feedback(guess, result);			
		}
	}

	public void printStats() {
		System.out.println("Iterations : " + iterations);
	}
	
	public int getLength(){
		return iterations;
	}

	public static void main(String[] args) {
		IPlayer player = new HumanPlayer();
		PlayerTesting test = new PlayerTesting();
		test.play(new RatGame("1234"), player);
		test.printStats();
	}
}
