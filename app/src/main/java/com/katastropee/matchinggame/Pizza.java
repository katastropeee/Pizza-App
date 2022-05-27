package com.katastropee.matchinggame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.StringJoiner;
public class Pizza extends AppCompatActivity {
    RadioButton hawaiian;
    RadioButton hamncheese;
    RadioButton sizeS;
    RadioButton sizeM;
    RadioButton sizeL;
    RadioButton tThin;
    RadioButton tThick;
    CheckBox exCheese;
    CheckBox exMushrooms;
    CheckBox exOnions;
    CheckBox exTomatoes;
    CheckBox exPineapples;
    double price, sizePrice, pizzaTypePrice, extraToppingsPrice, total;
    String pizza, size, crust;
    RadioGroup pizzaType;
    RadioButton radioButton;
    RadioGroup pizzaSize;
    RadioButton radioButtonSize;
    TextView textViewSizeCrust;
    RadioGroup pizzaCrust;
    RadioButton radioButtonCrustType;
    TextView textView;
    TextView textViewExtraToppings;
    TextView pizzaPriceTotal;
    TextView extraToppingsPriceTotal;
    TextView priceTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_layout);
        hawaiian = findViewById(R.id.f1);
        hamncheese = findViewById(R.id.f2);
        sizeS = findViewById(R.id.s1);
        sizeM = findViewById(R.id.s2);
        sizeL = findViewById(R.id.s3);
        tThin = findViewById(R.id.t1);
        tThick = findViewById(R.id.t2);
        exCheese = findViewById(R.id.top1);

        exMushrooms = findViewById(R.id.top2);
        exOnions = findViewById(R.id.top3);
        exTomatoes = findViewById(R.id.top4);
        exPineapples = findViewById(R.id.top5);
        pizzaType = findViewById(R.id.Pizza_Type);
        pizzaSize = findViewById(R.id.Pizza_Size);
        pizzaCrust = findViewById(R.id.Crust_Type);
        textView = findViewById(R.id.txt_info);
        textViewSizeCrust = findViewById(R.id.txt_size_crust);
        textViewExtraToppings = findViewById(R.id.txt_toppings);
        pizzaPriceTotal = findViewById(R.id.txt_sizecrust_total);
        extraToppingsPriceTotal = findViewById(R.id.txt_toppings_total);
        priceTotal = findViewById(R.id.txt_total);
        Button buttonApply = findViewById(R.id.porder);
        Button buttonClear = findViewById(R.id.norder);
        String s1 = null, s2 = null;
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                StringJoiner s1 = new StringJoiner(" & ");
                StringJoiner s2 = new StringJoiner(",");
                if (hawaiian.isChecked()) {
                    pizza = "Hawaian Pizza";
                    Toast.makeText(getApplicationContext(), "Hawaii", Toast.LENGTH_SHORT).show();
                    if (sizeS.isChecked()) {
                        size = "Small";
                        sizePrice = 100;
                    } else if (sizeM.isChecked()) {
                        size = "Medium";
                        sizePrice = 150;
                    } else if (sizeL.isChecked()) {
                        size = "Large";
                        sizePrice = 200;

                    }
                }
                if (hamncheese.isChecked()) {
                    pizza = "Ham & Cheese Pizza";
                    if (sizeS.isChecked()) {
                        size = "Small";
                        sizePrice = 200;

                    } else if (sizeM.isChecked()) {

                        size = "Medium";
                        sizePrice = 300;

                    } else if (sizeL.isChecked()) {

                        size = "Large";
                        sizePrice = 400;

                    }
                }
                if (tThin.isChecked()) {
                    crust = "Thin Crust";
                    pizzaTypePrice = 0;

                }
                if (tThick.isChecked()) {
                    crust = "Thick Crust";
                    pizzaTypePrice = sizePrice * 0.5;

                }
                if (exCheese.isChecked()) {
                    s2.add("Extra Cheese");
                    extraToppingsPrice += 20;
                }
                if (exMushrooms.isChecked()) {
                    s2.add("Mushrooms");
                    extraToppingsPrice += 20;
                }
                if (exOnions.isChecked()) {
                    s2.add("Onions");
                    extraToppingsPrice += 10;
                }
                if (exTomatoes.isChecked()) {
                    s2.add("Tomatoes");
                    extraToppingsPrice += 10;
                }
                if (exPineapples.isChecked()) {
                    s2.add("Pineapples");
                    extraToppingsPrice += 15;
                }
                s1.add(size);
                s2.add(crust);
                price = sizePrice + pizzaTypePrice;
                total = price + extraToppingsPrice;

                //show the prices on the screen
                textView.setText(pizza);
                textViewSizeCrust.setText(" " + s1);
                textViewExtraToppings.setText(" (" + s2 + ")");
                pizzaPriceTotal.setText("" + price);
                extraToppingsPriceTotal.setText("" + extraToppingsPrice);
                priceTotal.setText("" + total);

            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clear the radio and checkboxes
                total = 0;
                pizzaType.clearCheck();
                pizzaSize.clearCheck();
                pizzaCrust.clearCheck();
                exCheese.setChecked(false);
                exMushrooms.setChecked(false);
                exOnions.setChecked(false);
                exTomatoes.setChecked(false);
                exPineapples.setChecked(false);
                textView.setText("");
                textViewSizeCrust.setText("");
                textViewExtraToppings.setText("");
                pizzaPriceTotal.setText("");
                extraToppingsPriceTotal.setText("");
                priceTotal.setText("");

                price = 0;
                sizePrice = 0;
                pizzaTypePrice = 0;
                extraToppingsPrice = 0;
            }
        });
    }


}