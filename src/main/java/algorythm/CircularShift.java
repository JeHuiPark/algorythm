package algorythm;

/**
 * 세지윅 알고리즘 119 페이지
 * 어떤 문자열 s 가 다른 문자열 a 를 원형 순환한(위치를 몇 번 순환하든 상관없이) 결과와 같을 때
 * 문자열 S 를 문자열 a 의 원형 시프트라고 한다. 예를 들어 ACTGACG 와 TGACGAC 는 서로 원형 시프트 관계이다.
 * 문자열 두 개가 주어졌을 때 둘이 원형 시프트 관계인지 찾는 프로그램을 작성하라.
 *
 * 힌트: indexOf(), length() 그리고 문자열 병합을 이용하면 한 줄로 작성할 수 있다.
 */
class CircularShift {

  public static void main(String[] args) {
    var solution = new Solution();
    var a = "ACTGACG";
    var b = "TGACGAC";

    boolean result = solution.isCircularShift(a, b);
    if (!result) {
      throw new AssertionError();
    }
  }

  static class Solution {

    boolean isCircularShift(String a, String b) {
      if (a.length() != b.length()) {
        return false;
      }
      int c = 0;
      while(c++ < a.length()) {
        if ((a = a.substring(1).concat(a.substring(0, 1))).equals(b)) {
          return true;
        }
      }
      return false;
    }
  }
}
