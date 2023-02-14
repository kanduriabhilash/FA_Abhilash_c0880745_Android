package com.example.fa_abhilash_c0880745_android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyViewData extends AppCompatActivity {

    private ArrayList<prodmodel> prodmodelArrayList;
    private DBHandler dbHandler;
    private prodAdapter prodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_data);

        prodmodelArrayList=new ArrayList<>();
        dbHandler=new DBHandler(MyViewData.this);

        prodmodelArrayList=dbHandler.readprod();

        prodAdapter=new prodAdapter(prodmodelArrayList, MyViewData.this);
        Object prod=findViewById(R.id.viewdata1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyViewData.this, RecyclerView.VERTICAL, false);
         prod.setLayoutManager(linearLayoutManager);

         prod.setAdapter(prodAdapter);



    }

    private class prodmodel {
    }

    private class DBHandler {
        public DBHandler(MyViewData myViewData) {
        }

        public ArrayList<prodmodel> readprod() {
            return null;
        }
    }

    private class prodAdapter {
        public prodAdapter(ArrayList<prodmodel> prodmodelArrayList, MyViewData myViewData) {

        }
    }
}