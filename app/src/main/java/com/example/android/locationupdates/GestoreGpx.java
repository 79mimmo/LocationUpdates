package com.example.android.locationupdates;

import android.content.Context;
import android.location.Location;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mimmo on 20/09/2014.
 */
public class GestoreGpx {
    String dirName = "MyGPSlog";
    String filename;
    String string = "Hello world!";
    String baseDir;
    File fileGpx;
    FileOutputStream fos;
    OutputStreamWriter osw;

    public GestoreGpx(){
        //Test se presente external Storage:
        Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        File fileDir = new File(baseDir+File.separator+dirName);

        if (!fileDir.mkdirs()) {
            Log.d(LocationUtils.APPTAG, "Directory non creata!");
        }else{
            Log.d(LocationUtils.APPTAG, "Directory creata!");
        }
    }

    public boolean creaFileGpx(){
        boolean esito=false;
        Date dataOdierna= new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMddhhmmss");
        filename=sdf.format(dataOdierna)+".gpx";


        fileGpx=new File(baseDir+File.separator+dirName+File.separator+filename);
        SimpleDateFormat sdfutc=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
        String dataUTC=sdfutc.format(dataOdierna);
        try {
            fileGpx.createNewFile();
            fos = new FileOutputStream(fileGpx);
            osw= new OutputStreamWriter(fos);
            osw.append("\n" +
                    "<gpx version=\"1.0\" creator=\"MyGPSlog - a cura di Mimmo Cuomo\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.topografix.com/GPX/1/0\" xsi:schemaLocation=\"http://www.topografix.com/GPX/1/0 http://www.topografix.com/GPX/1/0/gpx.xsd\">"+"\n"+"<time>"+dataUTC+"</time>\n");
            osw.flush();
            osw.close();

            fos.close();
            esito=true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return esito;
    }
    public boolean scriviPosizione(Context contesto, Location location){
        boolean esito=false;
        try {
            fos = new FileOutputStream(fileGpx, true);

            osw= new OutputStreamWriter(fos);

            osw.append("\n"+LocationUtils.getLatLng(contesto, location));
            osw.flush();
            osw.close();
            esito=true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return esito;
    }
    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
}
