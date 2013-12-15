package com.k13n.soliton;

public class App {

  public static void main(String[] args) {
    int k = 50;
    double c = 0.05;
    double delta = 0.01;
    SolitonGenerator rng = new RobustSolitonGenerator(k, c, delta);

    HistogramSampler sampler = new HistogramSampler(rng);
    sampler.printHistogram(10000);
  }

}
