package com.example.studenthotel.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studenthotel.ActivityUtils;
import com.example.studenthotel.MainActivity;
import com.example.studenthotel.R;

public class LoginActivity extends ActivityUtils {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void login(View view) {
        EditText email = findViewById(R.id.login_email);
        EditText password = findViewById(R.id.login_password);
        if (hasText(email.getText().toString()) && hasText(password.getText().toString()))
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    public void goToRegister(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    public void goToForgot(View view) {
        startActivity(new Intent(LoginActivity.this, ForgotActivity.class));
    }
}
