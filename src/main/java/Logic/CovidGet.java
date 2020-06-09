package Logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

public class CovidGet {
  
  private final OkHttpClient client = new OkHttpClient();
  private final ObjectMapper mapper = new ObjectMapper();
  
  public LinkedHashMap<String, Object> getInfo(String country) throws JsonProcessingException {
    String allInfo = getAllInfo();
    if(allInfo.contains("maximum request limit")) {
      System.out.println("Maximum API calls reached. Try again in 1 minute.");
      return null;
    }
    HashMap<String, Object> mapped = mapper.readValue(allInfo, HashMap.class);
    ArrayList<LinkedHashMap<String, Object>> countries = (ArrayList<LinkedHashMap<String, Object>>) mapped.get("Countries");
    for (LinkedHashMap<String, Object> l: countries) {
      if(l.containsValue(country)) {
        return l;
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
    } catch (Exception e) {
      return("Error in connection.\nYou may have exceeded API usage. Try again in 1 minute.");
    }
  }
  
}
