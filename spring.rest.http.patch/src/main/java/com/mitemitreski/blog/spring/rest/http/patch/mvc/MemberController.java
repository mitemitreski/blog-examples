package com.mitemitreski.blog.spring.rest.http.patch.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mitemitreski.blog.spring.rest.http.patch.domain.Member;

@Controller
@RequestMapping(value = "/")
public class MemberController {


  @RequestMapping(method = RequestMethod.GET)
  public String displaySortedMembers(Model model) {
    model.addAttribute("newMember", new Member());
    return "index";
  }

}
