package com.example.asramapoltekbang;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.InputStream;


public class CustomListView extends ArrayAdapter<String>{

    private String[] status;
    private String[] nama;
    private String[] tanggal;
    private String[] imagepath;
    private Activity context;
    Bitmap bitmap;

    public CustomListView(Activity context,String[] status,String[] nama,String[] tanggal,String[] imagepath) {
        super(context, R.layout.layout,nama);
        this.context=context;
        this.status=status;
        this.nama=nama;
        this.tanggal=tanggal;
        this.imagepath=imagepath;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layout,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)r.getTag();

        }

        viewHolder.tvw1.setText(status[position]);
        viewHolder.tvw2.setText(nama[position]);
        viewHolder.tvw3.setText(tanggal[position]);
        new GetImageFromURL(viewHolder.ivw).execute(imagepath[position]);

        return r;
    }

    class ViewHolder{

        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        ImageView ivw;

        ViewHolder(View v){
            tvw1=(TextView)v.findViewById(R.id.tvstatus);
            tvw2=(TextView)v.findViewById(R.id.tvnama);
            tvw3=(TextView)v.findViewById(R.id.tvtanggal);
            ivw=(ImageView)v.findViewById(R.id.image);
        }

    }

    public class GetImageFromURL extends AsyncTask<String,Void,Bitmap>
    {

        ImageView imgView;
        public GetImageFromURL(ImageView imgv)
        {
            this.imgView=imgv;
        }
        @Override
        protected Bitmap doInBackground(String... url) {
            String urldisplay=url[0];
            bitmap=null;

            try{

                InputStream ist=new java.net.URL(urldisplay).openStream();
                bitmap= BitmapFactory.decodeStream(ist);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap){

            super.onPostExecute(bitmap);
            imgView.setImageBitmap(bitmap);
        }
    }



}
