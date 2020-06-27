package algorythm;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.List;

/**
 * 세지윅 알고리즘 119 페이지
 * 1.2.1 문제
 *
 * 명령어 인수로 정수 N을 입력 받아 N개의 랜덤 좌표를 1X1 사각형 영역 안에 생성하는
 * Point2D 클라이언트 프로그램을작성하라. 그리고 가장 가까이 있는 두 점의 거리를 계산하라.
 */
class Pro_1_2_1 {

  public static void main(String[] args) {
    int n = argumentParse(args);

    List<Point2D> points = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      points.add(new Point2D(Math.random(), Math.random()));
    }
    var solution = new Solution();
    var minimumDistance = solution.minimumDistance(points.toArray(new Point2D[]{}));

    StdOut.printf("가장 가까이 있는 두 점의 거리 = %f", minimumDistance);
  }

  private static int argumentParse(String[] args) {
    if (args.length == 0) {
      throw new IllegalArgumentException();
    }
    try {
      var n = Integer.parseInt(args[0]);
      if (n < 2) {
        throw new IllegalArgumentException("n > 2");
      }
      return n;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException();
    }
  }

  private static class Solution {

    double minimumDistance(Point2D[] points) {
      double min = 2;
      for (int i = 0; i < points.length; i++) {
        var p1 = points[i];
        for (int j = i + 1; j < points.length; j++) {
          var p2 = points[j];
          min = Math.min(min, p1.distanceSquaredTo(p2));
        }
      }
      return min;
    }
  }
}
