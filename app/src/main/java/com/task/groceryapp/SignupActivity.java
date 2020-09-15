package com.task.groceryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        toolbar = findViewById(R.id.signUpBackBtn);
        toolbar.setNavigationIcon(R.drawable.ic_backarrow);
        setSupportActionBar(toolbar);
        String textsignup = "Already have an account? Login";
        TextView Signuptip = findViewById(R.id.signuptooltip);
        SpannableString spannableString = new SpannableString(textsignup);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void updateDrawState(final TextPaint textPaint) {
                textPaint.setColor(getApplicationContext().getResources().getColor(R.color.colorblack));
                textPaint.setUnderlineText(true);
            }
            @Override
            public void onClick(@NonNull View view) {
                //intent logic
                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        };
        spannableString.setSpan(clickableSpan,25,textsignup.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Signuptip.setText(spannableString);
        Signuptip.setMovementMethod(LinkMovementMethod.getInstance());

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
