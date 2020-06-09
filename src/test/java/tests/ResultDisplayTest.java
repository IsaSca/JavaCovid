package tests;

import Logic.CovidGet;
import Logic.ResultDisplay;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

class ResultDisplayTest {
  ResultDisplay display;
  ResultDisplay displayHelp;
  ResultDisplay displayWrong;
  CovidGet covidGet = new CovidGet();
  String results = covidGet.getAllInfo();
  
  @BeforeEach
  void setUp() throws JsonProcessingException {

    display = new ResultDisplay(results, "GB");
    displayHelp = new ResultDisplay(results, "help");
    displayWrong = new ResultDisplay(results, "wrong");
  }
  
  @AfterEach
  void tearDown() {
  }
  
  @Test
  void testToString() {
    System.out.println(display.toString());
  }
}