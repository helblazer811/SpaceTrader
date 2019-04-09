package com.example.spacetrader.views.maingame.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.spacetrader.R;
import com.example.spacetrader.databinding.FragmentMapBinding;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.planet.Planet;
import com.example.spacetrader.viewmodels.travel.MapAdapter;
import com.example.spacetrader.viewmodels.travel.MapViewModel;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * defines operating parameters for unniverse map; data binding
 */
public class MapFragment extends Fragment {

    MapViewModel viewModel;

    /**
     * defines xml for fragment, sets up data binding, updates view
     * @param inflater used for layout
     * @param parent the view for the buy
     * @param savedInstanceState the bundle containing the state
     * @return the updated view
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        FragmentMapBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_map, parent, false);

        View view = binding.getRoot();

        viewModel = ViewModelProviders.of(this).get(MapViewModel.class);

        if (savedInstanceState == null) {
            long playerId = this.getArguments().getLong("playerId");
            viewModel.init(playerId, this);
        }

        LiveData<Player> player = viewModel.getPlayer();

        final Fragment owner = this;
        player.observe(this, new Observer<Player>() {
            @Override
            public void onChanged(Player player) {
                ListView listView = getView().findViewById(R.id.planet_list);
                List<Planet> planets = viewModel.getTravelablePlanets().getValue();
                listView.setAdapter(new MapAdapter(owner, planets, player, viewModel));
            }
        });

        binding.setViewmodel(viewModel);

        binding.setLifecycleOwner(this);

        return view;

    }

}
