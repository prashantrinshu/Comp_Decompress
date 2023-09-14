package comp_decomp;

import java.io.*;
import java.util.zip.GZIPInputStream;

public class decompressor {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();
        String fileName = file.getName();

        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/" + fileName.substring(0, fileName.length() - 20) + " (decompressed)" + fileName.substring(fileName.length() - 20, fileName.length() - 16));

        byte[] buffer = new byte[1024];
        int len;

        while ((len = gzip.read(buffer)) != -1)
            fos.write(buffer, 0, len);

        fos.close();
        gzip.close();
        fis.close();
    }

    public static void main(String[] args) throws IOException {
        // File path = new File("CompressedFile.gz");
        // method(path);
    }
}
