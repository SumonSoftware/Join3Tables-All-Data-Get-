package com.apkgallery.myjointabledataget;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    public static ArrayList<HashMap<String,String>>arrayList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView= findViewById(R.id.listView);



        /// listView Adapter set short key  ============
        listView.setAdapter(new MyAdapter());



    }///onCreate End Here ==============

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater= getLayoutInflater();
            View myView = layoutInflater.inflate(R.layout.item_view,parent,false);

            TextView tvTitle= myView.findViewById(R.id.tvTitle);
            TextView tvsubTitle= myView.findViewById(R.id.tvsubTitle);
            Button nextActivity= myView.findViewById(R.id.nextActivity);


            HashMap<String,String>mHashMap= arrayList.get(position);

            String id= mHashMap.get("AuthorsTable_id");
            String title= mHashMap.get("AuthorsTable_title");
            String subTitle= mHashMap.get("AuthorsTable_subTitle");

            /// set Text
            if (title !=null){
                tvTitle.setText(title);
                tvsubTitle.setText(subTitle);
            }



            // button short setOnClickListener ============

            nextActivity.setOnClickListener(v -> {
                MainActivity3.id = id;
                startActivity(new Intent(MainActivity2.this,MainActivity3.class));

            }); //button End Here ==========




            return myView;
        }
    } //MyAdapter End Here ============




}/// public class MainActivity2 End Here ==================