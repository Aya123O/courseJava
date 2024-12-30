class MyException1 extends Exception {
    public MyException1(String s) {
        super(s);
    }
}



class ExceptionClass {
    
    public void method1() throws MyException1 {
        int x = 10;
        int y = 0;
        if (y == 0) {
            throw new MyException1("Divided By Zero");
        }
    }

   public void method2() throws MyException2 {
        String str = null;
        if (str == null) { 
            throw new MyException2("Error Null Pointer");
        }
       
    }
    

    public void method3() throws MyException3 {
        String s = "";
        if (s.isEmpty()) { 
            throw new MyException3("Error Empty String");
        }
    }
    
}

public class Main {
    public static void main(String[] args) {
        ExceptionClass obj = new ExceptionClass();

        try {
            obj.method1();
            obj.method2();
            obj.method3();
        } catch (MyException1 ex) {
            System.out.println("Caught MyException1");
            System.out.println(ex.getMessage());
           } catch (MyException2 ex) {
            System.out.println("Caught MyException1");
            System.out.println(ex.getMessage());
           } catch (MyException3 ex) {
            System.out.println("Caught MyException1");
            System.out.println(ex.getMessage());
           } 
           
        finally {
            System.out.println("Finally");
        }
    }
}

