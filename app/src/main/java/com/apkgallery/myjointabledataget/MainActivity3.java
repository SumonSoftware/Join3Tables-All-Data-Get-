package com.apkgallery.myjointabledataget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity3 extends AppCompatActivity {

    ArrayList<HashMap<String,String>>arrayList= new ArrayList<>();
    HashMap<String,String>hashMap;
    ListView listView;
    public static String id= "";
    String userTableURL= "https://sumondevelopers.xyz/my/userTable.php?AuthorsTable_id="+id;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        listView= findViewById(R.id.listView);



        userTable_Json();




    }///onCreate End Here ==============


    private void userTable_Json() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, userTableURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                   // Toast.makeText(MainActivity3.this, "response: " + response.toString(), Toast.LENGTH_SHORT).show();

                    for (int x = 0; x < response.length(); x++) {

                        JSONObject jsonObject = response.getJSONObject(x);

                        String title = jsonObject.getString("title");
                        String subTitle = jsonObject.getString("subTitle");

                        hashMap = new HashMap<>();

                        hashMap.put("title", title);
                        hashMap.put("subTitle", subTitle);
                        arrayList.add(hashMap);
                    }

                    // listView set adapter
                    MyAdapter myAdapter= new MyAdapter();
                    listView.setAdapter(myAdapter);


                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity3.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity3.this);
        requestQueue.add(jsonArrayRequest);
    }








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
            View myView = layoutInflater.inflate(R.layout.item_view,null);

            TextView tvTitle= myView.findViewById(R.id.tvTitle);
            TextView tvsubTitle= myView.findViewById(R.id.tvsubTitle);

            hashMap= arrayList.get(position);
            String title= hashMap.get("title");
            String subTitle= hashMap.get("subTitle");



            // set Text
            tvTitle.setText(title);
            tvsubTitle.setText(subTitle);



            return myView;
        }
    } //MyAdapter End Here ============




}/// public class MainActivity3 End Here ==================