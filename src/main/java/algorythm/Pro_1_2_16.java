package algorythm;

import java.util.Objects;

/**
 * 유리수에 대한 덧셈, 뺄셈, 곱셈, 나눗셈을 지원하는 불변 데이터 타입 Rational 을 구현하라.
 *
 * Rational(int numerator, int denominator) 분자, 분모
 * Rational plus(Rational b) 이 값과 b의 합
 * Rational minus(Rational b) 이 값과 b의 차이
 * Rational times(Rational b) 이 값과 b의 곱
 * Rational divideBy(Rational b) 이 값을 b로 나눈 몫
 * Rational equals(Rational that) 동치성
 * String toString() 문자열 표현
 *
 * 오버플로 발생에 대해서는 걱정하지 않아도 된다 (연습문제 1.2.17 참조)
 * 대신 분자, 분모는 long 타입을 사용하도록 한다.
 * 분자와 분모가 항상 약분된 상태로 유지되도록 유클리드 알고리즘을 적용한다.
 *
 * 마지막으로 모든 메서드에 대해서 테스트 클라이언트를 작성한다.
 */
class Pro_1_2_16 {

  static class Rational {
    private final long numerator;
    private final long denominator;

    /**
     * 유리수 생성자.
     * @param integer 정수
     */
    Rational(long integer) {
      this.numerator = integer;
      this.denominator = 1;
    }

    /**
     * 유리수 생성자.
     * @param numerator 분자
     * @param denominator 분모
     */
    Rational(long numerator, long denominator) {
      long gcd = gcd(numerator, denominator);
      this.numerator = numerator / gcd;
      this.denominator = denominator / gcd;
    }

    /**
     * this + b 의 결과를 리턴한다.
     */
    Rational plus(Rational b) {
      if (this.denominator == b.denominator) {
        return new Rational(this.numerator + b.numerator, denominator);
      }
      long lcm = lcm(this.denominator, b.denominator);
      return new Rational(
          (this.numerator * (lcm / this.denominator)) + (b.numerator * (lcm / b.denominator)),
          lcm
      );
    }

    /**
     * this - b 의 결과를 리턴한다.
     */
    Rational minus(Rational b) {
      if (this.denominator == b.denominator) {
        return new Rational(this.numerator - b.numerator, denominator);
      }
      long lcm = lcm(this.denominator, b.denominator);
      return new Rational(
          (this.numerator * (lcm / this.denominator)) - (b.numerator * (lcm / b.denominator)),
          lcm
      );
    }

    /**
     * this * b 의 결과를 리턴한다.
     */
    Rational times(Rational b) {
      return new Rational(
          this.numerator * b.numerator,
          this.denominator * this.denominator
      );
    }

    /**
     * this / b 의 결과를 리턴한다.
     */
    Rational divideBy(Rational b) {
      throw new UnsupportedOperationException();
    }

    /**
     * this 와 b 의 동치성 결과를 리턴한다.
     */
    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Rational rational = (Rational) o;
      return getNumerator() == rational.getNumerator() &&
          getDenominator() == rational.getDenominator();
    }

    @Override
    public int hashCode() {
      return Objects.hash(getNumerator(), getDenominator());
    }

    @Override
    public String toString() {
      return numerator + "/" + denominator;
    }

    long getNumerator() {
      return numerator;
    }

    long getDenominator() {
      return denominator;
    }

    /**
     * a 와 b의 최대 공약수를 리턴한다.
     *
     * https://ko.wikipedia.org/wiki/%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C_%ED%98%B8%EC%A0%9C%EB%B2%95
     */
    static long gcd(long a, long b) {
      if (b == 0) {
        return a;
      }
      return gcd(b, a%b);
    }

    /**
     * a 와 b 의 최소 공배수를 리턴한다.
     */
    static long lcm(long a, long b) {
      return (a * b) / gcd(a,b);
    }
  }

}
