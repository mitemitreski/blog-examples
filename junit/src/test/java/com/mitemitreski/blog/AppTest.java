package com.mitemitreski.blog;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;

/**
 * Super awesome tests.
 */
@RunWith(Parameterized.class)
public class AppTest {

  private RationalNumber input;
  private BigDecimal expected;

  public AppTest(RationalNumber input, BigDecimal expected) {
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters(name = "{index}: number[{0}]= {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new RationalNumber(1, 2), new BigDecimal("0.50000")},
        {new RationalNumber(1, 1), new BigDecimal("1.00000")},
        {new RationalNumber(1, 3), new BigDecimal("0.33333")},
        {new RationalNumber(1, 5), new BigDecimal("0.20000")},
        {new RationalNumber(10000000, 3), new BigDecimal("3333333.33333")}
    });
  }

  @Test
  public void testApp() {
    //given the test data
    //when
    BigDecimal out = App.convert(input);
    //then
    Assert.assertThat(out, is(equalTo(expected)));
  }

}
