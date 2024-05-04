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

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.listView);




        Book_Authors_Json();




    }// onCreate End Here ========================

    private void Book_Authors_Json() {
        MakeList.rootArrayList = new ArrayList<>();
        MakeList.bookTableArrayList = new ArrayList<>();
        MakeList.authorsTableArrayList = new ArrayList<>();
        String url = "https://sumondevelopers.xyz/my/Book%26AuthorsDataGet.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                // Toast.makeText(MainActivity.this,"response"+response.toString(),Toast.LENGTH_SHORT).show();

                try {

                    for (int x = 0; x < response.length(); x++) {

                        JSONObject jsonObject = response.getJSONObject(x);

                        String BooksTable_id = jsonObject.getString("BooksTable_id");
                        String BooksTable_title = jsonObject.getString("BooksTable_title");
                        String BooksTable_subTitle = jsonObject.getString("BooksTable_subTitle");


                        JSONArray Authors = jsonObject.getJSONArray("Authors");


                        for (int i = 0; i < Authors.length(); i++) {

                            JSONObject AuthorsTable = Authors.getJSONObject(i);

                            String AuthorsTable_id = AuthorsTable.getString("AuthorsTable_id");
                            String AuthorsTable_title = AuthorsTable.getString("AuthorsTable_title");
                            String AuthorsTable_subTitle = AuthorsTable.getString("AuthorsTable_subTitle");

                            MakeList.authorsList(AuthorsTable_id,AuthorsTable_title,AuthorsTable_subTitle);

                        }
                        MakeList.bookList(BooksTable_id,BooksTable_title,BooksTable_subTitle);



                        /// listView Adapter set short key  ============
                        MyAdapter myAdapter= new MyAdapter();
                        listView.setAdapter(myAdapter);
                        myAdapter.notifyDataSetChanged();

                    }









                } catch (JSONException e) {
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"error"+error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonArrayRequest);


    }///  Book_Authors_Json End Here =============




    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return MakeList.bookTableArrayList.size();
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


            HashMap<String,String>mHashMap= MakeList.bookTableArrayList.get(position);

            String title= mHashMap.get("BooksTable_title");
            String subTitle= mHashMap.get("BooksTable_subTitle");
            String id= mHashMap.get("BooksTable_id");

            /// set Text
            if (title !=null) {
                tvTitle.setText(title);
                tvsubTitle.setText(subTitle);
            }


            // button short setOnClickListener ============

            nextActivity.setOnClickListener(v -> {

                 MainActivity2.arrayList = MakeList.rootArrayList.get(position);
                startActivity(new Intent(MainActivity.this,MainActivity2.class));


            }); //button End Here ==========




            return myView;
        }
    } //MyAdapter End Here ============





}// public class MainActivity End Here ===============