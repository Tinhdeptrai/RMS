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

import com.ptit.rms.model.MonAn;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.model.api.MonAnApi;
import com.ptit.rms.service.MonAnService;
import com.ptit.rms.ultil.ResponseList;
import com.ptit.rms.ultil.VerifyToken;

@CrossOrigin(origins = "http://localhost:8080/rms", maxAge = 3600)
@RestController
@RequestMapping("api")
public class MonAnAPI {

  @Autowired
  private MonAnService monAn;

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/monan/list", method = RequestMethod.GET)
  public ResponseEntity<ResponseList> getMonAn(@RequestHeader HttpHeaders headers) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<MonAn> lstMonAn = this.monAn.getMonAn();
      List<MonAnApi> monAnAPIs = this.monAn.converMonAn(lstMonAn);

      ResponseList<MonAnApi> lst = new ResponseList<>(monAnAPIs);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }
}
