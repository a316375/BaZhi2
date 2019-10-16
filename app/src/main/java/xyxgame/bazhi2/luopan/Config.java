package xyxgame.bazhi2.luopan;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class Config {
//拿到bitmap
    public static Bitmap getBitmap(Context context){
        String base64String ="data:image/png;base64,"+ Config.getString(context);
        String base64Image = base64String.split(",")[1];

        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }
//拿到asset里边的数据
    public static String getString(Context context) {
     return    readAndDisplayFileContentFromAssetsFolder(context);
    }

    public static String readAndDisplayFileContentFromAssetsFolder(Context context) {
        AssetManager mgr = context.getAssets();
        String filename = null;
        String sHTML="";
        try {
            filename = "lp.txt";
            System.out.println("filename : " + filename);
            InputStream in = mgr.open(filename, AssetManager.ACCESS_BUFFER);
            sHTML = StreamToString(in);
            in.close();

            // fileContent.setText(sHTML);

        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sHTML;
    }

    public static String StreamToString(InputStream in) throws IOException {
        if (in == null) {
            return "";
        }
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
        }
        return writer.toString();
    }
}

