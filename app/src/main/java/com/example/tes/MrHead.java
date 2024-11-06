package com.example.tes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MrHead extends AppCompatActivity {

    ImageView hair, eyes, eye_brow, moustache;
    CheckBox  checkHair, checkEye, checkEyeBrow, checkMoustache;
    Button btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mr_head);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        hair = findViewById(R.id.hair);
        eyes = findViewById(R.id.eyes);
        eye_brow = findViewById(R.id.eye_brow);
        moustache = findViewById(R.id.moustache);

        checkHair = findViewById(R.id.checkHair);
        checkEye = findViewById(R.id.checkEye);
        checkEyeBrow = findViewById(R.id.checkEyeBrow);
        checkMoustache = findViewById(R.id.checkMoustache);

        btnProfile = findViewById(R.id.button_profile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MrHead.this, profile.class);
                startActivity(i);
            }
        });

        checkHair.setOnCheckedChangeListener((buttonView, isChecked)->{
            hair.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
        });

        checkEye.setOnCheckedChangeListener((buttonView, isChecked)->{
            eyes.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
        });

        checkEyeBrow.setOnCheckedChangeListener((buttonView, isChecked)->{
            eye_brow.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
        });

        checkMoustache.setOnCheckedChangeListener((buttonView, isChecked)->{
            moustache.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
        });

    }
}