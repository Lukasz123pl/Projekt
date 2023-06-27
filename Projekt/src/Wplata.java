public class Wplata extends Klient {
    int wplKwot, stanPoWpl;

    public String wplGotowki(String rodzajKarty, int wplKwot, int stanPoWpl) {
        return "\nRodzaj karty: " + rodzajKarty + "\nKwota wpłacona: " + wplKwot + " zł\nObecny stan konta: " + stanPoWpl + " zł";
    }
}