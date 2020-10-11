package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.io.Console;

public class SwapBits {
    @EpiTest(testDataFile = "swap_bits.tsv")
    public static long swapBits(long x, int i, int j) {
        long bitSet1 = (x >>> i) & 1;
        long bitSet2 = (x >>> j) & 1;
        if (bitSet1 != bitSet2) {
          long mask = 1L << i | 1L << j;
          x ^= mask;
        }
        return x;
    }

    public static void main(String[] args) {
      System.exit(
        GenericTest
            .runFromAnnotations(args, "SwapBits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
    }
}
