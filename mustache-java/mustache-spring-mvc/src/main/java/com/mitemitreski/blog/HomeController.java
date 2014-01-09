package com.mitemitreski.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.*;

/**
 * Hello Mustache.
 */
@Controller
public class HomeController {

  private static final Logger logger = LoggerFactory
      .getLogger(HomeController.class);


  /**
   * Simple controller that redirects to home and adds map and date objects.
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {

    Properties properties = System.getProperties();

    Map<String, String> map = new HashMap<String, String>((Map) properties);
    String formattedDate = currentTime(locale);
    model.addAttribute("serverTime", formattedDate);
    model.addAttribute("props", map.entrySet());
    return "home";
  }



  private String currentTime(Locale locale) {
    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
        DateFormat.LONG, locale);
    return dateFormat.format(date);
  }
}
