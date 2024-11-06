package com.example.tes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity6 extends AppCompatActivity {

    Button btnTelp;
    Button btnBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnTelp = findViewById(R.id.btnTelp);
        btnBrowser = findViewById(R.id.btnBrowser);

        btnTelp.setOnClickListener(v->{
            Uri uri = Uri.parse("tel:081235279931");
            Intent it = new Intent(Intent.ACTION_DIAL, uri);
            startActivity(it);
        });

        btnBrowser.setOnClickListener(v->{
            Uri uri = Uri.parse("https://tedxuns.com");
            Intent it = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(it);
        });

    }

}