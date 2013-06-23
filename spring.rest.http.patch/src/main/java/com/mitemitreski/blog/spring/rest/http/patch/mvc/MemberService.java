package com.mitemitreski.blog.spring.rest.http.patch.mvc;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import com.mitemitreski.blog.spring.rest.http.patch.domain.Member;

@Component
public class MemberService {

  private Map<Integer,Member> memberCollection = new HashMap<Integer, Member>();

  @PostConstruct
  private void init() {
    memberCollection.put(0,new Member("John Doe", "jd@example.com", "awesome it is"));
    memberCollection.put(1,new Member("That Guy", "tg@example.com", "this is it"));
    memberCollection.put(2,new Member("Dr. Who", "who@example.com", "It's the doctor."));
  }

  public Collection<Member> getAll() {
    return memberCollection.values();
  }

  public Member findById(Integer id) {
    return memberCollection.get(id);
  }

  public Member add(Member member) {
    memberCollection.put(memberCollection.size(), member);
    return member;
  }

  public Member update(Integer id, Member member) {
    memberCollection.put(id, member);
    return member;
  }

  /**
   * Simplified patch scenario done "manually"
   * 
   * @return updated object
   */
  public Member patch(Integer id, Member newMember) {
    Member oldMember = memberCollection.get(id);

    if(newMember.getEmail() !=null){
      oldMember.setEmail(newMember.getEmail());
    }

    if(newMember.getInfo() !=null){
      oldMember.setInfo(newMember.getInfo());
    }

    if(newMember.getName() !=null){
      oldMember.setName(newMember.getEmail());
    }

    return newMember;
  }

  public Member delete(Integer id) {
    return memberCollection.remove(id);
  }

  public boolean exists(Integer id) {
    return memberCollection.containsKey(id);
  }

  // alternative way of copying values
  public void copyValues(Member source, Member target, Iterable<String> properties) {
    BeanWrapper src = new BeanWrapperImpl(source);
    BeanWrapper trg = new BeanWrapperImpl(target);

    for(String propertyName : properties){
      trg.setPropertyValue(propertyName,src.getPropertyValue(propertyName)
      );
    }

  }
}

