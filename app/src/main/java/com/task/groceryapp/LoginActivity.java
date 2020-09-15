/*package com.task.groceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
*/
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

public class LoginActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView forgetPwdTextView = findViewById(R.id.Textforgetpass);
        TextView signUpTextView = findViewById(R.id.signupLink);
        String forgetPwdText = "Forget Password?";
        String signUpText = "Don't have an account? Signup";

        toolbar = findViewById(R.id.loginBackBtn);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_backarrow);

        SpannableString spannableString = new SpannableString(signUpText);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void updateDrawState(final TextPaint textPaint) {
                textPaint.setColor(getApplicationContext().getResources().getColor(R.color.colorblack));
                textPaint.setUnderlineText(true);
            }

            @Override
            public void onClick(@NonNull View view) {

                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        };

        spannableString.setSpan(clickableSpan, 23, signUpText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signUpTextView.setText(spannableString);
        signUpTextView.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString = new SpannableString(forgetPwdText);

        ClickableSpan clickableForgetPwdSpan = new ClickableSpan() {

            @Override
            public void updateDrawState(final TextPaint textPaint) {
                textPaint.setColor(getApplicationContext().getResources().getColor(R.color.colorblack));
                textPaint.setUnderlineText(true);
            }

            @Override
            public void onClick(@NonNull View view) {
                Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        };

        spannableString.setSpan(clickableForgetPwdSpan, 0, forgetPwdText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        forgetPwdTextView.setText(spannableString);
        forgetPwdTextView.setMovementMethod(LinkMovementMethod.getInstance());

        toolbar.setNavigationOnClickListener(new View.OnClickListener()    {
            @Override
            public void onClick (View view){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            }
        });
    }
}