package com.mitemitreski.blog.examples;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ProvideSystemProperty;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by mite on 2/18/14.
 */
public class OutputStreamTest {
  @Rule
  public final StandardOutputStreamLog log = new StandardOutputStreamLog();
  @Rule
  public final ProvideSystemProperty myPropertyHasMyValue = new ProvideSystemProperty(MyService.KEY, "4");

  @Test
  public void check_output_stream() {
    MyService myService = new MyService();

    myService.shouldIEvenReadDataLikeThis();

    assertThat(log.getLog(), is(equalTo("The data is 2")));

  }


}
