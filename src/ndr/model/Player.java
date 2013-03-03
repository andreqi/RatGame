package ndr.model;

public interface Player {
	String guessNumber();
	void feedback( String number, TryResult result ); 
}
