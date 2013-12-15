package com.k13n.soliton;

import java.util.Random;

public class IdealSolitonGenerator implements SolitonGenerator {
  private Random random;
  private int nrBlocks;

  public IdealSolitonGenerator(int nrBlocks, long seed) {
    if (nrBlocks <= 0)
      throw new IllegalArgumentException(
          "number of blocks must be strictly positive");
    this.nrBlocks = nrBlocks;
    random = new Random(seed);
  }

  public IdealSolitonGenerator(int nrBlocks) {
    this(nrBlocks, new Random().nextLong());
  }

  public int next() {
    double v = 1 - random.nextDouble();
    if (v <= (1.0 / nrBlocks))
      return 1;
    else
      return binarySearch(v, 2, nrBlocks);
  }

  private int binarySearch(double v, int min, int max) {
    while (min <= max) {
      int mid = (min + max) / 2;
      if ((1.0 / mid) < v && v <= (1.0 / (mid - 1)))
        return mid;
      else if (v <= 1.0 / mid)
        min = mid + 1;
      else
        max = mid - 1;
    }
    throw new AssertionError();
  }

}
