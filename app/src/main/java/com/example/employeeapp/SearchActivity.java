package com.example.employeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
AppCompatButton b1;
String getcode,getname,getdesignation,getmob;
DbHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ed1=(EditText) findViewById(R.id.empcode);
        ed2=(EditText) findViewById(R.id.empname);
        ed3=(EditText) findViewById(R.id.desig);
        ed4=(EditText) findViewById(R.id.mobno);
        b1=(AppCompatButton) findViewById(R.id.search);
        mydb=new DbHelper(this);
        mydb.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getcode=ed1.getText().toString();
               Cursor c=mydb.SearchEmployee(getcode);
               if(c.getCount()==0)
               {
                   Toast.makeText(getApplicationContext(), "No Employee Found", Toast.LENGTH_SHORT).show();
               } else {
                   while (c.moveToNext())
                   {
                       getname=c.getString(2);
                       getdesignation=c.getString(3);
                       getmob=c.getString(4);
                   }
                   ed2.setText(getname);
                   ed3.setText(getdesignation);
                   ed4.setText(getmob);
               }
            }
        });
    }
}