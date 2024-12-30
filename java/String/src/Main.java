import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String s = "Java5";
        List<Character> ch = new ArrayList<>();

        // Populate the list with characters from the string
        for (int i = 0; i < s.length(); i++) {
            ch.add(s.charAt(i));
        }

        System.out.println(ch);

        boolean flage = true;
            for (int j = 0; j < ch.size(); j++) {
                if (!Character.isLetter(ch.get(j))) {
                    flage = false;
                    break;
                }

            }

        if(flage){
            System.out.println(" String");

        }else{
            System.out.println("Not String");
        }
    }
}
