package com.mitemitreski.blog;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TheRuleTest {

  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

  @Test
  public void countsAssets() throws IOException {
    //given
    final File tempFile = folder.newFile("thefile.txt");
    //when
    tempFile.setExecutable(true)  ;
    //then
    assertThat(tempFile.canExecute(), is(true));
  }
}
