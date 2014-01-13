package soliton;

import org.junit.Test;

public class RobustSolitonGeneratorTest {
  private static int DEFAULT_NR_BLOCKS = 1000;
  private static double DEFAULT_FAILURE_PROBABILITY = 0.05;
  private static double DEFAULT_CONSTANT_C = 0.2;

  @Test(expected = IllegalArgumentException.class)
  public void ensureThatNumberOfBlocksIsStrictlyPositve() {
    new RobustSolitonGenerator(0, DEFAULT_CONSTANT_C,
        DEFAULT_FAILURE_PROBABILITY);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ensureThatConstantCisStrictlyPositive() {
    new RobustSolitonGenerator(DEFAULT_NR_BLOCKS, 0.0,
        DEFAULT_FAILURE_PROBABILITY);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ensureThatFailureProbabilityIsPositive() {
    new RobustSolitonGenerator(DEFAULT_NR_BLOCKS, DEFAULT_CONSTANT_C, -0.1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ensureThatFailureProbabilityIsLessThanOrEqualToOne() {
    new RobustSolitonGenerator(DEFAULT_NR_BLOCKS, DEFAULT_CONSTANT_C, 1.01);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ensureThatSpikeIsStrictlyPositive() {
    new RobustSolitonGenerator(DEFAULT_NR_BLOCKS, 0,
        DEFAULT_FAILURE_PROBABILITY);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ensureThatSpikeIsLessThanTheNrOfBlocks() {
    new RobustSolitonGenerator(DEFAULT_NR_BLOCKS, DEFAULT_NR_BLOCKS + 1,
        DEFAULT_FAILURE_PROBABILITY);
  }

}
