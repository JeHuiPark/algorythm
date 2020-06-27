package algorythm;

import edu.princeton.cs.algs4.StdDraw;

/**
 * 세지윅 알고리즘 120 페이지
 * 1.2.10 문제
 *
 * 증가와 감소를 모두 지원하는 VisualCounter 클래스를 작성하라. 생성자에서는
 * 두 개의 인수 N (최대 작업 횟수) 과 max (카운터가 가질 수 있는 최댓값) 를
 * 넘겨받게 한다. 그리고 카운터의 값이 바뀔 때마다 그래프를 그리도록 한다.
 */
class Pro_1_2_10 {

  private static class VisualCounter {
    private final LimitedCounter limitedCounter;

    VisualCounter(int handleLimit, int maximumCount) {
      limitedCounter = new LimitedCounter(handleLimit, maximumCount);
      StdDraw.setXscale(0, handleLimit);
      StdDraw.setYscale(-maximumCount, maximumCount);
      StdDraw.setPenRadius(.01);
    }

    void increment() {
      limitedCounter.increment();
      drawing();
    }

    void decrement() {
      limitedCounter.decrement();
      drawing();
    }

    private void drawing() {
      StdDraw.point(limitedCounter.handleCount, limitedCounter.count);
    }

    public static void main(String[] args) {
      var visualCounter = new VisualCounter(100, 100);

      for (int i = 0; i < 100; i++) {
        if (Math.random() > .5) {
          visualCounter.increment();
        } else {
          visualCounter.decrement();
        }
      }
    }
  }

  private static class LimitedCounter {
    private final int handleLimit;
    private final int maximumCount;
    private int handleCount;
    int count;

    LimitedCounter(int handleLimit, int maximumCount) {
      this.handleLimit = handleLimit;
      this.maximumCount = maximumCount;
    }

    void increment() {
      if (++count > maximumCount) {
        throw new IllegalStateException();
      }
      accumulateHandleCount();
    }

    void decrement() {
      count--;
      accumulateHandleCount();
    }

    private void accumulateHandleCount() {
      if (++handleCount > handleLimit) {
        throw new IllegalStateException();
      }
    }
  }
}
