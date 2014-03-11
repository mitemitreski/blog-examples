package com.mitemitreski.blog.examples;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ProvideSystemProperty;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by mite on 2/18/14.
 */
public class PropertiesTest {

  @Rule
  public final ProvideSystemProperty myPropertyHasMyValue = new ProvideSystemProperty("blip", "blop");

  @Test
  public void overrideProperty() {
    assertThat(System.getProperty("blip"), is(equalTo("blop")));
  }

}
