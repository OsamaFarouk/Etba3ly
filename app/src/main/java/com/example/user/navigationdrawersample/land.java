package com.example.user.navigationdrawersample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class land extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land);
    }

    public void gotologin(View view) {
        Intent myintent = new Intent(this, Signin.class);
        startActivity(myintent);
    }
}
