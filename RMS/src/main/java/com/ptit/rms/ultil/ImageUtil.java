package com.ptit.rms.ultil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.DatatypeConverter;

public class ImageUtil {

  public static String upLoadImage(String image, String filename) {
    String url = Constants.PATH + filename + ".jpg";
    String base64Image = image;
    File file = new File(Constants.ROOT + Constants.PATH);
    if (!file.exists()) {
      file.canWrite();
      file.canExecute();
      file.canRead();
      file.mkdir();
    }
    byte[] imageBytes = DatatypeConverter.parseBase64Binary(base64Image);
    try {
      FileOutputStream fos = new FileOutputStream(Constants.ROOT + url);
      fos.write(imageBytes);
      fos.close();
      return url;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "";
  }
}
