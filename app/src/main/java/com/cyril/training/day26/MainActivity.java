package com.cyril.training.day26;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    /*
    * IMPORTANT:
    *
    * Make sure to use "inputType='phone'" instead of "inputType='number'" as an
    * attribute in EditText's View, in the Layout, in order to insert spaces between the input.
    *
    * */

    private static final String LOG_TAG= "day26Log";

    TextView mTextViewForCardNumber; // To show the Credit Card number on Submit.
    EditText mEditTextForCardNumber; // To get and format the Credit Card number
    Button mSubmitButton;// To submit and show the Credit Card number in the TextView.

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewForCardNumber = (TextView) findViewById(R.id.textView_for_credit_card);
        mEditTextForCardNumber = (EditText) findViewById(R.id.editText_for_Credit_card);

        // Checking and adding gaps between every four numbers, using TextWatcher.
        mEditTextForCardNumber.addTextChangedListener(new CreditCardNumberTextWatcher());

        mSubmitButton = (Button) findViewById(R.id.button_to_submit_credit_card_number);

        // Showing the Credit Card number in the TextView on Submit.
        mSubmitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Checking for the correct format.
                if((mEditTextForCardNumber.length() > 0) && (mEditTextForCardNumber.length() == 19))
                {
                    String cardNumber= mEditTextForCardNumber.getText().toString();
                    mTextViewForCardNumber.setText(cardNumber);
                }
                else if ((mEditTextForCardNumber.length() == 0) && (mEditTextForCardNumber.length() < 19))
                {
                    Log.v(LOG_TAG, "EditText is blank.");
                    Toast.makeText(MainActivity.this, "EditText is blank.", Toast.LENGTH_SHORT).show();
                }
                else if(mEditTextForCardNumber.length() < 19)
                {
                    Log.v(LOG_TAG, "Insert full Card number.");
                    Toast.makeText(MainActivity.this, "Insert full Card number.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
