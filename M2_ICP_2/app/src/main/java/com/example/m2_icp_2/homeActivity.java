package com.example.m2_icp_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homeActivity extends AppCompatActivity {

    Button button;
    Intent logout;

    private View.OnClickListener signOutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            signOutClicked();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button = new Button(this);


        button = (Button) findViewById(R.id.logout);

        button.setOnClickListener(signOutOnClickListener);
    }

    //Logout
    private void signOutClicked() {
        logout = new Intent(homeActivity.this, MainActivity.class);
        //startActivity(logout);

        //Finish the started activity
        finish();
    }
}
