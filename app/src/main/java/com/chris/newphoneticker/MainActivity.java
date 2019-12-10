package com.chris.newphoneticker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button ClearBtn, OkBtn;
    EditText TextField;
    String mainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClearBtn = (Button) findViewById(R.id.clear_btn);
        OkBtn = (Button) findViewById(R.id.ok_button);
        TextField = (EditText) findViewById(R.id.text_field);

        // Clear text field
        ClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                TextField.getText().clear();
            }
        });

        // Save entered text, move to next page
        OkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText = TextField.getText().toString();
                moveToTicker();
            }
        });
    }

    private void moveToTicker() {
        Intent intent = new Intent(MainActivity.this, TickerActivity.class);
        intent.putExtra("mytext", mainText);
        startActivity(intent);
    }
}
