package S.Murashev;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Logict logict = new Logict();
        try {
         String json = logict.action();// write your code here
            System.out.print("Ведіть тип валюти");
            Scanner sc = new Scanner(System.in);
            String cantry = sc.nextLine();
            System.out.print("ведіть суму");
            Integer number = sc.nextInt();
            System.out.print("тип операції");
            Scanner sd = new Scanner(System.in);
            String operation = sd.nextLine();

            JSONArray array= new JSONArray(json);
            Double value ;
            for (int i=0; i< array.length(); i++)
            {
                JSONObject valut = array.getJSONObject(i);
            String val = valut.getString("ccy");
            if (!(val.equalsIgnoreCase(cantry)))
            {
                continue;
            }
               value = Double.parseDouble(valut.getString(operation));
                value = value * number;
                System.out.println(value);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
