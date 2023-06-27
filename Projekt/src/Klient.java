public class Klient implements RodzajKarty {
    String PIN, rodzajKarty;
    int stan;

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getPIN() {
        return PIN;
    }

    public void setRodzajKarty(String rodzajKarty) {
        this.rodzajKarty = rodzajKarty;
    }

    public String getRodzajKarty() {
        return rodzajKarty;
    }

    public void setStan(int stan) {
        this.stan = stan;
    }

    public int getStan() {
        return stan;
    }

    @Override
    public void sprRodzKarty() {
        System.out.println();
        System.out.println("Taki rodzaj karty nie jest akceptowany!");
        System.out.println("Obsługiwać można karty: Mastercard, Visa, American Express, Visa Electron");
    }
}