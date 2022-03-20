package com.example.registerform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name,mob,Email,dept,city;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.fname);
        mob = findViewById(R.id.mnumber);
        Email =findViewById(R.id.email);
        dept = findViewById(R.id.dept);
        city = findViewById(R.id.city);
        send = findViewById(R.id.sendData);

         send.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String sname = String.valueOf(name.getText());
                String mobile = String.valueOf(mob.getText());
                 String Emails = String.valueOf(Email.getText());
                 String Dept = String.valueOf(dept.getText());
                 String City = String.valueOf(city.getText());

                 Intent intent = new Intent(MainActivity.this,DisplayData.class);
                 intent.putExtra("keyname",sname);
                 intent.putExtra("keymob",mobile);
                 intent.putExtra("keyemail",Emails);
                 intent.putExtra("keydept",Dept);
                 intent.putExtra("keycity",City);

                 startActivity(intent);

             }
         });
    }
}