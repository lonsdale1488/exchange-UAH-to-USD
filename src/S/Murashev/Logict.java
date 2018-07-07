package S.Murashev;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.X509Certificate;

public class Logict {

   protected String  exchangeRate () throws Exception {
        String ur1 = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
        URL obj = new URL(ur1);//
       // - create new url object web-site's

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // - create new oject class HttpURLConnection which support http protocol
       int responseCode = con.getResponseCode();
       // - created cod connection
       System.out.println("\nSending 'GET' request to URL : " + ur1);
        System.out.println("Response Code : " + responseCode);
        // - show respons code
       try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
           // read information on "con" and write to "in"
           String inputLine;
           // new object String
            StringBuilder response = new StringBuilder();
            // new object StringBuilder
          while ((inputLine = in.readLine()) != null) {
              // until "in" wosn't "null"
                response.append(inputLine);
                // stick all informaation in one line on "inputline"
           }
            return response.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected void disableSSL() {
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }};
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
protected String action() throws Exception {
    disableSSL();
    String result = exchangeRate();
  return result;
}

    }


