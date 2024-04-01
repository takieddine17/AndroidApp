package com.example.timetable_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LogInActivity extends AppCompatActivity {

    TextInputEditText emailEditText, passwordEditText;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mAuth = FirebaseAuth.getInstance();
        emailEditText = findViewById(R.id.emailBox);
        passwordEditText = findViewById(R.id.passwordBox);

        Button b1 = findViewById(R.id.Loginbutton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;
                email = String.valueOf(emailEditText.getText());
                password = String.valueOf(passwordEditText.getText());

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(LogInActivity.this, "Please fill in all fields", Toast.LENGTH_LONG).show();
                    return;
                }

                // signin existing user
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LogInActivity.this, "Login successful!!", Toast.LENGTH_LONG).show();
                                    // if sign-in is successful
                                    // intent to home activity
                                    Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    // sign-in failed
                                    Toast.makeText(getApplicationContext(), "Login failed!!", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });

        Button b2 = findViewById(R.id.Registerbutton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent il = new Intent(LogInActivity.this, RegistrationActivity.class);
                startActivity(il);
            }
        });
    }
}