package com.ptit.rms.controller.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
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
import com.ptit.rms.model.HoaDon;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.service.BanService;
import com.ptit.rms.service.DatBanService;
import com.ptit.rms.service.HoaDonService;
import com.ptit.rms.ultil.Messages;
import com.ptit.rms.ultil.ResponseList;
import com.ptit.rms.ultil.ResponseObject;
import com.ptit.rms.ultil.VerifyToken;

@CrossOrigin(origins = "http://localhost:8080/rms", maxAge = 3600)
@RestController
@RequestMapping("api")
public class HoaDonAPI {

  @Autowired
  private HoaDonService hoaDonService;

  @Autowired
  private BanService banService;

  @Autowired
  private DatBanService datBanService;

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/hoadon/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseList> getDatBan(@RequestHeader HttpHeaders headers) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<HoaDon> lstHoaDon = this.hoaDonService.getHoaDon();
      ResponseList<HoaDon> lst = new ResponseList<>(lstHoaDon);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/hoadon/add", method = RequestMethod.POST)
  public ResponseEntity<ResponseObject> addNewHoaDon(@RequestHeader HttpHeaders headers, @RequestBody HoaDon hoaDon)
      throws ParseException {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      DatBan datBan = hoaDon.getDatBan();
      datBan.setTrangThai(1);
      Ban ban = datBan.getBan();
      ban.setTrangThai(0);
      this.banService.update(ban);
      datBan.setBan(ban);
      this.datBanService.update(datBan);
      hoaDon.setDatBan(datBan);
      hoaDon.setNgayLapHd(new Date());
      hoaDon.setFlagDelete(false);
      hoaDon.setTrangThai(0);
      this.hoaDonService.save(hoaDon);
    }
    Messages messages = new Messages(200, "Cập Nhật Thành Công", true);
    ResponseObject<Messages> responseObject = new ResponseObject<Messages>(messages);
    return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
  }
}
