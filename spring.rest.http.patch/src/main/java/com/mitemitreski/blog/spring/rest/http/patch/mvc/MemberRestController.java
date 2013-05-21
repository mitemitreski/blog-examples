package com.mitemitreski.blog.spring.rest.http.patch.mvc;

import java.util.List;

import com.mitemitreski.blog.spring.rest.http.patch.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/members")
public class MemberRestController {

  private List<Member> memberCollection;

  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody
  List<Member> listAllMembers() {
    return memberCollection;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody
  Member lookupMemberById(@PathVariable("id") Long id) {
    return memberCollection.get(0);
  }
}
