package com.k13n.soliton;

import java.util.Random;

public class RobustSolitonGenerator implements SolitonGenerator {
  private Random random;
  private int k, M;
  private double c, delta, R, beta;

  public RobustSolitonGenerator(int k, double c, double delta, long seed) {
    this.k = k;
    this.c = c;
    this.delta = delta;
    random = new Random(seed);
    R = computeR();
    M = computeM();
    beta = computeBeta();
  }

  public RobustSolitonGenerator(int k, double c, double delta) {
    this(k, c, delta, new Random().nextLong());
  }

  private double computeR() {
    return c * Math.log(k / delta) * Math.sqrt(k);
  }

  private int computeM() {
    return (int) Math.floor(k / R);
  }


  public RobustSolitonGenerator(int k, int M, double delta, long seed) {
    this.k = k;
    this.M = M;
    this.delta = delta;
    random = new Random(seed);
    R = k / ((double) M);
    beta = computeBeta();
  }

  public RobustSolitonGenerator(int k, int M, double delta) {
    this(k, M, delta, new Random().nextLong());
  }


  private double computeBeta() {
    double sum = 0;
    for (int i = 1; i <= k; i++)
      sum += idealSoliton(i) + unnormalizedRobustSoliton(i);
    return sum;
  }

  @Override
  public int next() {
    double u = random.nextDouble();
    return inverseTransformSampling(u);
  }

  private int inverseTransformSampling(double u) {
     double sum = 0;
     int index = 1;
     while (sum <= u)
       sum += normalizedRobustSoliton(index++);
     return index - 1;
  }

  private double normalizedRobustSoliton(int i) {
    return (idealSoliton(i) + unnormalizedRobustSoliton(i)) / beta;
  }

  private double unnormalizedRobustSoliton(int i) {
    if (1 <= i && i <= M-1)
      return 1.0 / (i*M);
    else if (i == M)
      return Math.log(R / delta) / M;
    else
      return 0;
  }

  private double idealSoliton(int i) {
    if (i == 1)
      return 1.0 / k;
    else
      return 1.0 / (i * (i-1));
  }

}
