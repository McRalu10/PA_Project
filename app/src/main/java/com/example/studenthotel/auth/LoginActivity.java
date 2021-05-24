package com.example.studenthotel.auth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studenthotel.ActivityUtils;
import com.example.studenthotel.MainActivity;
import com.example.studenthotel.R;
import com.example.studenthotel.requests.APIClient;
import com.example.studenthotel.requests.APIInterface;
import com.example.studenthotel.requests.POJO.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends ActivityUtils {
    APIInterface apiInterface;
    User user = new User();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        apiInterface = APIClient.getClient().create(APIInterface.class);
    }


    public void login(View view) {
        EditText email = findViewById(R.id.login_email);
        EditText password = findViewById(R.id.login_password);
        if (hasText(email.getText().toString()) && hasText(password.getText().toString())) {
            user.setEmail(email.getText().toString());
            user.setPassword(password.getText().toString());
            Call<User> call = apiInterface.login(user);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User newUser = response.body();
                    if (newUser == null)
                        toastMessage("Wrong credentials!");
                    else {
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("userID", user.getUserID());
                        editor.putString("type", user.getType());
                        editor.putString("email", user.getEmail());
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    toastMessage("An error occurred!");
                    call.cancel();
                }
            });

        }
    }

    public void goToRegister(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    public void goToForgot(View view) {
        startActivity(new Intent(LoginActivity.this, ForgotActivity.class));
    }
}
