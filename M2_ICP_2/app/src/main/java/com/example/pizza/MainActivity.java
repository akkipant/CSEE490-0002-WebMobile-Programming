package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name, email, address;
    Intent selectTopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get data that is inserted into the fields
        final Button button = findViewById(R.id.buttonCook);
        name = (EditText) findViewById(R.id.editName);
        email = (EditText) findViewById(R.id.editEmail);
        address = (EditText) findViewById(R.id.editAddress);

        //Creating intent to call next activity
        selectTopping = new Intent(MainActivity.this, selectTopping.class);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Put data with the intent
                selectTopping.putExtra("Name", name.getText().toString());
                selectTopping.putExtra("Address", address.getText().toString());
                selectTopping.putExtra("Email", email.getText().toString());

                startActivity(selectTopping);

            }
        });
    }
}
