package ndr.player;

import ndr.model.TryResult;

public interface IPlayer {
	String guessNumber();
	void feedback( String number, TryResult result ); 
}
