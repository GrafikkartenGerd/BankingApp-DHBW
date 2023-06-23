package java.bankingapp;

abstract class Konto {
    private String Kontonummer;
    private double Kontostand;
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
