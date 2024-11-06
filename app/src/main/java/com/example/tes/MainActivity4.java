package com.example.tes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    Button btnLogin;
    TextView etEmail;
    TextView etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main4);

        btnLogin    = findViewById(R.id.btn_login);
        etEmail     = findViewById(R.id.et_email);
        etPassword  = findViewById(R.id.et_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email    = etEmail.getText().toString();
                String password = etPassword.getText().toString();



                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity4.this, "Email dan password tidak boleh kosong", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity4.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity4.this, MrHead.class);
                    startActivity(i);
                }
            }
        });

    }
}