package tests;

import Logic.ResultDisplay;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultDisplayTest {
  ResultDisplay display;
  
  @BeforeEach
  void setUp() throws JsonProcessingException {
    display = new ResultDisplay("united-states");
  }
  
  @AfterEach
  void tearDown() {
  }
  
  @Test
  void testToString() {
    if(display.getCountryName().equals("")) {
      return;
    }
    System.out.println(display.toString());
  }
}