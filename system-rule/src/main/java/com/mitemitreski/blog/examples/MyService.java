package com.mitemitreski.blog.examples;

/**
 * Test service.
 */
public class MyService {

  public static final String KEY = "myKey";

  public void shouldIEvenReadDataLikeThis() {
    System.out.printf("The data is %s",readData() / 2);
  }

  public long readData() {
    return Long.valueOf(System.getProperty(KEY));
  }

}
