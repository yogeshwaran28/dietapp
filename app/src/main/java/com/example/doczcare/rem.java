package com.example.doczcare;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;



import java.util.Calendar;

public class rem extends AppCompatActivity {




        private EditText medicineInput;
        private TimePicker timeInput;
    private AlarmManager alarmManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_rem);

            medicineInput = findViewById(R.id.medicine_input);
            timeInput = findViewById(R.id.time_input);
            Button scheduleButton = findViewById(R.id.schedule_button);
            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            scheduleButton.setOnClickListener(v -> {
                String medicineName = medicineInput.getText().toString();
                int hour = timeInput.getCurrentHour();
                int minute = timeInput.getCurrentMinute();

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, minute);
                calendar.set(Calendar.SECOND, 0);

                Intent intent = new Intent(rem.this, rem.class);
                intent.putExtra("medicine_name", medicineName);
                @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pendingIntent = PendingIntent.getBroadcast(rem.this,
                        0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                }

                Toast.makeText(rem.this, "You have to take your medicine " +
                        hour + ":" + minute, Toast.LENGTH_SHORT).show();
            });
        }
    }