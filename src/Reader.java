import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    ArrayList<String> Keys = new ArrayList<String>();
    //Metodo que lee el archivo del diccionario
    public static ArrayList<String> leer() {
        ArrayList<String> lineas = new ArrayList<>();

        try {
            File archivo = new File("diccionario.txt");
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                lineas.add(linea);
            }
            scanner.close();

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
        return lineas;
    }
}
