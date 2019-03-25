package com.example.spacetrader.views.maingame.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.databinding.FragmentBuyBinding;
import com.example.spacetrader.databinding.FragmentSellBinding;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.viewmodels.BuyViewModel;
import com.example.spacetrader.viewmodels.SellViewModel;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class SellFragment extends Fragment {

    private SellViewModel viewModel;

    public View onCreateView(LayoutInflater inflater,final ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        //setup data binding here
        FragmentSellBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_sell, parent, false);

        View view = binding.getRoot();

        viewModel = ViewModelProviders.of(this).get(SellViewModel.class);

        if (savedInstanceState == null) {
            long playerId = this.getArguments().getLong("playerId");
            viewModel.init(playerId, this);
        }

        binding.setViewmodel(viewModel);

        setupSaleButton(parent);

        binding.setLifecycleOwner(this);

        return view;
    }

    private void setupSaleButton(final ViewGroup parent) {
        viewModel.getSaleButtonClick().observe(this, new Observer<Player>() {
            @Override
            public void onChanged(Player playerModel) {
                Toast.makeText(parent.getContext(),
                        playerModel.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


}

