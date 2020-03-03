package edu.temple.lab10;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationFragment.OnSymbolSelectedListener {


    NavigationFragment nF;
    DetailsFragment dF;



    SearchManager searchManager;
    SearchView searchView;
    static String website, imageWebsite;
    String fullURL;

    Intent intent;
    Bundle bundle;
    MyService myService;
    boolean isBound = false;
    String name, price, stockInfo;
    Handler handler, handler2;
    String fileInfo = "stockInfo";
    String info;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nF = new NavigationFragment();
        dF = new DetailsFragment();

        intent = new Intent(MainActivity.this, MyService.class);



        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);




        website = "http://dev.markitondemand.com/MODApis/Api/v2/Quote/json/?symbol=";
        imageWebsite = "http://www.google.com/finance/chart?q=googl&p=1d";;



        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.nFragment, nF)
                .addToBackStack(null)
                .commit();

        if (findViewById(R.id.land) != null) {
            FragmentManager fm2 = getSupportFragmentManager();
            fm2.beginTransaction()
                    .replace(R.id.dFragment, dF)
                    .commit();
        }





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu_main, menu);

        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                nF.addStock(s);

                fullURL = website + s;


                if (isBound) {


                    myService.getUrl(fullURL, s, imageWebsite);

                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {



                        HttpURLConnection connection = null;
                        BufferedReader reader = null;

                        try {
                            URL url = new URL(fullURL);
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


                            Message message = new Message();
                            Message message2 = new Message();


                            message.what = 1;
                            message.obj = companyName;

                            message2.what = 2;
                            message2.obj = price;

                            handler.sendMessage(message);
                            handler2.sendMessage(message2);

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

                ).start();
                String info;
                info = readStockInfo();
               Log.d("Info Test: ", info);
               // bundle.putString("info",info);
              //NavigationFragment newF = new NavigationFragment();
              //  newF.setArguments(bundle);


                if(findViewById(R.id.land) != null){
                    dF.text.setText(info);
                }else{
                    FragmentManager fragmentManager;
                    fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction()
                            .replace(R.id.portrait,dF)
                            .addToBackStack(null)
                            .commit();
                    fragmentManager.executePendingTransactions();
                    dF.text.setText(info);
                }



                handler = new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message message) {
                        String name = (String) message.obj;
                        String TAG = "Company Name: \n";

                        TextView t = findViewById(R.id.stockName);

                        t.setText(name);

                        return true;
                    }
                });


                handler2 = new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message message) {
                        String price = (String) message.obj;
                        String TAG = "\nCompany Price:";

                        TextView t2 = findViewById(R.id.stockPrice);

                        t2.setText(price);


                        return false;
                    }
                });


                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.search:

                break;

        }

        return super.onOptionsItemSelected(item);
    }


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.MyLocalBinder binder = (MyService.MyLocalBinder) iBinder;
            myService = binder.getService();
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };

    protected void onStop() {
        super.onStop();
        unbindService(serviceConnection);
        isBound = false;
    }

    @Override
    public void setStockInfo(String s) {



        android.widget.Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();


    }


    public String readStockInfo() {
        try {
            FileInputStream fileInputStream = openFileInput("stockInfo");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            info = (String) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return info;
    }




    //public void displayText();


}

