package com.k13n.soliton;

import java.util.Random;

public class IdealSolitonGenerator implements SolitonGenerator {
  private Random random;
  private int k;

  public IdealSolitonGenerator(int k, long seed) {
    this.k = k;
    random = new Random(seed);
  }

  public IdealSolitonGenerator(int k) {
    this(k, new Random().nextLong());
  }

  public int next() {
    double v = 1 - random.nextDouble();
    if (v <= (1.0 / k))
      return 1;
    else
      return binarySearch(v, 2, k);
  }

  private int binarySearch(double v, int min, int max) {
    while (min <= max) {
      int mid = (min + max) / 2;
      if ((1.0 / mid) < v && v <= (1.0 / (mid-1)))
        return mid;
      else if (v <= 1.0 / mid)
        min = mid + 1;
      else
        max = mid - 1;
    }
    throw new AssertionError();
  }

}
