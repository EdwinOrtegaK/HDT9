import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Factory {
    public static Map getInstance(int TipoDeMapa){
        switch (TipoDeMapa){
            case 1:
                System.out.println("HashMap");
                return new HashMap();
            case 2:
                System.out.println("RedBlackTree");
                return new TreeMap();
            case 3:
                System.out.println("Eso fue todo...");
        }
        return null;
    }
}
