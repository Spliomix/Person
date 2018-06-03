package a01225308.coemert;

public enum Fertigkeit {
	MATHEMATIK(30), GEOGRAFIE(10),
	GESCHICHTE(), ENGLISCH(),
	FRANZOESISCH, LITERATUR, SPORT(10),
	PROGRAMMIEREN(40){
		public int getBonus(int stufe) {
			return(Grundwert+stufe*100);
		}
	}, JAPANISCH(40);
	
	public final int Grundwert;
	
	private Fertigkeit(int Grundwert) {
		this.Grundwert=Grundwert;
	}
	
	private Fertigkeit() {
		Grundwert=20;
	}
	
	public int getBonus(int stufe) {
		return(Grundwert*stufe);
	}
	public  String toString() {
		return name();
	}
	
}
