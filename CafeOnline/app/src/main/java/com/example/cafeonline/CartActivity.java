package com.example.cafeonline;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cafeonline.service.NotificationService;

public class CartActivity extends AppCompatActivity {
    private Button orderButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        orderButton = findViewById(R.id.btn_checkout);
        orderButton.setOnClickListener(v -> {
            // Gọi Service để hiển thị notification
            Intent serviceIntent = new Intent(this, NotificationService.class);
            serviceIntent.putExtra("title", "Order");
            serviceIntent.putExtra("text", "Your order is pending");
            startService(serviceIntent);
        });
    }
}