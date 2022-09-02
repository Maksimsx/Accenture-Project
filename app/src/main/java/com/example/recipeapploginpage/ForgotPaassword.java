package com.example.recipeapploginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPaassword extends AppCompatActivity {

    private EditText emailField;
    private Button sendEmailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_paassword);

        emailField = findViewById(R.id.editTextTextEmailAddress);
        sendEmailBtn = findViewById(R.id.buttonEmail);

        sendEmail();

    }

    protected void sendEmail() {
        sendEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value  = emailField.getText().toString();
                Log.i("Send email", "");
                String[] TO = {value};
                String[] CC = {"livmanis6@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Password");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "This is your password");

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                    Log.i("Finished sending email...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ForgotPaassword.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}