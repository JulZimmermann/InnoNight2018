package team3.innonight.fhws.innonight.model;

import java.io.Serializable;

public class Auto implements Serializable {

    private String kennzeichen;
    private String schluesselnummer;
    private String typnummer;
    private String versicherungsnummer;

    public Auto(String kennzeichen, String schluesselnummer, String typnummer, String versicherungsnummer) {
        this.kennzeichen = kennzeichen;
        this.schluesselnummer = schluesselnummer;
        this.typnummer = typnummer;
        this.versicherungsnummer = versicherungsnummer;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getSchluesselnummer() {
        return schluesselnummer;
    }

    public void setSchluesselnummer(String schluesselnummer) {
        this.schluesselnummer = schluesselnummer;
    }

    public String getTypnummer() {
        return typnummer;
    }

    public void setTypnummer(String typnummer) {
        this.typnummer = typnummer;
    }

    public String getVersicherungsnummer() {
        return versicherungsnummer;
    }

    public void setVersicherungsnummer(String versicherungsnummer) {
        this.versicherungsnummer = versicherungsnummer;
    }
}
