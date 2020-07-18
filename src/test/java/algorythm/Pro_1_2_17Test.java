package algorythm;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import algorythm.Pro_1_2_17.StrongRational;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Pro_1_2_17Test {

  @Test
  @DisplayName("overflow 테스트")
  void test1() {
    var rationalA = new StrongRational(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2);
    var rationalB = new StrongRational(Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 3);

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
