package bghimport.convert;

public class Fall {

	private String ueberschrift;
	private String unterueberschrift;
	private String aktenzeichen;
	private String datum;
	private String rechtsBereich;
	private String vergehen;
	private String strafmaﬂ;
	
	
	
	public Fall() {
		
	}
	public String getUeberschrift() {
		return ueberschrift;
	}
	public void setUeberschrift(String ueberschrift) {
		this.ueberschrift = ueberschrift;
	}
	public String getUnterueberschrift() {
		return unterueberschrift;
	}
	public void setUnterueberschrift(String unterueberschrift) {
		this.unterueberschrift = unterueberschrift;
	}
	public String getAktenzeichen() {
		return aktenzeichen;
	}
	public void setAktenzeichen(String aktenzeichen) {
		this.aktenzeichen = aktenzeichen;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public String getRechtsBereich() {
		return rechtsBereich;
	}
	public void setRechtsBereich(String rechtsBereich) {
		this.rechtsBereich = rechtsBereich;
	}
	public String getVergehen() {
		return vergehen;
	}
	public void setVergehen(String vergehen) {
		this.vergehen = vergehen;
	}
	public String getStrafmaﬂ() {
		return strafmaﬂ;
	}
	public void setStrafmaﬂ(String strafmaﬂ) {
		this.strafmaﬂ = strafmaﬂ;
	}
	
	public String Ausgabe (){ // gibt alle angaben aus
		String s="";
		s="ueberschrift "+ ueberschrift+ "\n" +
		 "unterueberschrift " +unterueberschrift+ "\n" +
		 "aktenzeichen " + aktenzeichen+ "\n" +
		 "datum "+ datum+ "\n" +
		 "rechtsBereich "+rechtsBereich+ "\n" +
		 "vergehen " +vergehen+ "\n" +
		 "strafmaﬂ " + strafmaﬂ;
		
		return s;
	}
	
	
}
