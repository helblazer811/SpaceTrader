package com.example.spacetrader.views;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.spacetrader.R;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        defineStartButton();
        defineLoadButton();
    }

    private void defineStartButton(){
        final Button start = findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent (from , to)
                Intent myIntent = new Intent(StartActivity.this, PlayerConfigurationActivity.class);
                startActivity(myIntent);
            }
        });
    }

    private void defineLoadButton(){
        final Button load = findViewById(R.id.button2);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(StartActivity.this, LoadActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
