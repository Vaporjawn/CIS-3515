package edu.temple.lab10;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyService extends Service {

    Handler handler, handler2;
    Intent intent;
    static String fullURL, imageURL;
    String price;
    String name;
    DetailsFragment dF;
    HttpURLConnection connection = null;
    BufferedReader reader = null;
    URL url;
    String info;
    static String stockSymbol;
    String space = " ";

    private final IBinder binder = new MyLocalBinder();

    public MyService()  {


    }


    @Override
    public void onCreate() {


        super.onCreate();
    }

    public void getUrl(String url,String s, String imageUrl){
        stockSymbol = s;
        fullURL = url;
        imageURL = imageUrl;

        startRequest(fullURL);


    }

    public void startRequest(final String s) {


        new Thread(new Runnable() {
            @Override
            public void run() {


               while (true) {
                    try {
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        url = new URL(s);
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(5000);
                        InputStream stream = connection.getInputStream();
                        reader = new BufferedReader(new InputStreamReader(stream));
                        StringBuilder sB = new StringBuilder();


                        String line = "";
                        while ((line = reader.readLine()) != null) {
                            sB.append(line);
                        }


                        connection.disconnect();

                        String jsonValue = sB.toString();
                        JSONObject jsonObject = new JSONObject(jsonValue);


                        String companyName = jsonObject.getString("Name");
                        String price = jsonObject.getString("LastPrice");


                        info = "Company Name:" + companyName + space + "Price:" + price + space + "Symbol:" + stockSymbol +"\n";
                        saveToFile(info);




//                        Bitmap stockImage = null;
//                        try {
//                            stockImage = Picasso.with(getApplicationContext()).load(imageURL).into(dF.im);
////                            getBitmapFromURL(stockImage, imageURL);
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }

//                        ImageView ivBasicImage = (ImageView) findViewById(R.id.image);
//                        Picasso.with(getApplicationContext()).load(imageURL).into(ivBasicImage);


                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    } finally {
                        if (connection != null) {
                            connection.disconnect();
                        }
                        try {
                            if (reader != null) {
                                reader.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
           }
        }

        ).start();


    }








    public void saveToFile(String data) {
        try {
            FileOutputStream fileOutputStream = openFileOutput("stockInfo", Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(data);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void saveInfoToFile(Context context) {
//        try {
//            FileOutputStream fileOutputStream = context.openFileOutput("info", Context.MODE_PRIVATE);
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(stockSymbol);
//            objectOutputStream.close();
//            fileOutputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }






    @Override
    public IBinder onBind(Intent intent) {

        return binder;
    }

    public class MyLocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }


    }



}
