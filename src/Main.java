import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static String op;
    public static void main(String[] args) {
        SplayTree ST = new SplayTree();
        System.out.println("===Bienvenido a tu Diccionario===");
        System.out.println("Qué arbol desea trabajar: \n1. SplayTree\n2. RedBlack");
        op = scan.nextLine();
        new SpanishEnglishMap(op);
    }
}