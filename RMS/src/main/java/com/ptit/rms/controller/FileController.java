package com.ptit.rms.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptit.rms.ultil.Constants;

@Controller
public class FileController {

  @RequestMapping(value = "/uploads/images/{filename}", method = RequestMethod.GET)
  public void doGet(@PathVariable("filename") String fileName, HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    File f = new File(Constants.ROOT + Constants.PATH + fileName + ".jpg");
    BufferedImage bi = ImageIO.read(f);
    OutputStream out = response.getOutputStream();
    response.setContentType("image/jpg,image/gif,image/png,image/JPG,image/JPEG,image/PNG");
    ImageIO.write(bi, "jpg", out);
    out.close();
  }

}
