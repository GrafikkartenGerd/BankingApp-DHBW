package java.bankingapp;

abstract class Konto {
    private String Kontonummer;
    private double Kontostand;

    private double Dispo;
    public String getKontoNummer(){
        return Kontonummer;
    }

    public double getDispo() {return Dispo;}
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
