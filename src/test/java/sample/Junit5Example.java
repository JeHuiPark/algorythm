package sample;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Junit5Example {

  @ParameterizedTest
  @CsvSource({
      "1,2,3,4,5"
  })
  void test(String col1, String col2, String col3, String col4, String col5) {
    System.out.println(
        "col1 = " + col1 + ", col2 = " + col2 + ", col3 = " + col3 + ", col4 = " + col4 +
            ", col5 = " + col5);
  }
}
