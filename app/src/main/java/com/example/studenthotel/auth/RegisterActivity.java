package com.example.studenthotel.auth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import com.example.studenthotel.ActivityUtils;
import com.example.studenthotel.MainActivity;
import com.example.studenthotel.R;
import com.example.studenthotel.requests.APIClient;
import com.example.studenthotel.requests.APIInterface;
import com.example.studenthotel.requests.POJO.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends ActivityUtils {
    private final static String passwordError = "The passwords must match!";
    APIInterface apiInterface;
    User user = new User();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        apiInterface = APIClient.getClient().create(APIInterface.class);

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
            if (theSame(password, passwordConfirm, passwordError)) {
                user.setName(name);
                user.setPassword(password);
                user.setEmail(email);
                user.setType(type.toUpperCase());
                Call<User> call = apiInterface.register(user);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User newUser = response.body();
                        if (newUser == null)
                            toastMessage("Something went wrong!!");
                        else {
                            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("userID", user.getUserID());
                            editor.putString("type", user.getType());
                            editor.putString("email", user.getEmail());
                            editor.apply();
                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
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

    public void goToLogin(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }
}
