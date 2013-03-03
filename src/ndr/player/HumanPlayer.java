package ndr.player;

import java.util.Scanner;

import ndr.model.TryResult;
/*
 * Ask for human help
 * */
public class HumanPlayer implements IPlayer {

	Scanner In = new Scanner(System.in);
	
	@Override
	public String guessNumber() {
		System.out.println("Ingrese un numero:");
		return In.next();
	}

	@Override
	public void feedback(String number, TryResult result) {
		System.out.println(result);
	}

}
