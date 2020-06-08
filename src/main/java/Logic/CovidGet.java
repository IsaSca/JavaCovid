package Logic;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.Objects;

public class CovidGet {
  
  OkHttpClient client = new OkHttpClient();
  
  public String getInfo(String country) {
    String allInfo = getAllInfo();
    JSONObject info = new JSONObject(allInfo);
    JSONArray arr = info.getJSONArray("Countries");
    for(Object object : arr) {
      if(object.toString().contains(country)) {
        return new JSONObject(object.toString()).toString(2);
      }
    }
    return null;
  }
  
  public String getAllInfo() {
    Request request = new Request.Builder()
      .url("https://api.covid19api.com/summary")
      .build();
    try (Response response = client.newCall(request).execute()) {
      return Objects.requireNonNull(response.body()).string();
    } catch (IOException e) {
      System.out.println("Error in connection");
      e.printStackTrace();
      return null;
    }
  }
  
}
