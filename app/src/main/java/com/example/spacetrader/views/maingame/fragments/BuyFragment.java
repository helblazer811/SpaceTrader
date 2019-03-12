package com.example.spacetrader.views.maingame.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.dataaccess.repositories.PlayerRepository;
import com.example.spacetrader.databinding.FragmentBuyBinding;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.viewmodels.BuyViewModel;
import com.example.spacetrader.viewmodels.PlayerConfigurationViewModel;
import com.example.spacetrader.views.PlayerConfigurationActivity;
import com.example.spacetrader.views.maingame.MainActivity;

public class BuyFragment extends Fragment {

    private BuyViewModel viewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        //setup data binding here
        FragmentBuyBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_buy, parent, false);

        View view = binding.getRoot();

        viewModel = ViewModelProviders.of(this).get(BuyViewModel.class);

        if (savedInstanceState == null) {
            long playerId = this.getArguments().getLong("playerId");
            viewModel.init(playerId);
        }

        binding.setViewmodel(viewModel);

        setupPurchaseButton(parent);

        viewModel.getLiveData().observe(this, new Observer<Player>() {
            @Override
            public void onChanged(@Nullable Player player) {
                System.out.println("==================");
                System.out.println(player);
                viewModel.getPlayer().setValue(player);
            }
        });

        binding.setLifecycleOwner(this);

        return view;
    }

    private void setupPurchaseButton(final ViewGroup parent) {
        viewModel.getPurchaseButtonClick().observe(this, new Observer<Player>() {
            @Override
            public void onChanged(Player playerModel) {
                Toast.makeText(parent.getContext(),
                        playerModel.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }




}
