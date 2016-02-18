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
        return this.ueberschrift;
    }

    public void setUeberschrift(final String ueberschrift) {
        this.ueberschrift = ueberschrift;
    }

    public String getUnterueberschrift() {
        return this.unterueberschrift;
    }

    public void setUnterueberschrift(final String unterueberschrift) {
        this.unterueberschrift = unterueberschrift;
    }

    public String getAktenzeichen() {
        return this.aktenzeichen;
    }

    public void setAktenzeichen(final String aktenzeichen) {
        this.aktenzeichen = aktenzeichen;
    }

    public String getDatum() {
        return this.datum;
    }

    public void setDatum(final String datum) {
        this.datum = datum;
    }

    public String getRechtsBereich() {
        return this.rechtsBereich;
    }

    public void setRechtsBereich(final String rechtsBereich) {
        this.rechtsBereich = rechtsBereich;
    }

    public String getVergehen() {
        return this.vergehen;
    }

    public void setVergehen(final String vergehen) {
        this.vergehen = vergehen;
    }

    public String getStrafmaﬂ() {
        return this.strafmaﬂ;
    }

    public void setStrafmaﬂ(final String strafmaﬂ) {
        this.strafmaﬂ = strafmaﬂ;
    }

    public String Ausgabe() { // gibt alle angaben aus
        String s = "";
        s = "ueberschrift " + this.ueberschrift + "\n" + "unterueberschrift " + this.unterueberschrift + "\n" + "aktenzeichen " + this.aktenzeichen + "\n" + "datum " + this.datum + "\n" + "rechtsBereich " + this.rechtsBereich + "\n" + "vergehen " + this.vergehen + "\n" + "strafmaﬂ " + this.strafmaﬂ;

        return s;
    }

}
