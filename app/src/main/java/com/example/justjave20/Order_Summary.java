package com.example.justjave20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class Order_Summary extends AppCompatActivity {
    TextView received;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        received = (TextView)findViewById(R.id.textView);
        String str =  MainActivity.getValue();
        received.setText(str);
    }
}