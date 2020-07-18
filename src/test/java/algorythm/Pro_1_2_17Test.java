package algorythm;

import static algorythm.Pro_1_2_16.Rational.gcd;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import algorythm.Pro_1_2_16.Rational;
import algorythm.Pro_1_2_17.StrongRational;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

@SuppressWarnings("InnerClassMayBeStatic")
class Pro_1_2_17Test {

  @Test
  @DisplayName("overflow 테스트")
  void test1() {
    var rationalA = new StrongRational(Integer.MAX_VALUE - 2, Integer.MAX_VALUE);
    var rationalB = new StrongRational(Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1);

    assertEquals(
        1,
        gcd(rationalA.getNumerator(), rationalB.getDenominator()),
        "overflow 테스트를 위한 사전조건을 만족하지 못합니다.");

    assertEquals(
        1,
        gcd(rationalA.getDenominator(), rationalB.getNumerator()),
        "overflow 테스트를 위한 사전조건을 만족하지 못합니다.");

    assertAll(
        () -> assertThrows(
            AssertionError.class,
            () -> rationalA.plus(rationalB)),
        () -> assertThrows(
            AssertionError.class,
            () -> rationalA.minus(rationalB)),
        () -> assertThrows(
            AssertionError.class,
            () -> rationalA.times(rationalB)),
        () -> assertThrows(
            AssertionError.class,
            () -> rationalA.divideBy(rationalB))
    );
  }

  @Nested
  @DisplayName("강건한 유리수의 계산 결과는")
  class Describe_all {

    Rational givenRandomRational() {
      int given_numerator = new Random().nextInt(100) + 1;
      int given_denominator = new Random().nextInt(100) + 1;
      return new Rational(given_numerator, given_denominator);
    }

    @Nested
    @DisplayName("overflow 케이스를 제외 하고는")
    class Context_case1 {

      @RepeatedTest(1000)
      @DisplayName("Rational 클래스와 동일하다")
      void test2() {
        var rationalA = givenRandomRational();
        var rationalB = givenRandomRational();

        assertAll(
            () -> assertEquals(
                StrongRational.of(rationalA.plus(rationalB)),
                StrongRational.of(rationalA).plus(StrongRational.of(rationalB))),
            () -> assertEquals(
                StrongRational.of(rationalA.minus(rationalB)),
                StrongRational.of(rationalA).minus(StrongRational.of(rationalB))),
            () -> assertEquals(
                StrongRational.of(rationalA.times(rationalB)),
                StrongRational.of(rationalA).times(StrongRational.of(rationalB))),
            () -> assertEquals(
                StrongRational.of(rationalA.divideBy(rationalB)),
                StrongRational.of(rationalA).divideBy(StrongRational.of(rationalB)))
        );
      }
    }
  }

}
