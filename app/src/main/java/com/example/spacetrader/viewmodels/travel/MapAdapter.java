package com.example.spacetrader.viewmodels.travel;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.spacetrader.R;
import com.example.spacetrader.databinding.TravelItemBinding;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.event.RandomEvent;
import com.example.spacetrader.entities.planet.Planet;
import com.example.spacetrader.views.LoadActivity;
import com.example.spacetrader.views.maingame.MainActivity;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class MapAdapter extends BaseAdapter {

    private List<Planet> planets;
    private Fragment fragment;
    private Player player;
    private MapViewModel viewModel;

    public MapAdapter(Fragment activity, List<Planet> listPlanets, Player player, MapViewModel viewModel){
        this.planets = listPlanets;
        this.fragment = activity;
        this.player = player;
        this.viewModel = viewModel;
    }

    @Override
    public int getCount() {
        return planets.size();
    }

    @Override
    public Object getItem(int position) {
        return planets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TravelItemBinding binding;
        if (convertView == null) {
            convertView = LayoutInflater.from(fragment.getContext()).inflate(R.layout.travel_item, null);
            binding = DataBindingUtil.bind(convertView);
            convertView.setTag(binding);
        } else {
            binding = (TravelItemBinding) convertView.getTag();
        }

        Button button = convertView.findViewById(R.id.travel_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RandomEvent event = player.travelToPlanet(planets.get(position));
                //need to register database change
                viewModel.insertPlayer(player);

                event.perform(viewModel.getApplication());

            }
        });

        binding.setPlanet(planets.get(position));
        binding.setDistance(player.getDistance(planets.get(position)));
        return binding.getRoot();

    }
}
