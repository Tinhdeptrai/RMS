package com.ptit.rms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ptit.rms.model.User;
import com.ptit.rms.service.BreadcrumbsBuilderService;
import com.ptit.rms.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("roles")
public class UserController extends BaseController {

  @Autowired
  UserService userService;

  @Autowired
  BreadcrumbsBuilderService breadcrumbBuilderService;

  /**
   * This method will list all existing users.
   */
  @RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
  public String listUsers(ModelMap model) {
    List<User> users = this.userService.findAllUsers();
    model.addAttribute("users", users);
    model.addAttribute("loggedinuser", this.getPrincipal());
    model.addAttribute("breadcrumbs", this.breadcrumbBuilderService.getUserBreadcrumb());
    return "users";
  }

  @RequestMapping(value = { "/edit-users" }, method = RequestMethod.GET)
  public String editUsers(ModelMap model) {
    List<User> users = this.userService.findAllUsers();
    model.addAttribute("users", users);
    model.addAttribute("breadcrumbs", this.breadcrumbBuilderService.getUserBreadcrumb());
    model.addAttribute("roles", this.userService.getRoles());
    model.addAttribute("loggedinuser", getPrincipal());
    return "editUsers";
  }
}
