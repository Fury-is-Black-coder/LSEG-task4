package org.example;
import com.aspose.cells.Workbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Download implements Runnable{
    String link;
    File out;

    public Download(String link, File out) throws IOException {
        this.link = link;
        this.out = out;
    }


    @Override
    public void run() {
        try{
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            double fileSize = (double) http.getContentLengthLong();
            BufferedInputStream in = new BufferedInputStream(http.getInputStream());
            FileOutputStream fos = new FileOutputStream(this.out);
            BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
            byte[] buffer = new byte[1024];
            double downloaded = 0.00;
            int read = 0;
            double percentDownloaded = 0.00;
            while ((read = in.read(buffer, 0, 1024))>=0){
                bout.write(buffer, 0, read);
                downloaded += read;
                percentDownloaded = (downloaded*100)/fileSize;
                String percent = String.format("%.4f", percentDownloaded);
                System.out.println("Downloaded "+percent+"% of a file");
            }
            bout.close();
            in.close();
            System.out.println("Download complete.");

            Workbook workbook = new Workbook(link.substring(link.lastIndexOf("/")+1));
            workbook.save("data_witout_formating.xls");
            // After Downloading we run our script
            ExcelUtility.getMapData("hurdat2-nepac-1949-2016-041317.xls");

        }
        catch (IOException ex){
            ex.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
