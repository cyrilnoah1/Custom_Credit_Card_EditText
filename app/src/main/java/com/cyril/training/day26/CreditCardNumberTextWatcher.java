package com.cyril.training.day26;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;

/**
 * TextWatcher subclass to format the entered input (Credit Card number) into
 * required format.
 */
public class CreditCardNumberTextWatcher implements TextWatcher
{
    private static final String LOG_TAG= "day26Log";

    // Gap/Space between every four numbers in EditText.
    private static final char numberGap= ' ';

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s)
    {
        // Adding gap between every four digits.
        addGapBetweenNumbers(s);

        // Seeing that gaps are not inserted between four-digit-set.
        noGapsBetweenFourDigitSets(s);

        // Removing gap between every four digits.
        removeGapBetweenNumbers(s);
    }

    /**
     * Method to add gap between numbers, when user gives input.
     * @param textInput
     */
    private void addGapBetweenNumbers(Editable textInput)
    {
        // Placing gaps after every four digits
        if((textInput.length() > 0) && (textInput.length() % 5 == 0))
        {
            char ch= textInput.charAt(textInput.length() - 1);

            if(Character.isDigit(ch) /*Checking if the current character is a digit*/
                && TextUtils.split(textInput.toString(), String.valueOf(numberGap)).length <= 3)
            {
                // Inserting gaps between
                textInput.insert(textInput.length() - 1, String.valueOf(numberGap));
                Log.v(LOG_TAG, "Gap inserted after four digits.");
            }

        }
    }

    /**
     * Method to remove added gaps between numbers when user presses Back Button.
     * @param textInput
     */
    private void removeGapBetweenNumbers(Editable textInput)
    {
        // Detecting gaps after every four digits.
        if((textInput.length() > 0) && (textInput.length() % 5 == 0))
        {
            char ch= textInput.charAt(textInput.length() - 1);

            // Checking if the assigned character is a white-space.
            if(ch == numberGap)
            {
                // Deleting the gap between FROM and TO
                textInput.delete(textInput.length() - 1/*FROM*/, textInput.length()/*TO*/);
                
                Log.v(LOG_TAG, "Gap removed between digits.");
            }
        }
    }

    /**
     * Method that does not allow user to insert spaces in between
     * four-digit-number-sets.
     * @param textInput
     */
    private void noGapsBetweenFourDigitSets(Editable textInput)
    {
        // Not allowing gaps in first four-digit-set.
        if((textInput.length() >= 1) && (textInput.length() <= 4))
        {
            // Getting current character
            char currentChar= textInput.charAt(textInput.length() - 1);

            // Checking if the current character is a space.
            if(currentChar == ' ')
            {
                // Removing the current character if it's a space.
                textInput.delete(textInput.length() - 1, textInput.length());
            }
        }
        // Not allowing gaps in second four-digit-set.
        else if((textInput.length() >= 6) && (textInput.length() <= 9))
        {
            char currentChar= textInput.charAt(textInput.length() - 1);

            if(currentChar == ' ')
            {
                textInput.delete(textInput.length() - 1, textInput.length());
            }
        }
        // Not allowing gaps in third four-digit-set.
        else if((textInput.length() >= 11) && (textInput.length() <= 14))
        {
            char currentChar= textInput.charAt(textInput.length() - 1);

            if(currentChar == ' ')
            {
                textInput.delete(textInput.length() - 1, textInput.length());
            }
        }
        // Not allowing gaps in fourth four-digit-set.
        else if((textInput.length() >= 16) && (textInput.length() <= 19))
        {
            char currentChar= textInput.charAt(textInput.length() - 1);

            if(currentChar == ' ')
            {
                textInput.delete(textInput.length() - 1, textInput.length());
            }
        }
    }
}
