import java.io.IOException;
import java.io.PrintWriter;

public class Zapis {
    public static void SaveFile(int kwota) throws IOException {
        PrintWriter zapis = new PrintWriter("Stan konta.txt");
        zapis.print(kwota);
        zapis.close();
    }
}