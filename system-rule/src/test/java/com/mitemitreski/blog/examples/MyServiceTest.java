package com.mitemitreski.blog.examples;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mite on 1/7/14.
 */
public class MyServiceTest {

  @Test
  public void should_read_data() {
    MyService service = new MyService();
    System.setProperty(MyService.KEY, "2");

    long data = service.readData();

    Assert.assertEquals(data, 2l);
  }

}
