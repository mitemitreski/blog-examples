package com.mitemitreski.blog.spring.rest.http.patch.domain;

import java.io.Serializable;


public class Member implements Serializable {

  /** Comment for <code>serialVersionUID</code>. */
  private static final long serialVersionUID = -8471654782015886485L;

  private String name;

  private String email;

  private String info;


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public String getInfo() {
    return info;
  }


  public void setInfo(String info) {
    this.info = info;
  }


}
