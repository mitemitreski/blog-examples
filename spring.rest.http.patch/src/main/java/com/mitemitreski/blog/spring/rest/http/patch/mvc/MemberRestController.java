package com.mitemitreski.blog.spring.rest.http.patch.mvc;

import java.util.Collection;

import com.mitemitreski.blog.spring.rest.http.patch.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value= "/rest/members", produces = MediaType.APPLICATION_JSON_VALUE)
public class MemberRestController {

  private MemberService memberService;

  @Autowired
  public MemberRestController(MemberService memberService) {
    super();
    this.memberService = memberService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody
  Collection<Member> listAllMembers() {
    return memberService.getAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public @ResponseBody
  Member lookupMemberById(@PathVariable("id") Integer id) {
    return memberService.findById(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public @ResponseBody
  Member addMember(Member member) {
   return memberService.add(member);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public @ResponseBody
  Member updateMember(@PathVariable("id") Integer id, Member member) {
    return memberService.update(id,member);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
  public @ResponseBody
  Member patchMember(@PathVariable("id") Integer id, Member member) {
    return memberService.patch(id, member);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public @ResponseBody
  Member deleteMember(@PathVariable("id") Integer id) {
    return memberService.delete(id);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
  public @ResponseBody
  String exsistsMember(@PathVariable("id") Integer id) {
    return "found";
  }

}
