package com.ptit.rms.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.rms.model.Menu;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.service.MenuService;
import com.ptit.rms.ultil.ResponseList;
import com.ptit.rms.ultil.VerifyToken;

@CrossOrigin(origins = "http://localhost:8080/rms", maxAge = 3600)
@RestController
@RequestMapping("api")
public class MenuAPI {

  @Autowired
  private MenuService menuService;
  
  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/menu/list", method = RequestMethod.GET)
  public ResponseEntity<ResponseList> getMenu(@RequestHeader HttpHeaders headers) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<Menu> lstMenu = this.menuService.getMenu();
      ResponseList<Menu> lst = new ResponseList<>(lstMenu);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }
}
