package com.example.doczcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean iswelcomeshown = preferences.getBoolean("welcomeshown",false);

        if(iswelcomeshown){
            startActivity(new Intent(MainActivity.this,login.class));
        }
        else{
            Button bt = (Button) findViewById(R.id.button);

            bt.setOnClickListener(view -> {
                Intent i = new Intent(MainActivity.this,signup.class);
                startActivity(i);
            });
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("welcomeshown",true);
            editor.apply();
        }


    }
}
