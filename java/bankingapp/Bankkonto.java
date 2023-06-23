package java.bankingapp;

abstract class Bankkonto {

    private String Kontonummer;
    private double Kontostand;

    public Bankkonto(String kontonummer, double kontostand){
        this.Kontonummer = kontonummer;
        this.Kontostand = kontostand;
    }

    public String getKontonummer(){
        return Kontonummer;
    }
    public double getKontostand(){
        return Kontostand;
    }
    public void einzahlen(double betrag){
        Kontostand += betrag;
    }
    public void auszahlen(double betrag){
        Kontostand -= betrag;
    }
}
