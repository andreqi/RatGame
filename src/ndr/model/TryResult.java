package ndr.model;

public class TryResult {
	int perfect, good;

	/*
	 * Result when the player try to guess the target number p : number of
	 * perfect matches g : number of good matches
	 */
	public TryResult(int p, int g) {
		perfect = p;
		good = g;
	}

	public int getPerfect() {
		return perfect;
	}

	public void setPerfect(int perfect) {
		this.perfect = perfect;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public boolean isWin() {
		return perfect == RatGame.LENGHTOFNUMBER;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		TryResult cmp = (TryResult) obj;
		return cmp.perfect == perfect && cmp.good == good;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Perfect match : " + perfect + "\n");
		str.append("Good match    : " + good + "\n");
		if(isWin()){
			str.append("You have found the number!!\n");			
		}
		return str.toString();
	}

}
