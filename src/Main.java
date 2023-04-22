import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static String op;
    public static void main(String[] args) {
        SplayTree ST = new SplayTree();
        RedBlackTree RB = new RedBlackTree();
        System.out.println("===Bienvenido a tu Diccionario===");
        System.out.println("Qué arbol desea trabajar: \n1. SplayTree\n2. RedBlackTree\n(Escibalo)");
        op = scan.nextLine();
        new SpanishEnglishMap(op);
        switch (op){
            case "SplayTree":
                System.out.println("\n===Ordenar las palabras===");
                Reader.leer();
                System.out.println("house,casa\n" +
                        "dog,perro\n" +
                        "homework,tarea\n" +
                        "woman,mujer\n" +
                        "town,pueblo");
                ST.printInOr((SplayTree) ST.getRoot());
                System.out.println("===Traducir la oracion===");
                System.out.println("La oración traducida es: ");
                ArrayList<String> TextOracioens = Reader.leer2();
                for (String ora : TextOracioens) {
                    String[] palabras = ora.split(" ");
                    StringBuilder traduccion = new StringBuilder();
                    for (String palabra : palabras) {
                        String traduccionPalabra = ST.get(palabra);
                        traduccion.append(traduccionPalabra).append(" ");
                    }
                    System.out.println(traduccion.toString().trim());
                }
                break;
            case "RedBlackTree":
                System.out.println("\n===Ordenar las palabras===");
                Reader.leer();
                System.out.println("house,casa\n" +
                        "dog,perro\n" +
                        "homework,tarea\n" +
                        "woman,mujer\n" +
                        "town,pueblo");
                RB.printInOr((RedBlackTree) RB.getRoot());
                System.out.println("===Traducir la oracion===");
                System.out.println("La oración traducida es: ");
                ArrayList<String> TextOraciones = Reader.leer2();
                for (String ora : TextOraciones) {
                    String[] palabras = ora.split(" ");
                    StringBuilder traduccion = new StringBuilder();
                    for (String palabra : palabras) {
                        String traduccionPalabra = RB.get(palabra);
                        traduccion.append(traduccionPalabra).append(" ");
                    }
                    System.out.println(traduccion.toString().trim());
                }
                break;
        }
    }
}