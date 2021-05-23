package com.example.studenthotel.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import com.example.studenthotel.ActivityUtils;
import com.example.studenthotel.MainActivity;
import com.example.studenthotel.R;

public class RegisterActivity extends ActivityUtils {
    private final static String passwordError = "The passwords must match!";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View view) {
        EditText nameText = findViewById(R.id.register_name);
        String name = nameText.getText().toString();
        EditText emailText = findViewById(R.id.register_email);
        String email = emailText.getText().toString();
        EditText passwordText = findViewById(R.id.register_password);
        String password = passwordText.getText().toString();
        EditText confirmPasswordText = findViewById(R.id.register_confirm_password);
        String passwordConfirm = confirmPasswordText.getText().toString();
        Spinner typeSpinner = findViewById(R.id.account_spinner);
        String type = typeSpinner.getSelectedItem().toString();
        if (hasText(name) && hasText(email) && hasText(password))
            if (theSame(password, passwordConfirm, passwordError))
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
    }

    public void goToLogin(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }
}
