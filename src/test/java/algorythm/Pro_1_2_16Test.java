package algorythm;

import static algorythm.Pro_1_2_16.Rational;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

@SuppressWarnings("InnerClassMayBeStatic")
class Pro_1_2_16Test {

  @Nested
  @DisplayName("Rational 은")
  class Describe_Rational {

    @RepeatedTest(10)
    @DisplayName("분자와 분모가 항상 약분된 상태를 유지해야 한다. ")
    void test1() {
      int given_numerator = new Random().nextInt(100) + 1;
      int given_denominator = new Random().nextInt(100) + 1;
      int given_times1 = new Random().nextInt(100) + 1;
      int given_times2 = new Random().nextInt(100) + 1;

      var rational1 = new Rational(
          given_numerator * given_times1,
          given_denominator * given_times1);

      var rational2 = new Rational(
          given_numerator * given_times2,
          given_denominator * given_times2);

      assertAll(
          () -> assertEquals(rational1.getNumerator(), rational2.getNumerator()),
          () -> assertEquals(rational1.getDenominator(), rational2.getDenominator())
      );
    }
  }

  @Nested
  @DisplayName("plus 는")
  class Describe_plus {

    Rational givenRandomRational() {
      int given_numerator = new Random().nextInt(100) + 1;
      int given_denominator = new Random().nextInt(100) + 1;
      return new Rational(given_numerator, given_denominator);
    }

    @RepeatedTest(10)
    @DisplayName("this 와 b 를 더한 결과를 리턴한다.")
    void test2() {
      var a = givenRandomRational();
      var b = givenRandomRational();
      var testHelper = new TestHelper(a, b);

      var actual = a.plus(b);
      assertEquals(testHelper.expectedPlus(), actual);
    }
  }

  /**
   * 테스트 검증 도우미 클래스.
   */
  static class TestHelper {
    private final Rational a;
    private final Rational b;

    TestHelper(Rational a, Rational b) {
      this.a = a;
      this.b = b;
    }

    Rational expectedPlus() {
      long aNumerator = a.getNumerator();
      long bNumerator = b.getNumerator();
      long aDenominator = a.getDenominator();
      long bDenominator = b.getDenominator();

      long calcDenominator = aDenominator * bDenominator;
      long calcNumerator = (aNumerator * bDenominator) + (bNumerator * aDenominator);
      return new Rational(calcNumerator, calcDenominator);
    }

  }
}
