package com.example.registerform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayData extends AppCompatActivity {

    private TextView vname, vmob,vemail,vdept,vcity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        vname = findViewById(R.id.viewName);
        vmob = findViewById(R.id.viewMob);
        vemail = findViewById(R.id.viewEmail);
        vdept = findViewById(R.id.viewDate);
        vcity = findViewById(R.id.viewCity);

        String username = getIntent().getStringExtra("keyname");
        String mobile = getIntent().getStringExtra("keymob");
        String email = getIntent().getStringExtra("keyemail");
        String dept = getIntent().getStringExtra("keydept");
        String city = getIntent().getStringExtra("keycity");

        vname.setText(username);
        vmob.setText(mobile);
        vemail.setText(email);
        vdept.setText(dept);
        vcity.setText(city);
    }
}