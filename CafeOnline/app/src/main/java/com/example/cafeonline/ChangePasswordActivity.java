package com.example.cafeonline;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ChangePasswordActivity extends AppCompatActivity {
    private EditText oldPassword, newPassword, confirmPassword;
    private Button btnChangePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_change_password_not_login);

        // Initialize views
        newPassword = findViewById(R.id.edt_new_password);
        confirmPassword = findViewById(R.id.edt_confirm_password);
        btnChangePassword = findViewById(R.id.btn_reset_password);
        oldPassword = findViewById(R.id.edt_old_password);
        // Set up click listener for login button
        btnChangePassword.setOnClickListener(v -> changePassword());

    }
    public void changePassword(){

    }
}