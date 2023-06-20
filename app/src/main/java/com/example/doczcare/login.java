package com.example.doczcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView t = (TextView) findViewById(R.id.tb);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i = new Intent(login.this,signup.class);
                    startActivity(i);
            }
        });

        EditText phone = (EditText) findViewById(R.id.phone);
        EditText password = (EditText) findViewById(R.id.password);
        Button btn = (Button) findViewById(R.id.buttonlog);
        dbconnect DB = new dbconnect(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phn = phone.getText().toString();
                String pas = password.getText().toString();
                if(phn.equals("") || pas.equals("")){
                    Toast.makeText(login.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean checkpnpass = DB.checkuserpass(phn,pas);

                    if(checkpnpass){
                        Toast.makeText(login.this,"Login successful",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(login.this,home.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(login.this,"Invalid Phone or password",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}