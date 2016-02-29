package bghimport.convert;

public class Fall {

    private String ueberschrift;
    private String unterueberschrift;
    private String aktenzeichen;
    private String datum;
    private String rechtsbereich;
    private String vergehen;
    private String strafmass;

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
        return this.rechtsbereich;
    }

    public void setRechtsbereich(final String rechtsBereich) {
        this.rechtsbereich = rechtsBereich;
    }

    public String getVergehen() {
        return this.vergehen;
    }

    public void setVergehen(final String vergehen) {
        this.vergehen = vergehen;
    }

    public String getStrafma�() {
        return this.strafmass;
    }

    public void setStrafmass(final String strafma�) {
        this.strafmass = strafma�;
    }

    @Override
    public String toString() {
        return String.join("\n", this.ueberschrift, this.unterueberschrift, "AKZ: " + this.aktenzeichen, "Datum: " + this.datum, "Rechtsbereich: " + this.rechtsbereich, "Vergehen: " + this.vergehen, "Strafma�: " + this.strafmass);
    }

}
