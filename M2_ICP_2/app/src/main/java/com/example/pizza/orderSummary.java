package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class orderSummary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        //Get data sent by last intent
        Intent topp = getIntent();
        final Button button = findViewById(R.id.button);
        String finalOrder = "Order Spectifications\n\n" + topp.getStringExtra("Size") + "\n"
                + topp.getStringExtra("Crust") + "\n" + topp.getStringExtra("Cheese")
                + "\n" + topp.getStringExtra("Meat") + "\n" +topp.getStringExtra("Veggies")
                + "\n\nFinal Price : " + topp.getStringExtra("Price");


        //making intent for email
        final Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "abc@pizza.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Pizza Order");
        email.putExtra(Intent.EXTRA_TEXT, "Delivery Details \n" + topp.getStringExtra("Name")
                + " \n" + topp.getStringExtra("Address") + "\n" + topp.getStringExtra("Email")
                + "\n" + "\n" + finalOrder);

        //need this to prompts email client only
        email.setType("message/rfc822");

        //To Display order Summary on Screen
        TextView summary = (TextView)findViewById(R.id.textView8) ;
        summary.setText(finalOrder);




        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Launch Email Client with the specified fields filled with the data provided
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });
    }
}
