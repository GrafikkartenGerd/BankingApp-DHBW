package java.bankingapp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Kunde extends Person {
    private String login;
    private String password;
    private List<Konto> konten;

    public Kunde(String name, Date birthDate, String address, String email, String phoneNumber, String login, String password) {
        super();
        this.setName(name);
        this.setBirthDate(birthDate);
        this.setAddress(address);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.login = login;
        this.password = password;
        this.konten = new ArrayList<>();
    }

    public void login(String login, String password) {
        // Implementieren Sie die Logik für den Login hier
    }

    public void logout() {
        // Implementieren Sie die Logik für den Logout hier
    }

    public void kontoAnlegen(Konto konto) {
        this.konten.add(konto);
    }

    public void kontoÄndern(String kontoNummer, Konto neuesKonto) {
        for (int i = 0; i < this.konten.size(); i++) {
            if (this.konten.get(i).getKontoNummer().equals(kontoNummer)) {
                this.konten.set(i, neuesKonto);
                break;
            }
        }
    }

    public void kontoAuflösen(String kontoNummer) {
        this.konten.removeIf(konto -> konto.getKontoNummer().equals(kontoNummer));
    }

    public void einzahlen(String kontoNummer, double betrag) {
        for (Konto konto : this.konten) {
            if (konto.getKontoNummer().equals(kontoNummer)) {
                konto.einzahlen(betrag);
                break;
            }
        }
    }

    public void auszahlen(String kontoNummer, double betrag) {
        for (Konto konto : this.konten) {
            if (konto.getKontoNummer().equals(kontoNummer)) {
                konto.auszahlen(betrag);
                break;
            }
        }
    }

    public void überweisen(String vonKontoNummer, String zuKontoNummer, double betrag) {
        Konto vonKonto = null, zuKonto = null;
        for (Konto konto : this.konten) {
            if (konto.getKontoNummer().equals(vonKontoNummer)) {
                vonKonto = konto;
            }
            if (konto.getKontoNummer().equals(zuKontoNummer)) {
                zuKonto = konto;
            }
        }
        if (vonKonto != null && zuKonto != null) {
            vonKonto.auszahlen(betrag);
            zuKonto.einzahlen(betrag);
        }
    }

    public boolean istKontoGedeckt(String kontoNummer, double betrag) {
        for (Konto konto : this.konten) {
            if (konto.getKontoNummer().equals(kontoNummer)) {
                return konto.getKontostand() >= betrag;
            }
        }
        return false;
    }

    public double dispoAnzeigen(String kontoNummer) {
        for (Konto konto : this.konten) {
            if (konto.getKontoNummer().equals(kontoNummer)) {
                return konto.getDispo();
            }
        }
        return 0.0;
    }
}