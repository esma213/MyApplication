package com.sample.myapplication;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText;
    Button loginButton;


    private static final String emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//     private static final String emailRegex = "[a-zA-Z0-9._-]+@gmail+\\.+com+";
    private static final int passwordMinLength = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        emailEditText = findViewById(R.id.emailTxt);
        passwordEditText  = findViewById(R.id.passwordTxt);
        loginButton = findViewById(R.id.loginBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emailEditText.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),getString(R.string.email_empty), Toast.LENGTH_LONG).show();
                } else if (!emailEditText.getText().toString().matches(emailRegex)) {
                    Toast.makeText(getApplicationContext(),getString(R.string.email_not_valid), Toast.LENGTH_LONG).show();
                } else if(passwordEditText.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),getString(R.string.password_empty), Toast.LENGTH_LONG).show();
                } else if (passwordEditText.getText().toString().length() < passwordMinLength) {
                    Toast.makeText(getApplicationContext(),getString(R.string.password_not_valid), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),getString(R.string.entry_success), Toast.LENGTH_LONG).show();
                    Intent intente = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intente);
                }

            }
        });

//        emailEditText.getText();
//        emailEditText.setText("essom.zoa@gmail.com");




    }
}