import ndr.model.RatGame;
import ndr.model.TryResult;
import ndr.player.HumanPlayer;
import ndr.player.IPlayer;
import ndr.player.RandomPlayer;

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
		IPlayer player = new RandomPlayer();
		PlayerTesting test = new PlayerTesting();	
		int iter = 100000;
		double ans = 0;
		for ( int i = 0 ; i < iter ; i++ ){
			test.play(new RatGame(player.guessNumber()), new RandomPlayer());
			ans += test.getLength();
		}
		System.out.println(ans/iter);
		test.printStats();
	}
}
