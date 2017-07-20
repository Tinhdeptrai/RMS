package com.ptit.rms.controller.ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.rms.controller.BaseController;
import com.ptit.rms.model.Roles;
import com.ptit.rms.model.User;
import com.ptit.rms.service.UserService;
import com.ptit.rms.ultil.Constants;

@RestController
@RequestMapping("/user")
public class UserControllerAjax extends BaseController {

  @Autowired
  UserService userService;

  @RequestMapping(value = { "/check-username" }, method = RequestMethod.POST, produces = "application/json")
  @ResponseBody
  public boolean checkUsername(@RequestBody String str) {
    JSONObject jsonObject = new JSONObject(str);
    String username = jsonObject.getString(Constants.USERNAME);
    User user = this.userService.findByUsername(username);
    if (user == null) {
      return true;
    }
    return false;
  }

  @RequestMapping(value = { "/update-users" }, method = RequestMethod.POST, produces = "application/json")
  public String updateUser(@RequestBody String str) {
    User currentUser = this.userService.findByUsername(getPrincipal());

    List<User> listUserSave = new ArrayList<>();
    List<User> listUserEdit = new ArrayList<>();

    JSONArray jsonarray = new JSONArray(str);
    for (int i = 0; i < jsonarray.length(); i++) {

      JSONObject jsonobject = jsonarray.getJSONObject(i);

      String type = jsonobject.getString(Constants.TYPE);
      String id = jsonobject.getString(Constants.ID) != null ? jsonobject.getString(Constants.ID) : "";
      if (type.equals(Constants.TYPE_DELETE)) {
        User user = null;
        if (!id.equals("")) {
          user = this.userService.findById(Integer.parseInt(id));
        }
        if (user != null) {
          user.setDeleted(true);
          user.setUpdatedAt(new Date());
          user.setUpdatedBy(currentUser.getId().intValue());
        }
        this.userService.updateUser(user);
      } else {
        String firstName = jsonobject.getString(Constants.FIRSTNAME) != null ? jsonobject.getString(Constants.FIRSTNAME)
            : "";
        String lastName = jsonobject.getString(Constants.LASTNAME) != null ? jsonobject.getString(Constants.LASTNAME)
            : "";
        String firstName1 = jsonobject.getString(Constants.FIRSTNAME1) != null
            ? jsonobject.getString(Constants.FIRSTNAME1) : "";
        String lastName1 = jsonobject.getString(Constants.LASTNAME1) != null ? jsonobject.getString(Constants.LASTNAME1)
            : "";
        String username = jsonobject.getString(Constants.USERNAME) != null ? jsonobject.getString(Constants.USERNAME)
            : "";
        String password = jsonobject.getString(Constants.PASSWORD) != null ? jsonobject.getString(Constants.PASSWORD)
            : "";
        String role = jsonobject.getString(Constants.ROLE) != null ? jsonobject.getString(Constants.ROLE) : "";
        if (type.equals(Constants.TYPE_EDIT)) {
          User user = null;
          if (!id.equals("")) {
            user = this.userService.findById(Integer.parseInt(id));
          }
          if (user != null) {
            user.setUpdatedAt(new Date());
            user.setUpdatedBy(currentUser.getId().intValue());
            if (!firstName.equals("")) {
              user.setFirstName(firstName);
            }
            if (!lastName.equals("")) {
              user.setLastName(lastName);
            }
            if (!firstName1.equals("")) {
              user.setFirstName1(firstName1);
            }
            if (!lastName1.equals("")) {
              user.setLastName1(lastName1);
            }
            if (!password.equals("")) {
              user.setPassword(password);
            }
            if (!role.equals("")) {
              Roles roles = this.userService.findRoleByRoleName(role);
              user.setRole(roles);
            }
            listUserEdit.add(user);
          }
        }
        if (type.equals(Constants.TYPE_SAVE)) {
          User user = new User();
          user.setFirstName(firstName);
          user.setLastName(lastName);
          user.setFirstName1(firstName1);
          user.setLastName1(lastName1);
          user.setUsername(username);
          user.setPassword(password);
          Roles roles = this.userService.findRoleByRoleName(role);
          user.setRole(roles);
          user.setDeleted(false);
          user.setCreatedAt(new Date());
          user.setUpdatedAt(new Date());
          user.setCreatedBy(currentUser.getId().intValue());
          user.setUpdatedBy(currentUser.getId().intValue());
          listUserSave.add(user);
        }
      }
    }
    if (listUserEdit.isEmpty()) {
      for (User user : listUserEdit) {
        this.userService.updateUser(user);
      }
    }
    if (listUserSave.isEmpty()) {
      for (User user : listUserSave) {
        this.userService.saveUser(user);
      }
    }
    return "redirect:/list";
  }

}
