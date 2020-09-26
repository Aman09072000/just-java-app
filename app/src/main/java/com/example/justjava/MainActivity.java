package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int num=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view){
        int price = (5);
        EditText name = (EditText)findViewById(R.id.name) ;
        String naam = name.getText().toString();
        CheckBox list = (CheckBox) findViewById(R.id.checkBox);
        boolean ans = list.isChecked();
        CheckBox list2 = (CheckBox) findViewById(R.id.checkBox2);
        boolean ll = list2.isChecked();

        String s = displayOrdersummary(price,ans,ll,naam);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,"just java Order for " + naam);
        intent.putExtra(Intent.EXTRA_TEXT, s);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        displayMessage(s);
    }

    private String displayOrdersummary(int price, boolean myans,boolean myans2,String name) {
       String priceis = "Name :- "+name ;
       priceis += "\nIs whipped cream is added ?" + myans;
       priceis += "\nIs Chocolate is added ?" + myans2;
       priceis += "\nQuantity :- " + num ;
       if(myans == true){
           price += 1;
       }
       if(myans2 == true){
           price +=2;
       }
       int total = num*price;
       priceis += "\ntotal :- " + total;
       priceis += "\nThank You :)";
       return priceis;

    }

    private void displayMessage(String itis) {
        TextView pricetextview = (TextView) findViewById(R.id.order_text_view);
        pricetextview.setText(itis);
    }

    public void increment(View view){
       num = num+1;
       display(num);
    }
    public void decrement(View view){
        if(num > 0) {
            num = num - 1;
            display(num);
        }
    }



    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}