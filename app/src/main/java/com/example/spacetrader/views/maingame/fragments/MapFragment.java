package com.example.spacetrader.views.maingame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spacetrader.R;
import com.example.spacetrader.entities.Player;

import java.util.Map;

public class MapFragment extends Fragment {

    private String playerId;
    private Player player;

    public MapFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
//        this.playerId = this.getArguments().getString("playerId");
        return inflater.inflate(R.layout.fragment_map, parent, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
