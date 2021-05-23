package com.example.studenthotel.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.studenthotel.ActivityUtils;
import com.example.studenthotel.MainActivity;
import com.example.studenthotel.R;

public class ForgotActivity extends ActivityUtils {
    private final static String passwordChanged = "Your password has been updated";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
    }

    public void changePassword(View view) {
        EditText emailText = findViewById(R.id.forgot_email);
        String email = emailText.getText().toString();
        EditText passwordText = findViewById(R.id.new_password);
        String password = passwordText.getText().toString();
        if(hasText(email) && hasText(password)){
            toastMessage(passwordChanged);
            startActivity(new Intent(ForgotActivity.this, MainActivity.class));
        }
    }
}
