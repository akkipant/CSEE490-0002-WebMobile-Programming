package com.example.m2_icp_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Boolean Valflag;
    EditText user, pass;
    Button button;
    Intent login;


    private View.OnClickListener signInOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            signInClicked();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = new Button(this);

        button = (Button) findViewById(R.id.signIn);

        //Button Listener
        button.setOnClickListener(signInOnClickListener);

    }

    //Validate and Login
    private void signInClicked() {

        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        Valflag = false;
        login = new Intent(MainActivity.this, homeActivity.class);
        String username = user.getText().toString();
        String password = pass.getText().toString();

        //Validation of Data entered
        if(!username.isEmpty() && !password.isEmpty()) {
            if(username.equals("User") && password.equals("Password")) {
                Valflag = true;
            }
        }

        //Start the Home Activity
        if(Valflag) {
            startActivity(login);
        }

        //Give a Toast notification
        if(!Valflag) {
            Toast.makeText(getApplicationContext(),"Details did not match",Toast.LENGTH_SHORT).show();
        }
    }

}
