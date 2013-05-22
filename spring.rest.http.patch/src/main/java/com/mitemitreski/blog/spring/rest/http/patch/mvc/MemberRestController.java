package com.mitemitreski.blog.spring.rest.http.patch.mvc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.mitemitreski.blog.spring.rest.http.patch.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/members")
public class MemberRestController {

  private Map<Integer,Member> memberCollection = new HashMap<Integer, Member>();

  @PostConstruct
  private void init() {
    memberCollection.put(0,new Member("John Doe", "jd@example.com", "awesome it is"));
    memberCollection.put(1,new Member("That Guy", "tg@example.com", "this is it"));
    memberCollection.put(2,new Member("Dr. Who", "who@example.com", "It's the doctor."));
  }

  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody
  Collection<Member> listAllMembers() {
    return memberCollection.values();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody
  Member lookupMemberById(@PathVariable("id") Integer id) {
    return memberCollection.get(id);
  }
  
  @RequestMapping(method = RequestMethod.POST, produces = "application/json")
  public @ResponseBody
  Member addMember(Member member) {
    memberCollection.put(memberCollection.size(), member);
    return member;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
  public @ResponseBody
  Member updateMember(@PathVariable("id") Integer id, Member member) {
    memberCollection.put(id, member);
    return member;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, produces = "application/json")
  public @ResponseBody
  Member patchMember(@PathVariable("id") Integer id, Member member) {
    // do the patch
    return member;
  }
  
}
