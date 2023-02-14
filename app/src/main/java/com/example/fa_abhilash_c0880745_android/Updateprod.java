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

        updateprodid = findViewById(R.id.updateid);
        updateprodname = findViewById(R.id.updatename);
        updateproddescription = findViewById(R.id.updatedescription);
        updateprodprice = findViewById(R.id.updateprice);

        dbHandler = new DBHandler(Updateprod.this);

        prodname = getIntent().getStringExtra("name");
        proddescription = getIntent().getStringExtra("description");
        prodprice = getIntent().getStringExtra("price");


        updateprodname.setText(prodname);
        updateproddescription.setText(proddescription);
        updateprodprice.setText(prodprice);
        updateprodid.setText(prodid);

        updateproddetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course
                // method and passing all our edit text values.
                dbHandler.Updateprod(prodname, updateprodname.getText().toString(), updateproddescription.getText().toString(), updateprodprice.getText().toString(), updateprodid.getText().toString());

                // displaying a toast message that our course has been updated.
                Toast.makeText(Updateprod.this, "Course Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(Updateprod.this, MainActivity.class);
                startActivity(i);


            }
        });
    }
    // adding on click listener for delete button to delete our course.
        deleteprod.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View  v) {
            // calling a method to delete our course.
            dbHandler.deleteprod(prodname);
            Toast.makeText(Updateprod.this, "Deleted the course", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Updateprod.this, MainActivity.class);
            startActivity(i);
        }
    });




    private class DBHandler {
        public DBHandler(Updateprod updateprod) {

        }

        public void Updateprod(String prodname, String toString, String toString1, String toString2, String toString3) {

        }

        public void deleteprod(String prodname) {
        }
    }
}