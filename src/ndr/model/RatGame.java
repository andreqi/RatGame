package ndr.model;

import java.util.Arrays;

public class RatGame {
	public static final int LENGHTOFNUMBER = 4;
	private String target;
	static boolean[] used = new boolean[10];
	public RatGame(String target_number) {
		assert (target_number.length() == LENGHTOFNUMBER);
		target = target_number;

	}

	public TryResult tryNumber(String number) {
		return compareNumbers(target, number);
	}
	
	static public TryResult compareNumbers(String target, String number){
		
		assert (number.length() == target.length());
		Arrays.fill(used, false);
		int perfect = 0, good = 0;
		for (int i = 0; i < number.length(); i++) {
			perfect += (number.charAt(i) != target.charAt(i)) ? 0 : 1;
			used[(int) (number.charAt(i) - '0')] = true;
		}
		for (int j = 0; j < number.length(); j++) {
			good += used[(int) (target.charAt(j) - '0')] ? 1 : 0;
		}
		good -= perfect;
		return new TryResult(perfect, good);
		
	}
	
}
