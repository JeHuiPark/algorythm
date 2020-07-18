package algorythm;

import algorythm.Pro_1_2_16.Rational;
import java.util.Objects;

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
      throw new UnsupportedOperationException();
    }

    StrongRational minus(StrongRational b) {
      throw new UnsupportedOperationException();
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
