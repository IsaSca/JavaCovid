package Logic;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.LinkedHashMap;

public class ResultDisplay {
  private String countryName = "";
  private String newConfirmed = "";
  private String totalConfirmed = "";
  private String newDeaths = "";
  private String totalDeaths = "";
  private String newRecovered = "";
  private String totalRecovered = "";
  private String date= "";
  
  public String getCountryName() {
    return countryName;
  }
  

  
  @Override
  public String toString() {
    return "Results:" + '\n' +
      "Country Name = " + countryName + '\n' +
      "New Confirmed = " + newConfirmed + '\n' +
      "Total Confirmed = " + totalConfirmed + '\n' +
      "New Deaths = " + newDeaths + '\n' +
      "Total Deaths = " + totalDeaths + '\n' +
      "Newly Recovered = " + newRecovered + '\n' +
      "Total Recovered = " + totalRecovered + '\n' +
      "Date = " + date;
  }
  
  public ResultDisplay(String country) throws JsonProcessingException {
    CovidGet covidResults = new CovidGet();
    LinkedHashMap<String, Object> results = covidResults.getInfo(country);
    if(results == null) {
      return;
    }
    this.countryName = results.get("Country").toString();
    this.newConfirmed = results.get("NewConfirmed").toString();
    this.totalConfirmed = results.get("TotalConfirmed").toString();
    this.newDeaths = results.get("NewDeaths").toString();
    this.totalDeaths = results.get("TotalDeaths").toString();
    this.newRecovered = results.get("NewRecovered").toString();
    this.totalRecovered = results.get("TotalRecovered").toString();
    this.date = results.get("Date").toString();

    
  }

}
