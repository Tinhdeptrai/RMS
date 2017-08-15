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

import com.ptit.rms.model.Ban;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.service.BanService;
import com.ptit.rms.ultil.ResponseList;
import com.ptit.rms.ultil.VerifyToken;

@CrossOrigin(origins = "http://localhost:8080/rms", maxAge = 3600)
@RestController
@RequestMapping("api")
public class BanAPI {

  
  @Autowired
  private BanService banService;

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/ban/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseList> getBan(@RequestHeader HttpHeaders headers) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<Ban> lstBan = this.banService.getBan();
      ResponseList<Ban> lst = new ResponseList<>(lstBan);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }
}
