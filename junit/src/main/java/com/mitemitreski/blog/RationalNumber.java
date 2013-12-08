package com.mitemitreski.blog;


public class RationalNumber {

  private final long numerator;
  private final long denominator;

  public RationalNumber(long numerator, long denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public long getNumerator() {
    return numerator;
  }

  public long getDenominator() {
    return denominator;
  }

  @Override
  public String toString() {
    return String.format("%d/%d", numerator, denominator);
  }
}