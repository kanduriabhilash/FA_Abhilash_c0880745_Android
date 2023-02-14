package com.example.fa_abhilash_c0880745_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText prodidEdt, prodnameEdt, proddescriptionEdt, prodpriceEdt;
    private Button adddataBtn;
    private DBHandler dbHandler;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        prodidEdt = findViewById(R.id.prodid);
        prodnameEdt = findViewById(R.id.prodname);
        proddescriptionEdt = findViewById(R.id.proddesc);
        prodpriceEdt = findViewById(R.id.prodprice);
        adddataBtn = findViewById(R.id.idBtnAddCourse);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add course button.
        adddataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String prodName = prodnameEdt.getText().toString();
                String prodid = prodidEdt.getText().toString();
                String proddescription = proddescriptionEdt.getText().toString();
                String prodprice = prodpriceEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (prodid.isEmpty() && prodName.isEmpty() && proddescription.isEmpty() && prodprice.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.adddata(prodid,prodName,proddescription,prodprice );

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                prodidEdt.setText("");
                prodnameEdt.setText("");
                proddescriptionEdt.setText("");
                prodpriceEdt.setText("");
            }
        });

        View viewdataBtn = null;
        viewdataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity.this, ViewData.class);
                startActivity(i);
            }
        });

    }

    private class DBHandler {
        public DBHandler(MainActivity mainActivity) {

        }

        public void adddata(String prodid, String prodName, String proddescription, String prodprice) {
        }
    }

    private class ViewData {
    }
}
