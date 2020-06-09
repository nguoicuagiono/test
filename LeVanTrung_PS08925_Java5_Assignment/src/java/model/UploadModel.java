package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.Part;

public class UploadModel {

    public boolean uploadFile(String filename, Part file, String uploadRootPath) {
        try {
            InputStream fis = file.getInputStream();
            byte[] data = new byte[fis.available()];
            fis.read(data);
            FileOutputStream out = new FileOutputStream(new File(uploadRootPath + "\\" + filename));
            out.write(data);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getTenHinh(Part file) {
        String fileName = "";
        String header = file.getHeader("Content-Disposition");
        int beginIndex = header.lastIndexOf("=");
        fileName = header.substring(beginIndex + 1);

        //remove "" quotes
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(fileName);
        while (m.find()) {
            fileName = m.group(1);

            //dành cho IE.
            beginIndex = fileName.lastIndexOf("\\");
            fileName = fileName.substring(beginIndex + 1);

        }
        return fileName;
    }
}
