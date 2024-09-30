package com.example.tes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Button buttonNext;
    EditText ET1;
    EditText ET2;
    TextView TV1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.halaman_kedua);

        ET1 = findViewById(R.id.EDT1);
        ET2 = findViewById(R.id.EDT2);
        TV1 = findViewById(R.id.tv1);

        buttonNext = findViewById(R.id.button);

        buttonNext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("button","diklik");
                        Intent i = new Intent(MainActivity2.this, MainActivity.class);
                        startActivity(i);
                    }
                }
        );

        Log.d("Manggil Callback", "masuk onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Manggil Callback", "masuk onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("Manggil Callback", "masuk onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Manggil Callback", "masuk onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Manggil Callback", "masuk onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("Manggil Callback", "masuk onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("Manggil Callback", "masuk onRestart");
    }
}