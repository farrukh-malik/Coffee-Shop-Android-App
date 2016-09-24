package com.example.sayla.mycoffeeshopapp;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkbox1;
    private CheckBox checkbox2;
    private Button Plus;
    private Button Minus;
    private TextView Quantity;
    private Button Order;
    private TextView Whiped;
    private TextView Coffee;
    private TextView OrderQuantity;
    private TextView TotalPrice;
    private int i;
    private int cofeePrice;
    private int WhipedPrice;
    private LinearLayout Report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }


    private void init() {
        checkbox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkbox2 = (CheckBox) findViewById(R.id.checkBox2);
        Plus = (Button)findViewById(R.id.plus);
        Minus = (Button)findViewById(R.id.minus);
        Quantity = (TextView)findViewById(R.id.q);
        Order = (Button)findViewById(R.id.order);
        Whiped = (TextView)findViewById(R.id.whip);
        Coffee = (TextView)findViewById(R.id.cofee);
        OrderQuantity = (TextView)findViewById(R.id.quan);
        TotalPrice = (TextView)findViewById(R.id.total);
        Report = (LinearLayout)findViewById(R.id.report);

        checkbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkbox1.isChecked()){
                    checkbox2.setChecked(false);
                    Whiped.setText("WhipedCreame : true");
                    Coffee.setText("Add Chocolate? false");
                    WhipedPrice = 10;
                    cofeePrice = 0;
                }else {
                    Whiped.setText("Add WhippedCreame? false");
                }
            }
        });


        checkbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkbox2.isChecked()){
                    checkbox1.setChecked(false);
                    Coffee.setText("Add Chocolate? true");
                    Whiped.setText("Add WhippedCreame? false");
                    cofeePrice = 20;
                    WhipedPrice = 0;

                }else {
                    Coffee.setText("Add Chocolate? false");
                }
            }
        });


        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               i++;
                Quantity.setText(i+"");
            }
        });

        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i != 0){
                    i--;
                    Quantity.setText(i+"");
                }
            }
        });

        Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Report.INVISIBLE == View.INVISIBLE){
                    Report.setVisibility(View.VISIBLE);
                }
                int Total = (cofeePrice + WhipedPrice) * i;
                OrderQuantity.setText("Quantity: "+i);
                TotalPrice.setText("Total: $"+ Total);
            }
        });
    }
}
