package com.mitemitreski.blog.spring.rest.http.patch.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class MemberController {

  @RequestMapping(method = RequestMethod.GET)
  public String displaySortedMembers() {
    return "index";
  }
}
