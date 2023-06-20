package com.example.doczcare;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
        import android.widget.TextView;



public class health extends AppCompatActivity {

     EditText heartRateInput;
     EditText systolicInput;
     EditText diastolicInput;
     EditText sugarInput;

     TextView healthStatus;
     TextView recommendations;

     Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        heartRateInput = (EditText) findViewById(R.id.heart_rate_i);
        systolicInput = (EditText)findViewById(R.id.systolic_i);
        diastolicInput = (EditText)findViewById(R.id.diastolic_i);
        sugarInput = (EditText)findViewById(R.id.sugar_i);
        btn = (Button)findViewById(R.id.btbt);
        healthStatus =(TextView) findViewById(R.id.health_s);
        recommendations = (TextView) findViewById(R.id.recom);


    btn.setOnClickListener(view -> {

        int heartRate = Integer.parseInt(heartRateInput.getText().toString());
        int systolicBP = Integer.parseInt(systolicInput.getText().toString());
        int diastolicBP = Integer.parseInt(diastolicInput.getText().toString());
        int sugarLevel = Integer.parseInt(sugarInput.getText().toString());

        // Perform calculations to determine health status and recommendations
        String status = "";
        String recommendation = "";

        // Determine health status based on input values
        if (heartRate < 60 || heartRate > 100) {
            status += "Abnormal heart rate. ";
            recommendation += "Consult a doctor. ";
        }

        if (systolicBP >= 140 || diastolicBP >= 90) {
            status += "High blood pressure. ";
            recommendation += "Adopt a healthy lifestyle and consult a doctor. ";
        }

        if (sugarLevel >= 126) {
            status += "High blood sugar. ";
            recommendation += "Consult a doctor. ";
        }

        if (status.isEmpty()) {
            status = "Normal";
            recommendation = "Keep up the good work!";
        }

        // Display results
        healthStatus.setText(status);
        recommendations.setText(recommendation);
    });



}}