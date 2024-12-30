import java.util.regex.*;
import java.util.StringTokenizer;

public class StringCount {
    public static void main(String[] args) {
        String text = "i love iti  i hate iti i went to go to iti";
        String word = "iti";

       
        if (text == null || text.length() == 0) {
            System.out.println("Text is empty or null.");
            return;
        }
        if (word == null || word.length() == 0) {
            System.out.println("Word is empty or null.");
            return;
        }

    
        String lowerText = text.toLowerCase();
        String lowerWord = word.toLowerCase();

       
        StringTokenizer tokenizer = new StringTokenizer(lowerText);
        int tokencount = 0;
        
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.equals(lowerWord)) {
                tokencount++;
            }
        }

     
        System.out.println("StringTokenizer, the word '" + word + "' appears " + tokencount + " times.");

    
        Pattern pattern = Pattern.compile("\\b" + lowerWord + "\\b");
        Matcher matcher = pattern.matcher(lowerText);
        int regcount = 0;
        while (matcher.find()) {
            regcount++;
        }
        
      
        System.out.println("Using regex, the word '" + word + "' appears " + regcount + " times.");

      
        String[] words = lowerText.split("\\s+");
        int count = 0;
        for (String currentWord : words) {
            if (currentWord.equals(lowerWord)) {
                count++;
            }
        }

      
        System.out.println("Using split, the word '" + word + "' appears " + count + " times.");
    }
}

