package ndr.player;

import java.util.Random;

import junit.framework.TestResult;

import ndr.containers.RandomizedQueue;
import ndr.model.RatGame;
import ndr.model.TryResult;

/*
 * Randomly selects a valid number 
 * the valid numbers are pruned each time feedback is called
 * */
public class RandomPlayer implements IPlayer {

	String[] candidates;
	int len;
	Random generator;

	public RandomPlayer() {
		candidates = new String[3030];
		generator = new Random();
		len = 0;
		for (int i = 1000; i < 10000; i++) {
			if (valid(i))
				candidates[len++] = "" + i;
		}
	}

	private boolean valid(int n) {
		int[] usd = new int[10];
		while (n != 0) {
			usd[n % 10]++;
			n /= 10;
		}
		for (int x : usd)
			if (x > 1)
				return false;
		return usd[0] == 0;
	}

	@Override
	public String guessNumber() {
		return candidates[generator.nextInt(len)];
	}

	@Override
	public void feedback(String number, TryResult result) {
		int j = 0;
		for (int i = 0; i < len; i++) {
			TryResult res = RatGame.compareNumbers(candidates[i],number);
			if ( res.equals(result) ) {
				candidates[j++] = candidates[i];
			}
		}
		len = j;
	}

}
