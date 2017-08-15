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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.rms.model.Ctddh;
import com.ptit.rms.model.DonDatHang;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.service.DonDatHangService;
import com.ptit.rms.ultil.Messages;
import com.ptit.rms.ultil.ResponseList;
import com.ptit.rms.ultil.ResponseObject;
import com.ptit.rms.ultil.VerifyToken;

@CrossOrigin(origins = "http://localhost:8080/rms", maxAge = 3600)
@RestController
@RequestMapping("api")
public class DonDatHangAPI {

  @Autowired
  private DonDatHangService donDatHangService;

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/dondathang/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseList> getDonDatHang(@RequestHeader HttpHeaders headers) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<DonDatHang> donDatHangs = this.donDatHangService.getDonDatHang();
      ResponseList<DonDatHang> lst = new ResponseList<>(donDatHangs);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/ctdondathang/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseList> getCTDonDatHang(@RequestHeader HttpHeaders headers, @RequestParam("id") int id) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<Ctddh> ctDonDatHangs = this.donDatHangService.getCTDonDatHang(id);
      ResponseList<Ctddh> lst = new ResponseList<>(ctDonDatHangs);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }

  @RequestMapping(value = "/dondathang/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public ResponseEntity<Integer> addDonDAtHang(@RequestHeader HttpHeaders headers, @RequestBody DonDatHang donDatHang) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      donDatHang.setNgayDatHang(new Date());
      donDatHang.setFlagdelete(false);
      int id = this.donDatHangService.saveDDH(donDatHang);
      return new ResponseEntity<Integer>(id, HttpStatus.OK);
    }
  }

  @SuppressWarnings("rawtypes")
  @RequestMapping(value = "/dondathang/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseObject> updateDonDAtHang(@RequestHeader HttpHeaders headers,
      @RequestBody DonDatHang donDatHang) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      DonDatHang datHang = this.donDatHangService.getDonDatHangById(donDatHang.getIddonDatHang());
      datHang.setTrangThai(1);
      this.donDatHangService.updateDDH(datHang);
      Messages messages = new Messages(200, "Cập Nhật Thành Công", true);
      ResponseObject<Messages> responseObject = new ResponseObject<Messages>(messages);
      return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
    }
  }

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/ctdondathang/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseObject> addCTDonDAtHang(@RequestHeader HttpHeaders headers,
      @RequestBody List<Ctddh> listCTDDH) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      this.donDatHangService.saveCTDDH(listCTDDH);
      Messages messages = new Messages(200, "Cập Nhật Thành Công", true);
      ResponseObject<Messages> responseObject = new ResponseObject<Messages>(messages);
      return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
    }
  }
}
