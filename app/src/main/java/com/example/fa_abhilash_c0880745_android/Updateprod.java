package com.example.fa_abhilash_c0880745_android;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Updateprod extends AppCompatActivity {

    private EditText updateprodid, updateprodname, updateproddescription, updateprodprice;
    private Button updateproddetails;
    private DBHandler dbHandler;
    int prodid;
    String prodname, proddescription,prodprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateprod);

        updateprodid=findViewById(R.id.updateid);
        updateprodname=findViewById(R.id.updatename);
        updateproddescription=findViewById(R.id.updatedescription);
        updateprodprice=findViewById(R.id.updateprice);

        dbHandler = new DBHandler(Updateprod.this);


    }

    private class DBHandler {
        public DBHandler(Updateprod updateprod) {

        }
    }
}