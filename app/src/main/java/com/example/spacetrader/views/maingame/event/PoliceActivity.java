package com.example.spacetrader.views.maingame.event;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.spacetrader.R;

public class PoliceActivity extends EventActivity {

    /**
     * initializes the police event
     * @param savedInstanceState the bundle containing the state
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_event);

        Button button = findViewById(R.id.close_event);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
