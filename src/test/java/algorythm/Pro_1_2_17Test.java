package algorythm;

import static algorythm.Pro_1_2_16.Rational.gcd;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import algorythm.Pro_1_2_17.StrongRational;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
