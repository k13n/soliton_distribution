package com.k13n.soliton;

public class App {
  private static int DEFAULT_NR_BLOCKS = 10000;
  private static double DEFAULT_FAILURE_PROBABILITY = 0.05;

  public static void main(String[] args) {
    SolitonGenerator srng = fixedSpikeExample();

    HistogramSampler sampler = new HistogramSampler(srng);
    int nrTrials = 10000;
    sampler.printHistogram(nrTrials);
  }

  public static SolitonGenerator fixedSpikeExample() {
    int nrBlocks = DEFAULT_NR_BLOCKS;
    double failureProbability = DEFAULT_FAILURE_PROBABILITY;
    int spike = 30;
    return new RobustSolitonGenerator(nrBlocks, spike, failureProbability);
  }

  public static SolitonGenerator paperExample() {
    int nrBlocks = DEFAULT_NR_BLOCKS;
    double failureProbability = DEFAULT_FAILURE_PROBABILITY;
    double c = 0.2;
    return new RobustSolitonGenerator(nrBlocks, c, failureProbability);
  }

  public static SolitonGenerator idealSolitonExample() {
    int nrBlocks = DEFAULT_NR_BLOCKS;
    return new IdealSolitonGenerator(nrBlocks);
  }

}
