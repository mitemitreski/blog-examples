package com.mitemitreski.blog;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SomeTest {

  @Rule
  public MyTestRule folder = new MyTestRule();

  @Test
  public void testA()  {
    System.out.println("A");
  }

  @Test
  public void testB()  {
    System.out.println("B");
  }
}
