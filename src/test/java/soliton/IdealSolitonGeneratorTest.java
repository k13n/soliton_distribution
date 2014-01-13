package soliton;

import org.junit.Test;

public class IdealSolitonGeneratorTest {

  @Test(expected = IllegalArgumentException.class)
  public void ensureThatNumberOfBlocksIsStrictlyPositve() {
    new IdealSolitonGenerator(0);
  }

}
