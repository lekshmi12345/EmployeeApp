package com.example.employeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddemployeeActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
AppCompatButton b1;
String getempcode,getname,getdesig,getmobno;
DbHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addemployee);
        ed1=(EditText) findViewById(R.id.ecode);
        ed2=(EditText) findViewById(R.id.name);
        ed3=(EditText) findViewById(R.id.desig);
        ed4=(EditText) findViewById(R.id.mbno);
        b1=(AppCompatButton) findViewById(R.id.submit);
        mydb=new DbHelper(this);
        mydb.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getempcode=ed1.getText().toString();
                getname=ed2.getText().toString();
                getdesig=ed3.getText().toString();
                getmobno=ed4.getText().toString();

                if(getmobno.matches("^[6-9]\\d{9}$"))
                {
                    Toast.makeText(getApplicationContext(), "valid", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "invalid", Toast.LENGTH_SHORT).show();
                }
                boolean status=mydb.insertEmployee(getempcode,getname,getdesig,getmobno);
                if (status==true) {
                    ed4.setText("");
                    Toast.makeText(getApplicationContext(), "successfully inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    }