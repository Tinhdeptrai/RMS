package com.ptit.rms.controller.api;

import java.util.Date;
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

import com.ptit.rms.model.Ban;
import com.ptit.rms.model.DatBan;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.service.BanService;
import com.ptit.rms.service.DatBanService;
import com.ptit.rms.ultil.Messages;
import com.ptit.rms.ultil.ResponseList;
import com.ptit.rms.ultil.ResponseObject;
import com.ptit.rms.ultil.VerifyToken;

@CrossOrigin(origins = "http://localhost:8080/rms", maxAge = 3600)
@RestController
@RequestMapping("api")
public class DatBanAPI {

  @Autowired
  private DatBanService datBanService;
  
  @Autowired
  private BanService banService;

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/datban/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseList> getDatBan(@RequestHeader HttpHeaders headers) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<DatBan> lstDatBan = this.datBanService.getDatBan();
      ResponseList<DatBan> lst = new ResponseList<>(lstDatBan);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/datban/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseObject> addDatBan(@RequestHeader HttpHeaders headers, @RequestBody DatBan datBan) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      Ban ban = datBan.getBan();
      ban.setTrangThai(1);
      datBan.setNgayGioDat(new Date());
      datBan.setBan(ban);
      datBan.setFlagdelete(false);
      this.banService.update(ban);
      this.datBanService.saveDatBan(datBan);
      Messages messages = new Messages(200, "Cập Nhật Thành Công", true);
      ResponseObject<Messages> responseObject = new ResponseObject<Messages>(messages);
      return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
    }
  }
}
