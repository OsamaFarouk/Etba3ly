package com.example.user.navigationdrawersample;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText login_name,login_email,login_pass,login_pass2;
    String str_login_email, str_login_name,str_login_pass,str_login_pass2;
    TextView login_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_signup);

        login_button = (TextView) findViewById(R.id.signupbu);
        login_name = (EditText) findViewById(R.id.name);
        login_email = (EditText) findViewById(R.id.email);
        login_pass = (EditText) findViewById(R.id.pass);
        login_pass2 = (EditText) findViewById(R.id.pass2);
    }



    public void already(View view) {
        Intent myintent=new Intent(this, Signin.class);
        startActivity(myintent);

    }

    public void click(View view) {
        Intent next=new Intent(this,MainActivity.class);

        if (view == login_button) {

            str_login_name = login_name.getText().toString();
            str_login_email = login_email.getText().toString();
            str_login_pass = login_pass.getText().toString();
            str_login_pass2 = login_pass2.getText().toString();

            if (str_login_name.isEmpty()) {
                login_name.setError("Please, Enter Your Name.");
            } else if (str_login_email.isEmpty()) {
                login_email.setError("Please, Enter Your Email.");
            }
            else if (str_login_pass.isEmpty()) {
                login_pass.setError("Please, Enter Your Password.");
            }
            else if (str_login_pass2.isEmpty()) {
                login_pass2.setError("Please, Confirm Your Password.");
            }else if(!str_login_pass.equals(str_login_pass2))  {
              login_pass2.setError("Those passwords didn't match. Try again.");

            }else{
                startActivity(next);
                Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show();

            }

        }
    }
}
