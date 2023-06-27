import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String kod, rodzaj;
        Scanner in = new Scanner(System.in);
        Klient klient = new Klient();
        Odczyt odczyt = new Odczyt();
        Zapis zapis = new Zapis();
        klient.setPIN("1234");
        System.out.println("Obsługiwane rodzaje kart: Mastercard, Visa, American Express, Visa Electron");
        System.out.println("Podaj rodzaj swojej karty:");
        rodzaj = in.nextLine();
        if (rodzaj.equals("Mastercard") || rodzaj.equals("Visa") || rodzaj.equals("American Express") || rodzaj.equals("Visa Electron")) {
            klient.setRodzajKarty(rodzaj);
            klient.setStan(odczyt.ReadFile());
            System.out.println();
            System.out.println("Proszę, wprowadź numer PIN:");
            kod = in.next();
            try {
                Integer.parseInt(kod);
                if (kod.equals(klient.getPIN())) {
                    String w;
                    do {
                        System.out.println();
                        System.out.println("Proszę wybrać typ operacji");
                        System.out.println("1-Wypłata");
                        System.out.println("2-Wpłata");
                        System.out.println("3-Stan konta");
                        System.out.println("4-Zakończ");
                        String wybor = in.next();
                        if (wybor.equals("1")) {
                            System.out.println();
                            System.out.println("Podaj kwotę do wypłaty");
                            int kwotaWypl = in.nextInt();
                            if (kwotaWypl < 0) {
                                System.out.println();
                                throw new IllegalArgumentException("Kwota ujemna!");
                            }
                            if (kwotaWypl <= klient.getStan()) {
                                if (kwotaWypl % 10 == 0) {
                                    Wyplata wyplata = new Wyplata();
                                    wyplata.stanPoWypl = klient.getStan() - kwotaWypl;
                                    klient.stan = wyplata.stanPoWypl;
                                    zapis.SaveFile(klient.getStan());
                                    System.out.println(wyplata.wyplGotowki(klient.getRodzajKarty(), kwotaWypl, klient.getStan()));
                                } else {
                                    System.out.println();
                                    System.out.println("Bankomat wypłaca banknoty w nominale: 10, 20, 50, 100");
                                }
                            } else {
                                System.out.println();
                                System.out.println("Brak wystarczających środków na koncie!");
                            }
                        } else if (wybor.equals("2")) {
                            System.out.println();
                            System.out.println("Podaj kwotę do wpłaty");
                            int kwotaWpl = in.nextInt();
                            if (kwotaWpl < 0) {
                                System.out.println();
                                throw new IllegalArgumentException("Kwota ujemna!");
                            }
                            if (kwotaWpl % 10 == 0) {
                                Wplata wplata = new Wplata();
                                wplata.stanPoWpl = klient.getStan() + kwotaWpl;
                                klient.stan = wplata.stanPoWpl;
                                zapis.SaveFile(klient.getStan());
                                System.out.println(wplata.wplGotowki(klient.getRodzajKarty(), kwotaWpl, klient.getStan()));
                            } else {
                                System.out.println();
                                System.out.println("Kwota musi być podzielna przez 10!");
                            }
                        } else if (wybor.equals("3")) {
                            Stan stan = new Stan();
                            System.out.println();
                            System.out.println(stan.stanRachunku(klient.getStan()));
                        } else if (wybor.equals("4")) break;
                        else {
                            System.out.println();
                            System.out.println("Nie rozpoznano polecenia!");
                        }
                        System.out.println();
                        System.out.println("Czy chcesz wykonać kolejną operację?");
                        System.out.println("1. TAK");
                        System.out.println("2. NIE");
                        w = in.next();
                        while (!w.equals("1") && !w.equals("2")) {
                            System.out.println();
                            System.out.println("Nie rozpoznano polecenia!");
                            System.out.println();
                            System.out.println("Czy chcesz wykonać kolejną operację?");
                            System.out.println("1. TAK");
                            System.out.println("2. NIE");
                            w = in.next();
                        }
                    } while (w.equals("1"));
                    System.out.println();
                    System.out.println("Dziękujemy za skorzystanie z bankomatu");
                    System.out.println("Odbierz kartę");
                } else {
                    System.out.println();
                    System.out.println("Niepoprawny kod PIN");
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Kod PIN musi się składać z cyfer!\n" + e.getMessage());
            }
        } else klient.sprRodzKarty();
    }
}