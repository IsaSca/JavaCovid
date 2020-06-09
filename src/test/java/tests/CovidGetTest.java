package tests;

import Logic.CovidGet;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CovidGetTest {
  
  CovidGet covidGet = new CovidGet();
  String results = covidGet.getAllInfo();
  
  @org.junit.jupiter.api.BeforeEach
  void setUp() {
  }
  
  @org.junit.jupiter.api.AfterEach
  void tearDown() {
  }
  
  @Test
  public void test() throws IOException {
    System.out.println(covidGet.getInfo(results, "United Kingdom"));
  }
}