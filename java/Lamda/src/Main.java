//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    interface BetterCriteria {
        boolean isBetter(String s1,String s2);
    }
    public static    String  betterString( String s1,String s2,BetterCriteria criteria){
       return criteria.isBetter(s1,s2)?s1:s2;
    }

    public static void main(String[] args) {

        String string1="Hello";
        String string2 = "world";
        String Longer = betterString(string1,string2,(s1,s2)->s1.length() >s2.length());
        System.out.println("the longest word is " +Longer);
        String first = betterString(string1,string2,(s1,s2)->true);
        System.out.println("the first word is " +first);



    }
}