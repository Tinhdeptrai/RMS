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

import com.ptit.rms.model.CtphieuNhap;
import com.ptit.rms.model.PhieuNhap;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.service.PhieuNhapService;
import com.ptit.rms.ultil.Messages;
import com.ptit.rms.ultil.ResponseList;
import com.ptit.rms.ultil.ResponseObject;
import com.ptit.rms.ultil.VerifyToken;

@CrossOrigin(origins = "http://localhost:8080/rms", maxAge = 3600)
@RestController
@RequestMapping("api")
public class PhieuNhapAPI {
  
  @Autowired
  private PhieuNhapService phieuNhapService;
  
  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/phieunhap/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseList> getPhieuNhap(@RequestHeader HttpHeaders headers) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<PhieuNhap> lstphieuNhap = this.phieuNhapService.getPhieuNhap();
      ResponseList<PhieuNhap> lst = new ResponseList<>(lstphieuNhap);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }
  
  @RequestMapping(value = "/phieunhap/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public ResponseEntity<Integer> addPhieuNhap(@RequestHeader HttpHeaders headers,
      @RequestBody PhieuNhap phieuNhap) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      phieuNhap.setNhayNhap(new Date());
      phieuNhap.setFlagDelete(false);
      int id = this.phieuNhapService.savePhieuNhap(phieuNhap);
      return new ResponseEntity<Integer>(id, HttpStatus.OK);
    }
  }
  
  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/ctphieunhap/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseObject> addCTPhieuNhap(@RequestHeader HttpHeaders headers,
      @RequestBody List<CtphieuNhap> listCTPhieuNhap) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
    this.phieuNhapService.saveCTPhieuNhap(listCTPhieuNhap);
      Messages messages = new Messages(200, "Cập Nhật Thành Công", true);
      ResponseObject<Messages> responseObject = new ResponseObject<Messages>(messages);
      return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
    }
  }
  
  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/ctphieunhap/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseList> getCTPhieuNhap(@RequestHeader HttpHeaders headers) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<CtphieuNhap> lstctphieuNhap = this.phieuNhapService.getCTPhieuNhap();
      ResponseList<CtphieuNhap> lst = new ResponseList<>(lstctphieuNhap);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }
  
}
