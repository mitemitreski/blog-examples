package com.mitemitreski.blog.spring.rest.http.patch.mvc;

import java.util.Collection;

import com.mitemitreski.blog.spring.rest.http.patch.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping(value= "/rest/members", produces = MediaType.APPLICATION_JSON_VALUE)
public class MemberRestController {

  private MemberService memberService;

  @Autowired
  public MemberRestController(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody
  Collection<Member> listAllMembers() {
    return memberService.getAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Member lookupMemberById(@PathVariable("id") Integer id) {
    return memberService.findById(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(OK)
  public void addMember(Member member) {
    memberService.add(member);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  @ResponseStatus(OK)
  public void updateMemberName(@PathVariable("id") Integer id, Member member) {
    memberService.update(id, member);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
  @ResponseStatus(OK)
  public Member patchMember(@PathVariable("id") Integer id, Member member) {
    return memberService.patch(id, member);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(OK)
  public Member deleteMember(@PathVariable("id") Integer id) {
    return memberService.delete(id);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
  @ResponseStatus(HttpStatus.OK)
  public void exsistsMember(@PathVariable("id") Integer id) {
    if(memberService.exists(id)){
      return;
    }
    throw new RuntimeException("Missing resource with id " + id);
  }

}
