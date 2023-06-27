import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Odczyt {
    public static int ReadFile() throws IOException {
        File odczyt = new File("Stan konta.txt");
        Scanner in = new Scanner(odczyt);
        int stan = in.nextInt();
        return stan;
    }
}