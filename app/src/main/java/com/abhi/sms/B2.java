package com.abhi.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class B2 extends AppCompatActivity {

    TextInputEditText phonenumber ;
    TextView msg1,msg2,msg3,msg4,msg5;
    ImageButton send1,send2,send3,send4,send5;

    FloatingActionButton more,home,group,groups,close;
    Float translationYaxis = 100f;
    Boolean menuOpen = false;
    OvershootInterpolator interpolator = new OvershootInterpolator();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b2);
        showMenu();

        phonenumber = findViewById(R.id.textinputedittext_phonenumber);
        msg1 = findViewById(R.id.textview_msg1);
        msg2 = findViewById(R.id.textview_msg2);
        msg3 = findViewById(R.id.textview_msg3);
        msg4 = findViewById(R.id.textview_msg4);
        msg5 = findViewById(R.id.textview_msg5);
        send1 = findViewById(R.id.imagebutton_send1);
        send2 = findViewById(R.id.imagebutton_send2);
        send3 = findViewById(R.id.imagebutton_send3);
        send4 = findViewById(R.id.imagebutton_send4);
        send5 = findViewById(R.id.imagebutton_send5);




        send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sPhone = phonenumber.getText().toString().trim();
                String sMessage = msg1.getText().toString().trim();

                if (checkPermi()){
                    if(!sPhone.equals("") && !sMessage.equals("")){
                        SmsManager smsManager = SmsManager.getDefault();

                        smsManager.sendTextMessage(sPhone,null,sMessage,null,null);

                        Toast.makeText(getApplicationContext(),"SMS sent successfully!",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Enter value First.",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.RECEIVE_SMS},1);
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.READ_SMS},1);
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.SEND_SMS},1);
                }


            }
        });

        send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sPhone = phonenumber.getText().toString().trim();
                String sMessage = msg2.getText().toString().trim();

                if (checkPermi()){
                    if(!sPhone.equals("") && !sMessage.equals("")){
                        SmsManager smsManager = SmsManager.getDefault();

                        smsManager.sendTextMessage(sPhone,null,sMessage,null,null);

                        Toast.makeText(getApplicationContext(),"SMS sent successfully!",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Enter value First.",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.RECEIVE_SMS},1);
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.READ_SMS},1);
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.SEND_SMS},1);
                }



            }
        });

        send3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sPhone = phonenumber.getText().toString().trim();
                String sMessage = msg3.getText().toString().trim();

                if (checkPermi()){
                    if(!sPhone.equals("") && !sMessage.equals("")){
                        SmsManager smsManager = SmsManager.getDefault();

                        smsManager.sendTextMessage(sPhone,null,sMessage,null,null);

                        Toast.makeText(getApplicationContext(),"SMS sent successfully!",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Enter value First.",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.RECEIVE_SMS},1);
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.READ_SMS},1);
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.SEND_SMS},1);
                }
            }
        });

        send4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sPhone = phonenumber.getText().toString().trim();
                String sMessage = msg4.getText().toString().trim();

                if (checkPermi()){
                    if(!sPhone.equals("") && !sMessage.equals("")){
                        SmsManager smsManager = SmsManager.getDefault();

                        smsManager.sendTextMessage(sPhone,null,sMessage,null,null);

                        Toast.makeText(getApplicationContext(),"SMS sent successfully!",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Enter value First.",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.RECEIVE_SMS},1);
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.READ_SMS},1);
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.SEND_SMS},1);
                }
            }
        });

        send5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sPhone = phonenumber.getText().toString().trim();
                String sMessage = msg5.getText().toString().trim();

                if (checkPermi()){
                    if(!sPhone.equals("") && !sMessage.equals("")){
                        SmsManager smsManager = SmsManager.getDefault();

                        smsManager.sendTextMessage(sPhone,null,sMessage,null,null);

                        Toast.makeText(getApplicationContext(),"SMS sent successfully!",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Enter value First.",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.RECEIVE_SMS},1);
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.READ_SMS},1);
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.SEND_SMS},1);
                }
            }
        });
    }

    private void showMenu() {
        more = findViewById(R.id.more);
        home = findViewById(R.id.home);
        group = findViewById(R.id.group);
        groups = findViewById(R.id.groups);

        home.setAlpha(0f);
        group.setAlpha(0f);
        groups.setAlpha(0f);

        home.setTranslationY(translationYaxis);
        group.setTranslationY(translationYaxis);
        groups.setTranslationY(translationYaxis);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (menuOpen){
                    CloseMenu();
                }else{
                    OpenMenu();
                }


            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(B2.this,MainActivity.class);
                startActivity(intent);
            }
        });
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(B2.this,B1.class);
                startActivity(intent);
            }
        });
        groups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(B2.this,B2.class);
                startActivity(intent);
            }
        });



    }

    private void OpenMenu() {

        menuOpen=! menuOpen;
        more.setImageResource(R.drawable.ic_close);
        home.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        group.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        groups.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();


    }
    private void CloseMenu() {
        menuOpen=! menuOpen;
        more.setImageResource(R.drawable.ic_more);
        home.animate().translationY(translationYaxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        group.animate().translationY(translationYaxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        groups.animate().translationY(translationYaxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();


    }

    public boolean checkPermi(){
        if (ContextCompat.checkSelfPermission(B2.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){

            if (ContextCompat.checkSelfPermission(B2.this, Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED){

                if (ContextCompat.checkSelfPermission(B2.this, Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED){

                    return true;
                }else {
                    ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.RECEIVE_SMS},1);
                    return false;
                }
            }else {
                ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.READ_SMS},1);
                return false;
            }
        }else {
            ActivityCompat.requestPermissions(B2.this,new String[]{Manifest.permission.SEND_SMS},1);
            return false;
        }
    }

}