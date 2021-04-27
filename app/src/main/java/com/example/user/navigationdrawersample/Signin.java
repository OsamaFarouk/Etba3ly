package com.example.user.navigationdrawersample;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signin extends AppCompatActivity {

    EditText login_emailid, login_password;
    String str_login_email, str_login_password;
    TextView login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_signin);


        login_button = (TextView) findViewById(R.id.signinbu);

        login_emailid = (EditText) findViewById(R.id.username);
        login_password = (EditText) findViewById(R.id.password);



    }

    public void bu(View view) {
        Intent myintent = new Intent(this, MainActivity.class);

        if (view == login_button) {

            str_login_email = login_emailid.getText().toString();
            str_login_password = login_password.getText().toString();

            if (str_login_email.isEmpty()) {
                login_emailid.setError("Please, Enter your email or username.");
            } else if (str_login_password.isEmpty()) {
                login_password.setError("Please, Enter your password");
            } else {
                startActivity(myintent);
                Toast.makeText(this, "Welcome Back", Toast.LENGTH_LONG).show();


            }

        }
    }



    

    public void OpenSignupPage(View view) {
        startActivity(new Intent(Signin.this,Signup.class));
    }
}



