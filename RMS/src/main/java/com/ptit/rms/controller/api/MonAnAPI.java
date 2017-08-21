package com.ptit.rms.controller.api;

import java.util.Date;
import java.util.List;
import java.util.Random;

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

import com.ptit.rms.model.BangGia;
import com.ptit.rms.model.DanhMuc;
import com.ptit.rms.model.DinhLuong;
import com.ptit.rms.model.DonViTinh;
import com.ptit.rms.model.MonAn;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.model.api.MonAnApi;
import com.ptit.rms.service.HangHoaService;
import com.ptit.rms.service.MonAnService;
import com.ptit.rms.ultil.ImageUtil;
import com.ptit.rms.ultil.Messages;
import com.ptit.rms.ultil.ResponseList;
import com.ptit.rms.ultil.ResponseObject;
import com.ptit.rms.ultil.VerifyToken;

@CrossOrigin(origins = "http://localhost:8080/rms", maxAge = 3600)
@RestController
@RequestMapping("api")
public class MonAnAPI {

  @Autowired
  private MonAnService monAn;

  @Autowired
  private HangHoaService hangHoaService;

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

  @RequestMapping(value = "/monan/add", method = RequestMethod.POST)
  public ResponseEntity<Integer> addNewHoaDon(@RequestHeader HttpHeaders headers, @RequestBody MonAnApi monAn)
      throws ParseException {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      System.out.println(monAn);
      MonAn ma = new MonAn();
      ma.setTenMon(monAn.getTenMon());
      Random rand = new Random();
      int n = rand.nextInt(10000000) + 1;
      Date date = new Date();
      if (monAn.getAnh() != null) {
        String urlImage = ImageUtil.upLoadImage(monAn.getAnh(), n + date.getTime() + "");
        ma.setAnh(urlImage);
      }

      DonViTinh donViTinhObj = this.hangHoaService.findDVTByName(monAn.getDonViTinh().getTenDonVi());
      DanhMuc danhMuc = new DanhMuc();
      danhMuc.setIddanhMuc(1);
      ma.setDanhMuc(danhMuc);
      if (donViTinhObj == null) {
        DonViTinh obj = new DonViTinh();
        obj.setTenDonVi(monAn.getDonViTinh().getTenDonVi());
        this.hangHoaService.createDVT(obj);
        ma.setDonViTinh(obj);
      } else {
        ma.setDonViTinh(donViTinhObj);
      }
      ma.setGhiChu(monAn.getGhiChu());

      int id = this.monAn.saveMonAn(ma);
      return new ResponseEntity<Integer>(id, HttpStatus.OK);
    }

  }

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/dinhluong/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseObject> addDinhLuong(@RequestHeader HttpHeaders headers,
      @RequestBody List<DinhLuong> dinhLuongs) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      this.hangHoaService.saveDinhLuong(dinhLuongs);
      Messages messages = new Messages(200, "Cập Nhật Thành Công", true);
      ResponseObject<Messages> responseObject = new ResponseObject<Messages>(messages);
      return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
    }
  }

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/banggia/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public ResponseEntity<ResponseObject> addBangGia(@RequestHeader HttpHeaders headers, @RequestBody BangGia bangGias) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      this.monAn.saveBangGia(bangGias);
      Messages messages = new Messages(200, "Cập Nhật Thành Công", true);
      ResponseObject<Messages> responseObject = new ResponseObject<Messages>(messages);
      return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
    }
  }

  @RequestMapping(value = "/monan/update", method = RequestMethod.POST)
  public ResponseEntity<Integer> editNewHoaDon(@RequestHeader HttpHeaders headers, @RequestBody MonAnApi monAn)
      throws ParseException {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      System.out.println(monAn);
      MonAn ma = new MonAn();
      ma.setTenMon(monAn.getTenMon());
      Random rand = new Random();
      int n = rand.nextInt(10000000) + 1;
      Date date = new Date();
      if (monAn.getAnh() != null) {
        String urlImage = ImageUtil.upLoadImage(monAn.getAnh(), n + date.getTime() + "");
        ma.setAnh(urlImage);
      }

      DonViTinh donViTinhObj = this.hangHoaService.findDVTByName(monAn.getDonViTinh().getTenDonVi());
      DanhMuc danhMuc = new DanhMuc();
      danhMuc.setIddanhMuc(1);
      ma.setDanhMuc(danhMuc);
      if (donViTinhObj == null) {
        DonViTinh obj = new DonViTinh();
        obj.setTenDonVi(monAn.getDonViTinh().getTenDonVi());
        this.hangHoaService.createDVT(obj);
        ma.setDonViTinh(obj);
      } else {
        ma.setDonViTinh(donViTinhObj);
      }
      ma.setGhiChu(monAn.getGhiChu());

      this.monAn.updateMonAn(ma);
      return new ResponseEntity<Integer>(0, HttpStatus.OK);
    }

  }

}
