package com.example.akjn.whatsappdirectmessage;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).hide();
        }
    }

    public void messageOnWhatsApp(View v)
    {
        EditText phoneNum = (EditText)findViewById(R.id.inputField);
        String phoneNumber = phoneNum.getText().toString();
        if(phoneNumber.length() == 10) {
            Toast.makeText(this, "Add Country Code Before Phone Number", Toast.LENGTH_SHORT).show();
        }else if(phoneNumber.length()<10 || phoneNumber.length()>12){
            Toast.makeText(this, "Not A Valid Phone Number", Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumber));
            startActivity(i);
        }
    }
}
