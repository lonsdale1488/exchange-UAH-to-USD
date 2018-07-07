package S.Murashev;

public class Main {

    public static void main(String[] args) {
	Logict logict = new Logict();
        try {
         String json = logict.action();// write your code here
            System.out.print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
