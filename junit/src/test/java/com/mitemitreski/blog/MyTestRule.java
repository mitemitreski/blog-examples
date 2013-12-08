package com.mitemitreski.blog;


import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyTestRule implements TestRule {

  public class MyStatement extends Statement {

    private final Statement statement;

    public MyStatement(Statement statement) {
      this.statement = statement;
    }

    @Override
    public void evaluate() throws Throwable {
      System.out.println("before statement" );
      statement.evaluate();
      System.out.println("after statement");
    }

  }


  @Override
  public Statement apply(Statement statement, Description description) {
    System.out.println("apply rule");
    return new MyStatement(statement);
  }

}