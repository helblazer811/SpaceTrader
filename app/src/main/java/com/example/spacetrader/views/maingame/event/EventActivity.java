package com.example.spacetrader.views.maingame.event;

import android.content.Intent;

import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.event.Enemy;
import com.example.spacetrader.views.maingame.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

public abstract class EventActivity extends AppCompatActivity {

    public EventActivity() {
        //get intent
        //pull player
    }

    public void finish() {
        //performs intent to return to main activity

        Intent intent = new Intent(EventActivity.this, MainActivity.class);
        intent.putExtra("playerId", getIntent().getExtras().getLong("playerId"));

        startActivity(intent);
    }

}
