package com.mitemitreski.blog;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Awesome App!
 */
public class App {

  /**
   * THE Logic
   *
   * @param number some rational number
   * @return BigDecimal rounded to 5 decimal points
   */
  public static BigDecimal convert(RationalNumber number) {
    BigDecimal numerator = new BigDecimal(number.getNumerator()).
        setScale(5, RoundingMode.HALF_UP);

    BigDecimal result = numerator.divide(
        new BigDecimal(number.getDenominator()),
        RoundingMode.HALF_UP);

    return result;
  }
}
