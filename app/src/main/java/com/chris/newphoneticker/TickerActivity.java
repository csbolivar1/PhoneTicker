package com.chris.newphoneticker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class TickerActivity extends AppCompatActivity {

    TextView MovedText;
    TranslateAnimation myAnimation;
    String RetrievedText;
    int textLength;
    int uiOptions;
    ViewGroup.LayoutParams layoutParams;
    View hideStatusBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticker);

        // Hide notification / status bar
        hideStatusBar = getWindow().getDecorView();
        uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        hideStatusBar.setSystemUiVisibility(uiOptions);

        // Set text to what user entered
        MovedText = (TextView) findViewById(R.id.movedText);
        MovedText.setText(getIntent().getStringExtra("mytext"));

        // Adjust TextView size and animation speed based on length of message.
        RetrievedText = MovedText.toString();
        textLength = RetrievedText.length();
        layoutParams = MovedText.getLayoutParams();
        layoutParams.width = textLength * 120;
        layoutParams.height = textLength * 100;
        MovedText.setLayoutParams(layoutParams);

        // Initiate scrolling animation (see scrolling_animation.xml in res/anim folder for animation properties)
        myAnimation = new TranslateAnimation(textLength * 30, textLength * -150,  0, 0);

        // Speed of animation based on length of text(box)
        myAnimation.setRepeatCount(Animation.INFINITE);
        myAnimation.setDuration(textLength * 170);

        MovedText.startAnimation(myAnimation);
    }
}
