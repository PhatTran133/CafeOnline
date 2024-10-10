package com.example.cafeonline;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


import com.example.cafeonline.api.ApiService;
import com.example.cafeonline.api.UserApiService;
import com.example.cafeonline.model.request.LoginRequest;
import com.example.cafeonline.model.response.ApiResponse;
import com.example.cafeonline.model.response.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText edtEmail, edtPassword;
    private Button btnLogin;
    private TextView tvForgotPassword, tvRegister;
    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        tvForgotPassword = findViewById(R.id.tv_forgot_password);
        tvRegister =  findViewById(R.id.tv_register);
        imgBack = findViewById(R.id.img_toolbar_back);

        btnLogin.setOnClickListener(v -> performLogin());
        tvForgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });
        tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
        imgBack.setOnClickListener(v -> onBackPressed());
    }



    private void performLogin() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();


        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
            return;
        }


        LoginRequest loginRequest = new LoginRequest(email, password);
        UserApiService authService = ApiService.createService(UserApiService.class);
        Call<ApiResponse<UserResponse>> call = authService.loginUser(loginRequest);
        call.enqueue(new Callback<ApiResponse<UserResponse>>() {
            @Override
            public void onResponse(Call<ApiResponse<UserResponse>> call, Response<ApiResponse<UserResponse>> response) {
                System.out.println("Response received");
                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse<UserResponse> apiResponse = response.body();

                    if ("200".equals(apiResponse.getValue().getStatus())) {

                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(LoginActivity.this, "Login Failed: " + apiResponse.getValue().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {

                    Toast.makeText(LoginActivity.this, "Login Failed: Invalid response", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ApiResponse<UserResponse>> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Login Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
