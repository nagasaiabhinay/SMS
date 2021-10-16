package com.abhi.sms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton more, home, group, groups, close;
    Float translationYaxis = 100f;
    Boolean menuOpen = false;
    OvershootInterpolator interpolator = new OvershootInterpolator();

    IntentFilter intentFilter;
    RecyclerView recyclerView;
    TextInputEditText phonenumber;
    EditText custommessage;
    Button send_custom;

    private ArrayList<Card> usersList;
    private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            usersList.add(new Card(intent.getExtras().getString("number"),intent.getExtras().getString("message")));
            setAdapter();
        }
    };

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(usersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        usersList = new ArrayList<>();
        intentFilter = new IntentFilter();
        intentFilter.addAction("SMS_RECEIVED_ACTION");
        recyclerView = findViewById(R.id.recyclerView);




        showMenu();


    }

    private void showMenu() {
        more = findViewById(R.id.more);
        home = findViewById(R.id.home);
        group = findViewById(R.id.group);
        groups = findViewById(R.id.groups);

        phonenumber = findViewById(R.id.textinputedittext_phonenumber);
        custommessage = findViewById(R.id.textinputedittext_custommessage);
        send_custom = findViewById(R.id.send_custom);

        home.setAlpha(0f);
        group.setAlpha(0f);
        groups.setAlpha(0f);

        home.setTranslationY(translationYaxis);
        group.setTranslationY(translationYaxis);
        groups.setTranslationY(translationYaxis);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (menuOpen) {
                    CloseMenu();
                } else {
                    OpenMenu();
                }


            }
        });

        send_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sPhone = phonenumber.getText().toString().trim();
                String sMessage = custommessage.getText().toString().trim();

                if (checkPermi()) {
                    if (!sPhone.equals("") && !sMessage.equals("")) {
                        SmsManager smsManager = SmsManager.getDefault();

                        smsManager.sendTextMessage(sPhone, null, sMessage, null, null);

                        Toast.makeText(getApplicationContext(), "SMS sent successfully!", Toast.LENGTH_LONG).show();
                        custommessage.setText("");
                    } else {
                        Toast.makeText(getApplicationContext(), "Enter value First.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.RECEIVE_SMS}, 1);
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_SMS}, 1);
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);
                }


            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, B1.class);
                startActivity(intent);
            }
        });
        groups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, B2.class);
                startActivity(intent);
            }
        });

    }

    public boolean checkPermi() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {

            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED) {

                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED) {

                    return true;
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.RECEIVE_SMS}, 1);
                    return false;
                }
            } else {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_SMS}, 1);
                return false;
            }
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);
            return false;
        }
    }

    @Override
    protected void onStart() {
        requestSmsPermission();
        checkPermi();
        super.onStart();


    }
    @Override
    protected void onResume() {
        registerReceiver(intentReceiver,intentFilter);
        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(intentReceiver);
        super.onPause();
    }

    private void requestSmsPermission() {
        String permission = Manifest.permission.RECEIVE_SMS;
        int grant = ContextCompat.checkSelfPermission(this, permission);
        if ( grant != PackageManager.PERMISSION_GRANTED) {
            String[] permission_list = new String[1];
            permission_list[0] = permission;
            ActivityCompat.requestPermissions(this, permission_list, 1);
        }
    }


    private void OpenMenu() {

        menuOpen = !menuOpen;
        more.setImageResource(R.drawable.ic_close);
        home.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        group.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        groups.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();


    }

    private void CloseMenu() {
        menuOpen = !menuOpen;
        more.setImageResource(R.drawable.ic_more);
        home.animate().translationY(translationYaxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        group.animate().translationY(translationYaxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        groups.animate().translationY(translationYaxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();


    }


}

//        usersList = new ArrayList<>();
//        intentFilter = new IntentFilter();
//        intentFilter.addAction("SMS_RECEIVED_ACTION");
//        recyclerView = findViewById(R.id.recyclerView);
//
//        phonenumber = findViewById(R.id.textinputedittext_phonenumber);
////        custommessage = findViewById(R.id.textinputedittext_custommessage);
////        send_custom = findViewById(R.id.imagebutton_send_custom);
//
//
//
//
//        public boolean checkPermi(){
//            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
//
//                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED){
//
//                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED){
//
//                        return true;
//                    }else {
//                        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.RECEIVE_SMS},1);
//                        return false;
//                    }
//                }else {
//                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_SMS},1);
//                    return false;
//                }
//            }else {
//                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},1);
//                return false;
//            }
//        }n
//
//
//    @Override
//    protected void onStart() {
//        requestSmsPermission();
//        checkPermi();
//        super.onStart();
//
//
//    }
//
//
//
//    @Override
//    protected void onResume() {
//        registerReceiver(intentReceiver,intentFilter);
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        unregisterReceiver(intentReceiver);
//        super.onPause();
//    }
//
//
//
//
//
//    private void requestSmsPermission() {
//        String permission = Manifest.permission.RECEIVE_SMS;
//        int grant = ContextCompat.checkSelfPermission(this, permission);
//        if ( grant != PackageManager.PERMISSION_GRANTED) {
//            String[] permission_list = new String[1];
//            permission_list[0] = permission;
//            ActivityCompat.requestPermissions(this, permission_list, 1);
//        }
//    }







