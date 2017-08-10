package com.ptit.rms.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.rms.model.Ctmenu;
import com.ptit.rms.model.Menu;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.service.CTMenuService;
import com.ptit.rms.ultil.Messages;
import com.ptit.rms.ultil.ResponseList;
import com.ptit.rms.ultil.ResponseObject;
import com.ptit.rms.ultil.VerifyToken;

@CrossOrigin(origins = "http://localhost:8080/rms", maxAge = 3600)
@RestController
@RequestMapping("api")
public class CTMenuAPI {

  @Autowired
  private CTMenuService ctMenuService;

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/ctmenu/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseList> getDatBan(@RequestHeader HttpHeaders headers) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<Ctmenu> lstCtMenu = this.ctMenuService.getCtMenu();
      ResponseList<Ctmenu> lst = new ResponseList<>(lstCtMenu);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/ctmenu/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseObject> addDatBan(@RequestHeader HttpHeaders headers,
      @RequestBody List<Ctmenu> lstCTMenu) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      this.ctMenuService.saveCTMenu(lstCTMenu);
      Messages messages = new Messages(200, "Cập Nhật Thành Công", true);
      ResponseObject<Messages> responseObject = new ResponseObject<Messages>(messages);
      return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
    }
  }

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/menu/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseObject> addMenu(@RequestHeader HttpHeaders headers, @RequestBody Menu menu) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      this.ctMenuService.saveMenu(menu);
      Menu menu2 = this.ctMenuService.getMenuByName(menu.getTenMenu());
      ResponseObject<Menu> responseObject = new ResponseObject<Menu>(menu2);
      return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
    }
  }

}
