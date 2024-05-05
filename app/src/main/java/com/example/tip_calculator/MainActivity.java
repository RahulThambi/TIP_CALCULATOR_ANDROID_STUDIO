package com.example.tip_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText og_amount;
    TextView tip_amt, total_amt, perc;
    SeekBar seek;
    Button btn;

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        og_amount = findViewById(R.id.og_amount);
        tip_amt = findViewById(R.id.tip_amt);
        total_amt = findViewById(R.id.total_amt);
        btn = findViewById(R.id.btn);
        seek = findViewById(R.id.seek);
        perc = findViewById(R.id.perc);
        img = findViewById(R.id.img);


        // Set up SeekBar listener in onCreate if you want it to be active immediately
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                perc.setText(progress + "%");
                // You may want to perform some calculations here based on progress
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calculate(View view)
    {
        String ogamt = og_amount.getText().toString();
        double amt = Double.parseDouble(ogamt);

        int seekBarProgress = seek.getProgress();
        double tipPercentage = seekBarProgress / 100.0; // Convert to a decimal

        // Calculate tip and total amount
        double tipAmount = amt * tipPercentage;
        double totalAmount = amt + tipAmount;

        // Display the calculated values in your TextViews
        tip_amt.setText(String.valueOf(tipAmount));
        total_amt.setText(String.valueOf(totalAmount));

        if(seekBarProgress>=0 && seekBarProgress<=30)
        {
            img.setImageResource(R.drawable.sad);
        }
        if(seekBarProgress>=31 && seekBarProgress<=60)
        {
            img.setImageResource(R.drawable.mid);
        }
        if(seekBarProgress>=61)
        {
            img.setImageResource(R.drawable.happy);
        }
    }
}
