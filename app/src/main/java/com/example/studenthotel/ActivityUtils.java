package com.example.studenthotel;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityUtils extends AppCompatActivity{
    private final static String requiredFields = "All fields are required!";

    public boolean hasText(String text) {
        if (text.length() == 0) {
            Toast.makeText(getApplicationContext(), requiredFields, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean theSame(String message1, String message2,String errorMsg){
        if (!message1.equals(message2)) {
            Toast.makeText(getApplicationContext(), errorMsg, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public void toastMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
