package algorythm;

import static algorythm.Pro_1_2_16.Rational.lcm;

import algorythm.Pro_1_2_16.Rational;
import java.util.Objects;
import java.util.function.LongBinaryOperator;

/**
 * 강건한 유리수 구현.
 * 어서트를 이용해 Rational 의 구현이 오버플로 상태로 이용되는 상황이 발생하지 않도록 해보자.
 */
class Pro_1_2_17 {

  static class StrongRational {

    private final Rational rational;

    StrongRational(int numerator, int denominator) {
      this.rational = new Rational(numerator, denominator);
    }

    static StrongRational of(Rational rational) {
      return new StrongRational(rational.getNumerator(), rational.getDenominator());
    }

    StrongRational plus(StrongRational b) {
      commonDenominatorValidation(b, Long::sum);
      return StrongRational.of(rational.plus(b.rational));
    }

    StrongRational minus(StrongRational b) {
      commonDenominatorValidation(b, (_a, _b) -> _a - _b);
      return StrongRational.of(rational.minus(b.rational));
    }

    /**
     * 통분 후 연산(+,-) 작업에서 오버플로우가 발생하는지 검증한다.
     */
    private void commonDenominatorValidation(StrongRational b, LongBinaryOperator longBinaryOperator) {
      long commonDenominator = lcm(rational.getDenominator(), b.rational.getDenominator());
      assert Integer.MAX_VALUE >= commonDenominator
          && Integer.MIN_VALUE <= commonDenominator;

      long expectedNumeratorA =
          (commonDenominator / rational.getDenominator()) * (long) rational.getNumerator();
      long expectedNumeratorB =
          (commonDenominator / b.rational.getDenominator()) * (long) b.rational.getNumerator();
      long numerator = longBinaryOperator.applyAsLong(expectedNumeratorA, expectedNumeratorB);
      assert Integer.MAX_VALUE >= numerator
          && Integer.MIN_VALUE <= numerator;
    }

    StrongRational times(StrongRational b) {
      throw new UnsupportedOperationException();
    }

    StrongRational divideBy(StrongRational b) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      StrongRational that = (StrongRational) o;
      return Objects.equals(rational, that.rational);
    }

    @Override
    public int hashCode() {
      return Objects.hash(rational);
    }

    @Override
    public String toString() {
      return rational.toString();
    }
  }
}
