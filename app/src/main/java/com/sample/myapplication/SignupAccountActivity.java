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

public class SignupAccountActivity extends AppCompatActivity {

    EditText email2EditText, password2EditText, firstnameEditText, lastnameEdittext, repasswordEditText;
    Button createaccountButton;


    private static final String emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private static final int passwordMinLength = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_account2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        firstnameEditText = findViewById(R.id.firstnameTxt);
        lastnameEdittext = findViewById(R.id.lastnametxt);
        email2EditText = findViewById(R.id.email2Txt);
        password2EditText  = findViewById(R.id.password2Txt);
        repasswordEditText = findViewById(R.id.repasswordTxt);
        createaccountButton = findViewById(R.id.createaccountBtn);

        createaccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (firstnameEditText.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.first_name_create), Toast.LENGTH_LONG).show();
                } else if (lastnameEdittext.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.last_name_create), Toast.LENGTH_LONG).show();
                } else if (email2EditText.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.email_empty), Toast.LENGTH_LONG).show();
                } else if (!email2EditText.getText().toString().matches(emailRegex)) {
                    Toast.makeText(getApplicationContext(),getString(R.string.email_not_valid), Toast.LENGTH_LONG).show();
                } else if (password2EditText.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.password_empty), Toast.LENGTH_LONG).show();
                } else if (password2EditText.getText().toString().length() < passwordMinLength) {
                    Toast.makeText(getApplicationContext(), getString(R.string.password_not_valid), Toast.LENGTH_LONG).show();
                } else if (repasswordEditText.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.re_password_empty), Toast.LENGTH_LONG).show();
                } else if (!repasswordEditText.getText().toString().equals(password2EditText.getText().toString())) {
                    Toast.makeText(getApplicationContext(), getString(R.string.password_not_same), Toast.LENGTH_LONG).show();
                } else {



       //             Intent intente2 = new Intent(getApplicationContext(), HelloAcount.class);
                    Intent intenten = new Intent(SignupAccountActivity.this, HelloAcount.class);
                    intenten.putExtra("Namee", firstnameEditText.getText().toString());
                    startActivity(intenten);



                }

            }
        });











    }
}