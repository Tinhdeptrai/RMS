package com.ptit.rms.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AppController {

  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  public void home(HttpServletResponse res) {
    try {
      res.sendRedirect("swagger-ui.html");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}