import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
public class Test_URL_Req {
public static void main(String[] args) {
try {
//  String url = "http://api.fixer.io/latest?access_key=1b9936590c9e001786b2a719ef06fe6c";
  String url = "http://localhost:8081/user/userById?userId=2";
  URL obj = new URL(url);
  HttpURLConnection con = (HttpURLConnection) obj.openConnection();
  int responseCode = con.getResponseCode();
  System.out.println("\nSending 'GET' request to URL : " + url);
  System.out.println("Response Code : " + responseCode);
  BufferedReader in =new BufferedReader(
  new InputStreamReader(con.getInputStream()));
  String inputLine;
  StringBuffer response = new StringBuffer();
   while ((inputLine = in.readLine()) != null) {
     response.append(inputLine);
   } in .close();
   JSONObject myresponse = new JSONObject(response.toString());
   System.out.println(myresponse);
   System.out.println("username -" + myresponse.getString("username"));

  } catch(Exception e) {
    System.out.println(e);
  }
 }
}