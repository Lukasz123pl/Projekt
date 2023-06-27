public class Wyplata extends Klient {
    int wyplKwot, stanPoWypl;

    public String wyplGotowki(String rodzajKarty, int wyplKwot, int stanPoWypl) {
        return "\nRodzaj karty: " + rodzajKarty + "\nKwota wypłacona: " + wyplKwot + " zł\nObecny stan konta: " + stanPoWypl + " zł";
    }
}