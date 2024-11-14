package com.example.tes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import javax.annotation.Nullable;


public class MainActivity4 extends AppCompatActivity {

    static final int RC_SIGN_IN = 123;
    Button btnLogin;
    ImageView btnGoogleSignIn;
    TextView etEmail;
    TextView etPassword;

    FirebaseAuth auth;
    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btnGoogleSignIn = findViewById(R.id.btnGoogle);
        btnLogin        = findViewById(R.id.btn_login);
        etEmail         = findViewById(R.id.et_email);
        etPassword      = findViewById(R.id.et_password);


        auth        = FirebaseAuth.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.client_id))
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email    = etEmail.getText().toString();
                String password = etPassword.getText().toString();



                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity4.this, "Email dan password tidak boleh kosong", Toast.LENGTH_SHORT).show();

                }else{
                    loginUser(email, password);
                }
            }
        });
        btnGoogleSignIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                signInWithGoogle();
            }
        });

    }

    private void loginUser(String email, String password){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, task ->{
            if(task.isSuccessful()){
                FirebaseUser user = auth.getCurrentUser();
                Toast.makeText(MainActivity4.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity4.this, MrHead.class);
                startActivity(i);
                finish();
            }else{
                Toast.makeText(MainActivity4.this, "Login gagal: "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void signInWithGoogle(){
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN){
            try {
                GoogleSignInAccount account = GoogleSignIn.getSignedInAccountFromIntent(data).getResult(ApiException.class);
                if (account != null){
                    firebaseAuthWithGoogle(account);
                }
            } catch (ApiException e){
                Toast.makeText(this, "Google sign-in failed: "+ e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account){
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()){
                        FirebaseUser user = auth.getCurrentUser();
                        Toast.makeText(MainActivity4.this, "Login Berhasil dengan Google", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity4.this, MrHead.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(MainActivity4.this, "Autentikasi Gagal : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}