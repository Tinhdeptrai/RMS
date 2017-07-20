package com.ptit.rms.controller.api;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.model.User;
import com.ptit.rms.model.api.TokenInforAPI;
import com.ptit.rms.model.api.UsersAPI;
import com.ptit.rms.service.UserService;
import com.ptit.rms.ultil.CommonUtil;
import com.ptit.rms.ultil.DateUtil;
import com.ptit.rms.ultil.ReponseList;
import com.ptit.rms.ultil.ResponseObject;
import com.ptit.rms.ultil.VerifyToken;

@RestController
@RequestMapping("api")
public class UserAPI {

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public ResponseEntity<ReponseList> getListUserByUpdateTime(@RequestParam("time") String date,
      @RequestHeader HttpHeaders headers) throws ParseException {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      if (date != null && DateUtil.validateDateFormatMmDmYyyy(date)) {
        Date dateUpdateAt = DateUtil.string2Date(date, "MM-dd-yyyy HH:mm:ss");
        List<User> list = this.userService.getListUserByDate(dateUpdateAt);
        List<UsersAPI> usersAPIs = this.userService.convertUserToJson(list);
        ReponseList<UsersAPI> success = new ReponseList<>(usersAPIs);
        return new ResponseEntity<ReponseList>(success, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }
  }

  @SuppressWarnings("rawtypes")
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity<ResponseObject> addArticle(@RequestBody String str) {
    JSONObject jsonObject = new JSONObject(str);
    String username = jsonObject.getString("username");
    String password = jsonObject.getString("password");

    if (CommonUtil.isValidUsername(username) && CommonUtil.isValidPassword(password)) {
      User user = this.userService.findByUsername(username);
      if (user != null) {
        if (user.getRole().getRole().equals("USER")) {
          boolean res = passwordEncoder.matches(password, user.getPassword());
          if (res) {
            TokenInfor infor = new TokenInfor(user.getUsername(), user.getFirstName(), user.getLastName(),
                user.getFirstName1(), user.getLastName1());
            String token = VerifyToken.createToken(infor);
            TokenInforAPI inforAPI = new TokenInforAPI(token);
            ResponseObject<TokenInforAPI> responseObject = new ResponseObject<>(inforAPI);
            return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
          }
        }
      }
    }
    return new ResponseEntity<ResponseObject>(HttpStatus.UNAUTHORIZED);
  }

}
