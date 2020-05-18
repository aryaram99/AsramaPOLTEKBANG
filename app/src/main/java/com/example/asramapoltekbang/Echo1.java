package com.example.asramapoltekbang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.StrictMode;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Echo1 extends AppCompatActivity {

    String urladdress="https://magangubd17.000webhostapp.com/android/displayecho1.php";
    String[] status;
    String[] nama;
    String[] tanggal;
    String[] imagepath;
    ListView listView;
    BufferedInputStream is;
    String line=null;
    String result=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echo1);

        listView=(ListView)findViewById(R.id.list);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
        CustomListView customListView=new CustomListView(this,status,nama,tanggal,imagepath);
        listView.setAdapter(customListView);

    }


    private void collectData()
    {
//Connection
        try{

            URL url=new URL(urladdress);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            is=new BufferedInputStream(con.getInputStream());

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        //content
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            while ((line=br.readLine())!=null){
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

//JSON
        try{
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;
            status=new String[ja.length()];
            nama=new String[ja.length()];
            tanggal=new String[ja.length()];
            imagepath=new String[ja.length()];

            for(int i=0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                status[i]=jo.getString("status");
                nama[i]=jo.getString("penghuni");
                tanggal[i]=jo.getString("lama_menginap");
                imagepath[i]=jo.getString("gambar");
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }


    }
}
