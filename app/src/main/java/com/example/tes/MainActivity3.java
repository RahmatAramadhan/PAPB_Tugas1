package com.example.tes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    Button btnLogin;
    EditText etEmail;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

        btnLogin    = findViewById(R.id.btn_login);
        etEmail     = findViewById(R.id.et_email);
        etPassword  = findViewById(R.id.et_password);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email    = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity3.this, "Email dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity3.this, "Berhasil Log in", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}