public class IPAddr {
    public static void main(String[] args) {
        String ip = "125.36.5.0";

    
        if (ip == null || ip.length() == 0) {
            System.out.println("IP is empty or null.");
            return;
        }

     
        String[] words = ip.split("\\.");  


        for (String currentWord : words) {
            if ( Integer.parseInt(currentWord) >255){
              System.out.println("Not vaild ip");
            
            }
            System.out.println(currentWord);
        }
    }
}

