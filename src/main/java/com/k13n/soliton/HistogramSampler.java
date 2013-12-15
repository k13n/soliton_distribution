package com.k13n.soliton;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class HistogramSampler {
  private SolitonGenerator srng;
  private Map<Integer, Integer> histogram;

  public HistogramSampler(SolitonGenerator srng) {
    this.srng = srng;
  }

  public void printHistogram(int nrTrials) {
    Map<Integer, Integer> histogram = sampleHistogram(nrTrials);
    for (Map.Entry<Integer, Integer> entry : histogram.entrySet())
      System.out.printf("%6d %6d%n", entry.getKey(), entry.getValue());
  }

  public Map<Integer, Integer> sampleHistogram(int nrTrials) {
    histogram = new TreeMap<>();
    for (int i = 0; i < nrTrials; i++)
      increaseOccurrences(srng.next());
    return Collections.unmodifiableMap(histogram);
  }

  private void increaseOccurrences(Integer key) {
    if (histogram.containsKey(key))
      histogram.put(key, 1 + histogram.get(key));
    else
      histogram.put(key, 1);
  }

}
