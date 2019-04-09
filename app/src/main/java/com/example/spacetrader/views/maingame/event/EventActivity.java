package com.example.spacetrader.views.maingame.event;

import android.content.Intent;

import com.example.spacetrader.views.maingame.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

/**
 * abstract event class for randomized events during player transit
 */
public abstract class EventActivity extends AppCompatActivity {

    /**
     * get intent; pull player
     */
    public EventActivity() { }

    /**
     * on activity completion, performs intent to return to main activity
     */
    public void finish() {
        Intent intent = new Intent(EventActivity.this, MainActivity.class);
        intent.putExtra("playerId", getIntent().getExtras().getLong("playerId"));

        startActivity(intent);
    }

}
