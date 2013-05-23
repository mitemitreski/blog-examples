package com.mitemitreski.blog.spring.rest.http.patch.domain;

import java.io.Serializable;

/**
 * Some bean.
 */
public class Member  implements Serializable {

  /** Comment for <code>serialVersionUID</code>. */
  private static final long serialVersionUID = -8471654782015886485L;

  private String name;
  private String email;
  private String info;

  public Member(String name, String email, String info) {
    super();
    this.name = name;
    this.email = email;
    this.info = info;
  }

  public Member() {
    super();
  }

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
