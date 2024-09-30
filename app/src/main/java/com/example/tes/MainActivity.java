package com.example.tes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buttonBack = findViewById(R.id.button2);

        buttonBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(i);
                    }
                }
        );
        Log.d("Manggil Callback", "masuk halaman2 onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Manggil Callback", "masuk halaman2 onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("Manggil Callback", "masuk halaman2 onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Manggil Callback", "masuk halaman2 onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Manggil Callback", "masuk halaman2 onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("Manggil Callback", "masuk halaman2 onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("Manggil Callback", "masuk halaman2 onRestart");
    }

}