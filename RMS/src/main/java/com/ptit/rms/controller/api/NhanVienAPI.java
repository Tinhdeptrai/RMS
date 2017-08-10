package com.ptit.rms.controller.api;

import java.text.ParseException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.rms.model.NhanVien;
import com.ptit.rms.model.Quyen;
import com.ptit.rms.model.TokenInfor;
import com.ptit.rms.model.api.NhanVienApi;
import com.ptit.rms.model.api.TokenInforAPI;
import com.ptit.rms.service.NhanVienService;
import com.ptit.rms.ultil.CommonUtil;
import com.ptit.rms.ultil.Messages;
import com.ptit.rms.ultil.ResponseList;
import com.ptit.rms.ultil.ResponseObject;
import com.ptit.rms.ultil.VerifyToken;

@CrossOrigin(origins = "http://localhost:8080/rms", maxAge = 3600)
@RestController
@RequestMapping("api")
public class NhanVienAPI {
  @Autowired
  private NhanVienService nhanVienService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @SuppressWarnings("rawtypes")
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity<ResponseObject> addArticle(@RequestBody String str) {
    JSONObject jsonObject = new JSONObject(str);
    String username = jsonObject.getString("username");
    String password = jsonObject.getString("password");
    if (CommonUtil.isValidUsername(username) && CommonUtil.isValidPassword(password)) {
      NhanVien nhanVien = this.nhanVienService.findByUsername(username);
      if (nhanVien != null) {
        boolean res = passwordEncoder.matches(password, nhanVien.getMatKhau());
        if (res) {
          TokenInfor infor = new TokenInfor(nhanVien.getTaiKhoan(), nhanVien.getHo(), nhanVien.getTen(),
              nhanVien.getQuyen().getTenQuyen());
          String token = VerifyToken.createToken(infor);
          TokenInforAPI api = new TokenInforAPI(nhanVien.getIdnhanVien(), nhanVien.getTaiKhoan(), nhanVien.getHo(),
              nhanVien.getTen(), token, nhanVien.getQuyen().getTenQuyen());
          ResponseObject<TokenInforAPI> response = new ResponseObject<TokenInforAPI>(api);
          return new ResponseEntity<ResponseObject>(response, HttpStatus.OK);
        }
      }
    }
    return new ResponseEntity<ResponseObject>(HttpStatus.UNAUTHORIZED);
  }

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/nhanvien/list-nhanvien", method = RequestMethod.GET)
  public ResponseEntity<ResponseList> getNhanVien(@RequestHeader HttpHeaders headers) {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      List<NhanVien> lstNhanVien = this.nhanVienService.getNhanVien();
      List<NhanVienApi> nhanVienApis = this.nhanVienService.converNhanVien(lstNhanVien);

      ResponseList<NhanVienApi> lst = new ResponseList<>(nhanVienApis);
      return new ResponseEntity<ResponseList>(lst, HttpStatus.OK);
    }
  }

  @SuppressWarnings({ "rawtypes" })
  @RequestMapping(value = "/nhanvien/update", method = RequestMethod.POST)
  public ResponseEntity<ResponseObject> UpdateNhanVien(@RequestHeader HttpHeaders headers, @RequestBody String str)
      throws ParseException {
    TokenInfor infor = VerifyToken.verify(headers);
    if (infor == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else {
      JSONObject object = new JSONObject(str);
      String type = object.getString("type");
      if (type.equals("delete")) {
        String taikhoan = object.getString("taikhoan");
        NhanVien nhanVien = this.nhanVienService.findByUsername(taikhoan);
        nhanVien.setFlagDelete(true);
        this.nhanVienService.updateNhanVien(nhanVien);
      } else {
        String matkhau = object.getString("matkhau");
        String ho = object.getString("ho");
        String ten = object.getString("ten");
        String diaChi = object.getString("diachi");
        String sdt = object.getString("sdt");
        String quyen = object.getString("quyen");
        String taiKhoan = object.getString("taikhoan");
        int id = object.getInt("id");
        if (type.equals("edit")) {
          NhanVien nhanVien = this.nhanVienService.findById(id);
          nhanVien.setTaiKhoan(taiKhoan);
          if (!matkhau.equals("********"))
            nhanVien.setMatKhau(this.passwordEncoder.encode(matkhau));
          nhanVien.setHo(ho);
          nhanVien.setTen(ten);
          nhanVien.setDiaChi(diaChi);
          nhanVien.setSdt(sdt);
          Quyen quyenNv = this.nhanVienService.getQuyenByName(quyen);
          nhanVien.setQuyen(quyenNv);
          this.nhanVienService.updateNhanVien(nhanVien);
        }
        if (type.equals("new")) {
          NhanVien nhanVienCheck = this.nhanVienService.findByUsername(taiKhoan);
          if (nhanVienCheck == null) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setTaiKhoan(taiKhoan);
            nhanVien.setMatKhau(passwordEncoder.encode(matkhau));
            nhanVien.setHo(ho);
            nhanVien.setTen(ten);
            nhanVien.setDiaChi(diaChi);
            nhanVien.setSdt(sdt);
            Quyen quyenNv = this.nhanVienService.getQuyenByName(quyen);
            nhanVien.setQuyen(quyenNv);
            nhanVien.setFlagDelete(false);
            this.nhanVienService.saveNhanVien(nhanVien);
          } else {
            Messages messages = new Messages(200, "Tên tài khoản bị trùng", true);
            ResponseObject<Messages> responseObject = new ResponseObject<Messages>(messages);
            return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
          }
        }
      }
      Messages messages = new Messages(200, "Cập Nhật Thành Công", true);
      ResponseObject<Messages> responseObject = new ResponseObject<Messages>(messages);
      return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
    }
  }

}
