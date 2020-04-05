package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class selectTopping extends AppCompatActivity {

    TextView test;
    RadioGroup size, crust, cheese;
    RadioButton radSize, radCrust, radCheese;
    Intent summary, main;
    String Size, Crust, Cheese, Meat, Veggies;
    CheckBox meat1, meat2, meat3, veggies1, veggies2, veggies3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_topping);

        main = getIntent();
        summary = new Intent(selectTopping.this, orderSummary.class);
        final Button button = findViewById(R.id.buttonSummary);



        final String name = main.getStringExtra("Name");
        final float[] price = new float[1];

        test = (TextView) findViewById(R.id.textView2);
        size = (RadioGroup)findViewById(R.id.Size);
        crust = (RadioGroup)findViewById(R.id.Crust);
        cheese = (RadioGroup)findViewById(R.id.Cheese);
        meat1 = (CheckBox)findViewById(R.id.checkBoxHam);
        meat2 = (CheckBox)findViewById(R.id.checkBoxPepperoni);
        meat3 = (CheckBox)findViewById(R.id.checkBoxSausage);
        veggies1 = (CheckBox)findViewById(R.id.checkBoxMushroom);
        veggies2 = (CheckBox)findViewById(R.id.checkBoxOlive);
        veggies3 = (CheckBox)findViewById(R.id.checkBoxOnion);



        test.setText("Hello " + name + " lets customise your Pizza");


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Meat = "";
                Veggies = "";

                //Get Size and store it and calculate price
                int s = size.getCheckedRadioButtonId();
                radSize = (RadioButton)findViewById(s);
                Size = (String) radSize.getText();
                if (Size.equals("Small")) {
                    price[0] = (float) 8.0;
                    Size = Size + "($8.0)";
                }
                else if (Size.equals("Medium")) {
                    price[0] = (float) 10.0;
                    Size = Size + "($10.0)";
                }
                else {
                    price[0] = (float) 12.0;
                    Size = Size + "($12.0)";
                }
                summary.putExtra("Size", Size);



                //Get Crust type and store it and calculate price
                int c = crust.getCheckedRadioButtonId();
                radCrust = (RadioButton)findViewById(c);
                Crust = (String) radCrust.getText();
                if (Crust.equals("Regular"))
                    price[0] += (float) 0.0;
                else if (Crust.equals("Thin")) {
                    price[0] += (float) 1.5;
                    Crust = Crust + "($1.5)";
                }
                else {
                    price[0] += (float) 2.0;
                    Crust = Crust + "($2.0)";
                }
                summary.putExtra("Crust", Crust);


                //Get Cheese type and store it and calculate price
                int ch = cheese.getCheckedRadioButtonId();
                radCheese = (RadioButton)findViewById(ch);
                Cheese = (String) radCheese.getText();
                if (Cheese.equals("No Cheese")) {
                    price[0] -= (float) 1;
                    Cheese = Cheese + "(-$1.0)";
                }
                else if (Cheese.equals("Regular")){
                    price[0] += (float) 0.0;
                }
                else{
                    price[0] += (float) 2.0;
                    Cheese = Cheese + "($2.0)";
                }
                summary.putExtra("Cheese", Cheese);

                //Check the options that are checked for meat and calculate the prices accordingly
                if(meat1.isChecked()) {
                    Meat = "Ham($1.5)";
                    price[0] += 1.5;
                }
                if(meat2.isChecked()) {
                    if(TextUtils.isEmpty(Meat))
                        Meat = "Pepperoni($1.5)";
                    else
                        Meat += ", Pepperoni($1.5)";
                    price[0] += 1.5;
                }
                if(meat3.isChecked()) {
                    if(TextUtils.isEmpty(Meat))
                        Meat = "Sausage($1.5)";
                    else
                        Meat += ", Sausage($1.5)";
                    price[0] += 1.5;
                }
                summary.putExtra("Meat", Meat);

                //Check the options that are checked for veggies and calculate the prices accordingly
                if(veggies1.isChecked()) {
                    Veggies = "Mushroom($0.5)";
                    price[0] += 0.5;
                }
                if(veggies2.isChecked()) {
                    if(TextUtils.isEmpty(Veggies))
                        Veggies = "Olive($0.5)";
                    else
                        Veggies += ", Olive($0.5)";
                    price[0] += 0.5;
                }
                if(veggies3.isChecked()) {
                    if(TextUtils.isEmpty(Veggies))
                        Veggies = "Onion($0.5)";
                    else
                        Veggies += ", Onion($0.5)";
                    price[0] += 1.5;
                }

                summary.putExtra("Veggies", Veggies);

                //Pass Price as a string
                summary.putExtra("Price", "$ " + Float.toString(price[0]));

                //Get data from last intent and pass it to next intent
                summary.putExtra("Name", name);
                summary.putExtra("Address", main.getStringExtra("Address"));
                summary.putExtra("Email", main.getStringExtra("Email"));

                startActivity(summary);

            }
        });


    }
}
