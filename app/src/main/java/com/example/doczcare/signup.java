package com.example.doczcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class signup extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText user = (EditText) findViewById(R.id.username);
        EditText email = (EditText) findViewById(R.id.email);
        EditText pass = (EditText) findViewById(R.id.passwords);
        EditText phone = (EditText) findViewById(R.id.phones);
        TextView tbs = (TextView) findViewById(R.id.tbs);
        dbconnect DB = new dbconnect(this);
        Button btn = (Button) findViewById(R.id.buttonsign);


        tbs.setOnClickListener(view -> {
            Intent i = new Intent(signup.this,login.class);
            startActivity(i);
        });
        btn.setOnClickListener(view -> {
            String pn = phone.getText().toString();
            String password = pass.getText().toString();
            String username = user.getText().toString();
            String emailid = email.getText().toString();
            if(pn.equals("")||password.equals("")||username.equals("")||emailid.equals("")){
                Toast.makeText(signup.this,"Please Enter all the fields",Toast.LENGTH_SHORT).show();
            }
            else {
                boolean checkuser = DB.checkusername(username);
                if(checkuser ==false){
                    boolean insert = DB.insertdata(username,password,emailid,pn);
                    if (insert==true ) {

                        Toast.makeText(signup.this,"Sign up successful",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(signup.this,home.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(signup.this,"Sign up failed",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(signup.this,"user already exists",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
