package com.example.justjave20;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static String getValue() {
        return value;
    }
    int quantity = 2;
    boolean whip_checked = false;
    boolean choc_checked = false;
    String name;
    private static String value = "Name : ";
    String message = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button order_sum = findViewById(R.id.order_text_view);
        order_sum.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                value = message;
                Intent orderIntent = new Intent(MainActivity.this, Order_Summary.class);
                startActivity(orderIntent);
            }
        });

    }

    public void onCheckboxClicked1(View view) {
        whip_checked = ((CheckBox) view).isChecked();
    }

    public void onCheckboxClicked2(View view) {
        choc_checked = ((CheckBox) view).isChecked();
    }

    public void display(int number) {
        TextView amountTextView = (TextView) findViewById(R.id.amount_text_view);
        amountTextView.setText("" + number);
        EditText text = (EditText) findViewById(R.id.name);
        name = text.getText().toString();
        int price = 5 * quantity;
        message = "Name : " + name + "\n" + "Add whipped cream ? ";
        if(whip_checked) {
            message += "true";
            price += 1 * quantity;
        } else message += "false";
        message = message + "\nAdd chocolate ?   ";
        if (choc_checked) {
            message += "true";
            price += 2 * quantity;
        } else message += "false";
        message += "\nQuantity : " + quantity + "\nTotal : $" + price + "\nThank you!";
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity <= 0)
            quantity = 0;
        else {
            quantity = quantity - 1;
        }
        display(quantity);
    }

    public void getName(View view) {
        EditText text = (EditText) findViewById(R.id.name);
        name = text.getText().toString();
    }

}
