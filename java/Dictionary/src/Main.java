import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import  java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Map<String, Map<String, String>> dictionary = new HashMap<>();
        Map<String, String> innerMap1 = new HashMap<>();
        Map<String, String> innerMap2 = new HashMap<>();
        Map<String, String> innerMap3 = new HashMap<>();
        innerMap1.put("apple", "this is apple");
        innerMap1.put("ant", "this is ant");
        innerMap2.put("Banana", "this is Banana");
        innerMap2.put("Big", "this is Big");
        innerMap3.put("cat", "this is cat");
        dictionary.put("a", innerMap1);
        dictionary.put("b", innerMap2);
        dictionary.put("c", innerMap3);
        System.out.println("Keys => ");
        for (String i : dictionary.keySet()) {
            System.out.println(i);
        }
        System.out.println("Values => ");
        for (String j : dictionary.keySet()) {
            System.out.println(dictionary.get(j));
        }

    }
}