/*package com.task.groceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void connectGoogle(View view) {
    }

    public void createAccount(View view) {
        Intent intent = new Intent(MainActivity.this,SignupActivity.class);
        startActivity(intent);
    }
}*/

package com.task.groceryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String textsignup = "Already have an account? Login";
        TextView loginTip = findViewById(R.id.textLogintooltip);
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
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        };
        spannableString.setSpan(clickableSpan,25,textsignup.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        loginTip.setText(spannableString);
        loginTip.setMovementMethod(LinkMovementMethod.getInstance());
    }
    public void createaccountmain(View view) {
        Intent intent =  new Intent(MainActivity.this,SignupActivity.class);
        startActivity(intent);
    }

}
